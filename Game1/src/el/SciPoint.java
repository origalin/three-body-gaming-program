package el;

public class SciPoint{
	int GP = 0;
	
	private static double getBasic(){
		int n = 0;
		int i = 0;
		double basic = 30;
		n = Begin.HP-15;
		for(i=0;i<(n-1);i++){
			basic -= 1;
		}
		return basic;
	}
	
	public void point(){
		double a = (Begin.EV-100)/75;
		double b = (Begin.HV-75)/5;
		double c = (Begin.EMV-75)/5;
		if(a<=0)
			a = 0;
		if(b<=0)
			b = 0;
		if(c<=0)
			c = 0;
		GP = (int)(getBasic()*(0.43*1+0.35*(a+b+c)));
		if(GP>25)
			GP = 25;
		if(GP<=2)
			GP = 2;
		Begin.HP = Begin.HP + GP;
	}
}