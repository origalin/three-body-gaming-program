package ui;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import com.sun.org.apache.xml.internal.resolver.helpers.PublicId;

import sun.management.snmp.util.MibLogger;
import el.Begin;
import el.Tools;

public class ObjectPanel extends JLabel {
	static String[] textTitle = { "晶体管计算机", " 多媒体设备", "载具", "高精度工具", "塑料",
			"智能机械", "核武器", "生物制药", "宇宙飞船", "混合生物", "超级生物" };
	static String[] textContains = { "高等数学的一部分，科学体系的根基\n学科需求：数 3",
			"研究空间区域关系的数学分支\n学科需求：物 1 数 2 艺 1",
			"在分子、原子层次上研究物质的组成、性质、结构与变化规律\n学科需求：化 3 物 2 数 3 艺 2",
			"行星生态体系的研究，是掌握生命钥匙的开始\n学科需求：化 2 生 5 数 1",
			"信息技术的飞跃，具有无限可能\n学科需求：物 1 数 3 计 3 艺 1\n解锁：晶体管计算机 多媒体设备",
			"工程技术投入应用，用钢铁代替血肉\n学科需求：化 2 物 4 数 3 计 3 艺 2\n解锁：载具 高精度工具",
			"有机化合物及有机物质的结构、性质、反应的发现\n学科需求：化 6 生 4 物 1 数 3 计 3 艺 1\n解锁：塑料",
			"从绝对理性到感性的突破，社会伦理将因此改变\n学科需求：生 2 物 6 数 6 计 6 艺 2\n解锁：智能机械",
			"掌握物质深处的巨大能量\n学科需求：化 4  生 2 物 7 数 6 计 6 艺 2\n解锁：核武器",
			"这个种族已然主宰生命的一部分\n学科需求：化 5 生 7 物 2 数 4 计 4 艺 2\n解锁：生物制药", "" };
	static ObjectImageButton[] button = new ObjectImageButton[11];
	JPanel toSetGrid;
	JTextField money;
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
		money.setText("可用资金：" + Begin.EV);
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

	public void deleteToSet(ObjectImageButton object) {
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
		}

	}

	public void toSetToSetting(ObjectImageButton object, int i) {
		if (Begin.EV - Tools.Money[i] >= 0) {
			this.deleteToSet(object);
			this.addSetting(object);
			Begin.EV -= Tools.Money[i];
			top1.refresh();
			this.moneyRefresh();
		}
	}

	public void moneyRefresh() {
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
	}

}
