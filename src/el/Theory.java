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
	
	private void judgeC(Theory theory){
//		if(theory.isClicked==true)
//			��Ӧ��Ʒ������ڽ�������
	}
	
	private boolean judgeA(Theory theory){
		boolean a = false;
		return a;	
	}
	
	public void judgeSumC(){//����ĳ���Ƽ�ʱ����
		fly.judgeC(fly);	
	}
	
	public void judgeSumA(){//���˴����������Ƽ����İ�ťʱ����
		isAvailable = fly.judgeA(fly);
	}
	
	Theory fly = new Theory(1,2,3,4,5,6);
}

