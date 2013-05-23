package org.talamona.organizingForChange;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 5/17/13
 * Time: 3:59 PM
 */
public interface Sql {
    public String create();
    public String insert(Object[] fields);
    public String selectAll();
    public String findByKey(String keyColumn, String keyValue);
    public String select(Column column, String pattern);
    public String select(Criteria criteria);
    public String preparedInsert();

    /*
    private String columnList(Column[] columns);
    */
}
