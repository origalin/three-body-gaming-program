package ui;

import el.Theory;

public class geometry extends Theory {
	public geometry(){	
		mathPoint = 0;
		physicsPoint = 0;
	    biologyPoint = 0;
		chemistryPoint = 0;
		artPoint  = 0;
		computerPoint = 0;
	}
	public void judgeSumA(){//���˴����������Ƽ����İ�ťʱ����
		geometry.isAvailable = geometry.judgeA(geometry);//���������۷���һ��arraylist�У�����arraylist
	}
	

}
