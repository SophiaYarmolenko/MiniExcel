package sample;

import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import javafx.beans.property.ReadOnlyObjectWrapper;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.util.Callback;
import org.stringtemplate.v4.ST;

public class Controller
{
    public static ObservableList< HashMap<String, Cell> > table = FXCollections.observableArrayList();
    public ObservableList<Number> rowColumn = FXCollections.observableArrayList();
    private double cellStartWidth = 50.0;
    private double cellStartHeight = 12;
    public double tableWidth = 1500.0; // change it if you change in sample.fxml
    public double tableHeight = 325.0; // change it if you change in sample.fxml
    public static String lastColIndex = "A";
    public static int lastRowIndex = 0;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private AnchorPane mainAnchorPane;

    @FXML
    private TableView <HashMap<String, Cell>> mainTableView;

    @FXML
    private TextField formulaLabel;

    @FXML
    private TextField formulaNameLabel;

    @FXML
    private Button addColButton;

    @FXML
    private Button addRowButton;

    @FXML
    private Button showInstructionButton;

    @FXML
    private AnchorPane instructionAnchorPane;

    @FXML
    private Button closeButton;

    @FXML
    public AnchorPane saveOpenAnchorPane;

    @FXML
    private TextField saveOpenFileTextField;

    @FXML
    private Button openFileDialogButton;

    @FXML
    private Button saveButton;

    @FXML
    private Button openButton;

    @FXML
    private Button doneButton;

    @FXML
    private Button cancelButton;

    @FXML
    private Button removeColButton;

    @FXML
    private Button removeRowButton;

    @FXML
    private TableView<Number> rowColumnTableView = new TableView<Number>(rowColumn);

    private class Number
    {
        public int number;
        Number(int number)
        {
            this.number = number;
        }
    }

    @FXML
    void initialize()
    {
        //Editable
        mainTableView.setEditable( true );
        saveOpenAnchorPane.setDisable(true);
        saveOpenAnchorPane.setOpacity(0);
        setDeleteColButton();
        setStartColumns();
        addRowCol();
        setDeleteRowButton();
        cancelButton.setOnAction( actionEvent ->
        {
            saveOpenAnchorPane.setDisable(true);
            saveOpenAnchorPane.setOpacity(0);
            saveOpenFileTextField.setText("");
        });

        showInstructionButton.setOnAction( actionEvent ->
        {
            instructionAnchorPane.setOpacity(0.9);
            instructionAnchorPane.setDisable(false);
        } );
        closeButton.setOnAction(actionEvent ->
        {
            instructionAnchorPane.setOpacity(0);
            instructionAnchorPane.setDisable(true);
        });

        addColButton.setOnAction ( actionEvent ->
        {
            addCol();
        }
        );
        addRowButton.setOnAction( actionEvent ->
        {
            addRow();
        });
        mainTableView.setItems( table );
        Stage stage = new Stage();
        save(stage);
        Stage stage2 = new Stage();
        open(stage2);
    }

    private void addRowCol()
    {
        for(int i = 0; i < lastRowIndex; i++)
        {
            rowColumn.add(new Number(i));
        }

        TableColumn<Number, Integer> rowCol = new TableColumn<Number, Integer>("№");
       // rowCol.setMaxWidth(46);
        rowCol.setCellValueFactory(new Callback<TableColumn.CellDataFeatures<Number, Integer>, ObservableValue<Integer>>() {
            public ObservableValue<Integer> call(TableColumn.CellDataFeatures<Number, Integer> p) {
                return new ReadOnlyObjectWrapper(p.getValue().number);
            }
        });
        rowColumnTableView.getColumns().add(rowCol);
        rowColumnTableView.setItems( rowColumn );
    }
    private void addCol()
    {
        lastColIndex = generateNextString(lastColIndex);
        if(lastColIndex.equals("B"))
        {
            removeColButton.setVisible(true);
            removeColButton.setOpacity(1);
        }
        for( int i = 0; i <= lastRowIndex; i++ )
        {
            if ( i == 0 )
            {
                addNewColumn( lastColIndex );
            }
            Cell cell = new Cell( lastColIndex, "", lastColIndex + i );
            table.get(i).put( lastColIndex, cell );
        }
        resetTable();
    }
    private void addRow()
    {
        lastRowIndex++;
        if( lastRowIndex == 1 )
        {
            removeRowButton.setVisible(true);
            removeRowButton.setOpacity(1);
        }
        HashMap<String, Cell> map = new HashMap<String, Cell>();
        String colIndex = "A";
        while ( !colIndex.equals(lastColIndex) )
        {
            Cell cell = new Cell( colIndex, "", colIndex + lastRowIndex );
            map.put( colIndex, cell );
            colIndex = generateNextString( colIndex );
        }
        Cell cell = new Cell( colIndex, "", colIndex + lastRowIndex );
        map.put( colIndex, cell );
        table.add(map);
        resetTable();
    }
    private void setDeleteColButton ()
    {
        removeColButton.setOnAction( actionEvent ->
        {
            deleteLastCol();
        });
    }
    private void deleteLastCol()
    {
        deleteCol(lastColIndex);
        lastColIndex = generatePreviousString(lastColIndex);
        if(lastColIndex.equals("A"))
        {
            removeColButton.setVisible(false);
            removeColButton.setOpacity(0);
        }
    }
    private void deleteCol (String colName)
    {
        try
        {
            for( HashMap<String, Cell> map : table )
            {
                map.get(colName).setStringValue("Error");
                resetTable();
                map.remove(colName);
            }
            for( TableColumn column : mainTableView.getColumns())
            {
                if( column.getText().equals(colName) )
                {
                    mainTableView.getColumns().remove(column);
                    break;
                }
            }
        }
        catch (Exception e){}
    }

    private void setDeleteRowButton ()
    {
        removeRowButton.setOnAction( actionEvent ->
        {
           deleteLastRow();
        });
    }
    private void deleteLastRow()
    {
        deleteRow(lastRowIndex);
        lastRowIndex--;
        if(lastRowIndex == 0)
        {
            removeRowButton.setVisible(false);
            removeRowButton.setOpacity(0);
        }
    }
    private void deleteRow (int rowName)
    {
        try
        {
            for(Cell cell : table.get(rowName).values())
            {
                cell.setStringValue("Error");
                resetTable();
            }
            table.remove(rowName);
            mainTableView.refresh();
        }
        catch (Exception e){}
    }

    private void save(Stage primaryStage)
    {
        saveButton.setOnAction(actionEvent ->
        {
            AtomicBoolean fromFileDialog = new AtomicBoolean(false);
            saveOpenAnchorPane.setDisable( false );
            saveOpenAnchorPane.setOpacity(0.9);
            saveOpenFileTextField.setPromptText("Введіть назву файла для збереження");

            openFileDialogButton.setOnAction( actionEvent1 ->
            {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                File file = fileChooser.showOpenDialog(primaryStage);
                saveOpenFileTextField.setText( file.getName() );
                fromFileDialog.set(true);
                saveFromFile(file);
            });

            if( !fromFileDialog.get() )
            {
                saveFromFileName();
            }
        });
    }

    private void saveFromFile(File file)
    {
        doneButton.setOnAction(actionEvent2 ->
        {
            try
            {
                FileWriter fileWriter = new FileWriter( file );
                fileWriter.write(lastRowIndex + " " + lastColIndex);
                fileWriter.append('\n');
                for ( HashMap<String, Cell> map : Controller.table )
                {
                    for( Cell cell : map.values() )
                    {
                        if(!cell.getStringValue().equals(""))
                        {
                            fileWriter.write(cell.getCellCol() + " "
                                                + cell.getCellName() + " "
                                                + cell.getStringValue() + " "
                                                + cell.getFormula());
                            fileWriter.append('\n');
                        }
                    }
                }
                fileWriter.close();
                saveOpenAnchorPane.setDisable( true );
                saveOpenAnchorPane.setOpacity(0);
            }
            catch (IOException e)
            {
                saveOpenFileTextField.setPromptText("Назва файлу не коректна. Введіть правильну назву файла");
            }

        });
    }

    private void saveFromFileName()
    {
        String fileName = saveOpenFileTextField.getText();
        File file = new File(fileName);
        saveFromFile(file);
    }

    private void open(Stage stage)
    {
        openButton.setOnAction(actionEvent ->
        {
            AtomicBoolean fromFileDialog = new AtomicBoolean(false);
            saveOpenAnchorPane.setDisable( false );
            saveOpenAnchorPane.setOpacity(0.9);
            saveOpenFileTextField.setPromptText("Введіть назву файла для відкриття");

            openFileDialogButton.setOnAction( actionEvent1 ->
            {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("Open Resource File");
                File file = fileChooser.showOpenDialog(stage);
                saveOpenFileTextField.setText( file.getName() );
                fromFileDialog.set(true);
                openFromFile(file);
            });

            if( !fromFileDialog.get() )
            {
               openFromFileName();
            }
        });
    }

    private void openFromFile(File file)
    {
        doneButton.setOnAction(actionEvent2 ->
        {
            try
            {
                FileReader fileReader = new FileReader( file );
                Scanner scanner = new Scanner(fileReader);
                String firstLine  = scanner.nextLine();
                int expectedRow = Integer.parseInt(firstLine.split(" ")[0]);
                String expectedCol = firstLine.split(" ")[1];
                setTableSizeFromFile(expectedRow, expectedCol);
                clearTable();
                while( scanner.hasNext() )
                {
                    String[] line = scanner.nextLine().split(" ");
                    String col = line[0];
                    int row = Integer.parseInt(line[1].replaceAll(col, ""));
                    table.get(row).get(col).setStringValue(line[2]);
                    table.get(row).get(col).setFormula(line[3]);
                    mainTableView.refresh();
                }
                fileReader.close();
                resetTable();
                saveOpenAnchorPane.setDisable( true );
                saveOpenAnchorPane.setOpacity(0);
            }
            catch (IOException e)
            {
                saveOpenFileTextField.setPromptText("Назва файлу не коректна. Введіть правильну назву файла");
            }

        });
    }

    private void clearTable()
    {
        for(HashMap<String, Cell> map : table)
        {
            for(Cell cell : map.values())
            {
                cell.setStringValue("");
                cell.setFormula("");
                cell.setDoubleValue(0);
            }
        }
    }

    private void openFromFileName()
    {
        String fileName = saveOpenFileTextField.getText();
        File file = new File(fileName);
        openFromFile(file);
    }
    private void setTableSizeFromFile(int expectedRow, String expectedCol)
    {
        if(lastRowIndex < expectedRow)
        {
            while( lastRowIndex != expectedRow )
            {
                addRow();
            }
        }
        else if(lastRowIndex > expectedRow)
        {
            while( lastRowIndex != expectedRow )
            {
                deleteLastRow();
            }
        }
        if(lastColIndex.compareTo(expectedCol) < 0)
        {
            while( !lastColIndex.equals(expectedCol) )
            {
                addCol();
            }
        }
        else if( lastColIndex.compareTo(expectedCol) > 0)
        {
            while( !lastColIndex.equals(expectedCol) )
            {
                deleteLastCol();
            }
        }
    }

    private void addNewColumn(String columnName)
    {
        TableColumn< HashMap<String, Cell>, String > col = new TableColumn<HashMap<String, Cell>, String> (columnName);
        col.setCellValueFactory( c-> new SimpleStringProperty(c.getValue().get(columnName).getStringValue()) );
        col.setCellFactory( TextFieldTableCell.< HashMap<String, Cell>> forTableColumn() );
        col.setMinWidth(cellStartWidth);

        col.setOnEditStart( (TableColumn.CellEditEvent< HashMap<String, Cell> , String> event) ->
                {
                    TablePosition< HashMap<String, Cell> , String> pos = event.getTablePosition();
                    int row = pos.getRow();
                    Cell cell = event.getTableView().getItems().get(row).get(columnName);
                    formulaLabel.setText(cell.getFormula());
                    formulaNameLabel.setText(cell.getCellName());
                }
        );

        // On Cell edit commit (for col)
        col.setOnEditCommit( (TableColumn.CellEditEvent< HashMap<String, Cell> , String> event) ->
        {
            TablePosition< HashMap<String, Cell> , String> pos = event.getTablePosition();
            String newFormula = event.getNewValue();
            int row = pos.getRow();
            Cell cell = event.getTableView().getItems().get(row).get(columnName);
            formulaLabel.setText(cell.getFormula());
            cell.setFormula(newFormula);
            cell.calculateFormulaInCell();
            formulaLabel.setText(cell.getFormula());
            formulaNameLabel.setText(cell.getCellName());
            mainTableView.setItems(table);
            resetTable();
            col.setVisible(false);
            col.setVisible(true);
        });
        mainTableView.getColumns().add(col);
    }

    private void setStartColumns()
    {
        int columnsNumber = (int) ( tableWidth / cellStartWidth );
        int rowNumber = (int) ( tableHeight / cellStartHeight );
        String colIndex = "A";
        lastRowIndex = rowNumber-1;
        for( int i = 0; i < rowNumber; i++ )
        {
            HashMap<String, Cell> map = new HashMap<String, Cell>();
            colIndex = "A";
            for( int j = 0; j < columnsNumber; j++ )
            {
                if ( i == 0 )
                {
                    addNewColumn( colIndex );
                    if( j == columnsNumber - 1)
                    {
                        lastColIndex = colIndex;
                    }
                }
                Cell cell = new Cell( colIndex, "", colIndex + i );
                map.put( colIndex, cell );
                colIndex = generateNextString( colIndex );
            }
            table.add(map);

        }
    }

    //generate next string ("A" -> B, "AZ" -> "BA", "ZZ" -> "AAA" ... )
    private String generateNextString( String previousString )
    {
        StringBuilder nextString = new StringBuilder();
        int stringLength = previousString.length();
        for ( int i = stringLength - 1; i >= 0; i-- )
        {
            char ch = previousString.charAt(i);
            if( ch < 'Z' )
            {
                nextString.append( previousString.substring(0 , i) );
                nextString.append( generateNextLetter(ch) );
                for( int j = i + 1; j < stringLength; j++ )
                    nextString.append('A');
                break;
            }
            else
            {
                if( i == 0 )
                {
                    for( int j = 0; j <= stringLength; j++ )
                        nextString.append('A');
                }
            }
        }
        return nextString.toString();
    }

    // for generation next letter use ASCII cod
    // A = 65 ... Z = 90
    private char generateNextLetter( char previousLetter )
    {
        if ('A' <= previousLetter && previousLetter < 'Z')
        {
            int asciiPreviousLetter = (int) previousLetter;
            asciiPreviousLetter++;
            return (char) asciiPreviousLetter;
        }
        throw new IllegalArgumentException( String.valueOf(previousLetter) );
    }

    private String generatePreviousString( String nextString )
    {
        StringBuilder previousString = new StringBuilder();
        int stringLength = nextString.length();
        for ( int i = stringLength - 1; i >= 0; i-- )
        {
            char ch = nextString.charAt(i);
            if( ch > 'A' )
            {
                previousString.append( nextString.substring(0 , i) );
                previousString.append( generatePreviousLetter(ch) );
                for( int j = i + 1; j < stringLength; j++ )
                    previousString.append('Z');
                break;
            }
            else
            {
                if( i == 0 )
                {
                    for( int j = 0; j < stringLength - 1; j++ )
                        previousString.append('Z');
                }
            }
        }
        return previousString.toString();
    }

    private char generatePreviousLetter( char nextLetter )
    {
        if ('A' < nextLetter && nextLetter <= 'Z')
        {
            int asciiPreviousLetter = (int) nextLetter;
            asciiPreviousLetter--;
            return (char) asciiPreviousLetter;
        }
        throw new IllegalArgumentException( String.valueOf(nextLetter) );
    }

    public static void resetTable()
    {
        for( HashMap<String, Cell> map : table )
        {
            for(Cell cell : map.values() )
            {
                if( !cell.getStringValue().equals("") && !cell.getStringValue().equals("Error"))
                {
                    cell.calculateFormulaInCell();
                }
            }
        }
    }
}