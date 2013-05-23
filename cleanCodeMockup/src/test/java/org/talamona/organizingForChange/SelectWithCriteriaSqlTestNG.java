package org.talamona.organizingForChange;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 4/30/13
 * Time: 2:12 PM
 */

import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoAnnotations.Mock;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

/**
 * @author luigi
 */
public class SelectWithCriteriaSqlTestNG {

    private final String TABLE_NAME = "MYTABLE";
    private Column[] columns;

    @Mock
    SqlListGenerator columnList;
    @Mock Criteria criteria;
    @InjectMocks private SelectWithCriteriaSql sut = new SelectWithCriteriaSql(TABLE_NAME, columns, criteria);


    public SelectWithCriteriaSqlTestNG() {
    }

    @BeforeMethod
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void setup() {



        Column c1 = Mockito.mock(Column.class);
        Mockito.when(c1.getName()).thenReturn("COLUMN_1");

        Column c2 = Mockito.mock(Column.class);
        Mockito.when(c2.getName()).thenReturn("COLUMN_2");

        Column c3 = Mockito.mock(Column.class);
        Mockito.when(c3.getName()).thenReturn("COLUMN_3");


        Mockito.when(criteria.getWhereCriteria()).thenReturn("WHERE COLUMN_1 = 'TEST'");
        Mockito.when(columnList.generate()).thenReturn("COLUMN_1, COLUMN_2, COLUMN_3");


        columns = new Column[3];
        columns[0] = c1;
        columns[1] = c2;
        columns[2] = c3;
   // Run before every test method
    }



    @Test
    public void testMethodName() throws Exception {
        String expected = "SELECT COLUMN_1, COLUMN_2, COLUMN_3 FROM MYTABLE WHERE COLUMN_1 = 'TEST';";
        String actual = sut.generate();
        assertEquals(actual, expected);

    }

}