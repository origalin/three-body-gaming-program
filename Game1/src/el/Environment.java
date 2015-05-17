package el;

import ui.SciPanel;

public class Environment {
	double EMI = 0;
	int n  = 0;
	
	public void environment(){
		
		EMI = -0.045*SciPanel.physicsSum + -0.0675*SciPanel.biologySum +
				-0.09*SciPanel.chemistrySum + -0.045*SciPanel.computerSum + 1;
		
		n = (int) (Begin.EMV + EMI + ToolFunction.OEMIRF());
		if(n<=100)
			Begin.EMV = n;
		else
			Begin.EMV = 100;
	}
}