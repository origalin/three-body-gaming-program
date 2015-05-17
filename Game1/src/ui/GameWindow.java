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
		background = new ImageIcon("image/background.png");// ����ͼƬ
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
		// ����ͼ
		JLabel label = new JLabel(background);// �ѱ���ͼƬ��ʾ��һ����ǩ����
		label.setBounds(0, 0, background.getIconWidth(),
				background.getIconHeight());

		// ��������
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

		// ������ʼ���水ť
		for (int i = 0; i <= 2; i++) {
			imageButton[i] = new ImageButton(start1, start2, start3, false);
			imageButton[i].setLocation(530, 290 + (i) * 120);
			imageButton[i].setVisible(true);
			imageButton[i].setHorizontalTextPosition(JButton.CENTER);
			imageButton[i].setVerticalTextPosition(JButton.CENTER);
			imageButton[i].setFont(new Font("΢���ź�", Font.BOLD, 20));
			imagePanel.add(imageButton[i]);
		}
		imageButton[0].setText("��ʼ��Ϸ");

		imageButton[1].setText("������Ա");

		imageButton[2].setText("�˳���Ϸ");

		// ����ʱ���ǩ
		timeLabel = new JLabel(message);
		timeLabel.setBounds(1060, 20, message.getIconWidth(),
				message.getIconHeight());
		frontPanel.add(timeLabel);
		timeLabel.setVisible(false);

		// ������ͣ��ť
		pauseButton = new ImageButton(pause1, pause2, pause3, false);
		pauseButton.setLocation(50, 20);
		frontPanel.add(pauseButton);
		pauseButton.setVisible(false);

		// ��������ͼƬ
		backgroundMain = new ImageIcon("image/planet.png");
		backgroundMain.setImage(backgroundMain.getImage().getScaledInstance(
				600, 600, Image.SCALE_DEFAULT));
		mainPanel = new JPanel();
		JLabel labelBackground = new JLabel(backgroundMain);// �ѱ���ͼƬ��ʾ��һ����ǩ����
		labelBackground.setBounds(0, 0, backgroundMain.getIconWidth(),
				backgroundMain.getIconHeight());
		mainPanel.setOpaque(false);
		mainPanel.setBounds(360, 30, backgroundMain.getIconWidth(),
				backgroundMain.getIconHeight());
		mainPanel.add(labelBackground);
		imagePanel.add(mainPanel);
		
		//�����������
		topPanel = new TopPanel();
		topPanel.setVisible(false);
		frontPanel.add(topPanel, -1);

		// �����ײ���尴ť
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
			bottombottons[i].setFont(new Font("΢���ź�", Font.BOLD, 20));
		}
		bottombottons[0].setText("ѧ��");

		bottombottons[1].setText("�Ƽ�");

		bottombottons[2].setText("����");
		for (ImageButton im : bottombottons) {
			frontPanel.add(im, 0);
			im.setVisible(false);
		}

		// �����غϰ�ť
		roundButton = new ImageButton(roundIcon1, roundIcon2, roundIcon3, false);
		roundButton.setLocation(1100, 620);
		frontPanel.add(roundButton);
		roundButton.setVisible(false);

		// ����ѧ�����
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

		// �����Ƽ����
		tecPanel = new TecPanel(backgroundTec);
		tecPanel.setVisible(false);
		frontPanel.add(tecPanel, 0);
		
//		�����������
		objectPanel=new ObjectPanel(objectBackground);
		objectPanel.setVisible(false);
		frontPanel.add(objectPanel,0);
		// ��ť����
		imageButton[0].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������

				
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
				// TODO �Զ����ɵķ������

			}
		});
		imageButton[2].addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO �Զ����ɵķ������
				dispose();
			}
		});
		bottombottons[0].addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				int i[] = {Sci.chemistry.point,Sci.biology.point,Sci.physics.point,
						Sci.math.point,Sci.computer.point,Sci.art.point};
				sciPanel.setpoints(i);
				sciPanel.pointsavailable.setText("�ɷ���ѧ�Ƶ㣺" + Begin.HP);
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
				// TODO �Զ����ɵķ������
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
				topPanel.topLabel.setText("�������ԣ�"+Begin.EV);
			}
		});		

		// �������
		String url = "image/cursor.gif"; // �������ͼƬ��λ��
		Toolkit tk = Toolkit.getDefaultToolkit();
		Image image = new ImageIcon(url).getImage();
		Cursor cursor = tk.createCustomCursor(image, new Point(0, 0), "invisi");
		setCursor(cursor); // panel Ҳ�������������
		
		//��ȡ�������
		addMouseMotionListener(new MouseMotionListener() {
			
			@Override
			public void mouseMoved(MouseEvent e) {
				// TODO �Զ����ɵķ������
				x = e.getX();
				y = e.getY();
			}
			
			@Override
			public void mouseDragged(MouseEvent e) {
				// TODO �Զ����ɵķ������				
			}
		});

		imagePanel.add(label);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(background.getIconWidth(), background.getIconHeight());
		this.setUndecorated(true);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
		
		//������Ϣ���
		messageLabel = new MessageLabel();
		messageLabel.setVisible(false);
		frontPanel.add(messageLabel,0);
		for(final ImageButton im : tecPanel.tecButton) {
			im.addMouseListener(new MouseListener() {
				
				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO �Զ����ɵķ������
					
				}
				
				@Override
				public void mousePressed(MouseEvent e) {
					// TODO �Զ����ɵķ������
					
				}
				
				@Override
				public void mouseExited(MouseEvent e) {
					// TODO �Զ����ɵķ������
					messageLabel.setVisible(false);
				}
				
				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO �Զ����ɵķ������

					messageLabel.setLocation(GameWindow.x, GameWindow.y);
					messageLabel.setVisible(true);
				}
				
				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO �Զ����ɵķ������
					
				}
			});
		}

	}

}

