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
	
	
	public Theory (int chemistry,int biology,int physics,int math,int computer,int art){//�� �� �� �� �� ��
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
	
	public static Theory  geometry=new Theory(0,0,1,2,0,2);//����
	public static Theory calculus=new Theory(0,0,0,4,0,0);//΢����
	public static Theory computerScience=new Theory(0,0,1,4,0,2);//�������ѧ
	public static Theory mechanical=new Theory(0,0,4,3,0,2);//��е����
	public static Theory materialStructure=new Theory(0,2,1,3,0,3);//΢�����ʽṹ
	public static Theory ecology=new Theory(4,1,0,1,1,0);//��̬ѧ
	public static Theory organic=new Theory(5,5,1,4,1,1);//�л���ѧ
	public static Theory bioEngineering=new Theory(7,5,1,4,1,3);//���﹤��
	public static Theory ArtificialInt=new Theory(0,0,6,7,2,5);//�˹�����
	public static Theory nuclearChemistry=new Theory(4,0,8,8,2,3);//�˻�ѧ
}

