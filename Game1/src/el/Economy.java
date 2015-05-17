package el;

import ui.SciPanel;

public class Economy{
	public static double EIR = 0;
	double HVEIR = 0;
	double EMVEIR = 0;
	
	private static double getBasic(){
		int n = 0;
		int i = 0;
		double basic = 0.05;
		n = Begin.EV/100;
		for(i=0;i<(n-1);i++){
			basic -= 0.001;
		}
		return basic;
	}

	public void economy(){
		

		if(Begin.HV<60){
			HVEIR = (Begin.HV-60)*0.001;
		}

		if(Begin.EMV<60){
			EMVEIR = (Begin.EMV-60)*0.0005;//和环境关系
		}
		
		EIR = Economy.getBasic()*(0.72*SciPanel.mathSum+0.69*(SciPanel.physicsSum+SciPanel.chemistrySum
				+SciPanel.biologySum)+0.63*SciPanel.artSum+0.75*SciPanel.computerSum)+
				HVEIR + EMVEIR + ToolFunction.OEIRF() - 0.001;

		Begin.EV = (int) (Begin.EV * (EIR+1));
	}
}