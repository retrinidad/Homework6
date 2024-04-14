public class MessageMemento {
    private String timestamp;
    private Message content;

    public MessageMemento(Message content){
        this.content = content;
        this.timestamp = content.getTimestamp();
    }
    public Message getMementoContent(){
        return content;
    }

    public void setContent(Message content){
        this.content = content;
    }
}
