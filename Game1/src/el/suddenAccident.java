package el;

public class suddenAccident {
	static int MP=Sci.math.point;
	static int PP=Sci.physics.point;
	static int CP=Sci.chemistry.point;
	static int BP=Sci.biology.point;
	static int COMP=Sci.computer.point;
	static int AP=Sci.art.point;
	static int SUM=MP+PP+CP+BP+COMP+AP;
	static String[]economy={"����������ڷ�������","�׶��������𣬼�ȱ���ֻ���","��ľ���Ҫ��ҽ�Ʊ��ϣ���������Ƶ��","�ط���������������ծ��"};
	static String[]happiness={"�������ڷ�������","ҽ��������ʾ����֢���߼�������","��������ɱ�¹�Ƶ��","���ط�����Ϊ���ϣ���������Ϊ��"};
	static String[]enviroment={"ɭ�ֵĸ����������Ѹ���½�","�ݳ����ڼ����Į��","ˮ��Դ�����ȱ","��س��ּ�������"};
	public static String checkAccident(){
		String s="";
	if((MP+PP)<(SUM/3)){
		//Economy will suffer
		Economy.EIR-=0.5;
		s=economy[(int)(Math.random()*5)];
		return s;
	}
	if(MP>SUM/3){
		//Happiness will suffer
		Happiness.HI-=0.04;
		s=happiness[(int)(Math.random()*5)];
		return s;
	}
	if(CP>SUM/3){
		//Enviroment will suffer
		Environment.EMI-=0.05;
		s=enviroment[(int)(Math.random()*5)];
		return s;
	}
	if(BP<SUM/6){
		//Enviroment will suffer
		Environment.EMI-=0.03;
		s=enviroment[(int)(Math.random()*5)];
		return s;
	}
	if(AP<SUM/10){
		//Happiness will suffer a lot
		Happiness.HI-=0.03;
		s=happiness[(int)(Math.random()*5)];
		return s;
	}
	if(COMP<SUM/8){
		//Economy will suffer
		Economy.EIR-=0.4;
		s=economy[(int)(Math.random()*5)];
		return s;
	}
	return null;
	}	

}
