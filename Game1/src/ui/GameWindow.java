package ui;

import el.*;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.KeyEventPostProcessor;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;

import sun.audio.AudioPlayer;
import sun.audio.AudioStream;

import com.sun.java_cup.internal.runtime.Scanner;
import com.sun.org.apache.bcel.internal.generic.NEW;

@SuppressWarnings("serial")
public class GameWindow extends JFrame {

	JLayeredPane frontPanel;
	// JDialog sciDialog = new JDialog(this);
	private ImageIcon backgroundScn;
	ImageIcon backgroundTec;
	private JPanel imagePanel;
	// private JPanel panel=new JPanel();
	// private ImageIcon backgroundTest;
	private ImageIcon background;
	SciPanel sciPanel;
	TecPanel tecPanel;
	ObjectPanel objectPanel;
	private ImageIcon backgroundTitle;
	ImageIcon planet;
	JPanel lightPanel;
	JPanel planetPanel;
	JLabel labelTitle;
	JLabel bottomLabel;
	ImageButton pauseButton;
	JLabel timeLabel;
	JLabel accidentLabel;
	JLabel successLabel;
	JLabel blackLabel;
	JLabel starLabel1;
	JLabel starLabel2;
	JLabel starLabel3;
	JLabel starLabel4;
	static JLabel blockLabel;
	JLabel label2;
	PlaneLabel planetLabel2;
	JTextPane accidenPane;
	JTextPane successPane;
	static ImageButton[] bottombottons = new ImageButton[3];
	ImageButton roundButton;
	ImageButton accidentButton;
	ImageButton successButton;
	TopPanel topPanel;
	ImageIcon objectBackground;
	public static int x;
	public static int y;
	final MessageLabel messageLabel;
	int tec;
	static JLabel light1;
	static JLabel light2;
	static JLabel light3;
	public static int time = 1020;
	JTextField timeField;
	Timer objtimer;
	Timer sciTimer;
	Timer tecTimer;
	Timer blackTimer;
	Timer mouseTimer;
	Timer starTimer;
	Timer accidTimer;
	Timer blackTimer2;
	ImageButton[] imageButton = new ImageButton[3];
	int v = 1;
	Bomb bom;
	boolean fail = false;
	static int win = 0;
	SimpleAttributeSet bSet = new SimpleAttributeSet();
	SimpleAttributeSet Set = new SimpleAttributeSet();

	public GameWindow(GraphicsConfiguration gc) {
		super(gc);
		frontPanel = getLayeredPane();
		backgroundScn = new ImageIcon("image/scnpanel.png");
		backgroundTec = new ImageIcon("image/tecpanel.png");
		background = new ImageIcon("image/background.png");// 背景图片
		backgroundTitle = new ImageIcon("image/title.png");
		objectBackground = new ImageIcon("image/prdpanel.png");
		ImageIcon startst1 = new ImageIcon("image/buttonstart1.png");
		final ImageIcon start1 = new ImageIcon("image/button1.png");
		ImageIcon start2 = new ImageIcon("image/button2.png");
		ImageIcon start3 = new ImageIcon("image/button3.png");
		ImageIcon roundIcon1 = new ImageIcon("image/roundbutton.png");
		ImageIcon roundIcon2 = new ImageIcon("image/roundbutton2.png");
		ImageIcon roundIcon3 = new ImageIcon("image/roundbutton3.png");
		ImageIcon message = new ImageIcon("image/message.png");
		ImageIcon pause1 = new ImageIcon("image/messagel.png");
		ImageIcon pause2 = new ImageIcon("image/messagel2.png");
		ImageIcon pause3 = new ImageIcon("image/messagel3.png");
		ImageIcon accident1 = new ImageIcon("image/accidentbutton1.png");
		ImageIcon accident2 = new ImageIcon("image/accidentbutton2.png");
		ImageIcon accident3 = new ImageIcon("image/accidentbutton3.png");
		ImageIcon success1 = new ImageIcon("image/buttongreen1.png");
		ImageIcon success2 = new ImageIcon("image/buttongreen2.png");
		ImageIcon success3 = new ImageIcon("image/buttongreen3.png");
		// 背景图
		JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
		label.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());

		// 过渡图片
		blackLabel = new JLabel();
		blackLabel.setBounds(0, 0, 1280, 720);
		blackLabel.setBackground(new Color(0, 0, 0, 0));
		blackLabel.setOpaque(true);
		label2 = new JLabel();
		label2.add(blackLabel);
		label2.setBounds(0, 0, 1280, 720);
		label2.setVisible(false);
		frontPanel.add(label2, new Integer(-1));

		// 屏蔽图片
		blockLabel = new JLabel(new ImageIcon("image/block.png"));
		blockLabel.setBounds(0, 0, 1280, 720);
		blockLabel.setVisible(false);
		frontPanel.add(blockLabel, new Integer(-7));
		// 星空图片
		starLabel1 = new JLabel(new ImageIcon("image/back1.png"));
		starLabel1.setBounds(0, 0, 2560, 720);
		frontPanel.add(starLabel1, new Integer(-40));
		starLabel2 = new JLabel(new ImageIcon("image/back2.png"));
		starLabel2.setBounds(2560, 0, 2560, 720);
		frontPanel.add(starLabel2, new Integer(-41));
		starLabel3 = new JLabel(new ImageIcon("image/back3.png"));
		starLabel3.setBounds(0, 0, 1280, 720);
		frontPanel.add(starLabel3, new Integer(-42));
		starLabel4 = new JLabel(new ImageIcon("image/back4.png"));
		starLabel4.setBounds(1280, 0, 1280, 720);
		frontPanel.add(starLabel4, new Integer(-43));
		staranim();

		// 光晕图片
		planetLabel2 = new PlaneLabel(new ImageIcon("image/planet2.png"));
		planetLabel2.setBounds(305, 50, planetLabel2.getIcon().getIconWidth(),
				planetLabel2.getIcon().getIconHeight());

		planetPanel = new JPanel();
		planetPanel.setBounds(305, 40, 665, 605);
		planetPanel.setOpaque(false);
		planetPanel.add(planetLabel2);
		frontPanel.add(planetPanel, new Integer(-29));

		// 标题文字
		labelTitle = new JLabel(backgroundTitle);
		labelTitle.setLocation(430, 60);
		labelTitle.setSize(backgroundTitle.getIconWidth(),
				backgroundTitle.getIconHeight());
		imagePanel = (JPanel) this.getContentPane();
		imagePanel.setOpaque(false);
		imagePanel.setSize(background.getIconWidth(),
				background.getIconHeight());
		imagePanel.setLocation(200, 0);
		frontPanel.add(labelTitle, new Integer(-17));

		// 创建开始界面按钮
		for (int i = 0; i <= 2; i++) {
			imageButton[i] = new ImageButton(startst1, start2, start3, false);
			imageButton[i].setLocation(530, 290 + (i) * 120);
			imageButton[i].setVisible(true);
			imageButton[i].setHorizontalTextPosition(JButton.CENTER);
			imageButton[i].setVerticalTextPosition(JButton.CENTER);
			imageButton[i].setFont(new Font("微软雅黑", Font.BOLD, 20));
			imageButton[i].setForeground(new Color(0, 89, 130));
			frontPanel.add(imageButton[i], new Integer(-18));
		}
		imageButton[0].setText("开始游戏");

		imageButton[1].setText("制作人员");

		imageButton[2].setText("退出游戏");

		// 创建时间标签
		timeLabel = new JLabel(message);
		timeLabel.setBounds(1060, 20, message.getIconWidth(),
				message.getIconHeight());
		timeField = new JTextField();
		timeField.setBounds(20, 5, 100, 40);
		timeField.setBorder(null);
		timeField.setEditable(false);
		timeField.setOpaque(false);
		timeField.setFont(new Font("微软雅黑", Font.BOLD, 20));
		timeField.setForeground(new Color(42, 96, 128));
		timeField.setText("AC " + time);
		timeLabel.add(timeField);
		frontPanel.add(timeLabel, new Integer(-16));
		timeLabel.setVisible(false);

		// 创建暂停按钮
		pauseButton = new ImageButton(pause1, pause2, pause3, false);
		pauseButton.setLocation(50, 20);
		frontPanel.add(pauseButton, new Integer(-14));
		pauseButton.setVisible(false);

		// 创建星球图片
		planet = new ImageIcon("image/planet.png");
		lightPanel = new JPanel();
		JLabel planetLabel = new JLabel(planet);// 把背景图片显示在一个标签里面
		light1 = new JLabel(new ImageIcon("image/light1.png"));
		light1.setBounds(0, 0, light1.getIcon().getIconWidth(), light1
				.getIcon().getIconHeight());
		light1.setVisible(false);
		light2 = new JLabel(new ImageIcon("image/light2.png"));
		light2.setBounds(0, 0, light1.getIcon().getIconWidth(), light1
				.getIcon().getIconHeight());
		light2.setVisible(false);
		light3 = new JLabel(new ImageIcon("image/light3.png"));
		light3.setBounds(0, 0, light1.getIcon().getIconWidth(), light1
				.getIcon().getIconHeight());
		light3.setVisible(false);
		planetLabel.setBounds(345, 30, planet.getIconWidth(),
				planet.getIconHeight());
		planetLabel.setOpaque(false);
		lightPanel.setOpaque(false);
		lightPanel.setBounds(330, 30, planet.getIconWidth(),
				planet.getIconHeight());
		lightPanel.add(light3);
		lightPanel.add(light2);
		lightPanel.add(light1);
		frontPanel.add(lightPanel, new Integer(-30));
		frontPanel.add(planetLabel, new Integer(-31));

		// 创建顶部面板
		topPanel = new TopPanel();
		topPanel.setVisible(false);
		frontPanel.add(topPanel, new Integer(-15));

		// 创建底部面板按钮
		ImageIcon bottomImage = new ImageIcon("image/bottompanel.png");
		bottomLabel = new JLabel(bottomImage);
		bottomLabel.setBounds(240, 597, bottomImage.getIconWidth(),
				bottomImage.getIconHeight());
		bottomLabel.setVisible(false);
		frontPanel.add(bottomLabel, new Integer(-10));
		for (int i = 0; i <= 2; i++) {
			bottombottons[i] = new ImageButton(start1, start2, start3, false);
			bottombottons[i].setLocation(40 + 250 * i, 70);
			bottombottons[i].setForeground(new Color(53, 76, 107));
			bottombottons[i].setHorizontalTextPosition(JButton.CENTER);
			bottombottons[i].setVerticalTextPosition(JButton.CENTER);
			bottombottons[i].setFont(new Font("微软雅黑", Font.BOLD, 20));
		}
		bottombottons[0].setText("学科");

		bottombottons[1].setText("科技");

		bottombottons[2].setText("建造");
		for (ImageButton im : bottombottons) {
			bottomLabel.add(im);
			im.setVisible(false);
		}

		// 创建回合按钮
		roundButton = new ImageButton(roundIcon1, roundIcon2, roundIcon3, false);
		roundButton.setLocation(1100, 620);
		frontPanel.add(roundButton, new Integer(-11));
		roundButton.setVisible(false);

		// 设置信息面板
		messageLabel = new MessageLabel();
		messageLabel.setVisible(false);
		frontPanel.add(messageLabel, 0);

		// 创建学科面板
		sciPanel = new SciPanel(backgroundScn);
		sciPanel.setVisible(false);
		frontPanel.add(sciPanel, new Integer(-6));

		// 创建科技面板
		tecPanel = new TecPanel(backgroundTec);
		tecPanel.setVisible(false);
		frontPanel.add(tecPanel, new Integer(-5));

		// 创建生产面板

		objectPanel = new ObjectPanel(objectBackground, messageLabel, topPanel);
		objectPanel.setVisible(false);
		frontPanel.add(objectPanel, new Integer(-4));

		// 创建事件面板
		accidentLabel = new JLabel(new ImageIcon("image/accidentpanel.png"));
		accidentLabel.setBounds(400, 720, accidentLabel.getIcon()
				.getIconWidth(), accidentLabel.getIcon().getIconHeight());
		accidentLabel.setVisible(false);
		accidentButton = new ImageButton(accident1, accident2, accident3, false);
		accidentButton.setLocation(140, 180);
		accidentButton.setText("确认");
		accidentButton.setHorizontalTextPosition(JButton.CENTER);
		accidentButton.setVerticalTextPosition(JButton.CENTER);
		accidentButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
		accidentButton.setForeground(new Color(117, 16, 0));
		accidentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				// accidentLabel.setVisible(false);
				if (fail) {
					wipe();
				} else {
					accidentanim2();
				}

			}
		});
		accidentLabel.add(accidentButton);
		frontPanel.add(accidentLabel, 0);
		accidenPane = new JTextPane();
		accidenPane.setOpaque(false);
		accidenPane.setBorder(null);
		accidenPane.setBounds(24, 60, 430, 150);
		accidenPane.setEditable(false);
		accidenPane.setFocusable(false);
		StyleConstants.setAlignment(bSet, StyleConstants.ALIGN_CENTER);
		StyleConstants.setFontFamily(bSet, "宋体 bold");
		StyleConstants.setForeground(bSet, new Color(117, 16, 0));
		StyleConstants.setFontSize(bSet, 24);
		// accidenPane.setFont(new Font("宋体", Font.BOLD, 23));
		// accidenPane.setForeground(new Color(117, 16, 0));
		accidentLabel.add(accidenPane);

		// 创建胜利面板
		successLabel = new JLabel(new ImageIcon("image/successpanel.png"));
		successLabel.setBounds(400, 720,
				accidentLabel.getIcon().getIconWidth(), accidentLabel.getIcon()
						.getIconHeight());
		successLabel.setVisible(false);
		successButton = new ImageButton(success1, success2, success3, false);
		successButton.setLocation(140, 180);
		successButton.setText("确认");
		successButton.setHorizontalTextPosition(JButton.CENTER);
		successButton.setVerticalTextPosition(JButton.CENTER);
		successButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
		successButton.setForeground(new Color(117, 16, 0));
		successButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				// accidentLabel.setVisible(false);
				successanim2();
			}
		});
		successLabel.add(successButton);
		frontPanel.add(successLabel, 0);
		successPane = new JTextPane();
		successPane.setOpaque(false);
		successPane.setBorder(null);
		successPane.setBounds(24, 80, 430, 150);
		successPane.setEditable(false);
		successPane.setFocusable(false);
		StyleConstants.setAlignment(Set, StyleConstants.ALIGN_CENTER);
		StyleConstants.setFontFamily(Set, "宋体 bold");
		StyleConstants.setForeground(Set, new Color(117, 16, 0));
		StyleConstants.setFontSize(Set, 17);

		// 按钮功能
		imageButton[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				label2.setVisible(true);
				blackanime();

			}
		});
		imageButton[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				load();
			}
		});
		imageButton[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				dispose();
				System.exit(0);
			}
		});
		bottombottons[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				blockLabel.setVisible(true);
				sciPanel.pointsavailable.setText("可分配学科点：" + Begin.HP);
				SciPanel.iconData[3].setText(Sci.math.point + "");
				SciPanel.iconData[2].setText(Sci.physics.point + "");
				SciPanel.iconData[0].setText(Sci.chemistry.point + "");
				SciPanel.iconData[4].setText(Sci.computer.point + "");
				SciPanel.iconData[5].setText(Sci.art.point + "");
				SciPanel.iconData[1].setText(Sci.biology.point + "");
				sciPanel.refresh();
				sciPanel.setLocation(232, 720);
				sciPanel.setVisible(true);
				sciTimer = new Timer(10, new ActionListener() {
					int i = 0;

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						i += 1;
						if (i <= 10) {
							sciPanel.setLocation(sciPanel.getLocation().x,
									720 - ((720 - 48) / 10 * i));
						} else {
							sciTimer.stop();
						}
					}
				});
				sciTimer.start();
				for (ImageButton im : bottombottons) {
					im.setVisible(false);
				}
			}
		});
		bottombottons[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				blockLabel.setVisible(true);
				tecPanel.pointsfield.setText("化学:" + Sci.chemistry.point
						+ " 生物:" + Sci.biology.point + " 物理:"
						+ Sci.physics.point + " 数学:" + Sci.math.point + " 计算机:"
						+ Sci.computer.point + " 艺术:" + Sci.art.point);
				tecPanel.Refresh();
				tecPanel.setLocation(232, 720);
				tecPanel.setVisible(true);
				tecTimer = new Timer(10, new ActionListener() {
					int i = 0;

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						i += 1;

						if (i <= 10) {
							tecPanel.setLocation(tecPanel.getLocation().x,
									720 - ((720 - 48) / 10 * i));
						} else {
							tecTimer.stop();
						}
					}
				});
				tecTimer.start();
				for (ImageButton im : bottombottons) {
					im.setVisible(false);
				}
			}
		});
		bottombottons[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				blockLabel.setVisible(true);
				objectPanel.setLocation(232, 720);
				objectPanel.refresh();
				objectPanel.setVisible(true);
				objtimer = new Timer(10, new ActionListener() {
					int i = 0;

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO 自动生成的方法存根
						i += 1;

						if (i <= 10) {
							objectPanel.setLocation(
									objectPanel.getLocation().x,
									720 - ((720 - 48) / 10 * i));
						} else {
							objtimer.stop();
						}
					}
				});
				objtimer.start();
				for (ImageButton im : bottombottons) {
					im.setVisible(false);
				}
			}
		});
		pauseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				label2.setVisible(true);
				blackanime2();
				// repaint();
			}
		});

		roundButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				mouseTimer = new Timer(100, new ActionListener() {
					int i = 0;

					@Override
					public void actionPerformed(ActionEvent arg0) {
						// TODO 自动生成的方法存根
						if (i == 0) {
							Toolkit tk = Toolkit.getDefaultToolkit();
							Image image = new ImageIcon("image/cursor2.gif")
									.getImage();
							Cursor cursor = tk.createCustomCursor(image,
									new Point(0, 0), "invisi");
							setCursor(cursor);
							getGlassPane().setVisible(true);
							getGlassPane().addMouseListener(new MouseAdapter() {
							});
							getGlassPane().addMouseMotionListener(
									new MouseMotionAdapter() {
									});
							starTimer.setDelay(7);

							try {
								FileInputStream fileau = new FileInputStream(
										"sound/fly.wav");
								AudioStream as = new AudioStream(fileau);
								AudioPlayer.player.start(as);

							} catch (Exception e) {
							}

						} else if (i <= 10) {

						} else {
							getGlassPane().setVisible(false);
							Toolkit tk = Toolkit.getDefaultToolkit();
							Image image = new ImageIcon("image/cursor.gif")
									.getImage();
							Cursor cursor = tk.createCustomCursor(image,
									new Point(0, 0), "invisi");
							setCursor(cursor);
							mouseTimer.stop();
							starTimer.setDelay(100);
							topPanel.topLabel.setText("◎经济值" + Begin.EV + "  "
									+ "◎幸福值" + Begin.HV + "  " + "◎环境值"
									+ Begin.EMV);

							timeField.setText("AC " + time);

							String s = bom.bomb();
							if (win!=0) {
								if(win==1) {
									shipwin();
								}
								else if (win==2) {
									mixwin();
								}
								else {
									supwin();
								}
							} else {
								if (s != "") {
									accidenPane.setText(s);
									accidentanim();

								} else if (s == "") {
									if (Begin.EV <= 0) {
										fail1();
									} else if (Begin.HV <= 0) {
										fail2();
									} else if (Begin.EMV <= 0) {
										fail3();
									}
								}
							}
						}
						i++;
					}
				});

				mouseTimer.start();
				Economy eco = new Economy();
				Environment env = new Environment();
				Happiness hap = new Happiness();
				SciPoint poi = new SciPoint();
				bom = new Bomb();

				eco.economy();
				env.environment();
				hap.happiness();
				poi.point();

				time++;

			}
		});

		// 设置鼠标
		String url = "image/cursor.gif"; // 储存鼠标图片的位置
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image image = new ImageIcon(url).getImage();
		Cursor cursor = tk.createCustomCursor(image, new Point(0, 0), "invisi");

		setCursor(cursor); // panel 也可以是其他组件

		// 获取鼠标坐标
		addMouseMotionListener(new MouseMotionListener() {

			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO 自动生成的方法存根
				x = e.getX();
				y = e.getY();
			}

			@Override
			public void mouseDragged(MouseEvent e) {

				// TODO 自动生成的方法存根

			}
		});

		imagePanel.add(label);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(background.getIconWidth(), background.getIconHeight());
		setUndecorated(true);
		// setVisible(true);
		setLocationRelativeTo(null);

		// 科技按钮的信息内容（很长。。。。）
		tecPanel.tecButton[0].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(TecPanel.textTitle[0]);
				MessageLabel.setContains(TecPanel.textContains[0]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		tecPanel.tecButton[1].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(TecPanel.textTitle[1]);
				MessageLabel.setContains(TecPanel.textContains[1]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		tecPanel.tecButton[2].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(TecPanel.textTitle[2]);
				MessageLabel.setContains(TecPanel.textContains[2]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		tecPanel.tecButton[3].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(TecPanel.textTitle[3]);
				MessageLabel.setContains(TecPanel.textContains[3]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		tecPanel.tecButton[4].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(TecPanel.textTitle[4]);
				MessageLabel.setContains(TecPanel.textContains[4]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		tecPanel.tecButton[5].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(TecPanel.textTitle[5]);
				MessageLabel.setContains(TecPanel.textContains[5]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		tecPanel.tecButton[6].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(TecPanel.textTitle[6]);
				MessageLabel.setContains(TecPanel.textContains[6]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		tecPanel.tecButton[7].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(TecPanel.textTitle[7]);
				MessageLabel.setContains(TecPanel.textContains[7]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		tecPanel.tecButton[8].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(TecPanel.textTitle[8]);
				MessageLabel.setContains(TecPanel.textContains[8]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		tecPanel.tecButton[9].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(TecPanel.textTitle[9]);
				MessageLabel.setContains(TecPanel.textContains[9]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		// 学科按钮的信息内容（也很长。。。。）
		sciPanel.cheButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 50, GameWindow.y + 50);
				MessageLabel.setTitle(SciPanel.iconTitle[0]);
				MessageLabel.setContains(SciPanel.iconContains[0]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		sciPanel.bioButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 50, GameWindow.y + 50);
				MessageLabel.setTitle(SciPanel.iconTitle[1]);
				MessageLabel.setContains(SciPanel.iconContains[1]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		sciPanel.phyButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 50, GameWindow.y + 50);
				MessageLabel.setTitle(SciPanel.iconTitle[2]);
				MessageLabel.setContains(SciPanel.iconContains[2]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		sciPanel.mathButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 50, GameWindow.y + 50);
				MessageLabel.setTitle(SciPanel.iconTitle[3]);
				MessageLabel.setContains(SciPanel.iconContains[3]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		sciPanel.comButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 50, GameWindow.y + 50);
				MessageLabel.setTitle(SciPanel.iconTitle[4]);
				MessageLabel.setContains(SciPanel.iconContains[4]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		sciPanel.artButton.addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 50, GameWindow.y + 50);
				MessageLabel.setTitle(SciPanel.iconTitle[5]);
				MessageLabel.setContains(SciPanel.iconContains[5]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		ObjectPanel.button[0].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(ObjectPanel.textTitle[0]);
				MessageLabel.setContains(ObjectPanel.textContains[0]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		ObjectPanel.button[1].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(ObjectPanel.textTitle[1]);
				MessageLabel.setContains(ObjectPanel.textContains[1]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		ObjectPanel.button[2].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(ObjectPanel.textTitle[2]);
				MessageLabel.setContains(ObjectPanel.textContains[2]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		ObjectPanel.button[3].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(ObjectPanel.textTitle[3]);
				MessageLabel.setContains(ObjectPanel.textContains[3]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		ObjectPanel.button[4].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(ObjectPanel.textTitle[4]);
				MessageLabel.setContains(ObjectPanel.textContains[4]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		ObjectPanel.button[5].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(ObjectPanel.textTitle[5]);
				MessageLabel.setContains(ObjectPanel.textContains[5]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		ObjectPanel.button[6].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(ObjectPanel.textTitle[6]);
				MessageLabel.setContains(ObjectPanel.textContains[6]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		ObjectPanel.button[7].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(ObjectPanel.textTitle[7]);
				MessageLabel.setContains(ObjectPanel.textContains[7]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		ObjectPanel.button[8].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(ObjectPanel.textTitle[8]);
				MessageLabel.setContains(ObjectPanel.textContains[8]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
		ObjectPanel.button[9].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(ObjectPanel.textTitle[9]);
				MessageLabel.setContains(ObjectPanel.textContains[9]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

		});
		ObjectPanel.button[10].addMouseListener(new MouseListener() {

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO 自动生成的方法存根

			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO 自动生成的方法存根
				messageLabel.setVisible(false);
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO 自动生成的方法存根

				messageLabel.setLocation(GameWindow.x + 35, GameWindow.y + 35);
				MessageLabel.setTitle(ObjectPanel.textTitle[10]);
				MessageLabel.setContains(ObjectPanel.textContains[10]);
				messageLabel.setVisible(true);
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根

			}
		});
	}

	public KeyEventPostProcessor getMyKeyEventHandler() {
		return new KeyEventPostProcessor() { // 返回一个实现KeyEventPostProcessor接口的匿名内部类。
			public boolean postProcessKeyEvent(KeyEvent e) { // 实现postProcessKeyEvent方法

				if (e.getKeyCode() == KeyEvent.VK_E) { // 根据你的需要监听相应的动作。
					for (ImageButton im : TecPanel.tecButton) {
						im.setavalible(true);
						im.setVisible(true);
					}
					for (JLabel j : TecPanel.lineLabels) {
						j.setVisible(true);
					}
				}
				if (e.getKeyCode() == KeyEvent.VK_S) {
					save();
				}
				if (e.getKeyCode() == KeyEvent.VK_L) {
					load();

				}
				return rootPaneCheckingEnabled;

			}
		};
	}

	private void blackanime() {

		blackTimer = new Timer(15, new ActionListener() {
			int i = 0;
			int j = 0;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				i++;
				if (i <= 20) {
					blackLabel.setBackground(new Color(0, 0, 0, 255 / 20 * i));
					starTimer.stop();
				} else if (i > 20 && i <= 30) {
					if (j == 0) {
						for (ImageButton im : bottombottons) {
							im.setVisible(true);
						}
						labelTitle.setVisible(false);
						for (ImageButton ib : imageButton) {
							ib.setVisible(false);
						}
						topPanel.setVisible(true);
						bottomLabel.setVisible(true);
						roundButton.setVisible(true);
						pauseButton.setVisible(true);
						timeLabel.setVisible(true);
						j++;

					}
				} else if (i > 30 && i <= 50) {
					blackLabel.setBackground(new Color(0, 0, 0,
							255 / 20 * (50 - i)));
				} else {
					starTimer.start();
					label2.setVisible(false);
					blackTimer.stop();

				}
			}
		});
		blackTimer.start();
	}

	private void blackanime2() {

		blackTimer2 = new Timer(15, new ActionListener() {
			int i = 0;
			int j = 0;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				i++;
				if (i <= 10) {
					blackLabel.setBackground(new Color(0, 0, 0, 255 / 10 * i));
					starTimer.stop();
				} else if (i > 10 && i <= 20) {
					if (j == 0) {
						blockLabel.setVisible(false);
						accidentLabel.setVisible(false);
						successLabel.setVisible(false);
						pauseButton.setVisible(false);
						bottomLabel.setVisible(false);
						roundButton.setVisible(false);
						timeLabel.setVisible(false);
						topPanel.setVisible(false);
						for (ImageButton ib : imageButton) {
							ib.setVisible(true);
						}
						for (ImageButton im : bottombottons) {
							im.setVisible(false);
						}
						labelTitle.setVisible(true);
						j++;

					}
				} else if (i > 20 && i <= 30) {
					blackLabel.setBackground(new Color(0, 0, 0,
							255 / 10 * (30 - i)));
				} else {
					label2.setVisible(false);
					starTimer.start();
					blackTimer2.stop();

				}
			}
		});
		blackTimer2.start();
	}

	void staranim() {
		starTimer = new Timer(100, new ActionListener() {
			int i = 0;
			int j = 0;
			int k = 0;

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根

				if (i <= 2560) {
					starLabel1.setLocation(0 - i, 0);
					starLabel2.setLocation(2560 - i, 0);

				} else {
					i = -1;
				}
				i++;
				if (j <= 50) {
					PlaneLabel.trance = j * 2;
					if (planetLabel2 != null) {
						planetLabel2.repaint();
					}
				} else if (j > 50 && j <= 100) {
					PlaneLabel.trance = (100 - j) * 2;
				} else {
					j = -1;
				}

				j++;
				if (k <= 1280) {
					starLabel3.setLocation((int) ((0 - k) * 0.5), 0);
					starLabel4.setLocation((int) ((1280 - k) * 0.5), 0);

				} else {
					k = -1;
				}
				k++;
			}
		});
		starTimer.start();
	}

	void accidentanim() {
		StyledDocument doc = accidenPane.getStyledDocument();
		doc.setParagraphAttributes(0, 104, bSet, false);
		blockLabel.setVisible(true);
		roundButton.setVisible(false);
		for (ImageButton im : bottombottons) {
			im.setVisible(false);
		}
		pauseButton.setVisible(false);
		accidentLabel.setVisible(true);
		accidTimer = new Timer(10, new ActionListener() {
			int i = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				i += 1;

				if (i <= 10) {
					accidentLabel.setLocation(accidentLabel.getLocation().x,
							720 - ((720 - 250) / 10 * i));
				} else {
					accidTimer.stop();
				}
			}
		});
		accidTimer.start();
	}

	void accidentanim2() {
		roundButton.setVisible(true);
		for (ImageButton im : bottombottons) {
			im.setVisible(true);
		}
		pauseButton.setVisible(true);
		blockLabel.setVisible(false);
		accidTimer = new Timer(10, new ActionListener() {
			int i = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				i += 1;

				if (i <= 10) {
					accidentLabel.setLocation(accidentLabel.getLocation().x,
							250 + ((720 - 250) / 10 * i));
				} else {

					accidTimer.stop();
					if (Begin.EV <= 0) {
						fail1();
					} else if (Begin.HV <= 0) {
						fail2();
					} else if (Begin.EMV <= 0) {
						fail3();
					}
				}
			}
		});
		accidTimer.start();
	}

	void successanim() {
		StyledDocument doc = successPane.getStyledDocument();
		doc.setParagraphAttributes(0, 104, Set, false);
		blockLabel.setVisible(true);
		roundButton.setVisible(false);
		for (ImageButton im : bottombottons) {
			im.setVisible(false);
		}
		pauseButton.setVisible(false);
		successLabel.setVisible(true);
		accidTimer = new Timer(10, new ActionListener() {
			int i = 0;

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				i += 1;

				if (i <= 10) {
					successLabel.setLocation(accidentLabel.getLocation().x,
							720 - ((720 - 250) / 10 * i));
				} else {
					accidTimer.stop();
				}
			}
		});
		accidTimer.start();
	}

	void successanim2() {
		wipe();
	}

	public void save() {
		int[] savedata = new int[39];
		savedata[0] = Begin.EV;
		savedata[1] = Begin.EMV;
		savedata[2] = Begin.HV;
		savedata[3] = Begin.HP;
		savedata[4] = Sci.math.point;
		savedata[5] = Sci.physics.point;
		savedata[6] = Sci.chemistry.point;
		savedata[7] = Sci.biology.point;
		savedata[8] = Sci.computer.point;
		savedata[9] = Sci.art.point;
		savedata[10] = SciPanel.mathSum;
		savedata[11] = SciPanel.physicsSum;
		savedata[12] = SciPanel.chemistrySum;
		savedata[13] = SciPanel.biologySum;
		savedata[14] = SciPanel.computerSum;
		savedata[15] = SciPanel.artSum;
		for (int i = 16; i <= 25; i++) {
			savedata[i] = TecPanel.tecStats[i - 16];
		}
		for (int i = 26; i <= 36; i++) {
			savedata[i] = ObjectPanel.button[i - 26].location;
		}
		savedata[37] = TecPanel.ligntstate;
		String s = "";
		for (int i = 0; i <= 37; i++) {
			s += savedata[i] + " ";
		}
		s = s.substring(0, s.length() - 1);
		try {
			File f = new File("data/save.txt");
			FileWriter writer = new FileWriter(f);
			BufferedWriter bWriter = new BufferedWriter(writer);
			bWriter.write(s);
			bWriter.close();
		} catch (IOException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}

	public void load() {
		label2.setVisible(true);
		blackanime2();

		int[] i1 = new int[38];
		try {
			java.util.Scanner loadScanner = new java.util.Scanner(new File(
					"data/save.txt"));

			for (int i = 0; i <= 37; i++) {

				i1[i] = loadScanner.nextInt();

			}

		} catch (FileNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
		Begin.EV = i1[0];
		Begin.EMV = i1[1];
		Begin.HV = i1[2];
		Begin.HP = i1[3];
		Sci.math.point = i1[4];
		Sci.physics.point = i1[5];
		Sci.chemistry.point = i1[6];
		Sci.biology.point = i1[7];
		Sci.computer.point = i1[8];
		Sci.art.point = i1[9];
		SciPanel.mathSum = i1[10];
		SciPanel.physicsSum = i1[11];
		SciPanel.chemistrySum = i1[12];
		SciPanel.biologySum = i1[13];
		SciPanel.computerSum = i1[14];
		SciPanel.artSum = i1[15];
		for (int i = 16; i <= 25; i++) {
			if (i1[i] == 1) {
				TecPanel.tecButton[i - 16].ispressed = true;
			}
		}
		for (int i = 26; i <= 36; i++) {
			ObjectPanel.button[i - 26].location = i1[i];
		}
		TecPanel.ligntstate = i1[37];
		topPanel.topLabel.setText("◎经济值" + Begin.EV + "  " + "◎幸福值" + Begin.HV
				+ "  " + "◎环境值" + Begin.EMV);
		sciPanel.pointsavailable.setText("可分配学科点：" + Begin.HP);
		int scipoint[] = { Sci.chemistry.point, Sci.biology.point,
				Sci.physics.point, Sci.math.point, Sci.computer.point,
				Sci.art.point };
		for (int i = 0; i <= 5; i++) {
			SciPanel.iconData[i].setText(scipoint[i] + "");
		}
		tecPanel.pointsfield.setText("化学:" + Sci.chemistry.point + " 生物:"
				+ Sci.biology.point + " 物理:" + Sci.physics.point + " 数学:"
				+ Sci.math.point + " 计算机:" + Sci.computer.point + " 艺术:"
				+ Sci.art.point);
		fail = false;
		tecPanel.load();
		tecPanel.Refresh();
		objectPanel.recover();

	}

	public void wipe() {
		label2.setVisible(true);
		blackanime2();

		int[] i1 = { 100, 80, 80, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
				0, 0, 0, 0, 0, 0, 0, 0, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1,
				-1, 0 };

		Begin.EV = i1[0];
		Begin.EMV = i1[1];
		Begin.HV = i1[2];
		Begin.HP = i1[3];
		Sci.math.point = i1[4];
		Sci.physics.point = i1[5];
		Sci.chemistry.point = i1[6];
		Sci.biology.point = i1[7];
		Sci.computer.point = i1[8];
		Sci.art.point = i1[9];
		SciPanel.mathSum = i1[10];
		SciPanel.physicsSum = i1[11];
		SciPanel.chemistrySum = i1[12];
		SciPanel.biologySum = i1[13];
		SciPanel.computerSum = i1[14];
		SciPanel.artSum = i1[15];
		for (int i = 16; i <= 25; i++) {
			if (i1[i] == 1) {
				TecPanel.tecButton[i - 16].ispressed = true;
			}
		}
		for (int i = 26; i <= 36; i++) {
			ObjectPanel.button[i - 26].location = i1[i];
		}
		TecPanel.ligntstate = i1[37];
		topPanel.topLabel.setText("◎经济值" + Begin.EV + "  " + "◎幸福值" + Begin.HV
				+ "  " + "◎环境值" + Begin.EMV);
		sciPanel.pointsavailable.setText("可分配学科点：" + Begin.HP);
		int scipoint[] = { Sci.chemistry.point, Sci.biology.point,
				Sci.physics.point, Sci.math.point, Sci.computer.point,
				Sci.art.point };
		for (int i = 0; i <= 5; i++) {
			SciPanel.iconData[i].setText(scipoint[i] + "");
		}
		tecPanel.pointsfield.setText("化学:" + Sci.chemistry.point + " 生物:"
				+ Sci.biology.point + " 物理:" + Sci.physics.point + " 数学:"
				+ Sci.math.point + " 计算机:" + Sci.computer.point + " 艺术:"
				+ Sci.art.point);
		fail = false;
		tecPanel.load();
		tecPanel.Refresh();
		objectPanel.recover();

	}

	void shipwin() {
		successPane.setText("恭喜您！您带领您的同胞走到了现在，强大的宇宙飞船给了这个种族在宇宙远航的能力与信心。然而宇宙的危险也将更快展现在年轻的猎手面前。让我们拭目以待！");
	}

	void mixwin() {
		successPane.setText("将机械与生物同时研究到如此的高度，让这颗星球获得了在宇宙中安静地前行的能力。虽然没有强大的火力，但无论在本土还是在宇宙，混合生命都是最顽强的。");
	}

	void supwin() {
		successPane.setText("是什么样的技术，才能将生物的潜能发挥到如此地步！单凭生物本身，就能在无大气环境中自保。虽然不能随意穿梭宇宙，但若有外来客登陆，迎接他们的将是最可怕的噩梦。");
	}

	void fail1() {
		accidenPane.setText("经济大崩溃下，这个星球的成员已经陷入恐慌。政府无法有效集合资源，这颗星球在黑暗森林登场的日期被无限期延长。");
		accidentanim();
		fail = true;

	}

	void fail2() {
		accidenPane.setText("民众失去了对政府的信心，经过数年的暴乱游行与武装冲突后，统一联邦瓦解，技术进步的步伐在战火中停滞。");
		accidentanim();
		fail = true;

	}

	void fail3() {
		accidenPane.setText("环境恶化，生态系统崩溃，你的同胞在走向宇宙前就失去了赖以生存的家园，这颗星球又将回归原始。");
		accidentanim();
		fail = true;

	}

}
