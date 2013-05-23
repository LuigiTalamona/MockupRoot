package org.talamona.organizingForChange;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 4/30/13
 * Time: 2:12 PM
 */

import org.mockito.Mockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * @author luigi
 */
@PrepareForTest(SelectSqlTestNG.class)
public class SelectSqlTestNG {
    private SelectSql sut;

    private final String TABLE_NAME = "MYTABLE";
    private final String COLUMN_1 = "COLONNA1";
    private final String COLUMN_2 = "COLONNA2";
    private final String COLUMN_3 = "COLONNA3";


    public SelectSqlTestNG() {
    }


    @BeforeMethod
    public void setup() {
        Column c1 = Mockito.mock(Column.class);
        Mockito.when(c1.getName()).thenReturn(COLUMN_1);

        Column c2 = Mockito.mock(Column.class);
        Mockito.when(c2.getName()).thenReturn(COLUMN_2);

        Column c3 = Mockito.mock(Column.class);
        Mockito.when(c3.getName()).thenReturn(COLUMN_3);

        Column[] cols = {c1, c2, c3};

        sut = new SelectSql(TABLE_NAME, cols);
        // Run before every test method
    }
    /*
    @DataProvider
    private Object[][] getTestValues() {
        return new Object[][]{
                {"", ""},
                {"", ""},
                {"", ""},
                {"", ""}};
    }
    */


    @Test/* (dataProvider = "getIllegalTestValues", expectedExceptions = NullPointerException.class)*/
    public void shouldBeCreateSelectStatement() throws Exception {
        String expectedValue = "SELECT " + COLUMN_1 + ", " + COLUMN_2 + ", " + COLUMN_3 + " FROM " + TABLE_NAME +";";
        String actual = sut.generate();

        assertEquals(actual, expectedValue);
    }
}