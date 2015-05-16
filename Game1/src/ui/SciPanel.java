package ui;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

import el.Art;
import el.Begin;
import el.Biology;
import el.Chemistry;
import el.Computer;
import el.Math;
import el.Physics;

@SuppressWarnings("serial")
public class SciPanel extends JLabel {
	public int availablepoints;
	public static int[] scipoints = {Chemistry.point,Biology.point,Physics.point,Math.point,Computer.point,Art.point};
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
		confirmButton.setText("确认");
		confirmButton.setHorizontalTextPosition(JButton.CENTER);
		confirmButton.setVerticalTextPosition(JButton.CENTER);
		confirmButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
		confirmButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				setVisible(false);
			}
		});
		add(confirmButton);
		mathButton.setLocation(260, 115);
		mathButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(Math.botton == true&&Begin.HP>=14){
					Math.point++;
					Begin.HP=Begin.HP-14;
					iconData[3].repaint();
				}
			}
		});
		phyButton.setLocation(425, 115);
		phyButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(Physics.botton == true&&Begin.HP>=11){
					Physics.point++;
					Begin.HP=Begin.HP-11;
				}

			}
		});
		cheButton.setLocation(260, 400);
		cheButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(Chemistry.botton == true&&Begin.HP>=11){
					Chemistry.point++;
					Begin.HP=Begin.HP-11;
				}

			}
		});
		comButton.setLocation(425, 400);
		comButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(Computer.botton == true&&Begin.HP>=11){
					Computer.point++;
					Begin.HP=Begin.HP-10;
				}

			}
		});
		artButton.setLocation(160, 260);
		artButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(Art.botton == true&&Begin.HP>=11){
					Art.point++;
					Begin.HP=Begin.HP-12;
				}

			}
		});
		bioButton.setLocation(530, 260);
		bioButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				if(Biology.botton == true&&Begin.HP>=11){
					Biology.point++;
					Begin.HP=Begin.HP-11;
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

	void setpoints(int[] i) {
		scipoints = i;// 顺序：化学 生物 物理 数学 计算机 艺术
	}

	void setpointsavailable(int i) {
		availablepoints = i;
	}

}
