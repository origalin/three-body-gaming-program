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
	static String[]economy2={"","","",""};
	static String[]happiness2={"","","",""};
	static String[]enviroment2={"","","",""};
	
	public String bomb(){
		String s = "";
		double ev = 15000/(5000-Begin.HV);
		double hv = 300/(100-Begin.HV);
		double emv = 300/(100-Begin.EMV);
		if(Begin.EV>=40+(GameWindow.time-1020)*1.1&&(int)Math.random()*ev==0){
			Economy.EIR -= (0.001+(int)(Math.random()*4)*0.0002)/ev;
			Begin.EV -= (20+(int)(Math.random()*4)*3)/ev;
			Begin.HP -= 5*(int)(Math.random()*4)/ev;
			if(Begin.HP<=0)
				Begin.HP = 0;
			s += economy2[(int)(Math.random()*4)] + "\n";
		}
		else if(Begin.EV<40+(GameWindow.time-1020)*1.1&&(int)(Math.random()*3)==2){
			
			Economy.EIR -= 0.001+(int)(Math.random()*4)*0.0002;
			Begin.EV -= 20+(int)(Math.random()*4)*3;
			Begin.HP -= 5*(int)(Math.random()*4);
			if(Begin.HP<=0)
				Begin.HP = 0;
			s += economy[(int)(Math.random()*4)] + "\n";
		}
		
		if(Begin.HV>=60&&(int)Math.random()*hv==0){
			Begin.HV -= (10+(int)(Math.random()*4)*2)/hv;
			Begin.HP -= 5*(int)(Math.random()*4)/hv;
			if(Begin.HP<=0)
				Begin.HP = 0;
			s += happiness2[(int)(Math.random()*4)] + "\n";
		}
		else if(Begin.HV<60&&(int)(Math.random()*3)==2){
			Begin.HV -= 10+(int)(Math.random()*4)*2;
			Begin.HP -= 5*(int)(Math.random()*4);
			if(Begin.HP<=0)
				Begin.HP = 0;
			s += happiness[(int)(Math.random()*4)] + "\n";
		}
		
		if(Begin.EMV>=60&&(int)Math.random()*emv==0){
			Begin.EMV -= (10+(int)(Math.random()*4)*2)/emv;
			Begin.HP -= 5*(int)(Math.random()*4)/emv;
			if(Begin.HP<=0)
				Begin.HP = 0;
			s += economy2[(int)(Math.random()*4)] + "\n";
		}
		else if(Begin.EMV<60&&(int)(Math.random()*3)==2){
			Begin.EMV -= 10+(int)(Math.random()*4)*2;
			Begin.HP -= 5*(int)(Math.random()*4);
			if(Begin.HP<=0)
				Begin.HP = 0;
			s += enviroment2[(int)(Math.random()*4)] + "\n";
		}
		
		return s;
	}	
}
