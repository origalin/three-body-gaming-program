package ui;

import el.*;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

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
	ImageIcon backgroundMain;
	JPanel mainPanel;
	JLabel labelTitle;
	JLabel bottomLabel;
	ImageButton pauseButton;
	JLabel timeLabel;
	ImageButton[] bottombottons = new ImageButton[3];
	ImageButton roundButton;
	TopPanel topPanel;
	ImageIcon objectBackground;
	public static int x;
	public static int y;
	final MessageLabel messageLabel;

	public GameWindow(GraphicsConfiguration gc) {
		super(gc);
		frontPanel = getLayeredPane();
		final ImageButton[] imageButton = new ImageButton[3];
		backgroundScn = new ImageIcon("image/scnpanel.png");
		backgroundTec = new ImageIcon("image/tecpanel.png");
		background = new ImageIcon("image/background.png");// 背景图片
		backgroundTitle = new ImageIcon("image/title.png");
		objectBackground =new ImageIcon("image/prdpanel.png");
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
		// 背景图
		JLabel label = new JLabel(background);// 把背景图片显示在一个标签里面
		label.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());

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
		imagePanel.add(labelTitle);

		// 创建开始界面按钮
		for (int i = 0; i <= 2; i++) {
			imageButton[i] = new ImageButton(start1, start2, start3, false);
			imageButton[i].setLocation(530, 290 + (i) * 120);
			imageButton[i].setVisible(true);
			imageButton[i].setHorizontalTextPosition(JButton.CENTER);
			imageButton[i].setVerticalTextPosition(JButton.CENTER);
			imageButton[i].setFont(new Font("微软雅黑", Font.BOLD, 20));
			imagePanel.add(imageButton[i]);
		}
		imageButton[0].setText("开始游戏");

		imageButton[1].setText("制作人员");

		imageButton[2].setText("退出游戏");

		// 创建时间标签
		timeLabel = new JLabel(message);
		timeLabel.setBounds(1060, 20, message.getIconWidth(),
				message.getIconHeight());
		frontPanel.add(timeLabel);
		timeLabel.setVisible(false);

		// 创建暂停按钮
		pauseButton = new ImageButton(pause1, pause2, pause3, false);
		pauseButton.setLocation(50, 20);
		frontPanel.add(pauseButton);
		pauseButton.setVisible(false);

		// 创建星球图片
		backgroundMain = new ImageIcon("image/planet.png");
		backgroundMain.setImage(backgroundMain.getImage().getScaledInstance(
				600, 600, Image.SCALE_DEFAULT));
		mainPanel = new JPanel();
		JLabel labelBackground = new JLabel(backgroundMain);// 把背景图片显示在一个标签里面
		labelBackground.setBounds(0, 0, backgroundMain.getIconWidth(),
				backgroundMain.getIconHeight());
		mainPanel.setOpaque(false);
		mainPanel.setBounds(360, 30, backgroundMain.getIconWidth(),
				backgroundMain.getIconHeight());
		mainPanel.add(labelBackground);
		imagePanel.add(mainPanel);
		
		//创建顶部面板
		topPanel = new TopPanel();
		topPanel.setVisible(false);
		frontPanel.add(topPanel, -1);

		// 创建底部面板按钮
		ImageIcon bottomImage = new ImageIcon("image/bottompanel.png");
		bottomLabel = new JLabel(bottomImage);
		bottomLabel.setBounds(240, 597, bottomImage.getIconWidth(),
				bottomImage.getIconHeight());
		bottomLabel.setVisible(false);
		frontPanel.add(bottomLabel, -1);
		for (int i = 0; i <= 2; i++) {
			bottombottons[i] = new ImageButton(start1, start2, start3, false);
			bottombottons[i].setLocation(290 + 250 * i, 660);
			bottombottons[i].setHorizontalTextPosition(JButton.CENTER);
			bottombottons[i].setVerticalTextPosition(JButton.CENTER);
			bottombottons[i].setFont(new Font("微软雅黑", Font.BOLD, 20));
		}
		bottombottons[0].setText("学科");

		bottombottons[1].setText("科技");

		bottombottons[2].setText("建造");
		for (ImageButton im : bottombottons) {
			frontPanel.add(im, 0);
			im.setVisible(false);
		}

		// 创建回合按钮
		roundButton = new ImageButton(roundIcon1, roundIcon2, roundIcon3, false);
		roundButton.setLocation(1100, 620);
		frontPanel.add(roundButton);
		roundButton.setVisible(false);

		// 创建学科面板
		sciPanel = new SciPanel(backgroundScn);
		sciPanel.setVisible(false);
		frontPanel.add(sciPanel, 0);
		/*
		 * sciDialog.setBounds(500, 500, backgroundScn.getIconWidth(),
		 * backgroundScn.getIconHeight());
		 * sciDialog.setLocationRelativeTo(imagePanel);
		 * sciDialog.setUndecorated(true); sciDialog.add(sciPanel);
		 * sciDialog.getRootPane().setOpaque(false);
		 * sciDialog.getContentPane().setBackground(new Color(0, 0, 0, 0));
		 * sciDialog.setBackground(new Color(0, 0, 0, 0));
		 * sciDialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
		 */

		// 创建科技面板
		tecPanel = new TecPanel(backgroundTec);
		tecPanel.setVisible(false);
		frontPanel.add(tecPanel, 0);
		
//		创建生产面板
		objectPanel=new ObjectPanel(objectBackground);
		objectPanel.setVisible(false);
		frontPanel.add(objectPanel,0);
		// 按钮功能
		imageButton[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根

				
				labelTitle.setVisible(false);
				for (ImageButton im : bottombottons) {
					im.setVisible(true);
				}
				for (ImageButton ib : imageButton) {
					ib.setVisible(false);
				}

				topPanel.setVisible(true);
				bottomLabel.setVisible(true);
				roundButton.setVisible(true);
				pauseButton.setVisible(true);
				timeLabel.setVisible(true);
				validate();

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
			}
		});
		bottombottons[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i[] = {Sci.chemistry.point,Sci.biology.point,Sci.physics.point,
						Sci.math.point,Sci.computer.point,Sci.art.point};
				sciPanel.setpoints(i);
				sciPanel.pointsavailable.setText("可分配学科点：" + Begin.HP);
				sciPanel.setVisible(true);
			}
		});
		bottombottons[1].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				Theory.judgeSumA();
				tecPanel.setVisible(true);
			}
		});
		bottombottons[2].addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				objectPanel.setVisible(true);
			}
		});
		pauseButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
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
				repaint();
			}
		});
		
		
		roundButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Next next = new Next();
				next.goNext();
				topPanel.topLabel.setText("星球属性："+Begin.EV);
			}
		});		

		// 设置鼠标
		String url = "image/cursor.gif"; // 储存鼠标图片的位置
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image image = new ImageIcon(url).getImage();
		Cursor cursor = tk.createCustomCursor(image, new Point(0, 0), "invisi");
		setCursor(cursor); // panel 也可以是其他组件
		
		//获取鼠标坐标
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
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(background.getIconWidth(), background.getIconHeight());
		this.setUndecorated(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		//设置信息面板
		messageLabel = new MessageLabel();
		messageLabel.setVisible(false);
		frontPanel.add(messageLabel,0);
		for(final ImageButton im : tecPanel.tecButton) {
			im.addMouseListener(new MouseListener() {
				
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

					messageLabel.setLocation(GameWindow.x, GameWindow.y);
					messageLabel.setVisible(true);
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO 自动生成的方法存根
					
				}
			});
		}

	}

}

