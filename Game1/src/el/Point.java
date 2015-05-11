package el;

public class Point{
	int GP = 0;
	int HP = 0;
		
	public void point(){
		
		GP = (int) ((int) 50*((Begin.EV-500)/100+1));
		HP = (int) (HP + GP);
		if(Math.botton == true&&HP>=14){
			Math.point++;
			HP=HP-14;
		}
		if(Physics.botton == true&&Begin.HP>=11){
			Physics.point++;
			Begin.HP=Begin.HP-11;
		}
		if(Biology.botton == true&&Begin.HP>=11){
			Biology.point++;
			Begin.HP=Begin.HP-11;
		}
		if(Chemistry.botton == true&&Begin.HP>=11){
			Chemistry.point++;
			Begin.HP=Begin.HP-11;
		}
		if(Art.botton == true&&Begin.HP>=11){
			Art.point++;
			Begin.HP=Begin.HP-12;
		}
		if(Computer.botton == true&&Begin.HP>=11){
			Computer.point++;
			Begin.HP=Begin.HP-10;
		}
	}
}