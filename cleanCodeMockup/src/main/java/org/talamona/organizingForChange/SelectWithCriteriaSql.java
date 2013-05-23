package org.talamona.organizingForChange;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 5/17/13
 * Time: 5:28 PM
 */

public class SelectWithCriteriaSql extends AbstractSql{

    private final String START_SELECT="SELECT ";
    private final String FROM = " FROM ";
    private final String END_ROW = ";";


    private Criteria criteria;
    private SqlListGenerator columnList;

    public SelectWithCriteriaSql(){
        super();
    }

    public SelectWithCriteriaSql(String tableName, Column[] columns, Criteria criteria){
        super(tableName, columns);
        this.criteria = criteria;
    }

    @Override
    public String generate() {
        String retValue = START_SELECT + this.columnList.generate();
        retValue += FROM + this.getTableName() + " " + this.criteria.getWhereCriteria() + END_ROW;
        return retValue;
    }
}
