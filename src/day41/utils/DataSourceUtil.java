package day41.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @Author hhy
 * @Date 2019/8/23 11:19
 */
public class DataSourceUtil {
    private static DataSource dataSource;
    static {
        try {
            Properties properties=new Properties();
            InputStream inputStream=DataSourceUtil.class.getResourceAsStream("/druid.properties");
            properties.load(inputStream);
            //工厂类创建数据源
            dataSource=DruidDataSourceFactory.createDataSource(properties);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //得到数据源
    public static DataSource getDataSource(){
        return dataSource;
    }
    //获取连接
    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }
}
