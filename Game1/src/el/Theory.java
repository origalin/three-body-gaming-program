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
	
	public Theory(){
		
	}
	
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
	
	
	
	
}

