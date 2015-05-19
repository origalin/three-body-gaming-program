package ui;

import java.awt.Button;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.text.StyledEditorKit.ForegroundAction;

public class ObjectPanel extends JLabel {
	JPanel toSetCard;
	JPanel toSetGrid;

	JPanel settingCard;
	JPanel settingGrid;

	JPanel doneSetCard;
	JPanel doneSetGrid;
	ImageIcon settingBackground;
	ImageIcon doneSetBackground;
	ImageIcon toSetBackground;

	private JLabel toSetLabel;
	private JLabel settingLabel;
	private JLabel doneSetLabel;
	private ImageIcon icon1;
	private ImageIcon icon2;
	private ImageIcon icon3;
	private ArrayList toSetList;
	private ArrayList settingList;
	private ArrayList doneSetList;
	Timer t;

	public ObjectPanel(ImageIcon i) {
		super(i);
		toSetBackground = new ImageIcon("image/anothericon1.png");
		settingBackground = new ImageIcon("image/anothericon2.png");
		doneSetBackground = new ImageIcon("image/anotherdone3.png");
		ImageIcon start1 = new ImageIcon("image/button1.png");
		ImageIcon start2 = new ImageIcon("image/button2.png");
		ImageIcon start3 = new ImageIcon("image/button3.png");
		icon1 = new ImageIcon("image/roundbutton.png");
		icon2 = new ImageIcon("image/roundbutton2.png");
		icon3 = new ImageIcon("image/roundbutton3.png");
		icon1.setImage(icon1.getImage().getScaledInstance(50, 50,
				Image.SCALE_DEFAULT));
		icon2.setImage(icon2.getImage().getScaledInstance(50, 50,
				Image.SCALE_DEFAULT));
		icon3.setImage(icon3.getImage().getScaledInstance(50, 50,
				Image.SCALE_DEFAULT));
		ObjectImageButton confirmButton = new ObjectImageButton(start1, start2,
				start3, false);

		setBounds(240, 28, i.getIconWidth(), i.getIconHeight());
		setOpaque(false);

		confirmButton.setLocation(70, 540);
		confirmButton.setText("确认");
		confirmButton.setHorizontalTextPosition(JButton.CENTER);
		confirmButton.setVerticalTextPosition(JButton.CENTER);
		confirmButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
		confirmButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				GameWindow.blockLabel.setVisible(false);
				t = new Timer(10,new ActionListener() {
					int i = 0;					
					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						i+=1;
						
						if (i<=10) {
							setLocation(getLocation().x, 48+((720-48)/10*i));
						}
						else {
							t.stop();
						}
					}
				});
				t.start();
			}
		});
		add(confirmButton);

		// 可建造物品框
		toSetBackground.setImage(toSetBackground.getImage().getScaledInstance(
				570, 260, Image.SCALE_DEFAULT));
		toSetLabel = new JLabel(toSetBackground);
		toSetLabel.setBounds(0, 0, toSetBackground.getIconWidth(),
				toSetBackground.getIconHeight());
		toSetCard = new JPanel(new CardLayout());
		FlowLayout flowLayout = new FlowLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		toSetGrid = new JPanel(flowLayout);
		JPanel toSetNull = new JPanel();
		toSetCard.setBounds(65, 40, 570, 260);
		toSetGrid.setBounds(0, 0, 570, 260);
		toSetGrid.setBackground(new Color(85, 125, 205));
		toSetNull.setBounds(0, 0, 570, 260);

		toSetGrid.setVisible(true);
		toSetCard.setOpaque(true);
		toSetGrid.setOpaque(true);

		toSetNull.setOpaque(false);
		toSetNull.add(toSetLabel);
		toSetNull.add(toSetGrid);
		toSetLabel.add(toSetGrid);
		toSetCard.add(toSetNull);
		add(toSetCard);

		// 已建造物品框
		doneSetBackground.setImage(doneSetBackground.getImage()
				.getScaledInstance(570, 200, Image.SCALE_DEFAULT));
		doneSetLabel = new JLabel(doneSetBackground);
		doneSetLabel.setBounds(0, 0, doneSetBackground.getIconWidth(),
				doneSetBackground.getIconHeight());
		doneSetCard = new JPanel(new CardLayout());
		doneSetGrid = new JPanel(flowLayout);
		JPanel doneSetNull = new JPanel();
		doneSetCard.setBounds(65, 330, 570, 200);
		doneSetGrid.setBounds(0, 0, 570, 200);

		doneSetNull.setBounds(0, 0, 570, 200);
		doneSetCard.setVisible(true);
		doneSetGrid.setVisible(true);
		doneSetCard.setOpaque(true);
		doneSetGrid.setOpaque(true);
		doneSetNull.setOpaque(false);
		doneSetNull.add(doneSetLabel);
		doneSetLabel.add(doneSetGrid);
		doneSetCard.add(doneSetNull);
		add(doneSetCard);

		// 建造队列物品框
		settingBackground.setImage(settingBackground.getImage()
				.getScaledInstance(60, 520, Image.SCALE_DEFAULT));
		settingLabel = new JLabel(settingBackground);
		settingLabel.setBounds(0, 0, settingBackground.getIconWidth(),
				settingBackground.getIconHeight());
		settingCard = new JPanel(new CardLayout());
		settingGrid = new JPanel(flowLayout);
		JPanel settingNull = new JPanel();
		settingCard.setBounds(690, 40, 60, 520);
		settingGrid.setBounds(0, 0, 60, 520);
		settingGrid.setBackground(new Color(85, 125, 205));
		settingNull.setBounds(0, 0, 60, 520);
		settingCard.setVisible(true);
		settingGrid.setVisible(true);
		settingCard.setOpaque(true);
		settingGrid.setOpaque(false);
		settingNull.setOpaque(false);
		settingNull.add(settingLabel);
		settingLabel.add(settingGrid);
		settingCard.add(settingNull);
		add(settingCard);

		// 创建所有按钮
		final ObjectImageButton[] button = new ObjectImageButton[10];
		for (int j = 0; j < 10; j++) {
			button[j] = new ObjectImageButton(icon1, icon2, icon3, false);

		}
		for(int j=0;j<10;j++){
			if(TecPanel.tecStats[j]==1){
				this.addToSet(button[j]);
			}
		}
		// 创建按钮的监听
		button[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
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
		
	}
//	添加可解锁的按钮
	

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

}
