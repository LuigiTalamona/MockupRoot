package org.talamona.chapter6.example6_9_3;

import java.util.Collection;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import static org.fest.assertions.Assertions.assertThat;


/**
 *
 * @author luigi
 */
public class TestingCollectionsByPropertyFESTNGTest {
    private Collection<Book> books;
    
    

    public TestingCollectionsByPropertyFESTNGTest() {
    }


    @BeforeMethod
    public void setup(){
        books = new HashSet<Book>();
        books.add(new Book("Nicolai Lilin", "Caduta libera"));
        books.add(new Book("Tomasi di Lampedusa","Il gattopardo"));
        
        
        
    }
    
    @Test
    public void testLookingIntoProperties(){
        assertThat(books).onProperty("title").contains("Caduta libera");
        assertThat(books).onProperty("author").contains("Tomasi di Lampedusa");
        
    }
}