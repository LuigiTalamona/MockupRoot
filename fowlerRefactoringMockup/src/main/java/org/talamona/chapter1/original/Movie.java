package org.talamona.chapter1.original;

/**
 *
 * @author luigi
 */
public class Movie {
    
    private String title;
    private codes priceCode;

    
    
    public static enum codes{
        STANDARD, CHILDREN, NEWS;
    }
    
    public codes getPriceCode(){
        return this.priceCode;
    }
    public void setPriceCode(codes code){
        this.priceCode = code;
    }
    
    public String getTitle() {
        return this.title;
    }
    public void setTitle(String title) {
        this.title = title;
    }
}
