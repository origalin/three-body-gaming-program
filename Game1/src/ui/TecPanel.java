package ui;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.Timer;

import el.Sci;

public class TecPanel extends JLabel {
	JTextField pointsfield;
	ImageIcon start1 = new ImageIcon("image/button1.png");
	ImageIcon start2 = new ImageIcon("image/button2.png");
	ImageIcon start3 = new ImageIcon("image/button3.png");
	ImageIcon icon1 = new ImageIcon("image/iconblue1.png");
	ImageIcon icon2 = new ImageIcon("image/iconblue2.png");
	ImageIcon icon3 = new ImageIcon("image/iconblue3.png");
	ImageIcon treebackground = new ImageIcon("image/treebackground.png");
	static ImageButton[] tecButton = new ImageButton[10];// 微积分 几何 微观物质结构 生态学
															// 计算机科学 机械与力学 有机化学
															// 人工智能 核理论 生物工程
	static ImageIcon[] buttonIcons1 = new ImageIcon[10];
	static ImageIcon[] buttonIcons2 = new ImageIcon[10];
	static ImageIcon[] buttonIcons3 = new ImageIcon[10];
	static ImageIcon[] lineImageIcons = new ImageIcon[6];
	static JLabel[] lineLabels = new JLabel[6];
	ImageButton confirmButton = new ImageButton(start1, start2, start3, false);
	Timer t;
	static int  ligntstate = 0;
	static String[] textTitle = { "微积分", "几何", "微观物质结构", "生态学", "集成电路",
			"机械与力学", "有机化学", "人工智能", "核理论", "生物工程" };
	static String[] textContains = { "高等数学的一部分，科学体系的根基\n学科需求：数 3",
			"研究空间区域关系的数学分支\n学科需求：物 1 数 2 艺 1",
			"在分子、原子层次上研究物质的组成、性质、结构与变化规律\n学科需求：化 3 物 2 数 3 艺 2",
			"行星生态体系的研究，是掌握生命钥匙的开始\n学科需求：化 2 生 5 数 1",
			"信息技术的飞跃，具有无限可能\n学科需求：物 1 数 3 计 3 艺 1\n解锁：晶体管计算机 多媒体设备",
			"工程技术投入应用，用钢铁代替血肉\n学科需求：化 2 物 4 数 3 计 3 艺 2\n解锁：载具 高精度工具",
			"有机化合物及有机物质的结构、性质、反应的发现\n学科需求：化 6 生 4 物 1 数 3 计 3 艺 1\n解锁：塑料",
			"从绝对理性到感性的突破，社会伦理将因此改变\n学科需求：生 2 物 6 数 6 计 6 艺 2\n解锁：智能机械",
			"掌握物质深处的巨大能量\n学科需求：化 4  生 2 物 7 数 6 计 6 艺 2\n解锁：核武器",
			"这个种族已然主宰生命的一部分\n学科需求：化 5 生 7 物 2 数 4 计 4 艺 2\n解锁：生物制药"
			};
	public static int[] tecStats = new int[10];

	public TecPanel(ImageIcon i) {
		super(i);
		setBounds(232, 48, i.getIconWidth(), i.getIconHeight());
		setOpaque(false);

		confirmButton.setLocation(70, 530);
		confirmButton.setText("确认");
		confirmButton.setHorizontalTextPosition(JButton.CENTER);
		confirmButton.setVerticalTextPosition(JButton.CENTER);
		confirmButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
		confirmButton.setForeground(new Color(53, 76, 107));
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

		pointsfield = new JTextField();
		pointsfield.setOpaque(false);
		pointsfield.setFont(new Font("微软雅黑", Font.BOLD, 20));
		pointsfield.setFocusable(false);
		pointsfield.setBounds(25, 20, 500, 40);
		pointsfield.setHorizontalAlignment(JTextField.CENTER);
		pointsfield.setForeground(new Color(49, 77, 114));
		pointsfield.setBorder(null);
		pointsfield.setText("化学:" + Sci.chemistry.point + " 生物:"
				+ Sci.biology.point + " 物理:" + Sci.physics.point + " 数学:"
				+ Sci.math.point + " 计算机:" + Sci.computer.point + " 艺术:"
				+ Sci.art.point);
		pointsfield.setEditable(false);
		add(pointsfield);

		// 科技树部分
		JPanel treePanel = new JPanel();
		treePanel.setBounds(55, 70, 690, 450);
		treePanel.setLayout(new CardLayout());
		treePanel.setOpaque(false);
		add(treePanel);
		JLabel treeLabel1 = new JLabel(treebackground);
		treeLabel1.setBounds(0, 0, 690, 450);
		treeLabel1.setOpaque(false);
		treePanel.add(treeLabel1);

		// 科技树按钮
		for (int i1 = 0; i1 <= 9; i1++) {
			buttonIcons1[i1] = new ImageIcon("image/tec1" + (i1 + 1) + ".png");
		}
		for (int i1 = 0; i1 <= 9; i1++) {
			buttonIcons2[i1] = new ImageIcon("image/tec2" + (i1 + 1) + ".png");
		}
		for (int i1 = 0; i1 <= 9; i1++) {
			buttonIcons3[i1] = new ImageIcon("image/tec3" + (i1 + 1) + ".png");
		} // 测试用

		for (int i1 = 0; i1 <= 9; i1++) {
			tecButton[i1] = new ImageButton(buttonIcons1[i1], buttonIcons2[i1],
					buttonIcons3[i1], false);
		}
		for (int i1 = 0; i1 <= 9; i1++) {
			tecButton[i1].setspimage(new ImageIcon("image/tec" + (i1 + 1)
					+ ".png"));
		}

		tecButton[0].setLocation(42, 35);
		tecButton[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				tecButton[0].ispressed = true;
				tecButton[0].setavalible(false);
				lineLabels[0].setVisible(true);
				tecButton[4].setVisible(true);
				Sci.math.point -= 3;
				pointsfield.setText("化学:" + Sci.chemistry.point + " 生物:"
						+ Sci.biology.point + " 物理:" + Sci.physics.point
						+ " 数学:" + Sci.math.point + " 计算机:"
						+ Sci.computer.point + " 艺术:" + Sci.art.point);
				Refresh();
			}
		});
		tecButton[1].setLocation(42, 140);
		tecButton[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if (ligntstate <= 1) {
					GameWindow.light1.setVisible(true);
					ligntstate = 1;
				}
				tecButton[1].ispressed = true;
				tecButton[1].setavalible(false);
				lineLabels[1].setVisible(true);
				tecButton[5].setVisible(true);
				Sci.physics.point -= 1;
				Sci.math.point -= 2;
				Sci.art.point -= 1;
				pointsfield.setText("化学:" + Sci.chemistry.point + " 生物:"
						+ Sci.biology.point + " 物理:" + Sci.physics.point
						+ " 数学:" + Sci.math.point + " 计算机:"
						+ Sci.computer.point + " 艺术:" + Sci.art.point);
				Refresh();
			}
		});
		tecButton[2].setLocation(42, 245);
		tecButton[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				tecButton[2].ispressed = true;
				tecButton[2].setavalible(false);
				lineLabels[2].setVisible(true);
				tecButton[8].setVisible(true);
				Sci.chemistry.point -= 3;
				Sci.physics.point -= 2;
				Sci.math.point -= 3;
				Sci.art.point -= 2;
				pointsfield.setText("化学:" + Sci.chemistry.point + " 生物:"
						+ Sci.biology.point + " 物理:" + Sci.physics.point
						+ " 数学:" + Sci.math.point + " 计算机:"
						+ Sci.computer.point + " 艺术:" + Sci.art.point);
				Refresh();
			}
		});
		tecButton[3].setLocation(42, 350);
		tecButton[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				tecButton[3].ispressed = true;
				tecButton[3].setavalible(false);
				lineLabels[3].setVisible(true);
				tecButton[6].setVisible(true);
				Sci.chemistry.point -= 2;
				Sci.biology.point -= 5;
				Sci.math.point -= 1;
				pointsfield.setText("化学:" + Sci.chemistry.point + " 生物:"
						+ Sci.biology.point + " 物理:" + Sci.physics.point
						+ " 数学:" + Sci.math.point + " 计算机:"
						+ Sci.computer.point + " 艺术:" + Sci.art.point);
				Refresh();
			}
		});
		tecButton[4].setLocation(305, 35);
		tecButton[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if (ligntstate <= 2) {
					GameWindow.light1.setVisible(false);
					GameWindow.light2.setVisible(true);
					ligntstate = 2;
				}

				tecButton[4].ispressed = true;
				tecButton[4].setavalible(false);
				lineLabels[4].setVisible(true);
				tecButton[7].setVisible(true);
				Sci.physics.point -= 1;
				Sci.math.point -= 3;
				Sci.computer.point -= 3;
				Sci.art.point -= 1;
				pointsfield.setText("化学:" + Sci.chemistry.point + " 生物:"
						+ Sci.biology.point + " 物理:" + Sci.physics.point
						+ " 数学:" + Sci.math.point + " 计算机:"
						+ Sci.computer.point + " 艺术:" + Sci.art.point);
				Refresh();
			}
		});
		tecButton[5].setLocation(305, 140);
		tecButton[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				tecButton[5].ispressed = true;
				tecButton[5].setavalible(false);
				lineLabels[4].setVisible(true);
				tecButton[7].setVisible(true);
				lineLabels[2].setVisible(true);
				tecButton[8].setVisible(true);
				Sci.chemistry.point -= 2;
				Sci.physics.point -= 4;
				Sci.math.point -= 3;
				Sci.computer.point -= 3;
				Sci.art.point -= 2;
				pointsfield.setText("化学:" + Sci.chemistry.point + " 生物:"
						+ Sci.biology.point + " 物理:" + Sci.physics.point
						+ " 数学:" + Sci.math.point + " 计算机:"
						+ Sci.computer.point + " 艺术:" + Sci.art.point);
				Refresh();
			}
		});
		tecButton[6].setLocation(305, 350);
		tecButton[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				tecButton[6].ispressed = true;
				tecButton[6].setavalible(false);
				lineLabels[5].setVisible(true);
				tecButton[9].setVisible(true);
				Sci.chemistry.point -= 6;
				Sci.biology.point -= 4;
				Sci.physics.point -= 1;
				Sci.math.point -= 3;
				Sci.computer.point -= 3;
				Sci.art.point -= 1;
				pointsfield.setText("化学:" + Sci.chemistry.point + " 生物:"
						+ Sci.biology.point + " 物理:" + Sci.physics.point
						+ " 数学:" + Sci.math.point + " 计算机:"
						+ Sci.computer.point + " 艺术:" + Sci.art.point);
				Refresh();
			}
		});
		tecButton[7].setLocation(540, 35);
		tecButton[7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				tecButton[7].ispressed = true;
				tecButton[7].setavalible(false);
				Sci.biology.point -= 2;
				Sci.physics.point -= 6;
				Sci.math.point -= 6;
				Sci.computer.point -= 6;
				Sci.art.point -= 2;
				pointsfield.setText("化学:" + Sci.chemistry.point + " 生物:"
						+ Sci.biology.point + " 物理:" + Sci.physics.point
						+ " 数学:" + Sci.math.point + " 计算机:"
						+ Sci.computer.point + " 艺术:" + Sci.art.point);
				Refresh();
			}
		});
		tecButton[8].setLocation(540, 245);
		tecButton[8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				tecButton[8].ispressed = true;
				tecButton[8].setavalible(false);
				Sci.chemistry.point -= 4;
				Sci.biology.point -= 2;
				Sci.physics.point -= 7;
				Sci.math.point -= 6;
				Sci.computer.point -= 6;
				Sci.art.point -= 2;
				pointsfield.setText("化学:" + Sci.chemistry.point + " 生物:"
						+ Sci.biology.point + " 物理:" + Sci.physics.point
						+ " 数学:" + Sci.math.point + " 计算机:"
						+ Sci.computer.point + " 艺术:" + Sci.art.point);
				Refresh();
			}
		});
		tecButton[9].setLocation(540, 350);
		tecButton[9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if (ligntstate <= 3) {
					GameWindow.light1.setVisible(false);
					GameWindow.light2.setVisible(false);
					GameWindow.light3.setVisible(true);
					ligntstate = 3;
				}

				tecButton[9].ispressed = true;
				tecButton[9].setavalible(false);
				Sci.chemistry.point -= 5;
				Sci.biology.point -= 7;
				Sci.physics.point -= 2;
				Sci.math.point -= 4;
				Sci.computer.point -= 4;
				Sci.art.point -= 2;
				pointsfield.setText("化学:" + Sci.chemistry.point + " 生物:"
						+ Sci.biology.point + " 物理:" + Sci.physics.point
						+ " 数学:" + Sci.math.point + " 计算机:"
						+ Sci.computer.point + " 艺术:" + Sci.art.point);
				Refresh();
			}
		});

		for (ImageButton im : tecButton) {
			im.setavalible(false);
			treeLabel1.add(im);
		}
		for (int i1 = 4; i1 <= 9; i1++) {
			tecButton[i1].setVisible(false);
		}

		// 科技树线段
		for (int i1 = 0; i1 <= 5; i1++) {
			lineImageIcons[i1] = new ImageIcon("image/line" + (i1 + 1) + ".png");
		}
		for (int i1 = 0; i1 <= 5; i1++) {
			lineLabels[i1] = new JLabel(lineImageIcons[i1]);
			lineLabels[i1].setBounds(0, 0, lineLabels[i1].getIcon()
					.getIconWidth(), lineLabels[i1].getIcon().getIconHeight());
		}
		lineLabels[0].setLocation(112, 65);
		lineLabels[1].setLocation(112, 174);
		lineLabels[2].setLocation(112, 180);
		lineLabels[3].setLocation(112, 290);
		lineLabels[4].setLocation(373, 65);
		lineLabels[5].setLocation(373, 381);
		for (JLabel im : lineLabels) {
			treeLabel1.add(im);
			im.setVisible(false);
		}

	}

	public void Refresh() {
		int[] points = { Sci.chemistry.point, Sci.biology.point,
				Sci.physics.point, Sci.math.point, Sci.computer.point,
				Sci.art.point };
		int[][] pointsneed = { { 0, 0, 0, 3, 0, 0 }, { 0, 0, 1, 2, 0, 1 },
				{ 3, 0, 2, 3, 0, 2 }, { 2, 5, 0, 1, 0, 0 },
				{ 0, 0, 1, 3, 3, 1 }, { 2, 0, 4, 3, 3, 2 },
				{ 6, 4, 1, 3, 3, 1 }, { 0, 2, 6, 6, 6, 2 },
				{ 4, 2, 7, 6, 6, 2 }, { 5, 7, 2, 4, 4, 2 } };
		for (int i = 0; i <= 9; i++) {
			boolean isproable = true;
			for (int j = 0; j <= 5; j++) {
				if (points[j] < pointsneed[i][j] || tecButton[i].ispressed) {
					isproable = false;
				}
			}
			if (isproable && !tecButton[i].ispressed) {

				tecButton[i].setavalible(true);
			} else {
				tecButton[i].setavalible(false);
			}
		}
		if (!tecButton[4].ispressed || !tecButton[5].ispressed) {
			tecButton[7].setavalible(false);
		}
		if (!tecButton[2].ispressed || !tecButton[5].ispressed) {
			tecButton[8].setavalible(false);
		}
		if (!tecButton[2].ispressed || !tecButton[3].ispressed) {
			tecButton[6].setavalible(false);
		}
		for (int i = 0; i < 10; i++) {
			if (tecButton[i].ispressed) {
				tecStats[i] = 1;
			}
		}
	}

	public void load() {
		if (tecButton[1].ispressed) {
			lineLabels[1].setVisible(true);
			tecButton[5].setVisible(true);
		}
		if (tecButton[0].ispressed) {
			lineLabels[0].setVisible(true);
			tecButton[4].setVisible(true);
		}
		if (tecButton[2].ispressed) {
			lineLabels[2].setVisible(true);
			tecButton[8].setVisible(true);
		}
		if (tecButton[3].ispressed) {
			lineLabels[3].setVisible(true);
			tecButton[6].setVisible(true);
		}
		if (tecButton[4].ispressed) {
			lineLabels[4].setVisible(true);
			tecButton[7].setVisible(true);
		}
		if (tecButton[5].ispressed) {
			lineLabels[4].setVisible(true);
			tecButton[7].setVisible(true);
			lineLabels[2].setVisible(true);
			tecButton[8].setVisible(true);
		}
		if (tecButton[6].ispressed) {
			lineLabels[5].setVisible(true);
			tecButton[9].setVisible(true);
		}
		if(ligntstate ==1) {
			GameWindow.light1.setVisible(true);
		}
		else if(ligntstate ==2) {
			GameWindow.light2.setVisible(true);
		}
		else if(ligntstate ==3) {
			GameWindow.light3.setVisible(true);
		}
	}
}
