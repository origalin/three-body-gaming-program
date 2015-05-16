package el;

public class Economy{
	public static double basic = 0.015;
	double EIR = 0;
	double HVEIR = 0;
	double EMVEIR = 0;
	
	public static double getBasic(){
		int n = 0;
		int i = 0;
		n = Begin.EV/500;
		for(i=0;i<=(n-1);i++){
			basic = basic - 0.001;
		}
		return basic;
	}

	public void economy(){
		
		if(Begin.HV>60){
			HVEIR = (Begin.HV-60)*0.01;//和幸福值关系
		}
		else if(Begin.HV<50){
			HVEIR = (Begin.HV-50)*0.01;
		}

		else if(Begin.EMV<60){
			EMVEIR = (Begin.EMV-60)*0.005;//和环境关系
		}
		
		EIR = Sci.math.EIR + Sci.physics.EIR + Sci.biology.EIR + 
				Sci.chemistry.EIR + Sci.art.EIR + Sci.computer.EIR
			+ HVEIR + EMVEIR + ToolFunction.OEIRF();

		Begin.EV = (int) (Begin.EV * (EIR+1));
	}
}