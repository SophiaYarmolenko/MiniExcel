package sample;

import org.junit.Assert;

import java.util.LinkedList;

class CellTest
{
    @org.junit.jupiter.api.Test
    void analyzeFormulaWithParser()
    {
        String formula1 = "15%2+15^2-3*(6-4/2)>=5^2*pi/e-8:3+1";
        String formula2 = "         15%2 +15^2  -3* (6-4/ 2 )>=5 ^2 *pi  /e-8: 3+1 ";
        String formula3 = " 1*2 != 2";

        Cell cell1 = new Cell("A", formula1, "A0");
        Cell cell2 = new Cell("A", formula2, "A1");
        Cell cell3 = new Cell("A", formula3, "A2");

        LinkedList<String> expected = new LinkedList<>();
        expected.add("1.0");
        expected.add("1.0");
        expected.add("0.0");

        cell1.analyzeFormulaWithParser();
        cell2.analyzeFormulaWithParser();
        cell3.analyzeFormulaWithParser();
        LinkedList<String> actual = new LinkedList<>();
        actual.add( cell1.getStringValue() );
        actual.add( cell2.getStringValue() );
        actual.add( cell3.getStringValue() );

        Assert.assertEquals(expected, actual);
    }
}