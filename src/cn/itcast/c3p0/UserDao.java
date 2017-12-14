package cn.itcast.c3p0;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

//import cn.itcast.jdbc.MyRowMapper;
import cn.itcast.jdbc.User;

public class UserDao {
	
	//得到jdbcTemplate模板对象
	private JdbcTemplate jdbctemplate;
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	
	//添加操作
	public void add(){
		System.out.println("UserDao....");
		
//		String sql="insert into user values(?,?)";
//		jdbctemplate.update(sql,"lixue","520");
		
		System.out.println("UserDao...over");
		
		
		//写sql语句
		 String sql="select * from user";
		//调用jdbcTemplate的方法实现
		List<User> list=jdbctemplate.query(sql,new MyRowMapper());
		
		System.out.println(list);
			
	}

}


class MyRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int num) throws SQLException {
		//1 从结果集里面吧数据得到
		String username=rs.getString("username");
		String pass=rs.getString("password");
		
		//2 把得到的数据封装到对象中
		User user=new User();
		user.setPassword(pass);
		user.setUsername(username);
		
		return user;
	}
	
}
