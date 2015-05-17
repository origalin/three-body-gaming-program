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
		GP = (int)(0.5*getBasic()*(a+b+c+1));
		if(GP>50)
			GP = 50;
		if(GP<=0)
			GP = 0;
		Begin.HP = Begin.HP + GP;
	}
}