package cn.itcast.jdbc;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo1 {

	//1添加操作
	@Test
	public void add(){
		//设置数据库信息
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql:///spring_jdbc_template");
		datasource.setUsername("root");
		datasource.setPassword("wei_150");
		
		//创建jdbc Template对象，设置数据项
		JdbcTemplate jdbctemplate=new JdbcTemplate(datasource);
		//使用jdbctemplate对象里面的方法实现操作
		//创建sql语句
		String sql="insert into user values(?,?)";
		int n=jdbctemplate.update(sql,"lucy","20");
		n=jdbctemplate.update(sql,"jack","21");
		 n=jdbctemplate.update(sql,"jon","22");
		 n=jdbctemplate.update(sql,"tom","23");
		System.out.println(n);
		
	}
	
	//设置数据库信息
	//@Test
	public void update(){
		//设置数据库信息
				DriverManagerDataSource datasource=new DriverManagerDataSource();
				datasource.setDriverClassName("com.mysql.jdbc.Driver");
				datasource.setUrl("jdbc:mysql:///spring_jdbc_template");
				datasource.setUsername("root");
				datasource.setPassword("wei_150");
				
				//创建jdbc Template对象，设置数据项
				JdbcTemplate jdbctemplate=new JdbcTemplate(datasource);
		String sql="update user set password=? where username=?";
		int rows=jdbctemplate.update(sql,"1314","lucy");
		System.out.println(rows);
	}
	
	//删除操作
	//@Test
	public void delete(){
		//设置数据库信息
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql:///spring_jdbc_template");
		datasource.setUsername("root");
		datasource.setPassword("wei_150");
		
		//创建jdbc Template对象，设置数据项
		JdbcTemplate jdbctemplate=new JdbcTemplate(datasource);
		String sql="delete from user where username=?";
		int rows=jdbctemplate.update(sql,"lucy");
		System.out.println(rows);
			
	}
	
	//查询操作
	
	
	
	
}
