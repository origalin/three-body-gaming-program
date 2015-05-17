package el;

import ui.SciPanel;

public class Happiness {
	double HI = 0;
	int n  = 0;
	public void happiness(){
		if(Begin.EV>500){
			HI = (Begin.EV-500)*0.02;
		}		
		if(Begin.EV<50){
			HI = (Begin.EV-50)*0.04;
		}
		
		HI = 0.05*SciPanel.mathSum + 0.06*SciPanel.physicsSum + 0.07*SciPanel.biologySum + 
				0.07*SciPanel.chemistrySum + 0.09*SciPanel.computerSum + 0.1*SciPanel.artSum -2;
		
		n = (int) (Begin.HV + HI + ToolFunction.OHIRF());
		
		if(n<=100)
			Begin.HV = n;
		else
			Begin.HV = 100;
	}	
}