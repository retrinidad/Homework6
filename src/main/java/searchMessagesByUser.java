import java.util.*;
public class searchMessagesByUser implements Iterator{
    private User userToSearchWith;
    private int index;
    private int size;
    private ArrayList<MessageMemento> messages;

    public searchMessagesByUser(ChatHistory self_ChatHistory,User userToSearchWith){
        this.userToSearchWith = userToSearchWith;
        this.messages = self_ChatHistory.getHistory();
        this.index = 0;
        this.size = messages.size();
    }

    @Override
    public boolean hasNext(){
        MessageMemento memento = null;
        while(index < size){
            memento = messages.get(index);
            if(memento.getMementoContent().getSender() == userToSearchWith){
                return true;
            }
            else{
                index++;
            }
        }
        return false;
    }

    @Override
    public MessageMemento next(){
        if(hasNext()){
            return messages.get(index++);
        }
        return null;
    }

    @Override
    public void remove(){
        Iterator.super.remove();
    }
}
