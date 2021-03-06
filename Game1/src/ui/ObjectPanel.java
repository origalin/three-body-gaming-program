package ui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import el.Begin;
import el.Tools;

@SuppressWarnings("serial")
public class ObjectPanel extends JLabel {
	static String[] textTitle = { "晶体管计算机", " 多媒体设备", "载具", "高精度工具", "塑料",
			"智能机械", "核武器", "生物制药", "宇宙飞船", "混合生物", "超级生物" };
	static String[] textContains = { "开启信息时代钥匙，能极大地提高计算能力，可进行极为繁琐复杂的计算\n需要资金150，1回合",
			"音乐、影像技术实现大的飞跃，丰富人民的文化生活，能够激发个人的创造力、想象力\n需要资金180，1回合",
			"能够使运输方式、出行方式实现革命性变化，大幅度提高运输效率，世界因此变得更小\n需要资金170，1回合",
			"能够极大地提高制造物品的精度，可以制造精密仪器、探究微观世界\n需要资金160，1回合",
			"新型材料，能够制质轻、耐用的物品,丰富人们的物质 生活\n需要资金165，1回合",
			"智能机械是能够在各类环境中执行各种拟人任务的机器，它不可思议的力量将给工业带来革命性的变化\n需要资金250，2回合",
			"灼热的高温，致命的辐射将是任何生物的噩梦，具有毁灭一个星球的能力，然而在太空战中它的能力还是一个未知数\n需要资金260，2回合",
			"给医学带来巨大的飞跃，结合最新的微生物学研究成果，寿命将得到空前的延长\n需要资金240，2回合",
			"关键产品(不能与另两者同时建造) 打开宇宙之门的钥匙，畅游太空的第一步，具有极强的续航能力，或许在它的帮助下我们能找到宇宙的尽头\n需要资金415，3回合",
			"关键产品(不能与另两者同时建造) 融合各种生物的优良特性，能上天能入地能下海，是你进入太空的钥匙\n需要资金410，3回合",
			"关键产品(不能与另两者同时建造) 将各种科技加入生物中，超越已知任何生物的极限，是生物科技的巅峰之作\n需要资金420,3回合"
			  };
	static ObjectImageButton[] button = new ObjectImageButton[11];
	JPanel toSetGrid;
	static JTextField money;
	JPanel settingGrid;

	JPanel doneSetGrid;
	MessageLabel m1;
	private ImageIcon icon1[] = new ImageIcon[11];
	private ImageIcon icon2[] = new ImageIcon[11];
	private ImageIcon icon3[] = new ImageIcon[11];

	Timer t;

	TopPanel top1;

	public ObjectPanel(ImageIcon i, MessageLabel m, TopPanel top) {
		super(i);
		m1 = m;
		top1 = top;
		ImageIcon start1 = new ImageIcon("image/buttonred1.png");
		ImageIcon start2 = new ImageIcon("image/buttonred2.png");
		ImageIcon start3 = new ImageIcon("image/buttonred3.png");
		for (int j = 0; j < 11; j++) {
			icon1[j] = new ImageIcon("image/ob1" + (j + 1) + ".png");
		}
		for (int j = 0; j < 11; j++) {
			icon2[j] = new ImageIcon("image/ob2" + (j + 1) + ".png");
		}
		for (int j = 0; j < 11; j++) {
			icon3[j] = new ImageIcon("image/ob3" + (j + 1) + ".png");
		}

		ObjectImageButton confirmButton = new ObjectImageButton(start1, start2,
				start3, false);

		setBounds(240, 28, i.getIconWidth(), i.getIconHeight());
		setOpaque(false);

		confirmButton.setLocation(70, 540);
		confirmButton.setText("确认");
		confirmButton.setHorizontalTextPosition(JButton.CENTER);
		confirmButton.setVerticalTextPosition(JButton.CENTER);
		confirmButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
		confirmButton.setForeground(new Color(134, 69, 0));
		confirmButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				GameWindow.blockLabel.setVisible(false);
				t = new Timer(10, new ActionListener() {
					int i = 0;

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						i += 1;

						if (i <= 10) {
							setLocation(getLocation().x,
									48 + ((720 - 48) / 10 * i));
						} else {
							t.stop();
						}
					}
				});
				t.start();
				for (ImageButton im : GameWindow.bottombottons) {
					im.setVisible(true);
				}
			}
		});
		add(confirmButton);

		// 可建造物品框

		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		toSetGrid = new JPanel(flowLayout);

		toSetGrid.setBounds(65, 60, 500, 200);
		toSetGrid.setVisible(true);
		toSetGrid.setOpaque(false);
		add(toSetGrid);

		// 已建造物品框
		doneSetGrid = new JPanel(flowLayout);
		doneSetGrid.setBounds(65, 330, 500, 180);
		doneSetGrid.setVisible(true);
		doneSetGrid.setOpaque(false);
		add(doneSetGrid);

		// 建造队列物品框

		settingGrid = new JPanel(flowLayout);
		settingGrid.setBounds(630, 60, 80, 490);
		settingGrid.setVisible(true);
		settingGrid.setOpaque(false);
		add(settingGrid);

		// 创建所有按钮

		for (int j = 0; j < 11; j++) {
			button[j] = new ObjectImageButton(icon1[j], icon2[j], icon3[j],
					false);
		}
		// 创建按钮的监听

		button[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m1.setVisible(false);
				if (button[0].location == -1) {

				} else if (button[0].location == 0) {
					toSetToSetting(button[0], 0);
					repaint();
				} else if (button[0].location == 1) {
					deleteSetting(button[0]);
					addToSet(button[0]);
					Begin.EV += Tools.Money[0];
					top1.refresh();
					moneyRefresh();
					repaint();
				}
			}
		});

		button[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m1.setVisible(false);
				if (button[1].location == -1) {

				} else if (button[1].location == 0) {
					toSetToSetting(button[1], 1);
					repaint();
				} else if (button[1].location == 1) {
					deleteSetting(button[1]);
					addToSet(button[1]);
					Begin.EV += Tools.Money[1];
					top1.refresh();
					moneyRefresh();
					repaint();
				}
				isAvailable();
			}
		});
		button[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m1.setVisible(false);
				if (button[2].location == -1) {

				} else if (button[2].location == 0) {
					toSetToSetting(button[2], 2);
					repaint();
				} else if (button[2].location == 1) {
					deleteSetting(button[2]);
					addToSet(button[2]);
					Begin.EV += Tools.Money[2];
					top1.refresh();
					moneyRefresh();
					repaint();
				}
				isAvailable();
			}
		});
		button[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m1.setVisible(false);
				if (button[3].location == -1) {

				} else if (button[3].location == 0) {
					toSetToSetting(button[3], 3);
					repaint();
				} else if (button[3].location == 1) {
					deleteSetting(button[3]);
					addToSet(button[3]);
					Begin.EV += Tools.Money[3];
					top1.refresh();
					moneyRefresh();
					repaint();
				}
				isAvailable();
			}
		});
		button[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m1.setVisible(false);
				if (button[4].location == -1) {

				} else if (button[4].location == 0) {
					toSetToSetting(button[4], 4);
					repaint();
				} else if (button[4].location == 1) {
					deleteSetting(button[4]);
					addToSet(button[4]);
					Begin.EV += Tools.Money[4];
					top1.refresh();
					moneyRefresh();
					repaint();
				}
				isAvailable();
			}
		});
		button[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m1.setVisible(false);
				if (button[5].location == -1) {

				} else if (button[5].location == 0) {
					toSetToSetting(button[5], 5);
					repaint();
				} else if (button[5].location == 1) {
					deleteSetting(button[5]);
					addToSet(button[5]);
					Begin.EV += Tools.Money[5];
					top1.refresh();
					moneyRefresh();
					repaint();
				}
				isAvailable();
			}
		});
		button[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m1.setVisible(false);
				if (button[6].location == -1) {

				} else if (button[6].location == 0) {
					toSetToSetting(button[6], 6);
					repaint();
				} else if (button[6].location == 1) {
					deleteSetting(button[6]);
					addToSet(button[6]);
					Begin.EV += Tools.Money[6];
					top1.refresh();
					moneyRefresh();
					repaint();
				}
				isAvailable();
			}
		});
		button[7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m1.setVisible(false);
				if (button[7].location == -1) {

				} else if (button[7].location == 0) {
					toSetToSetting(button[7], 7);
					repaint();
				} else if (button[7].location == 1) {
					deleteSetting(button[7]);
					addToSet(button[7]);
					Begin.EV += Tools.Money[7];
					top1.refresh();
					moneyRefresh();
					repaint();
				}
				isAvailable();
			}
		});
		button[8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				m1.setVisible(false);
				if (button[8].location == -1) {

				} else if (button[8].location == 0) {
					toSetToSetting(button[8], 8);
					repaint();
				} else if (button[8].location == 1) {
					deleteSetting(button[8]);
					addToSet(button[8]);
					Begin.EV += Tools.Money[8];
					top1.refresh();
					moneyRefresh();
					repaint();
				}
				isAvailable();
			}
		});
		button[9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				m1.setVisible(false);
				if (button[9].location == -1) {

				} else if (button[9].location == 0) {
					toSetToSetting(button[9], 9);
					repaint();
				} else if (button[9].location == 1) {
					deleteSetting(button[9]);
					addToSet(button[9]);
					Begin.EV += Tools.Money[9];
					top1.refresh();
					moneyRefresh();
					repaint();
				}
				isAvailable();
			}
		});
		button[10].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				m1.setVisible(false);
				if (button[10].location == -1) {

				} else if (button[10].location == 0) {
					toSetToSetting(button[10], 10);
					repaint();
				} else if (button[10].location == 1) {
					deleteSetting(button[10]);
					addToSet(button[10]);
					Begin.EV += Tools.Money[10];
					top1.refresh();
					moneyRefresh();
					repaint();
				}
				isAvailable();
			}
		});
		money = new JTextField();
		money.setBounds(172, 256, 290, 40);
		money.setEditable(false);
		money.setFocusable(false);
		money.setOpaque(false);
		money.setHorizontalAlignment(JTextField.CENTER);
		money.setFont(new Font("微软雅黑", Font.BOLD, 20));
		money.setForeground(new Color(134, 69, 0));
		money.setBorder(null);

		add(money);
	}

	// 添加可解锁的按钮

	public void addToSet(ObjectImageButton object) {
		if (object.location == -1 || object.location == 1||object.location==0) {
			toSetGrid.add(object);
			object.location = 0;
			validate();
		}
	}

	public void deleteFromSet(ObjectImageButton object) {
		if (object.location == 0) {
			toSetGrid.remove(object);
			validate();
		}
	}

	public void addSetting(ObjectImageButton object) {
		if (object.location == 0||object.location==1) {
			settingGrid.add(object);
			object.location = 1;
			object.newTime = GameWindow.time;
			validate();
		}
	}

	public void deleteSetting(ObjectImageButton object) {
		if (object.location == 1) {
			settingGrid.remove(object);
			object.newTime = 0;
			validate();

		}
	}

	public void addDoneSet(ObjectImageButton object) {
		if (object.location == 1||object.location==2) {
			doneSetGrid.add(object);
			object.location = 2;
			validate();
			if(button[0].location==2){
				
			}
		}
	}

	public void toSetToSetting(ObjectImageButton object, int i) {
		if (Begin.EV - Tools.Money[i] >= 0) {
			this.deleteFromSet(object);
			this.addSetting(object);
			Begin.EV -= Tools.Money[i];
			top1.refresh();
			ObjectPanel.moneyRefresh();
		}
	}

	public static void moneyRefresh() {
		money.setText("可用资金：" + Begin.EV);
	}

	public void refresh() {
		if (TecPanel.tecStats[4] == 1 && button[0].location == -1
				&& button[1].location == -1) {
			this.addToSet(button[0]);
			this.addToSet(button[1]);
		}
		if (TecPanel.tecStats[5] == 1 && button[2].location == -1
				&& button[3].location == -1) {
			this.addToSet(button[2]);
			this.addToSet(button[3]);
		}
		if (TecPanel.tecStats[6] == 1 && button[4].location == -1) {
			this.addToSet(button[4]);
		}
		if (TecPanel.tecStats[7] == 1 && button[5].location == -1) {
			this.addToSet(button[5]);
		}
		if (TecPanel.tecStats[8] == 1 && button[6].location == -1) {
			this.addToSet(button[6]);
		}
		if (TecPanel.tecStats[9] == 1 && button[7].location == -1) {
			this.addToSet(button[7]);
		}
		if (TecPanel.tecStats[7] == 1 && TecPanel.tecStats[8] == 1
				&& button[8].location == -1) {
			this.addToSet(button[8]);
		}
		if (TecPanel.tecStats[7] == 1 && TecPanel.tecStats[9] == 1
				&& button[9].location == -1) {
			this.addToSet(button[9]);
		}
		if (TecPanel.tecStats[8] == 1 && TecPanel.tecStats[9] == 1
				&& button[10].location == -1) {
			this.addToSet(button[10]);
		}
		for (int i = 0; i < 11; i++) {
			if ((GameWindow.time - button[i].newTime >= Tools.Time[i])
					&& button[i].newTime > 0) {
				button[i].newTime = 0;
				this.deleteSetting(button[i]);
				this.addDoneSet(button[i]);
			}
		}
		isAvailable();
		repaint();
	}
	public void recover(){
		toSetGrid.removeAll();
		settingGrid.removeAll();
		doneSetGrid.removeAll();
		for(int j=0;j<11;j++){
			switch(button[j].location){
			case -1:break;
			case 0:this.addToSet(button[j]);
				break;
			case 1:this.addSetting(button[j]);
				break;
			case 2:this.addDoneSet(button[j]);
				break;
			default:
					break;
			}
		}
	}
	public void isAvailable(){

		for(int j=0;j<11;j++){
			if(button[j].location==0){
				if(Begin.EV<Tools.Money[j]){
					button[j].setavalible(false);
				}else {
					button[j].setavalible(true);
				}
			}
			if(button[j].location==1){
				button[j].setavalible(true);
			}
			if(button[j].location==2){
				button[j].setavalible(false);
			}
		}
		judge();
		
	}
	public static void judge(){
		if(button[10].location==0||button[8].location==0||button[9].location==0){
			if(button[6].location!=2||button[7].location!=2){
				button[10].setavalible(false);
		}
			if(button[5].location!=2||button[7].location!=2){
				button[9].setavalible(false);
		}
			if(button[6].location!=2||button[5].location!=2){
				button[8].setavalible(false);
		}
		if(button[10].location==1){
			button[8].setavalible(false);
			button[9].setavalible(false);
		}
		if(button[8].location==1){
			button[10].setavalible(false);
			button[9].setavalible(false);
		}
		if(button[9].location==1){
			button[8].setavalible(false);
			button[10].setavalible(false);
		}
		if(button[10].location==0&&button[8].location==0&&button[9].location==0){
			if(Begin.EV<Tools.Money[10]){
				button[10].setavalible(false);
			}else {
				button[10].setavalible(true);
			}
			if(Begin.EV<Tools.Money[9]){
				button[9].setavalible(false);
			}else {
				button[9].setavalible(true);
			}
			if(Begin.EV<Tools.Money[8]){
				button[8].setavalible(false);
			}else {
				button[8].setavalible(true);
			}
		}
	}

	}
}
