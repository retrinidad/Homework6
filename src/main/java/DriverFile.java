import java.util.*;
public class DriverFile {
    public static void main(String[] args){
        ChatServer chatServer = new ChatServer();
        User user1 = new User(chatServer, "Tim");
        User user2 = new User(chatServer,"Michael");
        User user3 = new User(chatServer,"John");

        ArrayList<User> user1_recipient_list = new java.util.ArrayList<User>();
        user1_recipient_list.add(user2);
        user1_recipient_list.add(user3);

        ArrayList<User> user2_recipient_list = new java.util.ArrayList<User>();
        user2_recipient_list.add(user1);
        user2_recipient_list.add(user3);

        ArrayList<User> user3_recipient_list = new java.util.ArrayList<User>();
        user3_recipient_list.add(user1);
        user3_recipient_list.add(user2);

        user1.send_Message("Hi guys", user1_recipient_list);
        user2.send_Message("Let's go play that new video game",user2_recipient_list);
        user3.send_Message("Let's start playing at 9",user3_recipient_list);
        user3.undo_Message();


        user3.send_Message("Lets play at 9:30", user3_recipient_list);

        user3.send_Message("I'm free now", user3_recipient_list);

        user2.send_Message("Tim cheated! I'm blocking you!",user2_recipient_list);
        user2.blockUser(user1);
        user1.send_Message("I did not cheat!",user1_recipient_list);

        user3.send_Message("I'm going to log off now",user3_recipient_list);

        searchMessagesByUser userIterator1 = user1.iterator(user3);
        System.out.println("Messages sent by user3 in user1's chat history");
        while(userIterator1.hasNext()){
            System.out.println(userIterator1.next().getMementoContent().getMessage_content());
        }

        searchMessagesByUser userIterator2 = user2.iterator(user3);
        System.out.println("Messages sent by user3 in user2's chat history");
        while(userIterator2.hasNext()){
            System.out.println(userIterator2.next().getMementoContent().getMessage_content());
        }

    }
}
