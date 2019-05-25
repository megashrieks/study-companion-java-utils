package com.company;
class LoginTemplate{
    public String error;
    public String token;
}
public class Login{
    String usr,pwd;
    Login(String username,String password){
        this.usr = username;
        this.pwd = password;
    }
    public String send() throws Exception{
        CreateConnection cc = new CreateConnection("http://localhost:8000/login");
        cc.addParam("username",this.usr);
        cc.addParam("password",this.pwd);
        ToJSON tj = new ToJSON(cc.doPost());
        LoginTemplate ls = tj.convert(LoginTemplate.class);
        if (ls.error == null)
            return ls.token;
        return "";
    }
}