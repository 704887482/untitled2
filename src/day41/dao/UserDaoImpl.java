package day41.dao;

import day41.pojo.User;
import day41.utils.DataSourceUtil;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

/**
 * @Author hhy
 * @Date 2019/8/23 11:37
 */
public class UserDaoImpl implements UserDao{
    JdbcTemplate jdbc=new JdbcTemplate(DataSourceUtil.getDataSource());
    @Override
    public User login(String username, String password) {
        String sql="select *from user where username = ? and password = ?";
        User user=jdbc.queryForObject(sql,new BeanPropertyRowMapper<User>(User.class),username,password);
        return user;
    }

    @Override
    public List<User> findUser() {
        String sql="select *from user";
        return jdbc.query(sql,new BeanPropertyRowMapper<User>(User.class));
    }

    @Override
    public int addUser(String username, String password) {
        String sql="insert into user values(null,?,?)";
        return jdbc.update(sql);
    }
}
