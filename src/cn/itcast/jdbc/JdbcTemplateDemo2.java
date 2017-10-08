package cn.itcast.jdbc;



import java.beans.PropertyVetoException;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mysql.jdbc.*;




public class JdbcTemplateDemo2 {
	
	
	//2jdbc代码
	@Test
	public void testJDBC(){
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		//加载驱动
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//创建连接
			conn= (Connection) DriverManager.getConnection("jdbc:mysql:///spring_jdbc_template","root","wei_150");
			String sql="select * from user where username=?";
			//预编译sql
			psmt=(PreparedStatement) conn.prepareStatement(sql);
			//设置参数值
			psmt.setString(1, "lucy");
			//执行sql
			rs=psmt.executeQuery();
			//遍历结果集
			while(rs.next()){
				String username=rs.getString("username");
				String password=rs.getString("password");
				
				User user=new User();
				user.setUsername(username);
				user.setPassword(password);
				System.out.println(user);
			}
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			try {
				rs.close();
				psmt.close();
				conn.close();
			} catch (SQLException ee) {
				// TODO Auto-generated catch block
				ee.printStackTrace();
			}
			
		}
	}
	
	
	//1、
	//@Test
	public void testCount(){
		//设置数据库信息
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql:///spring_jdbc_template");
		datasource.setUsername("root");
		datasource.setPassword("wei_150");
		
		//创建jdbc Template对象，设置数据项
		JdbcTemplate jdbctemplate=new JdbcTemplate(datasource);
		
		String sql="select count(*) from user";
		
		int count=jdbctemplate.queryForObject(sql, Integer.class);
		System.out.println(count);
		
	}
	
	//3、查询返回对象
	//@Test
	public void testObject(){
		//设置数据库信息
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql:///spring_jdbc_template");
		datasource.setUsername("root");
		datasource.setPassword("wei_150");
		
		//创建jdbc Template对象，设置数据项
		JdbcTemplate jdbctemplate=new JdbcTemplate(datasource);
		
		String sql="select * from user where username=?";
		
		User user =jdbctemplate.queryForObject(sql, new MyRowMapper(),"tom");
		System.out.println(user);
		
		
	}
	
	//4返回list集合
	@Test
	public void testList(){
		//创建连接池
	/*	ComboPooledDataSource dataSource=new ComboPooledDataSource();
		try {
			dataSource.setDriverClass("com.mysql.jdbc.Driver");
			dataSource.setJdbcUrl("jdbc:mysql:///spring_jdbc_template");
			dataSource.setUser("root");
			dataSource.setPassword("wei_150");
		} catch (PropertyVetoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		
		//********************//
		//设置数据库信息
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql:///spring_jdbc_template");
		datasource.setUsername("root");
		datasource.setPassword("wei_150");
		
		//创建jdbc Template对象，设置数据项
		JdbcTemplate jdbctemplate=new JdbcTemplate(datasource);
		
		//写sql语句
		String  sql="select * from user";
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
