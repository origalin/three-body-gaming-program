package el;

public class Tools {
	
	int mathPoint = 0;
	int physicsPoint = 0;
	int biologyPoint = 0;
	int chemistryPoint = 0;
	int artPoint  = 0;
	int computerPoint = 0;
	int time = 2;
	int money = 10;
	int emvDamage = 0;
	boolean isClicked = false;
	boolean upDate = false;
	
	private Tools(int math,int physics,int biology,int chemistry,int art,int computer,int t,int m){
		int n = 0;
		int i = 0;
		double k = 0;
		mathPoint = math;
		physicsPoint = physics;
		biologyPoint = biology;
		chemistryPoint = chemistry;
		artPoint = art;
		computerPoint = computer;
		time = t;
		money = m;
		
		n = m/10;
		for(i=0;i<=(n-1);i++){
			k = k + 0.001;
		}
		emvDamage = (int) (0.3*(0.09*physics + 0.135*biology + 0.18*chemistry + 0.09*computer - k));
	}

	private void judgeC(Tools tool){
		if(tool.isClicked==true)
			ToolFunction.add(tool);
	}
	
	private void judgeU(Tools tool){
		if(tool.upDate==true)
			tool.emvDamage=0;
	}
	
	public void judgeSumC(){//点了建造按钮时调用
		plane.judgeC(plane);
	}
	
	public void judgeSumU(){//点了升级按钮时调用
		plane.judgeU(plane);
	}
	
	Tools plane = new Tools(1,2,3,4,5,6,7,8);
}
