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
	ImageIcon math1 = new ImageIcon("image/math.png");
	ImageIcon math2 = new ImageIcon("image/math2.png");
	ImageIcon matn3 = new ImageIcon("image/math3.png");
	ImageIcon phy1 = new ImageIcon("image/phy.png");
	ImageIcon phy2 = new ImageIcon("image/phy2.png");
	ImageIcon phy3 = new ImageIcon("image/phy3.png");
	ImageIcon che1 = new ImageIcon("image/che.png");
	ImageIcon che2 = new ImageIcon("image/che2.png");
	ImageIcon che3 = new ImageIcon("image/che3.png");
	ImageIcon com1 = new ImageIcon("image/com.png");
	ImageIcon com2 = new ImageIcon("image/comp2.png");
	ImageIcon com3 = new ImageIcon("image/comp3.png");
	ImageIcon art1 = new ImageIcon("image/art.png");
	ImageIcon art2 = new ImageIcon("image/art2.png");
	ImageIcon art3 = new ImageIcon("image/art3.png");
	ImageIcon bio1 = new ImageIcon("image/bio.png");
	ImageIcon bio2 = new ImageIcon("image/bio2.png");
	ImageIcon bio3 = new ImageIcon("image/bio3.png");
	ImageButton confirmButton = new ImageButton(start1, start2, start3, false);
	ImageButton mathButton = new ImageButton(math1, math2, matn3, false);
	ImageButton phyButton = new ImageButton(phy1, phy2, phy3, false);
	ImageButton cheButton = new ImageButton(che1, che2, che3, false);
	ImageButton comButton = new ImageButton(com1, com2, com3, false);
	ImageButton artButton = new ImageButton(art1, art2, art3, false);
	ImageButton bioButton = new ImageButton(bio1, bio2, bio3, false);
	JTextField pointsavailable = new JTextField();
	static ArrayList<ImageButton> sciIcon = new ArrayList<ImageButton>();
	static JTextField[] iconData = { new JTextField(), new JTextField(),
			new JTextField(), new JTextField(), new JTextField(),
			new JTextField() };
	int i1 = 0;
	Timer t;
	public static String[] iconTitle = { "��ѧ", "����", "����", "��ѧ", "�����", "����" };
	public static String[] iconContains = { "��Ҫ4�Ƽ���\n��ҵ�����ĺ���,������Ի������һ���ƻ�Ŷ",
			"��Ҫ2�Ƽ���\nFrankenstein���Ի�����һ��Ӱ��", "��Ҫ4�Ƽ���\n�Ƽ������������������������ƽ���ص�Կ��",
			"��Ҫ5�Ƽ���\n��չ��������ѧ�ƵĻ���", "��Ҫ3�Ƽ���\n�Ƽ������벻���ļ�˼���",
			"��Ҫ3�Ƽ���\n��ұ��٣����������Ҹ���" };
	
	public SciPanel(ImageIcon i) {
		super(i);
		setBounds(232, 48, i.getIconWidth(), i.getIconHeight());
		setOpaque(false);
		confirmButton.setLocation(70, 530);
		confirmButton.setText("ȷ��");
		confirmButton.setHorizontalTextPosition(JButton.CENTER);
		confirmButton.setVerticalTextPosition(JButton.CENTER);
		confirmButton.setFont(new Font("΢���ź�", Font.BOLD, 20));
		confirmButton.setForeground(new Color(0,113,6));
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				GameWindow.blockLabel.setVisible(false);
				t = new Timer(10, new ActionListener() {
					int i = 0;

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO �Զ����ɵķ������
						i += 1;

						if (i <= 10) {
							setLocation(getLocation().x,
									48 + ((720 - 48) / 10 * i));

						}
						else {
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
		mathButton.setLocation(260, 115);
		mathButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if (Begin.HP >= 5) {
					Sci.math.point++;
					mathSum++;
					Begin.HP -= 5;
					iconData[3].setText(Sci.math.point + "");
					pointsavailable.setText("�ɷ���ѧ�Ƶ㣺" + Begin.HP);
					
					refresh();
				}
			}
		});
		phyButton.setLocation(425, 115);
		phyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if (Begin.HP >= 4) {
					Sci.physics.point++;
					physicsSum++;
					Begin.HP -= 4;
					iconData[2].setText(Sci.physics.point + "");
					pointsavailable.setText("�ɷ���ѧ�Ƶ㣺" + Begin.HP);
					refresh();
				}

			}
		});
		cheButton.setLocation(260, 400);
		cheButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if (Begin.HP >= 4) {
					Sci.chemistry.point++;
					chemistrySum++;
					Begin.HP -= 4;
					iconData[0].setText(Sci.chemistry.point + "");
					pointsavailable.setText("�ɷ���ѧ�Ƶ㣺" + Begin.HP);
					refresh();
				}

			}
		});
		comButton.setLocation(425, 400);
		comButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if (Begin.HP >= 2) {
					Sci.computer.point++;
					computerSum++;
					Begin.HP -= 2;
					iconData[4].setText(Sci.computer.point + "");
					pointsavailable.setText("�ɷ���ѧ�Ƶ㣺" + Begin.HP);
					refresh();
				}

			}
		});
		artButton.setLocation(160, 260);
		artButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if (Begin.HP >= 3) {
					Sci.art.point++;
					artSum++;
					Begin.HP -= 3;
					iconData[5].setText(Sci.art.point + "");
					pointsavailable.setText("�ɷ���ѧ�Ƶ㣺" + Begin.HP);
					refresh();
				}

			}
		});
		bioButton.setLocation(530, 260);
		bioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if (Begin.HP >= 3) {
					Sci.biology.point++;
					biologySum++;
					Begin.HP -= 3;
					iconData[1].setText(Sci.biology.point + "");
					pointsavailable.setText("�ɷ���ѧ�Ƶ㣺" + Begin.HP);
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
		pointsavailable.setText("�ɷ���ѧ�Ƶ㣺" + availablepoints);
		pointsavailable.setFont(new Font("΢���ź�", Font.BOLD, 20));
		pointsavailable.setFocusable(false);
		pointsavailable.setForeground(new Color(0,113,6));
		pointsavailable.setOpaque(false);
		pointsavailable.setBounds(300, 52, 240, 45);
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
			iconData[sciIcon.indexOf(b)].setText("0");
			iconData[sciIcon.indexOf(b)].setBorder(null);
			iconData[sciIcon.indexOf(b)]
					.setFont(new Font("΢���ź�", Font.BOLD, 20));
			iconData[sciIcon.indexOf(b)].setFocusable(false);
			iconData[sciIcon.indexOf(b)].setForeground(new Color(0,113,6));
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



}
