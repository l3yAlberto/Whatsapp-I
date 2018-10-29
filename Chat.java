import java.util.ArrayList;

public class Chat{
	private String id;
	protected ArrayList<Inbox> inboxes;
	
	public Chat(String id){
		this.id = id;
		this.inboxes = new ArrayList<Inbox>();
	}
	public String getId(){
		return this.id;
	}
	public void setId(String id){
		this.id = id;
	}
	public void mens(Msg msg, String idUser){
		for (int i = 0;i<inboxes.size();i++) {
			if (inboxes.get(i).user.getId().equals(idUser)) {
				inboxes.get(i).msgs.add(msg);
				return;
			}
		}
	}
	public int unreadCount(String userId) {
		int x = 0;
		for (int i = 0;i<inboxes.size();i++){
			if (inboxes.get(i).user.getId().equals(userId)) {
				x = inboxes.get(i).msgs.size();
				break;
			}
		}
		return x;
	}
	public void addUserChat(User x){
		Inbox inb = new Inbox(x);
		inboxes.add(inb);
	}
	public String toString(){
		return this.id;
	}
}
