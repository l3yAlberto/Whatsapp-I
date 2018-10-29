public class Msg{
	public String userId;
	public String text;
	
	public Msg(String userId,String text){
		this.userId = userId;
		this.text = text;
	}
	public String toString(){
		String res = this.userId+": "+this.text;
		return res;
	}
	
}
