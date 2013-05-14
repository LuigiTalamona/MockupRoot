package org.talamona.meaningfulNames;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luigi
 */
public class NoGoodNames {
    
    int d; // It's necessary to explain what is and when use it
           // for example: elapsed time in day
    
    int elapsedTimeInDay;
    int daySinceCreation;
    int daysSinceModification;
    int fileAgeInDays;
    
    private List<int[]> theList;
    private List<int[]> gameBoard;
    private List<Cell> cellsGameBoard;
    
    private final int STATUS_VALUE = 0;
    private final int FLAGGED = 4;
    
    public List<int[]> getThem(){
        List<int[]> list1 = new ArrayList<int[]>();
        for (int[] x: this.theList){
            if (x[0] == 4){
                list1.add(x);
            }
        }
        return list1;
    }
    
    public List<int[]> getFlaggedCells(){
        List<int[]> flaggedCells = new ArrayList<int[]>();
        for (int[] cell: this.gameBoard){
            if (cell[STATUS_VALUE] == FLAGGED){
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }
    
    public List<Cell> getFlaggedCellsUsingCellClass(){
        List<Cell> flaggedCells = new ArrayList<Cell>();
        for (Cell cell: this.cellsGameBoard){
            if (cell.isFlagged()){
                flaggedCells.add(cell);
            }
        }
        return flaggedCells;
    }
    
    public void copyChars(char[] a1, char[] a2){
        for (int i = 0; i < a1.length; i ++){
            a2[i] = a1[i];
        }
    }
    public void copyCharsWithBetterNames(char[] source, char[] destination){
        for (int i = 0; i < source.length; i ++){
            destination[i] = source[i];
        }
    }
    
}
