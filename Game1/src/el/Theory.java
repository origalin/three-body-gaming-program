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
	
	public static Theory  geometry=new Theory(2,1,0,0,2,0);//����
	public static Theory calculus=new Theory(4,0,0,0,0,0);//΢����
	public static Theory computerScience=new Theory(4,1,0,0,2,0);//�������ѧ
	public static Theory mechanical=new Theory(3,4,0,0,2,0);//��е����
	public static Theory materialStructure=new Theory(3,1,2,0,3,0);//΢�����ʽṹ
	public static Theory ecology=new Theory(1,0,1,4,0,1);//��̬ѧ
	public static Theory organic=new Theory(4,1,5,5,1,1);//�л���ѧ
	public static Theory bioEngineering=new Theory(4,1,5,7,3,1);//���﹤��
	public static Theory ArtificialInt=new Theory(7,6,0,0,5,2);//�˹�����
	public static Theory nuclearChemistry=new Theory(8,8,4,0,3,2);//�˻�ѧ
}

