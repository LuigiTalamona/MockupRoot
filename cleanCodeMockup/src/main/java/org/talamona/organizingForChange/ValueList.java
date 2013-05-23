package org.talamona.organizingForChange;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 5/19/13
 * Time: 11:37 AM
 */
public class ValueList implements SqlListGenerator{
    Column[] columns;
    Value[] values;


    public ValueList(Value[] values, Column[] columns){
        this.values = values;
        this.columns = columns;
    }
    @Override
    public String generate() {
        ColumnList c = new ColumnList(this.columns);
        String retValue = "(" + c.generate() + ") VALUES (";
        for (int i = 0; i < values.length; i++) {
            retValue += values[i].getDecoratedValue();
            if ( i < values.length -1){
                retValue += ", ";
            }
        }
        retValue += ")";
        return retValue;
    }
}
