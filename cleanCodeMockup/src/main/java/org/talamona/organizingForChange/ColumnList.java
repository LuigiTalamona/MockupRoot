package org.talamona.organizingForChange;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 5/19/13
 * Time: 11:08 AM
 */

public class ColumnList implements SqlListGenerator {

    private Column[] columns;

    public ColumnList(Column[] columns){
        this.columns = columns;

    }

    @Override
    public String generate() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < columns.length; i ++){
            buffer.append(columns[i].getName());
            if (i < columns.length - 1){
                buffer.append(", ");
            }
        }
        return buffer.toString();
    }
}
