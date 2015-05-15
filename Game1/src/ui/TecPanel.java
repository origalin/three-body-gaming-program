package ui;

import java.awt.CardLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class TecPanel extends JLabel {
	ImageIcon start1 = new ImageIcon("image/button1.png");
	ImageIcon start2 = new ImageIcon("image/button2.png");
	ImageIcon start3 = new ImageIcon("image/button3.png");
	ImageIcon icon1 = new ImageIcon("image/iconblue1.png");
	ImageIcon icon2 = new ImageIcon("image/iconblue2.png");
	ImageIcon icon3 = new ImageIcon("image/iconblue3.png");
	ImageButton confirmButton = new ImageButton(start1, start2, start3, false);
	public TecPanel(ImageIcon i) {
		super(i);
		setBounds(240, 28, i.getIconWidth(), i.getIconHeight());
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
		
		
		
		JTextField pointsfield = new JTextField();
		pointsfield.setOpaque(false);
		pointsfield.setFont(new Font("΢���ź�", Font.BOLD, 20));
		pointsfield.setBounds(100, 20, 500, 40);
		pointsfield.setBorder(null);
		pointsfield.setText("��ѧ:"+SciPanel.scipoints[0]+ " ����:"+SciPanel.scipoints[1]+ " ����:" +SciPanel.scipoints[2]+ " ��ѧ:"+SciPanel.scipoints[3] +" �����:"+SciPanel.scipoints[4]+ " ����:"+SciPanel.scipoints[5]);
		pointsfield.setEditable(false);
		add(pointsfield);
		
		//�Ƽ�������
		JPanel treePanel = new JPanel();
		treePanel.setBounds(55, 70, 690, 450);
		treePanel.setLayout(new CardLayout());
		treePanel.setOpaque(false);
		add(treePanel);
		JLabel treeLabel1 = new JLabel();
		treeLabel1.setBounds(0, 0, 690, 450);
		
	}
}
