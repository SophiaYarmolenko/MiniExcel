package sample;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATNConfigSet;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.tree.ParseTree;

import java.util.BitSet;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class Cell
{
    private String cellName;
    private String cellCol;
    private String stringValue = "";
    private double doubleValue = 0;
    private String formula = "";
    public Set<Cell> listOfCellsWhereAppears = Collections.newSetFromMap(new ConcurrentHashMap<>());;
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

    public Set<Cell> getListOfCellsWhereAppears()
    {
        return listOfCellsWhereAppears;
    }

    public LinkedList<Cell> getListOfCellInFormula()
    {
        return listOfCellInFormula;
    }

    public void calculateFormulaInCell ()
    {
        if(listOfCellInFormula.size() != 0)
        {
            for(Cell cell : listOfCellInFormula)
            {
                cell.listOfCellsWhereAppears.remove(this);
            }
        }
        listOfCellInFormula.clear();

        String stringOnlyWithCell = formula;
        stringOnlyWithCell = stringOnlyWithCell.replaceAll("[-+>^=%<:/*!a-z][0-9]*"," ")
                .replaceAll("[()][0-9]*"," ")
                .replaceAll("[-+<^=%:>/!*][0-9][)]*"," ");
        stringOnlyWithCell = stringOnlyWithCell.trim().replaceAll(" +", " ");

        for(String str : stringOnlyWithCell.split(" "))
        {
            String colLetter = str.replaceAll("[^A-Z]", "");
            if(!colLetter.equals(""))
            {
                if(!str.replaceAll("[^0-9]", "").equals(""))
                {
                    int rowNumber = Integer.parseInt(str.replaceAll("[^0-9]", ""));
                    if( Controller.lastRowIndex >= rowNumber
                            && Controller.table.get(rowNumber) != null
                            && Controller.table.get(rowNumber).get(colLetter) != null )
                    {
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
        }
        try
        {
            analyzeFormulaWithParser();
        }
        catch (IndexOutOfBoundsException e )
        {
            stringValue = "Error";
            doubleValue = 0;
        }
    }

    public void analyzeFormulaWithParser()
    {
        if(analyzeFormula())
        {
            try
            {
                CharStream lineStream = CharStreams.fromString(formula+"+0");
                LibExpLexer lexer = new LibExpLexer(lineStream);
                CommonTokenStream tokens = new CommonTokenStream(lexer);
                LibExpParser parser = new LibExpParser(tokens);
                parser.addErrorListener(new ANTLRErrorListener()
                {
                    @Override
                    public void syntaxError(Recognizer<?, ?> recognizer, Object o, int i, int i1, String s, RecognitionException e)
                    {
                        throw new RuntimeException("syntax error");
                    }

                    @Override
                    public void reportAmbiguity(Parser parser, DFA dfa, int i, int i1, boolean b, BitSet bitSet, ATNConfigSet atnConfigSet) {

                    }

                    @Override
                    public void reportAttemptingFullContext(Parser parser, DFA dfa, int i, int i1, BitSet bitSet, ATNConfigSet atnConfigSet) {

                    }

                    @Override
                    public void reportContextSensitivity(Parser parser, DFA dfa, int i, int i1, int i2, ATNConfigSet atnConfigSet) {

                    }
                });

                ParseTree tree = parser.input();
                LibExpBaseVisitorImpl calcVisitor = new LibExpBaseVisitorImpl();
                Double value = calcVisitor.visit(tree);
                doubleValue = value;
                stringValue = Double.toString(doubleValue);

                if(listOfCellsWhereAppears != null)
                {
                    for ( Cell listOfCellsWhereAppear : listOfCellsWhereAppears)
                    {
                        listOfCellsWhereAppear.calculateFormulaInCell();
                    }

                }
            }
            catch (NumberFormatException e)
            {
                stringValue = "Error";
                doubleValue = 0;
            }
            catch (NullPointerException e)
            {
                stringValue = "Error";
                doubleValue = 0;
            }
            catch (RuntimeException e)
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
        }
        catch (IllegalArgumentException e)
        {
            doubleValue = 0;
            stringValue = "Error";
            return false;
        }
        return true;
    }

    private void analyzeCellThatAppearsInFormula( Cell cell ) throws IllegalArgumentException
    {
        if( cell.stringValue.equals("Error"))
            throw new IllegalArgumentException("Value of another cell that is in use is \"Error\" ");
        chechCycle(cell);

    }
    private void chechCycle(Cell cell) throws IllegalArgumentException
    {
        if ( cell.listOfCellInFormula!=null )
        {
            if( cell.listOfCellInFormula.contains(this) )
            {
                setError(cell);
                throw new IllegalArgumentException("Catch value cycle");
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