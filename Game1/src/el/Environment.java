package el;

public class Environment {
	double EMI = 0.6;
	int n  = 0;
	
	public void environment(){
		n = (int) (Begin.EMV + EMI + ToolFunction.OEMIRF());
		if(n<=100)
			Begin.EMV = n;
		else
			Begin.EMV = 100;
	}
}
