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

import sun.management.snmp.util.MibLogger;
import el.Begin;
import el.Tools;

public class ObjectPanel extends JLabel {
	static String[] textTitle = { "����ܼ����", " ��ý���豸", "�ؾ�", "�߾��ȹ���", "����",
		"���ܻ�е", "������", "������ҩ", "����ɴ�", "�������","��������" };
	static String[] textContains = { "�ߵ���ѧ��һ���֣���ѧ��ϵ�ĸ���\nѧ�������� 3",
		"�о��ռ������ϵ����ѧ��֧\nѧ�������� 1 �� 2 �� 1",
		"�ڷ��ӡ�ԭ�Ӳ�����о����ʵ���ɡ����ʡ��ṹ��仯����\nѧ�����󣺻� 3 �� 2 �� 3 �� 2",
		"������̬��ϵ���о�������������Կ�׵Ŀ�ʼ\nѧ�����󣺻� 2 �� 5 �� 1",
		"��Ϣ�����ķ�Ծ���������޿���\nѧ�������� 1 �� 3 �� 3 �� 1\n����������ܼ���� ��ý���豸",
		"���̼���Ͷ��Ӧ�ã��ø�������Ѫ��\nѧ�����󣺻� 2 �� 4 �� 3 �� 3 �� 2\n�������ؾ� �߾��ȹ���",
		"�л������Ｐ�л����ʵĽṹ�����ʡ���Ӧ�ķ���\nѧ�����󣺻� 6 �� 4 �� 1 �� 3 �� 3 �� 1\n����������",
		"�Ӿ������Ե����Ե�ͻ�ƣ����������˸ı�\nѧ�������� 2 �� 6 �� 6 �� 6 �� 2\n���������ܻ�е",
		"����������ľ޴�����\nѧ�����󣺻� 4  �� 2 �� 7 �� 6 �� 6 �� 2\n������������",
		"���������Ȼ����������һ����\nѧ�����󣺻� 5 �� 7 �� 2 �� 4 �� 4 �� 2\n������������ҩ","" };
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


	public ObjectPanel(ImageIcon i,MessageLabel m) {
		super(i);
		m1 = m;
		ImageIcon start1 = new ImageIcon("image/buttonred1.png");
		ImageIcon start2 = new ImageIcon("image/buttonred2.png");
		ImageIcon start3 = new ImageIcon("image/buttonred3.png");
		for(int j = 0;j<11;j++) {
			icon1[j] = new ImageIcon("image/ob1"+(j+1)+".png");
		}
		for(int j = 0;j<11;j++) {
			icon2[j] = new ImageIcon("image/ob2"+(j+1)+".png");
		}
		for(int j = 0;j<11;j++) {
			icon3[j] = new ImageIcon("image/ob3"+(j+1)+".png");
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
		confirmButton.setForeground(new Color(134,69,0));
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
			button[j] = new ObjectImageButton(icon1[j], icon2[j], icon3[j], false);
		}
		// ������ť�ļ���

		button[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m1.setVisible(false);
				if (button[0].location == -1) {

				} else if (button[0].location == 0) {
					deleteToSet(button[0]);
					addSetting(button[0]);
					repaint();
				} else if (button[0].location == 1) {
					deleteSetting(button[0]);
					addToSet(button[0]);
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
					deleteToSet(button[1]);
					addSetting(button[1]);
					repaint();
				} else if (button[1].location == 1) {
					deleteSetting(button[1]);
					addToSet(button[1]);
					repaint();
				}
			}
		});
		button[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m1.setVisible(false);
				if (button[2].location == -1) {

				} else if (button[2].location == 0) {
					deleteToSet(button[2]);
					addSetting(button[2]);
					repaint();
				} else if (button[2].location == 1) {
					deleteSetting(button[2]);
					addToSet(button[2]);
					repaint();
				}
			}
		});
		button[3].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m1.setVisible(false);
				if (button[3].location == -1) {

				} else if (button[3].location == 0) {
					deleteToSet(button[3]);
					addSetting(button[3]);
					repaint();
				} else if (button[3].location == 1) {
					deleteSetting(button[3]);
					addToSet(button[3]);
					repaint();
				}
			}
		});
		button[4].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m1.setVisible(false);
				if (button[4].location == -1) {

				} else if (button[4].location == 0) {
					deleteToSet(button[4]);
					addSetting(button[4]);
					repaint();
				} else if (button[4].location == 1) {
					deleteSetting(button[4]);
					addToSet(button[4]);
					repaint();
				}
			}
		});
		button[5].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m1.setVisible(false);
				if (button[5].location == -1) {

				} else if (button[5].location == 0) {
					deleteToSet(button[5]);
					addSetting(button[5]);
					repaint();
				} else if (button[5].location == 1) {
					deleteSetting(button[5]);
					addToSet(button[5]);
					repaint();
				}
			}
		});
		button[6].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m1.setVisible(false);
				if (button[6].location == -1) {

				} else if (button[6].location == 0) {
					deleteToSet(button[6]);
					addSetting(button[6]);
					repaint();
				} else if (button[6].location == 1) {
					deleteSetting(button[6]);
					addToSet(button[6]);
					repaint();
				}
			}
		});
		button[7].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m1.setVisible(false);
				if (button[7].location == -1) {

				} else if (button[7].location == 0) {
					deleteToSet(button[7]);
					addSetting(button[7]);
					repaint();
				} else if (button[7].location == 1) {
					deleteSetting(button[7]);
					addToSet(button[7]);
					repaint();
				}
			}
		});
		button[8].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m1.setVisible(false);
				if (button[8].location == -1) {

				} else if (button[8].location == 0) {
					deleteToSet(button[8]);
					addSetting(button[8]);
					repaint();
				} else if (button[8].location == 1) {
					deleteSetting(button[8]);
					addToSet(button[8]);
					repaint();
				}
			}
		});
		button[9].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m1.setVisible(false);
				if (button[9].location == -1) {

				} else if (button[9].location == 0) {
					deleteToSet(button[9]);
					addSetting(button[9]);
					repaint();
				} else if (button[9].location == 1) {
					deleteSetting(button[9]);
					addToSet(button[9]);
					repaint();
				}
			}
		});
		button[10].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				m1.setVisible(false);
				if (button[10].location == -1) {

				} else if (button[10].location == 0) {
					deleteToSet(button[10]);
					addSetting(button[10]);
					repaint();
				} else if (button[10].location == 1) {
					deleteSetting(button[10]);
					addToSet(button[10]);
					repaint();
				}
			}
		});
		money = new JTextField();
		money.setBounds(172, 256, 290, 40);
		money.setEditable(false);
		money.setFocusable(false);
		money.setOpaque(false);
		money.setHorizontalAlignment(JTextField.CENTER);
		money.setFont(new Font("΢���ź�", Font.BOLD, 20));
		money.setForeground(new Color(134,69,0));
		money.setBorder(null);
		money.setText("�����ʽ�"+Begin.EV);
		add(money);

	}

	// ��ӿɽ����İ�ť

	public void addToSet(ObjectImageButton object) {
		if (object.location == -1 || object.location == 1) {
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
		if (object.location == 0) {
			settingGrid.add(object);
			object.location = 1;
			validate();
		}
	}

	public void deleteSetting(ObjectImageButton object) {
		if (object.location == 1) {
			settingGrid.remove(object);
			validate();
		}
	}

	public void addDoneSet(ObjectImageButton object) {
		if (object.location == 1) {
			doneSetGrid.add(object);
			object.location = 2;
			validate();
		}

	}

	public void refresh() {
		if (TecPanel.tecStats[4] == 1 && button[0].location == -1
				&& button[1].location == -1) {
			this.addToSet(button[0]);
			Begin.EV -= Tools.Time[0];
			button[0].newTime = GameWindow.time;
			this.addToSet(button[1]);
			Begin.EV -= Tools.Time[1];
			button[1].newTime = GameWindow.time;
			repaint();
		}
		if (TecPanel.tecStats[5] == 1 && button[2].location == -1
				&& button[3].location == -1) {
			this.addToSet(button[2]);
			Begin.EV -= Tools.Time[2];
			button[2].newTime = GameWindow.time;
			this.addToSet(button[3]);
			Begin.EV -= Tools.Time[3];
			button[3].newTime = GameWindow.time;
			repaint();
		}
		if (TecPanel.tecStats[6] == 1 && button[4].location == -1) {
			this.addToSet(button[4]);
			Begin.EV -= Tools.Time[4];
			button[4].newTime = GameWindow.time;
			repaint();
		}
		if (TecPanel.tecStats[7] == 1 && button[5].location == -1) {
			this.addToSet(button[5]);
			Begin.EV -= Tools.Time[5];
			button[5].newTime = GameWindow.time;
			repaint();
		}
		if (TecPanel.tecStats[8] == 1 && button[6].location == -1) {
			this.addToSet(button[6]);
			Begin.EV -= Tools.Time[6];
			button[6].newTime = GameWindow.time;
			repaint();
		}
		if (TecPanel.tecStats[9] == 1 && button[7].location == -1) {
			this.addToSet(button[7]);
			Begin.EV -= Tools.Time[7];
			button[7].newTime = GameWindow.time;
			repaint();
		}
		if (TecPanel.tecStats[7] == 1 && TecPanel.tecStats[8] == 1
				&& button[8].location == -1) {
			this.addToSet(button[8]);
			Begin.EV -= Tools.Time[8];
			button[8].newTime = GameWindow.time;
			repaint();
		}
		if (TecPanel.tecStats[7] == 1 && TecPanel.tecStats[9] == 1
				&& button[9].location == -1) {
			this.addToSet(button[9]);
			Begin.EV -= Tools.Time[9];
			button[9].newTime = GameWindow.time;
			repaint();
		}
		if (TecPanel.tecStats[8] == 1 && TecPanel.tecStats[9] == 1
				&& button[10].location == -1) {
			this.addToSet(button[10]);
			Begin.EV -= Tools.Time[10];
			button[10].newTime = GameWindow.time;
			repaint();
		}
		for (int i = 0; i < 11; i++) {
			if ((GameWindow.time - button[i].newTime >= Tools.Time[i])
					&& button[i].newTime > 0) {
				button[i].newTime = 0;
				this.deleteSetting(button[i]);
				this.addDoneSet(button[i]);
				repaint();
			}
		}
	}

}
