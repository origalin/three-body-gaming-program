package el;

public class Happiness {
	double HI = 0;
	int n  = 0;
	public void happiness(){
		if(Begin.EV>700){
			HI = (Begin.EV-700)*0.05;
		}		
		if(Begin.EV<400){
			HI = (Begin.EV-400)*0.03;
		}
		
		HI = 0.2*ToolFunction.mathPointSum + 0.21*ToolFunction.physicsPointSum + 0.22*ToolFunction.biologyPointSum + 
				0.22*ToolFunction.chemistryPointSum + 0.24*ToolFunction.computerPointSum + 0.25*ToolFunction.artPointSum;
		
		n = (int) (Begin.HV + HI + ToolFunction.OHIRF());
		
		if(n<=100)
			Begin.HV = n;
		else
			Begin.HV = 100;
	}	
}