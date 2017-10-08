package cn.itcast.jdbc;

import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

public class JdbcTemplateDemo1 {

	//1��Ӳ���
	@Test
	public void add(){
		//�������ݿ���Ϣ
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql:///spring_jdbc_template");
		datasource.setUsername("root");
		datasource.setPassword("wei_150");
		
		//����jdbc Template��������������
		JdbcTemplate jdbctemplate=new JdbcTemplate(datasource);
		//ʹ��jdbctemplate��������ķ���ʵ�ֲ���
		//����sql���
		String sql="insert into user values(?,?)";
		int n=jdbctemplate.update(sql,"lucy","20");
		n=jdbctemplate.update(sql,"jack","21");
		 n=jdbctemplate.update(sql,"jon","22");
		 n=jdbctemplate.update(sql,"tom","23");
		System.out.println(n);
		
	}
	
	//�������ݿ���Ϣ
	//@Test
	public void update(){
		//�������ݿ���Ϣ
				DriverManagerDataSource datasource=new DriverManagerDataSource();
				datasource.setDriverClassName("com.mysql.jdbc.Driver");
				datasource.setUrl("jdbc:mysql:///spring_jdbc_template");
				datasource.setUsername("root");
				datasource.setPassword("wei_150");
				
				//����jdbc Template��������������
				JdbcTemplate jdbctemplate=new JdbcTemplate(datasource);
		String sql="update user set password=? where username=?";
		int rows=jdbctemplate.update(sql,"1314","lucy");
		System.out.println(rows);
	}
	
	//ɾ������
	//@Test
	public void delete(){
		//�������ݿ���Ϣ
		DriverManagerDataSource datasource=new DriverManagerDataSource();
		datasource.setDriverClassName("com.mysql.jdbc.Driver");
		datasource.setUrl("jdbc:mysql:///spring_jdbc_template");
		datasource.setUsername("root");
		datasource.setPassword("wei_150");
		
		//����jdbc Template��������������
		JdbcTemplate jdbctemplate=new JdbcTemplate(datasource);
		String sql="delete from user where username=?";
		int rows=jdbctemplate.update(sql,"lucy");
		System.out.println(rows);
			
	}
	
	//��ѯ����
	
	
	
	
}
