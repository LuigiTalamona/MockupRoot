package org.talamona.organizingForChange;

import org.mockito.Mockito;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class ColumnListImplTestNG {

    private SqlListGenerator sut;


    @BeforeMethod
    public void setUp() throws Exception {
        Column c1 = Mockito.mock(Column.class);
        Column c2 = Mockito.mock(Column.class);
        Column c3 = Mockito.mock(Column.class);

        Mockito.when(c1.getName()).thenReturn("C1");
        Mockito.when(c2.getName()).thenReturn("C2");
        Mockito.when(c3.getName()).thenReturn("C3");

        Column[] columns = {c1, c2, c3};


        sut = new ColumnList(columns);


    }

    @Test
    public void testGenerate() throws Exception {
        String expected = "C1, C2, C3";
        String actual = sut.generate();

        assertEquals(actual, expected);




    }
}
