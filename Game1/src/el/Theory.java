package el;

public class Theory {
	
	public int mathPoint = 0;
	public int physicsPoint = 0;
	public int biologyPoint = 0;
	public int chemistryPoint = 0;
	public int artPoint  = 0;
	public int computerPoint = 0;
	public static boolean isClicked = false;//���������ܵ���Ʒ
	public static boolean isAvailable = false;//����������ͻᷢ��
	
	
	public Theory (int math,int physics,int biology,int chemistry,int art,int computer){
		mathPoint = math;
		physicsPoint = physics;
		biologyPoint = biology;
		chemistryPoint = chemistry;
		artPoint = art;
		computerPoint = computer;
	}
	
	
	public void judgeC(Theory theory){
//		if(theory.isClicked==true)
//			��Ӧ��Ʒ������ڽ�������
	}
	
	private static boolean judgeA(Theory theory){
		if(Sci.math.point>=theory.mathPoint&&
			Sci.physics.point>=theory.physicsPoint&&
			Sci.biology.point>=theory.biologyPoint&&
			Sci.chemistry.point>=theory.chemistryPoint&&
			Sci.art.point>=theory.artPoint&&
			Sci.computer.point>=theory.artPoint)
			return true;
		return false;
	}


	public static void judgeSumA() {
		judgeA(fly);
	}	
	
	public static Theory fly = new Theory(1,2,3,4,5,6);
}

