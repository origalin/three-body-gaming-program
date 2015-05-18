package ui;

import el.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.Timer;

@SuppressWarnings("serial")
public class SciPanel extends JLabel {
	public static int mathSum;
	public static int physicsSum;
	public static int chemistrySum;
	public static int biologySum;
	public static int computerSum;
	public static int artSum;
	public static int availablepoints;
	public static int[] scipoints = new int[6];
	ImageIcon start1 = new ImageIcon("image/buttongreen1.png");
	ImageIcon start2 = new ImageIcon("image/buttongreen2.png");
	ImageIcon start3 = new ImageIcon("image/buttongreen3.png");
	ImageIcon icon1 = new ImageIcon("image/icongreen1.png");
	ImageIcon icon2 = new ImageIcon("image/icongreen2.png");
	ImageIcon icon3 = new ImageIcon("image/icongreen3.png");
	ImageButton confirmButton = new ImageButton(start1, start2, start3, false);
	ImageButton mathButton = new ImageButton(icon1, icon2, icon3, false);
	ImageButton phyButton = new ImageButton(icon1, icon2, icon3, false);
	ImageButton cheButton = new ImageButton(icon1, icon2, icon3, false);
	ImageButton comButton = new ImageButton(icon1, icon2, icon3, false);
	ImageButton artButton = new ImageButton(icon1, icon2, icon3, false);
	ImageButton bioButton = new ImageButton(icon1, icon2, icon3, false);
	JTextField pointsavailable = new JTextField();
	static ArrayList<ImageButton> sciIcon = new ArrayList<ImageButton>();
	static JTextField[] iconData = { new JTextField(), new JTextField(),
			new JTextField(), new JTextField(), new JTextField(),
			new JTextField() };
	int i1 = 0;
	public static String[] iconTitle = { "化学", "生物", "物理", "数学", "计算机", "艺术" };
	public static String[] iconContains = { "需要4科技点\n工业生产的核心,不过会对环境造成一定破坏哦",
			"需要2科技点\nFrankenstein！对环境有一定影响", "需要4科技点\n科技进步，经济增长，物理是破解奥秘的钥匙",
			"需要5科技点\n发展其他各个学科的基础", "需要3科技点\n科技进步离不开的尖端技术",
			"需要3科技点\n陶冶情操，提高人民的幸福感" };

	public SciPanel(ImageIcon i) {
		super(i);
		setBounds(232, 48, i.getIconWidth(), i.getIconHeight());
		setOpaque(false);
		confirmButton.setLocation(70, 530);
		confirmButton.setText("确认");
		confirmButton.setHorizontalTextPosition(JButton.CENTER);
		confirmButton.setVerticalTextPosition(JButton.CENTER);
		confirmButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				final Timer t = new Timer(10, new ActionListener() {
					int i = 0;

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						i += 1;

						if (i <= 5) {
							setLocation(getLocation().x,
									48 + ((720 - 48) / 5 * i));

						}
					}
				});
				t.start();
			}
		});
		add(confirmButton);
		mathButton.setLocation(260, 115);
		mathButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (Begin.HP >= 5) {
					Sci.math.point++;
					mathSum++;
					Begin.HP -= 5;
					iconData[3].setText(Sci.math.point + "");
					pointsavailable.setText("可分配学科点：" + Begin.HP);
					refresh();
				}
			}
		});
		phyButton.setLocation(425, 115);
		phyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (Begin.HP >= 4) {
					Sci.physics.point++;
					physicsSum++;
					Begin.HP -= 4;
					iconData[2].setText(Sci.physics.point + "");
					pointsavailable.setText("可分配学科点：" + Begin.HP);
					refresh();
				}

			}
		});
		cheButton.setLocation(260, 400);
		cheButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (Begin.HP >= 4) {
					Sci.chemistry.point++;
					chemistrySum++;
					Begin.HP -= 4;
					iconData[0].setText(Sci.chemistry.point + "");
					pointsavailable.setText("可分配学科点：" + Begin.HP);
					refresh();
				}

			}
		});
		comButton.setLocation(425, 400);
		comButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (Begin.HP >= 2) {
					Sci.computer.point++;
					computerSum++;
					Begin.HP -= 2;
					iconData[4].setText(Sci.computer.point + "");
					pointsavailable.setText("可分配学科点：" + Begin.HP);
					refresh();
				}

			}
		});
		artButton.setLocation(160, 260);
		artButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (Begin.HP >= 3) {
					Sci.art.point++;
					artSum++;
					Begin.HP -= 3;
					iconData[5].setText(Sci.art.point + "");
					pointsavailable.setText("可分配学科点：" + Begin.HP);
					refresh();
				}

			}
		});
		bioButton.setLocation(530, 260);
		bioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if (Begin.HP >= 3) {
					Sci.biology.point++;
					biologySum++;
					Begin.HP -= 3;
					iconData[1].setText(Sci.biology.point + "");
					pointsavailable.setText("可分配学科点：" + Begin.HP);
					refresh();
				}
			}
		});
		sciIcon.add(cheButton);
		sciIcon.add(bioButton);
		sciIcon.add(phyButton);
		sciIcon.add(mathButton);
		sciIcon.add(comButton);
		sciIcon.add(artButton);
		pointsavailable.setEditable(false);
		pointsavailable.setText("可分配学科点：" + availablepoints);
		pointsavailable.setFont(new Font("微软雅黑", Font.BOLD, 20));
		pointsavailable.setForeground(new Color(0, 0, 0));
		pointsavailable.setOpaque(false);
		pointsavailable.setBounds(300, 55, 240, 45);
		pointsavailable.setBorder(null);
		add(confirmButton);
		add(comButton);
		add(artButton);
		add(mathButton);
		add(phyButton);
		add(cheButton);
		add(bioButton);
		for (ImageButton b : sciIcon) {
			iconData[sciIcon.indexOf(b)].setBounds(b.getLocation().x + 30,
					b.getLocation().y + 110, 40, 20);
			iconData[sciIcon.indexOf(b)].setEditable(false);
			iconData[sciIcon.indexOf(b)].setOpaque(false);
			iconData[sciIcon.indexOf(b)].setText(scipoints[i1] + "");
			iconData[sciIcon.indexOf(b)].setBorder(null);
			iconData[sciIcon.indexOf(b)]
					.setFont(new Font("微软雅黑", Font.BOLD, 20));
			iconData[sciIcon.indexOf(b)]
					.setHorizontalAlignment(JTextField.CENTER);
			i1++;
			add(iconData[sciIcon.indexOf(b)]);
		}
		add(pointsavailable);
	}

	void refresh() {
		if (Begin.HP < 5) {
			mathButton.setavalible(false);
		}
		else {
			mathButton.setavalible(true);
		}
		if (Begin.HP < 4) {
			phyButton.setavalible(false);
			cheButton.setavalible(false);
		}
		else {
			phyButton.setavalible(true);
			cheButton.setavalible(true);
		}
		
		if (Begin.HP < 3) {
			bioButton.setavalible(false);
			artButton.setavalible(false);
		}
		else {
			bioButton.setavalible(true);
			artButton.setavalible(true);
		}
		if (Begin.HP < 2) {
			comButton.setavalible(false);
		}
		else {
			comButton.setavalible(true);
		}

	}

	void setpoints(int[] i) {
		scipoints = i;// 顺序：化学 生物 物理 数学 计算机 艺术
	}

}
