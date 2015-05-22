package el;

import java.util.ArrayList;

public class Tools {
	public static int[] Time= {1,1,1,1,1,2,2,2,3,3,3};
	public static int[] Money= {150,180,170,160,250,260,240,415,410,420};
	
	int mathPoint = 0;
	int physicsPoint = 0;
	int biologyPoint = 0;
	int chemistryPoint = 0;
	int artPoint  = 0;
	int computerPoint = 0;
	int money;
	public static ArrayList<Tools> al = new ArrayList<Tools>();
	
	private Tools(int chemistry,int biology,int physics,int math,int computer,int art,int m){
		mathPoint = math;
		physicsPoint = physics;
		biologyPoint = biology;
		chemistryPoint = chemistry;
		artPoint = art;
		computerPoint = computer;
		money = m;
		al.add(this);
	}

	public static Tools computer = new Tools(0,0,1,3,3,1,150);
	public static Tools media = new Tools(0,0,1,3,3,1,180);
	public static Tools hitectool = new Tools(2,0,4,3,3,2,170);
	public static Tools plastic = new Tools(6,4,1,3,3,1,160);
	public static Tools ai = new Tools(0,2,6,6,6,2,250);
	public static Tools nuclear = new Tools(4,2,7,6,6,2,260);
	public static Tools medicine = new Tools(5,7,2,4,4,2,240);
	public static Tools supercreature = new Tools(9,9,9,10,10,4,415);
	public static Tools spaceship = new Tools(4,4,13,12,12,4,410);
	public static Tools mixcreature = new Tools(5,9,8,10,10,4,420);
	
}
