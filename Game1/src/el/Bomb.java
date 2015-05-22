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
	static String[]economy={"你的星球正在发生饥荒","首都发生地震，急缺赈灾基金","你的居民要求医疗保障，各地游行频发","地方政府已无力偿还债务"};
	static String[]happiness={"各地正在发生暴乱","医疗中心显示抑郁症患者急剧增多","青少年自杀事故频发","各地犯罪行为不断，监狱人满为患"};
	static String[]enviroment={"森林的覆盖面积正在迅速下降","草场正在急剧荒漠化","水资源陷入短缺","多地出现极端气候"};
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
