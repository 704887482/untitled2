package utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author hhy
 * @Date 2019/8/8 17:22
 */
public class DataSourceUtils {
    private static DataSource ds;

    static {
        Properties info=new Properties();
        InputStream in=DataSourceUtils.class.getResourceAsStream("/druid.properties");
        try {
            info.load(in);
            ds= DruidDataSourceFactory.createDataSource(info);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        return ds;
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
