import java.util.*;
public class ChatServer {
    private ArrayList<User> registered_Users;
    public void register_user(User user){
        registered_Users.add(user);
    }
    public void unregister_user(User user){
        registered_Users.remove(user);
    }

    public ArrayList<User> getRegistered_Users() {
        return registered_Users;
    }

    public ChatServer(){
        this.registered_Users = new ArrayList<User>();
    }

    public void send_Message(Message message, ArrayList<User> recipients){
        for(int i = 0; i < recipients.size(); i++){
            recipients.get(i).receive_Message(message);
        }
    }

    public void receive_Message(Message message){
        System.out.println(message.getMessage_content());
    }
}
