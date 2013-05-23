package org.talamona.organizingForChange;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 5/17/13
 * Time: 5:28 PM
 */

public class InsertSql extends AbstractSql{
    private Value[] fields;
    private ValueList valueList;

    public InsertSql(String tableName, Column[] columns, Value[] fields){
        super(tableName, columns);
        this.fields = fields;
        this.valueList = new ValueList(fields, columns);
    }

    @Override
    public String generate() {
        return "INSERT INTO " + this.getTableName() + this.valueList.generate() + ";";
    }
}
