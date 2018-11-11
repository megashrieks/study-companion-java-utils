package studycompanion;
public class Login{
	String usr,pwd;
	Login(String username,String password){
		this.usr = username;
		this.pwd = password;
	}
	public boolean send() throws Exception{
		CreateConnection cc = new CreateConnection("http://localhost:8000/login");
		cc.addParam("username",this.usr);
		cc.addParam("password",this.pwd);
		return !cc.doPost().matches(".*invalid.*");
	}
}
