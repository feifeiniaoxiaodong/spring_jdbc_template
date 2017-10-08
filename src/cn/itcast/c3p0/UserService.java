package cn.itcast.c3p0;

public class UserService {
	
	private UserDao userdao;
	
	public void setUserdao(UserDao userdao) {
		this.userdao = userdao;
	}
	
	public void add(){
		userdao.add();
	}

}
