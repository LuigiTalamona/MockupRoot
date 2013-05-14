package org.talamona.meaningfulNames;

/**
 *
 * @author luigi
 */
public class Cell {

    private final int STATUS_VALUE = 0;
    private final int FLAGGED = 4;
    private int[] status;

    public boolean isFlagged() {
        return (status[STATUS_VALUE] == FLAGGED);
    }
}
