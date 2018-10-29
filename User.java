import java.util.ArrayList;

public class User{
	private String id;
	protected ArrayList<Chat> chats = new ArrayList<Chat>();
	
	public User(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
	public String toString(){
		return this.id;
	}
	public void deliverZap(Msg msg, String idChat){
		if(msg.userId.equals(this.id)) return;
		else;
			for (int i = 0;i<chats.size();i++) {
				if(chats.get(i).getId().equals(idChat)){
					chats.get(i).mens(msg, this.id);
				}
			}
	}
	public ArrayList<String> getChats(){
		ArrayList<String> str = new ArrayList<String>();
		for (int i = 0;i<chats.size();i++) {
			str.add(chats.get(i).toString());
		}
		return str;
	}
	public ArrayList<Notify> getNotify(){
		ArrayList<Notify> not = new ArrayList<>();
		for (int i = 0;i<chats.size();i++) {
			Notify notif = new Notify(chats.get(i).getId(),chats.get(i).unreadCount(this.id));
			not.add(notif);
		}
		return not;
	}
}
