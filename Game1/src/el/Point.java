package el;

public class Point{
	int GP = 0;
		
	public void point(){
		
		GP = 50*((Begin.EV-500)/100+1);
		Begin.HP = Begin.HP + GP;
	}
}