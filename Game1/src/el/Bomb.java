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
	static String[]economy={"你的星球正在发生饥荒","经济大幅动荡，市场萧条","劳动者比例失衡，经济运转困难","地方政府已无力偿还债务"};
	static String[]happiness={"各地正在发生暴乱","地区冲突严重激化","反叛分子已形成相当势力","各地犯罪行为不断，监狱人满为患"};
	static String[]enviroment={"森林的覆盖面积正在迅速下降","草场正在急剧荒漠化","水资源陷入短缺","多地出现极端气候"};
	static String[]economy2={"星球饥饿人口比例上升","首都发生地震，急缺赈灾基金","你的居民要求医疗保障，各地游行频发","部分投机分子扰乱经济"};
	static String[]happiness2={"医疗中心显示抑郁症患者增多","青少年自杀事故频发","节目《fxxk总统》热播","城市中谣言泛滥"};
	static String[]enviroment2={"乱排放现象屡禁不止","生活垃圾处理不当，引发中毒事件","河流污染有加重趋势","环保税施行受挫"};

	public String bomb(){
		String s = "";

		int ev = 7500/(2500-Begin.HV+1)+2;
		int hv = 300/(100-Begin.HV+1);
		int emv = 300/(100-Begin.EMV+1);

		if(Begin.EV>=40+(GameWindow.time-1020)*1.1&&(int)(Math.random()*ev)==0){
			Economy.EIR -= (0.001+(int)(Math.random()*4)*0.0002)/ev;
			Begin.EV -= (20+(int)(Math.random()*4)*3)/ev;
			Begin.HP -= 5*(int)(Math.random()*4)/ev;
			if(Begin.HP<=0)
				Begin.HP = 0;
			s += economy2[(int)(Math.random()*4)] + "\n";
		}
		if(Begin.EV<40+(GameWindow.time-1020)*1.1&&(int)(Math.random()*3)==2){
			
			Economy.EIR -= 0.001+(int)(Math.random()*4)*0.0002;
			Begin.EV -= 20+(int)(Math.random()*4)*3;
			Begin.HP -= 5*(int)(Math.random()*4);
			if(Begin.HP<=0)
				Begin.HP = 0;
			s += economy[(int)(Math.random()*4)] + "\n";
		}
		
		if(Begin.HV>=60&&(int)(Math.random()*hv)==0){
			Begin.HV -= (10+(int)(Math.random()*4)*2)/hv;
			Begin.HP -= 5*(int)(Math.random()*4)/hv;
			if(Begin.HP<=0)
				Begin.HP = 0;
			s += happiness2[(int)(Math.random()*4)] + "\n";
		}
		if(Begin.HV<60&&(int)(Math.random()*3)==2){
			Begin.HV -= 10+(int)(Math.random()*4)*2;
			Begin.HP -= 5*(int)(Math.random()*4);
			if(Begin.HP<=0)
				Begin.HP = 0;
			s += happiness[(int)(Math.random()*4)] + "\n";
		}
		
		if(Begin.EMV>=60&&(int)(Math.random()*emv)==0){
			Begin.EMV -= (10+(int)(Math.random()*4)*2)/emv;
			Begin.HP -= 5*(int)(Math.random()*4)/emv;
			if(Begin.HP<=0)
				Begin.HP = 0;
			s += enviroment2[(int)(Math.random()*4)] + "\n";
		}
		if(Begin.EMV<60&&(int)(Math.random()*3)==2){
			Begin.EMV -= 10+(int)(Math.random()*4)*2;
			Begin.HP -= 5*(int)(Math.random()*4);
			if(Begin.HP<=0)
				Begin.HP = 0;
			s += enviroment[(int)(Math.random()*4)] + "\n";
		}
		
		return s;
	}	
}
