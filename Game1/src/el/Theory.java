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
	
	public Theory(){
		
	}
	
	public Theory (int math,int physics,int biology,int chemistry,int art,int computer){
		mathPoint = math;
		physicsPoint = physics;
		biologyPoint = biology;
		chemistryPoint = chemistry;
		artPoint = art;
		computerPoint = computer;
		Sci.math.point -= 14;
		Sci.physics.point -= 11;
		Sci.biology.point -= 11;
		Sci.chemistry.point -= 11;
		Sci.art.point -= 12;
		Sci.computer.point -= 10;
	}
	
	public void judgeC(Theory theory){
//		if(theory.isClicked==true)
//			��Ӧ��Ʒ������ڽ�������
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
	
	public void judgeSumA(){//���˴����������Ƽ����İ�ťʱ����
		fly.isAvailable = fly.judgeA(fly);//���������۷���һ��arraylist�У�����arraylist
	}
	
	Theory fly = new Theory(1,2,3,4,5,6);
}

