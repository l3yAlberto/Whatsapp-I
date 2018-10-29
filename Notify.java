public class Notify {
	String chatId;
	int unreadCount;
	public Notify(String chatId, int unreadCount) {
		super();
		this.chatId = chatId;
		this.unreadCount = unreadCount;
	}
	public String toString() {
		String res = this.chatId+"("+this.unreadCount+")";
		return res;
	}
}
