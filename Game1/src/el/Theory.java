package el;

public class Theory {
	
	int mathPoint = 0;
	int physicsPoint = 0;
	int biologyPoint = 0;
	int chemistryPoint = 0;
	int artPoint  = 0;
	int computerPoint = 0;
	boolean isClicked = false;//如果被点就能点物品
	boolean isAvailable = false;//如果点数够就会发光
	
	public Theory (int math,int physics,int biology,int chemistry,int art,int computer){
		mathPoint = math;
		physicsPoint = physics;
		biologyPoint = biology;
		chemistryPoint = chemistry;
		artPoint = art;
		computerPoint = computer;
	}
	
	public void judgeC(Theory theory){
//			对应物品会出现在建造栏中
		Sci.math.point -= theory.mathPoint;
		Sci.physics.point -= theory.physicsPoint;
		Sci.biology.point -= theory.biologyPoint;
		Sci.chemistry.point -= theory.chemistryPoint;
		Sci.art.point -= theory.chemistryPoint;
		Sci.computer.point -= theory.computerPoint;
		
	}
	
	private boolean judgeA(Theory theory){
		if(Sci.math.point>=theory.mathPoint&&
			Sci.physics.point>=theory.physicsPoint&&
			Sci.biology.point>=theory.biologyPoint&&
			Sci.chemistry.point>=theory.chemistryPoint&&
			Sci.art.point>=theory.artPoint&&
			Sci.computer.point>=theory.artPoint)
			return true;
		return false;
	}
	
	public static void judgeSumA(){//点了从主界面进入科技树的按钮时调用
		fly.isAvailable = fly.judgeA(fly);//把所有理论放在一个arraylist中，遍历arraylist
	}
	
	static Theory fly = new Theory(1,1,1,1,1,1);
}

