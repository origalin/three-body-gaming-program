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

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;

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
	JLabel labelTitle;
	JLabel bottomLabel;
	ImageButton pauseButton;
	JLabel timeLabel;
	JLabel accidentLabel;
	JLabel blackLabel;
	JLabel starLabel1;
	JLabel starLabel2;
	static JLabel blockLabel;
	JLabel label2;
	JTextArea accidenTextArea;
	ImageButton[] bottombottons = new ImageButton[3];
	ImageButton roundButton;
	ImageButton accidentButton;
	TopPanel topPanel;
	ImageIcon objectBackground;
	public static int x;
	public static int y;
	final MessageLabel messageLabel;
	int tec;
	static JLabel light1;
	static JLabel light2;
	static JLabel light3;
	int time = 1020;
	JTextField timeField;
	Timer objtimer;
	Timer sciTimer;
	Timer tecTimer;
	Timer blackTimer;
	Timer mouseTimer;
	Timer starTimer;
	ImageButton[] imageButton = new ImageButton[3];
	int v = 1;

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
		blockLabel.setOpaque(true);
		blockLabel.setVisible(false);
		frontPanel.add(blockLabel, new Integer(-7));
		//星空图片
		starLabel1 = new JLabel(new ImageIcon("image/back1.png"));
		starLabel1.setBounds(0, 0, 2560, 720);
		frontPanel.add(starLabel1, new Integer(-40));
		starLabel2 = new JLabel(new ImageIcon("image/back2.png"));
		starLabel2.setBounds(2560, 0, 2560, 720);
		frontPanel.add(starLabel2, new Integer(-41));
		staranim();
		

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
		frontPanel.add(labelTitle,new Integer(-17));

		// 创建开始界面按钮
		for (int i = 0; i <= 2; i++) {
			imageButton[i] = new ImageButton(startst1, start2, start3, false);
			imageButton[i].setLocation(530, 290 + (i) * 120);
			imageButton[i].setVisible(true);
			imageButton[i].setHorizontalTextPosition(JButton.CENTER);
			imageButton[i].setVerticalTextPosition(JButton.CENTER);
			imageButton[i].setFont(new Font("微软雅黑", Font.BOLD, 20));
			imageButton[i].setForeground(new Color(0,89,130));
			frontPanel.add(imageButton[i],new Integer(-18));
		}
		imageButton[0].setText("开始游戏");

		imageButton[1].setText("制作人员");

		imageButton[2].setText("退出游戏");

		// 创建时间标签
		timeLabel = new JLabel(message);
		timeLabel.setBounds(1060, 20, message.getIconWidth(),
				message.getIconHeight());
		timeField = new JTextField();
		timeField.setBounds(10, 5, 100, 40);
		timeField.setBorder(null);
		timeField.setEditable(false);
		timeField.setOpaque(false);
		timeField.setFont(new Font("微软雅黑", Font.BOLD, 20));
		timeField.setForeground(new Color(42,96,128));
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
		planet.setImage(planet.getImage().getScaledInstance(600, 600,
				Image.SCALE_DEFAULT));
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
		planetLabel.setBounds(360, 30, planet.getIconWidth(),
				planet.getIconHeight());
		planetLabel.setOpaque(false);
		lightPanel.setOpaque(false);
		lightPanel.setBounds(360, 30, planet.getIconWidth(),
				planet.getIconHeight());
		lightPanel.add(light1);
		lightPanel.add(light2);
		lightPanel.add(light3);
		frontPanel.add(lightPanel,new Integer(-30));
		frontPanel.add(planetLabel,new Integer(-31));

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
			bottombottons[i].setForeground(new Color(53,76,107));
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

		// 创建学科面板
		sciPanel = new SciPanel(backgroundScn);
		sciPanel.setVisible(false);
		frontPanel.add(sciPanel, new Integer(-6));

		// 创建科技面板
		tecPanel = new TecPanel(backgroundTec);
		tecPanel.setVisible(false);
		frontPanel.add(tecPanel, new Integer(-5));

		// 创建生产面板
		objectPanel = new ObjectPanel(objectBackground);
		objectPanel.setVisible(false);
		frontPanel.add(objectPanel, new Integer(-4));

		// 创建事件面板
		accidentLabel = new JLabel(new ImageIcon("image/accidentpanel.png"));
		accidentLabel.setBounds(400, 250, accidentLabel.getIcon()
				.getIconWidth(), accidentLabel.getIcon().getIconHeight());
		accidentButton = new ImageButton(accident1, accident2, accident3, false);
		accidentButton.setLocation(140, 180);
		accidentButton.setText("确认");
		accidentButton.setHorizontalTextPosition(JButton.CENTER);
		accidentButton.setVerticalTextPosition(JButton.CENTER);
		accidentButton.setFont(new Font("微软雅黑", Font.BOLD, 20));
		accidentButton.setForeground(new Color(117,16,0));
		accidentButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				accidentLabel.setVisible(false);
			}
		});
		accidentLabel.add(accidentButton);
		frontPanel.add(accidentLabel, 0);
		accidenTextArea = new JTextArea();
		accidenTextArea.setOpaque(false);
		accidenTextArea.setBorder(null);
		accidenTextArea.setEditable(false);
		accidenTextArea.setBounds(24, 20, 430, 150);
		accidenTextArea.setFont(new Font("宋体", Font.PLAIN, 17));
		accidenTextArea.setForeground(new Color(117,16,0));
		accidentLabel.add(accidenTextArea);

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
				int i[] = { Sci.chemistry.point, Sci.biology.point,
						Sci.physics.point, Sci.math.point, Sci.computer.point,
						Sci.art.point };
				sciPanel.setpoints(i);
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
			}
		});
		bottombottons[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				blockLabel.setVisible(true);
				objectPanel.setLocation(232, 720);
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
							topPanel.topLabel.setText("经济值" + Begin.EV + "  " + "幸福值"
									+ Begin.HV + "  " + "环境值" + Begin.EMV);

							timeField.setText("AC " + time);
						}
						i++;
					}
				});

				mouseTimer.start();
				Next next = new Next();
				next.goNext();
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

		// 设置信息面板
		messageLabel = new MessageLabel();
		messageLabel.setVisible(false);
		frontPanel.add(messageLabel, 0);
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
	}

	public KeyEventPostProcessor getMyKeyEventHandler() {
		return new KeyEventPostProcessor() {  // 返回一个实现KeyEventPostProcessor接口的匿名内部类。
			public boolean postProcessKeyEvent(KeyEvent e) {  // 实现postProcessKeyEvent方法

				if (e.getKeyCode() == KeyEvent.VK_E) {  // 根据你的需要监听相应的动作。
					for (ImageButton im : TecPanel.tecButton) {
						im.setavalible(true);
						im.setVisible(true);
					}
					for(JLabel j:TecPanel.lineLabels) {
						j.setVisible(true);
					}
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
				if (i <= 10) {
					blackLabel.setBackground(new Color(0, 0, 0, 255 / 10 * i));
					starTimer.stop();
				} else if (i > 10 && i <= 20) {
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
						
					} else {
						j++;
					}
				} else if (i > 20 && i <= 30) {
					blackLabel.setBackground(new Color(0, 0, 0,
							255 / 10 * (30 - i)));
				} else {
					blackTimer.stop();
					starTimer.start();
					label2.setVisible(false);

				}
			}
		});
		blackTimer.start();
	}

	private void blackanime2() {

		blackTimer = new Timer(15, new ActionListener() {
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
						
					} else {
						j++;
					}
				} else if (i > 20 && i <= 30) {
					blackLabel.setBackground(new Color(0, 0, 0,
							255 / 10 * (30 - i)));
				} else {
					blackTimer.stop();
					label2.setVisible(false);
					starTimer.start();

				}
			}
		});
		blackTimer.start();
	}
	void staranim(){
		starTimer = new Timer(100, new ActionListener() {
			int i = 0;
			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(i<=2560) {
					starLabel1.setLocation(0-i, 0);
					starLabel2.setLocation(2560-i, 0);
				}
				else {
					i=-1;
				}
				i++;
				
			}
		});
		starTimer.start();
	}

}
