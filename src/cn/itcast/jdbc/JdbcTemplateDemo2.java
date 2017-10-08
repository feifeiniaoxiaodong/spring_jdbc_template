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
	
	
	//2jdbc����
	@Test
	public void testJDBC(){
		Connection conn=null;
		PreparedStatement psmt=null;
		ResultSet rs=null;
		//��������
		try{
			Class.forName("com.mysql.jdbc.Driver");
			//��������
			conn= (Connection) DriverManager.getConnection("jdbc:mysql:///spring_jdbc_template","root","wei_150");
			String sql="select * from user where username=?";
			//Ԥ����sql
			psmt=(PreparedStatement) conn.prepareStatement(sql);
			//���ò���ֵ
			psmt.setString(1, "lucy");
			//ִ��sql
			rs=psmt.executeQuery();
			//���������
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
	
	
	//1��
	//@Test
	public void testCount(){
		//�������ݿ���Ϣ
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql:///spring_jdbc_template");
		datasource.setUsername("root");
		datasource.setPassword("wei_150");
		
		//����jdbc Template��������������
		JdbcTemplate jdbctemplate=new JdbcTemplate(datasource);
		
		String sql="select count(*) from user";
		
		int count=jdbctemplate.queryForObject(sql, Integer.class);
		System.out.println(count);
		
	}
	
	//3����ѯ���ض���
	//@Test
	public void testObject(){
		//�������ݿ���Ϣ
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql:///spring_jdbc_template");
		datasource.setUsername("root");
		datasource.setPassword("wei_150");
		
		//����jdbc Template��������������
		JdbcTemplate jdbctemplate=new JdbcTemplate(datasource);
		
		String sql="select * from user where username=?";
		
		User user =jdbctemplate.queryForObject(sql, new MyRowMapper(),"tom");
		System.out.println(user);
		
		
	}
	
	//4����list����
	@Test
	public void testList(){
		//�������ӳ�
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
		//�������ݿ���Ϣ
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql:///spring_jdbc_template");
		datasource.setUsername("root");
		datasource.setPassword("wei_150");
		
		//����jdbc Template��������������
		JdbcTemplate jdbctemplate=new JdbcTemplate(datasource);
		
		//дsql���
		String  sql="select * from user";
		//����jdbcTemplate�ķ���ʵ��
		List<User> list=jdbctemplate.query(sql,new MyRowMapper());
		
		System.out.println(list);
	}
	

}


class MyRowMapper implements RowMapper<User>{

	@Override
	public User mapRow(ResultSet rs, int num) throws SQLException {
		//1 �ӽ������������ݵõ�
		String username=rs.getString("username");
		String pass=rs.getString("password");
		
		//2 �ѵõ������ݷ�װ��������
		User user=new User();
		user.setPassword(pass);
		user.setUsername(username);
		
		return user;
	}
	
}
