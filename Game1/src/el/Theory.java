package el;

public class Theory {
	
	int mathPoint = 0;
	int physicsPoint = 0;
	int biologyPoint = 0;
	int chemistryPoint = 0;
	int artPoint  = 0;
	int computerPoint = 0;
	boolean isClicked = false;//���������ܵ���Ʒ
	boolean isAvailable = false;//����������ͻᷢ��
	
	public Theory (int math,int physics,int biology,int chemistry,int art,int computer){
		mathPoint = math;
		physicsPoint = physics;
		biologyPoint = biology;
		chemistryPoint = chemistry;
		artPoint = art;
		computerPoint = computer;
	}
	
	public void judgeC(Theory theory){
//			��Ӧ��Ʒ������ڽ�������
		Sci.math.point -= theory.mathPoint;
		Sci.physics.point -= theory.physicsPoint;
		Sci.biology.point -= theory.biologyPoint;
		Sci.chemistry.point -= theory.chemistryPoint;
		Sci.art.point -= theory.chemistryPoint;
		Sci.computer.point -= theory.computerPoint;
		
	}
	
	private boolean judgeA(Theory theory){
		if(Sci.math.point>=theory.mathPoint&&
			Sci.physics.point>=theory.physicsPoint&&
			Sci.biology.point>=theory.biologyPoint&&
			Sci.chemistry.point>=theory.chemistryPoint&&
			Sci.art.point>=theory.artPoint&&
			Sci.computer.point>=theory.artPoint)
			return true;
		return false;
	}
	
	public static void judgeSumA(){//���˴����������Ƽ����İ�ťʱ����
		fly.isAvailable = fly.judgeA(fly);//���������۷���һ��arraylist�У�����arraylist
	}
	
	static Theory fly = new Theory(1,1,1,1,1,1);
}

