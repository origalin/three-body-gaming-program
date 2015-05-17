package el;

public class Point{
	int GP = 0;
		
	public void point(){
		
		GP = (int)20*((Begin.EV-500)/200+1);
		Begin.HP = Begin.HP + GP;
	}
}