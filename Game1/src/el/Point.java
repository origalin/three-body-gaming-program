package el;

public class Point{
	int GP = 0;
		
	private static double getBasic(){
		int n = 0;
		int i = 0;
		double basic = 40;
		n = Begin.HP-20;
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
		GP = (int)(0.5*getBasic()*1+0.3*getBasic()*(a+b+c));
		if(GP>33)
			GP = 33;
		if(GP<=5)
			GP = 5;
		Begin.HP = Begin.HP + GP;
	}
}