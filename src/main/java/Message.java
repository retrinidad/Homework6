import java.util.*;
public class Message {
    private User sender;
    private ArrayList<User> recipients;
    private String timestamp;
    private String message_content;

    public String getTimestamp() {
        return timestamp;
    }
    public Message(String message_content, User sender, ArrayList<User> recipients){
        this.sender = sender;
        this.message_content = message_content;
        this.recipients = recipients;
        long currentTimeInMillis = System.currentTimeMillis();
        Date currentDate = new Date(currentTimeInMillis);
        this.timestamp = currentDate.toString();
    }
    public String getMessage_content(){
        return this.message_content;
    }

    public User getSender(){
        return this.sender;
    }

    public ArrayList<User> getRecipients() {
        return recipients;
    }
}
