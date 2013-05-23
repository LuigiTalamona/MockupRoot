package org.talamona.organizingForChange;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 5/17/13
 * Time: 5:24 PM
 */
public abstract class AbstractSql {
    private String tableName;
    private Column[] columns;

    public AbstractSql(){

    }

    public AbstractSql(String tableName, Column[] columns){
        this.setTableName(tableName);
        this.setColumns(columns);

    }
    public abstract String generate();

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Column[] getColumns() {
        return columns;
    }

    public void setColumns(Column[] columns) {
        this.columns = columns;
    }
}
