import java.util.*;
public class ChatHistory implements IterableByUser{
    private ArrayList<MessageMemento> history;

    public ChatHistory(){
        history = new ArrayList<MessageMemento>();
    }

    public ArrayList<MessageMemento> getHistory() {
        return history;
    }

    void add_message(Message message){
        history.add(new MessageMemento(message));
    }

    public searchMessagesByUser iterator(User userToSearchWith){
        return new searchMessagesByUser(this,userToSearchWith);
    }
}
