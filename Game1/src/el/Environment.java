package el;

public class Environment {
	double EMI = 0.6;
	int n  = 0;
	
	public void environment(){
		
		EMI += -0.09*ToolFunction.physicsPointSum + -0.135*ToolFunction.biologyPointSum +
				-0.18*ToolFunction.chemistryPointSum + -0.09*ToolFunction.computerPointSum;
		
		n = (int) (Begin.EMV + EMI + ToolFunction.OEMIRF());
		if(n<=100)
			Begin.EMV = n;
		else
			Begin.EMV = 100;
	}
}