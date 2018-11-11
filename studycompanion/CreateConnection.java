package studycompanion;
import java.util.Scanner;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

public class CreateConnection{
	private String URL;
	private URL urlobj; 
	public String POST_PARAMS;
	private final String USER_AGENT = "Mozilla/5.0";
	private HttpURLConnection con;
	CreateConnection(String url) throws Exception{
		this.URL = url;
		urlobj = new URL(url);
		con = (HttpURLConnection) urlobj.openConnection();
		con.setRequestProperty("User-Agent",USER_AGENT);
		POST_PARAMS = "";
	}
	public void addParam(String key,String value){
		if(POST_PARAMS.length() != 0)
			POST_PARAMS += "&";
 		POST_PARAMS += key + "=" + value;
	}
	public void clearParams(){
		POST_PARAMS = "";
	}
	public String doGet() throws Exception {
		int resCode = con.getResponseCode();
		String response = "";
		if(resCode == HttpURLConnection.HTTP_OK){
			Scanner s = new Scanner(con.getInputStream());
			while(s.hasNext()){
				response += s.next();
			}
			s.close();
			return response;
		}
		return "";
	}
	public String doPost() throws Exception{
		con.setDoOutput(true);
		PrintWriter pw = new PrintWriter(con.getOutputStream());
		pw.write(POST_PARAMS);
		pw.flush();
		pw.close();
		int resCode = con.getResponseCode();
		String response = "";
		if(resCode == HttpURLConnection.HTTP_OK){
			Scanner s = new Scanner(con.getInputStream());
			while(s.hasNext()){
				response += s.next();
			}
			s.close();
			return response;
		}
		return "";
	}
}
