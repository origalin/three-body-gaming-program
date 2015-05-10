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
	
	private void judgeC(Theory theory){
//		if(theory.isClicked==true)
//			对应物品会出现在建造栏中
	}
	
	private boolean judgeA(Theory theory){
		boolean a = false;
		return a;	
	}
	
	public void judgeSumC(){//点了某个科技时调用
		fly.judgeC(fly);	
	}
	
	public void judgeSumA(){//点了从主界面进入科技树的按钮时调用
		isAvailable = fly.judgeA(fly);
	}
	
	Theory fly = new Theory(1,2,3,4,5,6);
}

