import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
public class HW6_Test {

    @Test
    public void send_test(){
        ChatServer chatServer = new ChatServer();
        User user1 = new User(chatServer, "Tim");
        User user2 = new User(chatServer,"Michael");
        User user3 = new User(chatServer,"John");

        ArrayList<User> user1_recipient_list = new java.util.ArrayList<User>();
        user1_recipient_list.add(user2);
        user1_recipient_list.add(user3);

        user1.send_Message("Hi guys", user1_recipient_list);

        String expected = "Hi guys";
        assertEquals(expected,user1.chathistory.getHistory().get(0).getMementoContent().getMessage_content());
    }

    @Test
    public void receive_test(){
        ChatServer chatServer = new ChatServer();
        User user1 = new User(chatServer, "Tim");
        User user2 = new User(chatServer,"Michael");

        ArrayList<User> user1_recipient_list = new java.util.ArrayList<User>();
        user1_recipient_list.add(user2);

        user1.send_Message("Hi", user1_recipient_list);
        String expected = "Hi";
        assertEquals(expected,user2.chathistory.getHistory().get(0).getMementoContent().getMessage_content());
    }

    @Test
    public void undo_test(){
        ChatServer chatServer = new ChatServer();
        User user1 = new User(chatServer, "Tim");
        User user2 = new User(chatServer,"Michael");

        ArrayList<User> user1_recipient_list = new java.util.ArrayList<User>();
        user1_recipient_list.add(user2);

        user1.send_Message("Hi", user1_recipient_list);
        user1.send_Message("I'm on my way!", user1_recipient_list);
        user1.undo_Message();

        String expected = "Hi";
        assertEquals(expected,user2.chathistory.getHistory().get(0).getMementoContent().getMessage_content());
    }
}
