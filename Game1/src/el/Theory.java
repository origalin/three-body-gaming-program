package el;

public class Theory {
	
	public int mathPoint = 0;
	public int physicsPoint = 0;
	public int biologyPoint = 0;
	public int chemistryPoint = 0;
	public int artPoint  = 0;
	public int computerPoint = 0;
	public static boolean isClicked = false;//如果被点就能点物品
	public static boolean isAvailable = false;//如果点数够就会发光
	
	
	public Theory (int math,int physics,int biology,int chemistry,int art,int computer){
		mathPoint = math;
		physicsPoint = physics;
		biologyPoint = biology;
		chemistryPoint = chemistry;
		artPoint = art;
		computerPoint = computer;
	}
	
	
	public void judgeC(Theory theory){
//		if(theory.isClicked==true)
//			对应物品会出现在建造栏中
	}
	
	private static boolean judgeA(Theory theory){
		if(Sci.math.point>=theory.mathPoint&&
			Sci.physics.point>=theory.physicsPoint&&
			Sci.biology.point>=theory.biologyPoint&&
			Sci.chemistry.point>=theory.chemistryPoint&&
			Sci.art.point>=theory.artPoint&&
			Sci.computer.point>=theory.artPoint)
			return true;
		return false;
	}


	public static void judgeSumA() {
		judgeA(fly);
	}	
	
	public static Theory fly = new Theory(1,2,3,4,5,6);
	
	public static Theory  geometry=new Theory(2,1,0,0,2,0);//几何
	public static Theory calculus=new Theory(4,0,0,0,0,0);//微积分
	public static Theory computerScience=new Theory(4,1,0,0,2,0);//计算机科学
	public static Theory mechanical=new Theory(3,4,0,0,2,0);//机械工程
	public static Theory materialStructure=new Theory(3,1,2,0,3,0);//微观物质结构
	public static Theory ecology=new Theory(1,0,1,4,0,1);//生态学
	public static Theory organic=new Theory(4,1,5,5,1,1);//有机化学
	public static Theory bioEngineering=new Theory(4,1,5,7,3,1);//生物工程
	public static Theory ArtificialInt=new Theory(7,6,0,0,5,2);//人工智能
	public static Theory nuclearChemistry=new Theory(8,8,4,0,3,2);//核化学
}

