package src.com._520it._01_dbcp;

import static org.junit.Assert.*;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.Test;

public class DBCPTest {
    @Test
    public void testName() throws Exception {
        
        BasicDataSource ds = new BasicDataSource();
        ds.setDriverClassName("");
    }
}
