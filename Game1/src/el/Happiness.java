package el;

public class Happiness {
	double HI = 0;
	int n  = 0;
	public void happiness(){
		if(Begin.EV<120){
			HI = (Begin.EV-120)*0.05;
		}
		
		if(Begin.EV>60){
			HI = (Begin.EV-60)*0.1;
		}
		else if(Begin.EV<50){
			HI = (Begin.EV-50)*0.1;
		}
		
		n = (int) (Begin.HV + HI + ToolFunction.OHIRF());
		
		if(n<=100)
			Begin.HV = n;
		else
			Begin.HV = 100;
	}	
}