package el;

public class Sci {
	public int point;
	public double EIR;
	public double HI;
	public double EMI;
	public Sci(double eir,double hi,double emi){
		point = 0;
		EIR = eir * Economy.getBasic() * point;
		HI = hi;
		EMI = emi;
	}
	public static Sci art = new Sci(2.1, 0.25, 0);
	public static Sci math = new Sci(2.4, 0.2, 0);
	public static Sci biology = new Sci(2.3, 0.22, -0.135);
	public static Sci chemistry = new Sci(2.3, 0.22, -0.18);
	public static Sci computer = new Sci(2.5, 0.24, -0.09);
	public static Sci physics = new Sci(2.3, 0.21, -0.09);
}
