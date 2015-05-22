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

public class ObjectPanel extends JLabel {
	static String[] textTitle = { "����ܼ����", " ��ý���豸", "�ؾ�", "�߾��ȹ���", "����",
			"���ܻ�е", "������", "������ҩ", "����ɴ�", "�������", "��������" };
	static String[] textContains = { "����ܼ��������Ϣʱ���Ŀ��ˣ��ܼ������߼�������\n3",
			"��ý���豸�����֡�Ӱ����ʵ�ִ�ķ�Ծ���ܹ���ߴ�����",
			"�ؾߣ��ܹ�ʹ���䷽ʽʵ�ָ����Ա仯���������Ч��",
			"�߾��ȹ��ߣ��ܹ���������������Ʒ�ľ��ȣ��������쾫������",
			"���ϣ����Ͳ��ϣ��ܹ������ᡢ���õ���Ʒ",
			" ���ܻ�е�����ܻ�е���ܹ��ڸ��໷����ִ�и�����������Ļ�����������˼��������������๤ҵ���������Եı仯",
			"�����������ȵĸ��£������ķ��佫���κ������ج�Σ����л���һ�������������Ȼ����̫��ս��������������һ��δ֪��",
			" ������ҩ����ҽѧ�����޴�ķ�Ծ��������µ�΢����ѧ�о��ɹ���������������õ���ǰ���ӳ�",
			"����ɴ���������֮�ŵ�Կ�ף����೩��̫�յĵ�һ�������м�ǿ���������������������İ������������ҵ�����ľ�ͷ",
			"�������ںϸ���������������ԣ���������������º����������̫�յ�Կ��",
			"������������ֿƼ����������У���Խ��֪�κ�����ļ��ޣ�����Ļ����ܽ�һ�л�Ϊ�ҽ�",
			"���̼���Ͷ��Ӧ�ã��ø�������Ѫ��\nѧ�����󣺻� 2 �� 4 �� 3 �� 3 �� 2\n�������ؾ� �߾��ȹ���",
			"�л������Ｐ�л����ʵĽṹ�����ʡ���Ӧ�ķ���\nѧ�����󣺻� 6 �� 4 �� 1 �� 3 �� 3 �� 1\n����������",
			"�Ӿ������Ե����Ե�ͻ�ƣ����������˸ı�\nѧ�������� 2 �� 6 �� 6 �� 6 �� 2\n���������ܻ�е",
			"����������ľ޴�����\nѧ�����󣺻� 4  �� 2 �� 7 �� 6 �� 6 �� 2\n������������",
			"���������Ȼ����������һ����\nѧ�����󣺻� 5 �� 7 �� 2 �� 4 �� 4 �� 2\n������������ҩ",  };
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
		confirmButton.setText("ȷ��");
		confirmButton.setHorizontalTextPosition(JButton.CENTER);
		confirmButton.setVerticalTextPosition(JButton.CENTER);
		confirmButton.setFont(new Font("΢���ź�", Font.BOLD, 20));
		confirmButton.setForeground(new Color(134, 69, 0));
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

		// �ɽ�����Ʒ��

		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		toSetGrid = new JPanel(flowLayout);

		toSetGrid.setBounds(65, 60, 500, 200);
		toSetGrid.setVisible(true);
		toSetGrid.setOpaque(false);
		add(toSetGrid);

		// �ѽ�����Ʒ��
		doneSetGrid = new JPanel(flowLayout);
		doneSetGrid.setBounds(65, 330, 500, 180);
		doneSetGrid.setVisible(true);
		doneSetGrid.setOpaque(false);
		add(doneSetGrid);

		// ���������Ʒ��

		settingGrid = new JPanel(flowLayout);
		settingGrid.setBounds(630, 60, 80, 490);
		settingGrid.setVisible(true);
		settingGrid.setOpaque(false);
		add(settingGrid);

		// �������а�ť

		for (int j = 0; j < 11; j++) {
			button[j] = new ObjectImageButton(icon1[j], icon2[j], icon3[j],
					false);
		}
		// ������ť�ļ���

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
		money.setFont(new Font("΢���ź�", Font.BOLD, 20));
		money.setForeground(new Color(134, 69, 0));
		money.setBorder(null);

		add(money);
	}

	// ��ӿɽ����İ�ť

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
			this.moneyRefresh();
		}
	}

	public static void moneyRefresh() {
		money.setText("�����ʽ�" + Begin.EV);
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
		judge();
	}
	public static void judge(){
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
			button[10].setavalible(true);
			button[8].setavalible(true);
			button[9].setavalible(true);
		}
	}

}
