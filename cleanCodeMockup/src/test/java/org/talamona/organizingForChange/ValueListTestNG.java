package org.talamona.organizingForChange;

import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 5/19/13
 * Time: 11:38 AM
 */
public class ValueListTestNG {
    private ValueList sut;





    @BeforeMethod
    public void setUp() throws Exception {
        Column c1 = Mockito.mock(Column.class);
        Column c2 = Mockito.mock(Column.class);
        Column c3 = Mockito.mock(Column.class);

        Value v1 = Mockito.mock(Value.class);
        Value v2 = Mockito.mock(Value.class);
        Value v3 = Mockito.mock(Value.class);


        Mockito.when(c1.getName()).thenReturn("C1");
        Mockito.when(c2.getName()).thenReturn("C2");
        Mockito.when(c3.getName()).thenReturn("C3");

        Mockito.when(v1.getDecoratedValue()).thenReturn("'V1'");
        Mockito.when(v2.getDecoratedValue()).thenReturn("'V2'");
        Mockito.when(v3.getDecoratedValue()).thenReturn("'V3'");

        Column[] columns = {c1, c2, c3};
        Value[] values = {v1, v2, v3};

        sut = new ValueList(values, columns);





    }

    @Test
    public void testGenerate() throws Exception {
        String expected = "(C1, C2, C3) VALUES ('V1', 'V2', 'V3')";
        String actual = sut.generate();
        assertEquals(actual, expected);
    }
}
