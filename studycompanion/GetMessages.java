package studycompanion;

public class GetMessages{
	public static void main(String args[]) throws Exception{
		CreateConnection cc = new CreateConnection("http://localhost:8000/messages");
		System.out.println(cc.doGet());
	}
}
