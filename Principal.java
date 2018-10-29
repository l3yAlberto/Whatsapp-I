import java.util.Scanner;

public class Principal{
	public static Scanner sc = new Scanner(System.in);
	public static void main(String args[]){
		WhatsappService what = new WhatsappService();
		//what.createChat("Alberto","chat1");
		String help = "==================================Help==================================\n";
				help += "\taddUser_nome do usuario\n";
				help += "\tallUsers\n";
				help += "\tnewChat_nome do usuario_nome do grupo\n";
				help += "\tchats_nome do usuario\n";
				help += "\tinvite_nome do usuario do grupo_nome do convidado_nome do grupo\n";
				help += "\tusers_nome do usuario\n";
				help += "\tleave_nome do usuario_nome do grupo\n";
				help += "\tzap_nome do usuario_nome do grupo_mensagem\n";
				help += "\tnotify_nome do usuario\n";
				help += "\tler_nome do usuario_nome do grupo\n";
		
		while(true){
			System.out.print("Digite o comando: ");
			String comando = sc.nextLine();
			if (comando.equals("help")){
				System.out.println(help);
				continue;
			}
			if (comando.equals("sair")){
				break;
			}
			
			String v[] = comando.split(" ");
			switch(v[0]){
				case "addUser":
					User user = new User(v[1]);
					what.addUser(user);
				break;
				
				case "allUsers":
					what.allUsers();
				break;
				
				case "newChat":
					what.createChat(v[1], v[2]);
				break;
				
				case "chats":
					System.out.println(what.allChats(v[1]));
				break;
				
				case "users":
					System.out.println(what.allUser(v[1]));
				break;
				
				case "leave":
					what.leaveUser(v[1], v[2]);
				break;
				
				case "zap":
					String str = "";
					for (int i = 3;i<v.length;i++) {
						str += v[i]+" ";
					}
					what.sendMsg(v[2], str, v[1]);
				break;
				
				case "ler":
					what.lerChat(v[1], v[2]);
				break;
				
				case "notify":
					what.notify(v[1]);
				break;
				
				case "invite":
				what.inviteUser(v[1], v[2], v[3]);
				break;
				default:
					System.out.println("Comando invalido.");
			}
		}
	}
}
