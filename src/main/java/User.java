import java.util.*;

public class User implements IterableByUser{
    ChatHistory chathistory;
    ChatServer chatServer;
    ArrayList<User> blockedUsers;
    String name;


    public User(ChatServer mediator, String name){
        this.chatServer = mediator;
        chathistory = new ChatHistory();
        chatServer.register_user(this);
        this.blockedUsers = new ArrayList<User>();
        this.name = name;
    }
    void send_Message(String message_content, ArrayList<User> recipients){
        Message sent_Message = new Message(message_content,this, recipients);
        System.out.println("Sending message to specified recipient(s)");
        chatServer.send_Message(sent_Message,recipients);
        this.chathistory.add_message(sent_Message);

    }

    public void receive_Message(Message message){
        if(blockedUsers.contains(message.getSender())){
            System.out.println("Blocked user is trying to send you a message!");
            return;
        }
        System.out.println("User is reading sent message...");
        chatServer.receive_Message(message);
        this.chathistory.add_message(message);
    }

    public void blockUser(User blocked_user){
        this.blockedUsers.add(blocked_user);
    }

    public void undo_Message(){
        MessageMemento removed_message_memento = this.chathistory.getHistory().remove(this.chathistory.getHistory().size()-1);
        Message removed_message = removed_message_memento.getMementoContent();

        ArrayList<User> recipients = removed_message.getRecipients();
        for(int i = 0; i < recipients.size(); i++){
            ChatHistory recipient_history = recipients.get(i).chathistory;
            recipient_history.getHistory().remove(recipient_history.getHistory().size()-1);
        }
        return;
    }

    public ArrayList<MessageMemento> viewChatHistory(User viewed_user){
        int index = chatServer.getRegistered_Users().indexOf(viewed_user);
        return chatServer.getRegistered_Users().get(index).chathistory.getHistory();

    }

    public searchMessagesByUser iterator(User userToSearchWith){
        return this.chathistory.iterator(userToSearchWith);
    }

}
