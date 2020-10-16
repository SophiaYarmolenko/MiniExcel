package sample;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.LinkedList;

public class Cell
{
    private String cellName;
    private String cellCol;
    private String stringValue;
    private double doubleValue;
    private String formula;
    public LinkedList<Cell> listOfCellsWhereAppears = new LinkedList<>();
    private LinkedList<Cell> listOfCellInFormula = new LinkedList<>();

    public Cell( String cellCol, String formula, String name)
    {
        this.formula = formula;
        this.cellCol = cellCol;
        this.cellName = name;
    }

    private void addNewCellWhereAppears(Cell cell)
    {
        this.listOfCellsWhereAppears.add(cell);
    }

    public void setFormula( String formula )
    {
        this.formula = formula;
    }

    public void setDoubleValue(double doubleValue)
    {
        this.doubleValue = doubleValue;
    }

    public void setStringValue(String stringValue)
    {
        this.stringValue = stringValue;
    }

    public String getStringValue()
    {
        return stringValue;
    }

    public double getDoubleValue()
    {
        return doubleValue;
    }

    public String getFormula()
    {
        return formula;
    }

    public String getCellCol()
    {
        return cellCol;
    }

    public String getCellName()
    {
        return cellName;
    }

    public LinkedList<Cell>getListOfCellsWhereAppears()
    {
        return listOfCellsWhereAppears;
    }

    public LinkedList<Cell> getListOfCellInFormula()
    {
        return listOfCellInFormula;
    }

    public void calculateFormulaInCell ()
    {
        if(listOfCellInFormula != null)
        {
            for(Cell cell : listOfCellInFormula)
            {
                cell.listOfCellsWhereAppears.remove(this);
            }
        }
        listOfCellInFormula.clear();

        String stringOnlyWithCell = formula;
        stringOnlyWithCell = stringOnlyWithCell.replaceAll("[-+^>=<%:*a-z][0-9]*"," ")
                .replaceAll("[()][0-9]*"," ")
                .replaceAll("[-+^>=<%:*][0-9][)]*"," ");
        stringOnlyWithCell = stringOnlyWithCell.trim().replaceAll(" +", " ");

        for(String str : stringOnlyWithCell.split(" "))
        {
            String colLetter = str.replaceAll("[^A-Z]", "");
            if(!colLetter.equals(""))
            {
                if(!str.replaceAll("[^0-9]", "").equals(""))
                {
                    int rowNumber = Integer.parseInt(str.replaceAll("[^0-9]", ""));
                    listOfCellInFormula.add(Controller.table.get(rowNumber).get(colLetter));
                    if( Controller.table.get(rowNumber).get(colLetter) != null
                            && Controller.table.get(rowNumber).get(colLetter).getListOfCellsWhereAppears() != null
                            && !Controller.table.get(rowNumber).get(colLetter).getListOfCellsWhereAppears().contains(this))
                    {
                        Controller.table.get(rowNumber).get(colLetter).addNewCellWhereAppears(this);
                    }
                }
            }
        }
        analyzeFormulaWithParser();
    }

    private void analyzeFormulaWithParser()
    {
        if(analyzeFormula())
        {
            try
            {
                CharStream lineStream = CharStreams.fromString(formula+"+0");
                LibExpLexer lexer = new LibExpLexer(lineStream);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                LibExpParser parser = new LibExpParser(tokens);
                ParseTree tree = parser.input();
                LibExpBaseVisitorImpl calcVisitor = new LibExpBaseVisitorImpl();
                Double value = calcVisitor.visit(tree);
                doubleValue = value;
                stringValue = Double.toString(doubleValue);
                if(listOfCellsWhereAppears != null)
                {
                    for(Cell cell:listOfCellsWhereAppears)
                    {
                        cell.calculateFormulaInCell();
                    }
                }
            }
            catch (NumberFormatException e)
            {
                stringValue = "Error";
                doubleValue = 0;
            }
        }
        else
        {
            if(listOfCellsWhereAppears != null)
            {
                for(Cell cell:listOfCellsWhereAppears)
                {
                    cell.stringValue = "Error";
                    cell.doubleValue = 0;
                }
            }
        }
    }

    private boolean analyzeFormula()
    {
       try
       {
           if(listOfCellInFormula != null)
           {
               for (Cell cell : listOfCellInFormula )
                   analyzeCellThatAppearsInFormula(cell);
           }
       } catch (Exception e)
       {
           doubleValue = 0;
           stringValue = "Error";
           return false;
       }
       return true;
    }

    private void analyzeCellThatAppearsInFormula( Cell cell ) throws Exception
    {
        if( cell.stringValue.equals("Error") || cell.stringValue.equals(""))
            throw new Exception("Value of another cell that is in use is \"Error\" ");

        chechCycle(cell);

    }
    private void chechCycle(Cell cell) throws Exception
    {
        if ( cell.listOfCellInFormula!=null )
        {
            if( cell.listOfCellInFormula.contains(this) )
            {
                setError(cell);
                throw new Exception("Catch value cycle");
            }

            for(Cell cell2 : cell.listOfCellInFormula)
            {
                chechCycle(cell2);
            }
        }
    }
    private void setError(Cell cell)
    {
        cell.setStringValue("Error");
        if(listOfCellsWhereAppears != null)
        {
            for(Cell cell3:listOfCellsWhereAppears)
            {
                cell3.calculateFormulaInCell();
            }
        }

    }


}