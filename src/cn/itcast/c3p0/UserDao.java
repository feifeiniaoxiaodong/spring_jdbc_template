package cn.itcast.c3p0;

import org.springframework.jdbc.core.JdbcTemplate;

public class UserDao {
	
	//�õ�jdbcTemplateģ�����
	private JdbcTemplate jdbctemplate;
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	
	//��Ӳ���
	public void add(){
		System.out.println("UserDao....");
		
		String sql="insert into user values(?,?)";
		jdbctemplate.update(sql,"lixue","520");
		
		
		
	
	}

}
