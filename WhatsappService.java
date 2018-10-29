import java.util.ArrayList;

public class WhatsappService{
	private ArrayList<User> repUser;
	private ArrayList<Chat> repChat;
	
	public WhatsappService(){
		this.repUser = new ArrayList<User>();
		this.repChat = new ArrayList<Chat>();
	}
	public ArrayList<User> getRepUser() {
		return repUser;
	}

	public void setRepUser(ArrayList<User> repUser) {
		this.repUser = repUser;
	}

	public ArrayList<Chat> getRepChat() {
		return repChat;
	}

	public void setRepChat(ArrayList<Chat> repChat) {
		this.repChat = repChat;
	}
	public void addUser(User x) {
		for(int i = 0;i<repUser.size();i++) {
			if (repUser.get(i).getId().equals(x.getId())) {
				System.out.println("fail: User "+x.getId()+" ja existe");
				return;
			}
		}
		this.repUser.add(x);
		System.out.println("done");
	}
	public void allUsers() {
		String str = "[";
		for(int i = 0;i<repUser.size();i++) {
			str += repUser.get(i).toString()+" ";
		}
		str += "]";
		System.out.println(str);
	}
	public void createChat(String userId, String chatId){
		for (int i = 0;i<repChat.size();i++){
			if(repChat.get(i).getId().equals(chatId)){
				System.out.println("fail: chat "+chatId+" ja existe");
				return;
			}
		}
		Chat chat = new Chat(chatId);
		for (int i = 0;i<repUser.size();i++){
			if(repUser.get(i).getId().equals(userId)){
				chat.addUserChat(repUser.get(i));
				repUser.get(i).chats.add(chat);
				repChat.add(chat);
				System.out.println("done");
				return;
			}
		}
	}

	public void sendMsg(String idChat, String texto, String idUser){
		Msg msg = new Msg(idUser, texto);
		for (int i=0;i<repChat.size();i++) {
			if(repChat.get(i).getId().equals(idChat)) {
				for (int i1 = 0;i1<repChat.get(i).inboxes.size();i1++) {
					for(int i3 = 0;i3<repUser.size();i3++) {
						if(repUser.get(i3).getId().equals(repChat.get(i).inboxes.get(i1).user.getId())) {
							repUser.get(i3).deliverZap(msg, idChat);
							return;
						}
					}
				}
			}
		}
		System.out.println("done");
		
	}
	public String allChats(String idUser) {
		String str = "[";
		for(int i = 0;i<repUser.size();i++) {
			if(repUser.get(i).getId().equals(idUser)) {
				for (int i1 = 0;i1<repUser.get(i).chats.size();i1++) {
					str += repUser.get(i).chats.get(i1).toString()+" ";
				}
				break;
			}
		}
		str +="]";
		return str;
	}
	public String allUser(String idChat) {
		String str = "[";
		for (int i = 0;i<repChat.size();i++) {
			if(repChat.get(i).toString().equals(idChat)) {
				for (int i1 = 0;i1<repChat.get(i).inboxes.size();i1++) {
					str += repChat.get(i).inboxes.get(i1).user.toString()+" ";
				}
				break;
			}
		}
		str += "]";
		return str;
	}
	public void leaveUser(String idUser,String idChat) {
		String idC = "";
		for(int i = 0;i<repUser.size();i++) {
			if(repUser.get(i).getId().equals(idUser)) {
				for(int i1 = 0;i1<repUser.get(i).chats.size();i++) {
					if (repUser.get(i).chats.get(i1).getId().equals(idChat)) {
						idC += repUser.get(i).chats.get(i1).getId();
						repUser.get(i).chats.remove(i1);
						break;
					}
				}
				break;
			}
		}
		for (int i = 0;i<repChat.size();i++) {
			if (repChat.get(i).getId().equals(idC)) {
				for(int i1 = 0;i1<repChat.get(i).inboxes.size();i++) {
					if(repChat.get(i).inboxes.get(i1).user.getId().equals(idUser)) {
						repChat.get(i).inboxes.remove(i1);
						break;
					}
					
				}
				break;
			}
		}
		System.out.println("done");
	}
	public void notify(String idUser) {
		String str = "[";
		for (int i = 0;i<repUser.size();i++) {
			if (repUser.get(i).getId().equals(idUser)) {
				for(int i1 = 0;i1<repUser.get(i).getNotify().size();i1++) {
					str += repUser.get(i).getNotify().get(i1)+" ";
				}
				break;
			}
		}
		str += "]";
		System.out.println(str);
	}
	public void lerChat(String idUser,String idChat) {
		for(int i = 0;i<repUser.size();i++) {
			if(repUser.get(i).getId().equals(idUser)) {
				for(int i1 = 0;i1<repUser.get(i).chats.size();i1++) {
					if(repUser.get(i).chats.get(i1).getId().equals(idChat)) {
						for(int i2 = 0;i2<repUser.get(i).chats.get(i1).inboxes.size();i2++) {
							if (repUser.get(i).chats.get(i1).inboxes.get(i2).user.getId().equals(idUser)) {
								System.out.println(repUser.get(i).chats.get(i1).inboxes.get(i2).toString());
								repUser.get(i).chats.get(i1).inboxes.get(i2).msgs.clear();
								return;
							}
						}
					}
				}
			}
		}
	}
	public void inviteUser(String idUser,String idConv, String idChat) {
		for(int i = 0;i<repChat.size();i++) {
			if(repChat.get(i).getId().equals(idChat)) {
				for(int i1 = 0;i1<repChat.get(i).inboxes.size();i1++) {
					if(repChat.get(i).inboxes.get(i1).user.getId().equals(idUser)) {
						for(int i2 = 0;i2<repUser.size();i2++) {
							if(repUser.get(i2).getId().equals(idConv)) {
								repChat.get(i).addUserChat(repUser.get(i2));
								repUser.get(i2).chats.add(repChat.get(i));
								System.out.println("done");
								return ;
							}
						}
					}
				}
			}
		}
		System.out.println("fail: user "+idUser+" nao esta em chat "+idChat);
	}
}








