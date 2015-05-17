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
			HVEIR = (Begin.HV-60)*0.001;//和幸福值关系
		}
		else if(Begin.HV<20){
			HVEIR = (Begin.HV-20)*0.001;
		}

		else if(Begin.EMV<60){
			EMVEIR = (Begin.EMV-60)*0.0005;//和环境关系
		}
		
		EIR = Sci.math.getEIR(2.4) + Sci.physics.getEIR(2.3) + Sci.biology.getEIR(2.3) + 
				Sci.chemistry.getEIR(2.3) + Sci.art.getEIR(2.5) + Sci.computer.getEIR(2.1)
			+ HVEIR + EMVEIR + ToolFunction.OEIRF();

		Begin.EV = (int) (Begin.EV * (EIR+1));
	}
}