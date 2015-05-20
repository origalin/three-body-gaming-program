package el;

import ui.GameWindow;

public class Bomb {
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
	
	public String bomb(){
		String s = "";
		if(Begin.EV<40+(GameWindow.time-1020)*1.1){
			//Economy will suffer
			Economy.EIR -= 0.001+(int)(Math.random()*4)*0.0002;
			Begin.EV -= 20+(int)(Math.random()*4)*3;
			Begin.HP -= 5*(int)(Math.random()*4);
			if(Begin.HP<=0)
				Begin.HP = 0;
			s += economy[(int)(Math.random()*4)] + "\n";
		}
		if(Begin.HV<60){
			Begin.HV -= 10+(int)(Math.random()*4)*2;
			Begin.HP -= 5*(int)(Math.random()*4);
			if(Begin.HP<=0)
				Begin.HP = 0;
			s += happiness[(int)(Math.random()*4)] + "\n";
		}
		if(Begin.EMV<60){
			//Environment will suffer
			Environment.EMI -= 10+(int)(Math.random()*4)*2;
			Begin.HP -= 5*(int)(Math.random()*4);
			if(Begin.HP<=0)
				Begin.HP = 0;
			s += enviroment[(int)(Math.random()*4)] + "\n";
		}
		
		return s;
	}	
}
