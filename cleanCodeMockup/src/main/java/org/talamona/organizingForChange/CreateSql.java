package org.talamona.organizingForChange;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 5/17/13
 * Time: 5:28 PM
 */

public class CreateSql extends AbstractSql{

    public CreateSql(String tableName, Column[] columns){
        super(tableName, columns);
    }
    @Override
    public String generate() {
        return null;
    }
}
