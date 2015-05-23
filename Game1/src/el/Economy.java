package el;

import ui.SciPanel;

public class Economy{
	public static double EIR = 0;
	double HVEIR = 0;
	double EMVEIR = 0;
	
	private double calculate(int x){
		double d = 0;
		if(x<=6)
			d = x;
		else {
			d = 7*Math.log(x-4);
		}
		return d;
	}
	
	private static double getBasic(){
		int n = 0;
		int i = 0;
		double basic = 0.01;
		n = Begin.EV/100;
		for(i=0;i<(n-1);i++){
			basic -= 0.0004;
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
		
		EIR = Economy.getBasic()*(0.72*calculate(SciPanel.mathSum)+0.69*(calculate(SciPanel.physicsSum
				+SciPanel.chemistrySum+SciPanel.biologySum))
				+0.63*calculate(SciPanel.artSum)+0.75*calculate(SciPanel.computerSum))+
				HVEIR + EMVEIR + ToolFunction.OEIRF() - 0.001;

		Begin.EV = (int) (Begin.EV * (EIR+1));
		if(Begin.EV<=0)
			Begin.EV = 0;
	}
}