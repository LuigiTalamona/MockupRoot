package org.talamona.organizingForChange;

import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.MockitoAnnotations.Mock;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 5/19/13
 * Time: 12:26 PM
 */
@PrepareForTest(InsertSqlTestNG.class)
public class InsertSqlTestNG {

    private final String TABLE_NAME = "MYTABLE";
    private Column[] columns;
    private Value[] values;

    @InjectMocks private InsertSql sut = new InsertSql(TABLE_NAME, columns, values);
    @Mock private ValueList valueList;

    @BeforeMethod
    public void initMocks(){
        MockitoAnnotations.initMocks(this);
    }

    @BeforeMethod
    public void setup(){
        Mockito.when(valueList.generate()).thenReturn("(C1, C2, C3) VALUES ('V1', 'V2', 'V3')");
    }

    @Test
    public void testGenerate() throws Exception {
        String expected = "INSERT INTO " + TABLE_NAME + "(C1, C2, C3) VALUES ('V1', 'V2', 'V3');";
        String actual = this.sut.generate();
        assertEquals(actual, expected);
    }
}
