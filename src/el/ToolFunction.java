package el;

public class ToolFunction {
	static int mathPointSum = 0;
	static int physicsPointSum = 0;
	static int chemistryPointSum = 0;
	static int biologyPointSum = 0;
	static int artPointSum = 0;
	static int computerPointSum = 0;
	static int moneySum = 0;
	boolean isClicked = false;
	static double ToolIR = 0;
	static double OEIR = 0;
	static int OHIR = 0;
	static int OEMIR  = 0;
	
	public static void add(Tools tool){  //只调用函数，调用方不用这个值,没有返回值
		if(tool.isClicked = true){
			mathPointSum = mathPointSum +  tool.mathPoint;
			physicsPointSum = physicsPointSum +  tool.physicsPoint;
			biologyPointSum = biologyPointSum +  tool.biologyPoint;
			chemistryPointSum = chemistryPointSum +  tool.chemistryPoint;
			artPointSum = artPointSum +  tool.artPoint;
			computerPointSum = computerPointSum +  tool.computerPoint;
			moneySum = moneySum + tool.money;
		}
	}
	
	public static double getToolIR(){
		int i = 0;
		int n = 0;
		n = moneySum/10;
		for(i=0;i<=(n-1);i++){
			ToolIR = ToolIR + 0.001;
		}
		return ToolIR;
	}
	
	public static double OEIRF(){  //又要调用这个函数，又要用这个函数产生的值，所以要有返回值 object EIR function
		OEIR = 0.3*(0.036*mathPointSum + 0.0345*physicsPointSum + 0.0343*biologyPointSum + 
				0.0343*chemistryPointSum + 0.03075*artPointSum + 0.0377*computerPointSum) 
				+ getToolIR();
		return OEIR;
	}
	
	public static int OHIRF(){
		OHIR = (int) (0.3*(0.2*mathPointSum + 0.21*physicsPointSum + 0.22*biologyPointSum + 
				0.22*chemistryPointSum + 0.24*computerPointSum + 0.25*artPointSum + getToolIR()));
		return OHIR;
	}
	
	public static int OEMIRF(){
		OEMIR = (int) (0.3*(-0.09*physicsPointSum + -0.135*biologyPointSum + -0.18*chemistryPointSum
				+ -0.09*computerPointSum + getToolIR()));
		return OEMIR;
	}

}
