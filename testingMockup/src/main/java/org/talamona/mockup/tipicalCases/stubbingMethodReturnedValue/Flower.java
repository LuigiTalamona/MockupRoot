package org.talamona.mockup.tipicalCases.stubbingMethodReturnedValue;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 1/2/14
 * Time: 2:31 PM
 */
public class Flower {
    private int numberOfLeaf;

    public Flower(){
        this.numberOfLeaf = 4;
    }
    public Flower(int numberOfLeaf){
        this.numberOfLeaf = numberOfLeaf;
    }

    public int getNumberOfLeaf(){
        return this.numberOfLeaf;
    }

    public void setNumberOfLeaf(int numberOfLeaf){
        this.numberOfLeaf = numberOfLeaf;
    }

}
