import java.util.ArrayList;

public class Inbox{
	public User user;
	public ArrayList<Msg> msgs;
	
	public Inbox(User user){
		this.user = user;
		this.msgs = new ArrayList<Msg>();
	}
	public String toString(){
		String str = "";
		for (int i = 0;i<msgs.size();i++) {
			str += "["+msgs.get(i)+"]"+"\n";
		}
		return str;
	}
}
