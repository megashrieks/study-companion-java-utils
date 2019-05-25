package com.company;
class Messages{
    String error;
    Message data[];
}
public class GetMessages{
    public Message[] get() throws Exception{
        CreateConnection cc = new CreateConnection("http://localhost:8000/messages");
        ToJSON tj = new ToJSON(cc.doGet());
        Messages m = tj.convert(Messages.class);
        return m.data;
    }
    public static void main(String args[])throws Exception{
        GetMessages g = new GetMessages();
        Message[] msgs = g.get();
        for(Message msg : msgs){
            System.out.println("username : "+msg.username);
            System.out.println("message : "+msg.message);
            System.out.println();
        }
    }
}