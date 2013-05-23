package org.talamona.organizingForChange;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 5/17/13
 * Time: 5:28 PM
 */

public class SelectSql extends AbstractSql{

    private final String START_SELECT="SELECT ";
    private final String FROM = " FROM ";
    private final String END_ROW = ";";

    private SqlListGenerator columnList;

    public SelectSql(String tableName, Column[] columns){
        super(tableName, columns);
        this.columnList = new ColumnList(columns);
    }
    @Override
    public String generate() {
        String retValue = START_SELECT;
        retValue += this.columnList.generate();
        retValue += FROM + this.getTableName() + END_ROW;
        return retValue;
    }
}
