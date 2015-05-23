package el;

import ui.SciPanel;

public class Environment {
	static double EMI = 0;
	int n  = 0;
	
	public void environment(){
		
		EMI = 2.5*(-0.045*SciPanel.physicsSum + 0.0675*SciPanel.biologySum +
				-0.09*SciPanel.chemistrySum + -0.045*SciPanel.computerSum) + Math.random()*1;
		
		n = (int) (Begin.EMV + EMI + ToolFunction.OEMIRF());
		if(n<=0)
			Begin.EMV = 0;
		else if(n>=100)
			Begin.EMV = 100;
		else Begin.EMV = n;
	}
}