package sample;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.AnchorPane;

public class Controller
{
    public static ObservableList< HashMap<String, Cell> > table = FXCollections.observableArrayList();

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
    void initialize()
    {
        //Editable
        mainTableView.setEditable( true );
        setStartColumns();

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
            lastColIndex = generateNextString(lastColIndex);
            for( int i = 0; i <= lastRowIndex; i++ )
            {
                if ( i == 0 )
                {
                    addNewColumn( lastColIndex );
                }
                Cell cell = new Cell( lastColIndex, "", lastColIndex + i );
                table.get(i).put( lastColIndex, cell );
            }
        }
        );
        addRowButton.setOnAction( actionEvent ->
        {
            lastRowIndex++;
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
        });
        mainTableView.setItems( table );
    }

    private void addNewColumn(String columnName)
    {
        TableColumn< HashMap<String, Cell>, String > col = new TableColumn<HashMap<String, Cell>, String> (columnName);
        col.setCellValueFactory( c-> new SimpleStringProperty(c.getValue().get(columnName).getStringValue()) );
        col.setCellFactory( TextFieldTableCell.< HashMap<String, Cell>> forTableColumn() );
        col.setMinWidth(cellStartWidth);

        //On Cell edit
        col.setOnEditStart( (TableColumn.CellEditEvent< HashMap<String, Cell> , String> event) ->
        {
            TablePosition< HashMap<String, Cell> , String> pos = event.getTablePosition();
            int row = pos.getRow();
            Cell cell = event.getTableView().getItems().get(row).get(columnName);
            formulaLabel.setText(cell.getFormula());
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

            //make column refresh value:
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
}