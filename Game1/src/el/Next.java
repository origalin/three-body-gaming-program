package el;

public class Next {
	
	Economy eco = new Economy();
	Environment env = new Environment();
	Happiness hap = new Happiness();
	Point poi = new Point();
	Bomb bomb = new Bomb();
	
	public void goNext(){
		eco.economy();
		env.environment();
		hap.happiness();
		poi.point();
		bomb.bomb();
	}	
}