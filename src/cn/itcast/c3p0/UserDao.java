package cn.itcast.c3p0;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

//import cn.itcast.jdbc.MyRowMapper;
import cn.itcast.jdbc.User;

public class UserDao {
	
	//�õ�jdbcTemplateģ�����
	private JdbcTemplate jdbctemplate;
	public void setJdbctemplate(JdbcTemplate jdbctemplate) {
		this.jdbctemplate = jdbctemplate;
	}
	
	//��Ӳ���
	public void add(){
		System.out.println("UserDao....");
		
//		String sql="insert into user values(?,?)";
//		jdbctemplate.update(sql,"lixue","520");
		
		System.out.println("UserDao...over");
		
		
		//дsql���
		 String sql="select * from user";
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
