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
		Math.point -= 14;
		Physics.point -= 11;
		Biology.point -= 11;
		Chemistry.point -= 11;
		Art.point -= 12;
		Computer.point -= 10;
	}
	
	public void judgeC(Theory theory){
//		if(theory.isClicked==true)
//			��Ӧ��Ʒ������ڽ�������
	}
	
	private boolean judgeA(Theory theory){
		if(Math.point>=theory.mathPoint&&
				Physics.point>=theory.physicsPoint&&
				Biology.point>=theory.biologyPoint&&
				Chemistry.point>=theory.chemistryPoint&&
				Art.point>=theory.artPoint&&
				Computer.point>=theory.artPoint)
			return true;
		return false;
	}
	
	public void judgeSumA(){//���˴����������Ƽ����İ�ťʱ����
		fly.isAvailable = fly.judgeA(fly);//���������۷���һ��arraylist�У�����arraylist
	}
	
	Theory fly = new Theory(1,2,3,4,5,6);
}

