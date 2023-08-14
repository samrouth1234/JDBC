import org.postgresql.ds.PGSimpleDataSource;

import javax.sql.DataSource;

public class JdbcImp {
    public DataSource dataSource(){

        PGSimpleDataSource dataSource =new PGSimpleDataSource();
        dataSource.setUser("postgres");
        dataSource.setPassword("samrouth020320");
        dataSource.setDatabaseName("postgres");
        return dataSource;
    }

}
