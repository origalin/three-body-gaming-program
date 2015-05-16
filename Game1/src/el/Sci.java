package el;

import java.io.ObjectInputStream.GetField;

public class Sci {
	public int point;
	public double EIR;
	public double HI;
	public double EMI;
	public Sci(double hi,double emi){
		point = 0;
		HI = hi;
		EMI = emi;
	}
	
	public double getEIR(double eir){
		EIR = eir * Economy.getBasic() * point;
		return EIR;
	}
	
	public static Sci math = new Sci(0.2, 0);
	public static Sci physics = new Sci(0.21, -0.09);
	public static Sci chemistry = new Sci(0.22, -0.18);
	public static Sci biology = new Sci(0.22, -0.135);
	public static Sci computer = new Sci(0.24, -0.09);
	public static Sci art = new Sci(0.25, 0);
}
