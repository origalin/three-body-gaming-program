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
	public void judgeSumA(){//点了从主界面进入科技树的按钮时调用
		geometry.isAvailable = geometry.judgeA(geometry);//把所有理论放在一个arraylist中，遍历arraylist
	}
	

}
