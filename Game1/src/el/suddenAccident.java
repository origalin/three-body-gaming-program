package el;

public class suddenAccident {
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
