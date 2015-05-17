package ui;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.security.auth.Refreshable;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

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
	ImageButton[] tecButton = new ImageButton[10];// 微积分 几何 微观物质结构 生态学 计算机科学
													// 机械与力学 有机化学 人工智能 核理论 生物工程
	static ImageIcon[] buttonIcons1 = new ImageIcon[10];
	static ImageIcon[] buttonIcons2 = new ImageIcon[10];
	static ImageIcon[] buttonIcons3 = new ImageIcon[10];
	static ImageIcon[] lineImageIcons = new ImageIcon[6];
	static JLabel[] lineLabels = new JLabel[6];
	ImageButton confirmButton = new ImageButton(start1, start2, start3, false);

	public TecPanel(ImageIcon i) {
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
				setVisible(false);
				Refresh();
			}
		});
		add(confirmButton);

		pointsfield = new JTextField();
		pointsfield.setOpaque(false);
		pointsfield.setFont(new Font("微软雅黑", Font.BOLD, 20));
		pointsfield.setBounds(100, 20, 500, 40);
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
			buttonIcons1[i1] = new ImageIcon("image/anothericon1.png");
		}
		for (int i1 = 0; i1 <= 9; i1++) {
			buttonIcons2[i1] = new ImageIcon("image/anothericon2.png");
		}
		for (int i1 = 0; i1 <= 9; i1++) {
			buttonIcons3[i1] = new ImageIcon("image/anothericon3.png");
		} // 测试用

		for (int i1 = 0; i1 <= 9; i1++) {
			tecButton[i1] = new ImageButton(buttonIcons1[i1], buttonIcons2[i1],
					buttonIcons3[i1], false);
		}

		tecButton[0].setLocation(42, 35);
		tecButton[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				lineLabels[0].setVisible(true);
				tecButton[4].setVisible(true);
				Refresh();
			}
		});
		tecButton[1].setLocation(42, 140);
		tecButton[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				lineLabels[1].setVisible(true);
				tecButton[5].setVisible(true);
				Refresh();
			}
		});
		tecButton[2].setLocation(42, 245);
		tecButton[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				lineLabels[2].setVisible(true);
				tecButton[8].setVisible(true);
				Refresh();
			}
		});
		tecButton[3].setLocation(42, 350);
		tecButton[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				lineLabels[3].setVisible(true);
				tecButton[6].setVisible(true);
				Refresh();
			}
		});
		tecButton[4].setLocation(305, 35);
		tecButton[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				lineLabels[4].setVisible(true);
				tecButton[7].setVisible(true);
				Refresh();
			}
		});
		tecButton[5].setLocation(305, 140);
		tecButton[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				lineLabels[4].setVisible(true);
				tecButton[7].setVisible(true);
				lineLabels[2].setVisible(true);
				tecButton[8].setVisible(true);
				Refresh();
			}
		});
		tecButton[6].setLocation(305, 350);
		tecButton[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				lineLabels[5].setVisible(true);
				tecButton[9].setVisible(true);
				Refresh();
			}
		});
		tecButton[7].setLocation(540, 35);
		tecButton[7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根

			}
		});
		tecButton[8].setLocation(540, 245);
		tecButton[8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根

			}
		});
		tecButton[9].setLocation(540, 350);
		tecButton[9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根

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
		int[][] pointsneed = { { 2, 1, 0, 0, 2, 0 }, { 4, 0, 0, 0, 0, 0 },
				{ 4, 1, 0, 0, 2, 0 }, { 3, 4, 0, 0, 2, 0 },
				{ 3, 1, 2, 0, 3, 0 }, { 1, 0, 1, 4, 0, 1 },
				{ 4, 1, 5, 5, 1, 1 }, { 4, 1, 5, 7, 3, 1 },
				{ 7, 6, 0, 0, 5, 2 }, { 8, 8, 4, 0, 3, 2 } };
		for (int i = 0; i <= 9; i++) {
			boolean isproable = true;
			for (int j = 0; j <= 5; j++) {
				if (points[j] < pointsneed[i][j] || tecButton[i].ispressed) {
					isproable = false;
				}
			}
			if (isproable && !tecButton[i].ispressed) {

				tecButton[i].setavalible(true);
			}
		}
	}
}
