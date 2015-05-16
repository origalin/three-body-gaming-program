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


@SuppressWarnings("serial")
public class SciPanel extends JLabel {
	public int availablepoints;
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
	ArrayList<ImageButton> sciIcon = new ArrayList<ImageButton>();
	JTextField[] iconData = { new JTextField(), new JTextField(),
			new JTextField(), new JTextField(), new JTextField(),
			new JTextField() };
	int i1 = 0;
	


	public SciPanel(ImageIcon i) {
		super(i);
		setBounds(232, 48, i.getIconWidth(), i.getIconHeight());
		setOpaque(false);
		confirmButton.setLocation(70, 530);
		confirmButton.setText("ȷ��");
		confirmButton.setHorizontalTextPosition(JButton.CENTER);
		confirmButton.setVerticalTextPosition(JButton.CENTER);
		confirmButton.setFont(new Font("΢���ź�", Font.BOLD, 20));
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				setVisible(false);
			}
		});
		add(confirmButton);
		mathButton.setLocation(260, 115);
		mathButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO �Զ����ɵķ������
				if(Begin.HP>=14){
					Sci.math.point++;
					availablepoints -= 14;
					Begin.HP -= 14;
					iconData[3].setText(Sci.math.point+"");
					pointsavailable.setText("�ɷ���ѧ�Ƶ㣺" + availablepoints);
				}
			}
		});
		phyButton.setLocation(425, 115);
		phyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if(Begin.HP>=11){
					Sci.physics.point++;
					availablepoints -= 11;
					Begin.HP -= 11;
					iconData[2].setText(Sci.physics.point+"");
					pointsavailable.setText("�ɷ���ѧ�Ƶ㣺" + availablepoints);
				}

			}
		});
		cheButton.setLocation(260, 400);
		cheButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if(Begin.HP>=11){
					Sci.chemistry.point++;
					availablepoints -= 11;
					Begin.HP -= 11;
					iconData[0].setText(Sci.chemistry.point+"");
					pointsavailable.setText("�ɷ���ѧ�Ƶ㣺" + availablepoints);
				}

			}
		});
		comButton.setLocation(425, 400);
		comButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if(Begin.HP>=11){
					Sci.computer.point++;
					availablepoints -= 10;
					Begin.HP -= 10;
					iconData[4].setText(Sci.computer.point+"");
					pointsavailable.setText("�ɷ���ѧ�Ƶ㣺" + availablepoints);
				}

			}
		});
		artButton.setLocation(160, 260);
		artButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if(Begin.HP>=11){
					Sci.art.point++;
					availablepoints -= 12;
					Begin.HP -= 12;
					iconData[5].setText(Sci.art.point+"");
					pointsavailable.setText("�ɷ���ѧ�Ƶ㣺" + availablepoints);
				}

			}
		});
		bioButton.setLocation(530, 260);
		bioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				if(Begin.HP>=11){
					Sci.biology.point++;
					availablepoints -= 11;
					Begin.HP -= 11;
					iconData[1].setText(Sci.biology.point+"");
					pointsavailable.setText("�ɷ���ѧ�Ƶ㣺" + availablepoints);
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
					.setFont(new Font("΢���ź�", Font.BOLD, 20));
			iconData[sciIcon.indexOf(b)]
					.setHorizontalAlignment(JTextField.CENTER);
			i1++;
			add(iconData[sciIcon.indexOf(b)]);
		}
		add(pointsavailable);
	}

	void setpoints(int[] i) {
		scipoints = i;// ˳�򣺻�ѧ ���� ���� ��ѧ ����� ����
	}

	void setpointsavailable(int i) {
		availablepoints = i;
	}

}
