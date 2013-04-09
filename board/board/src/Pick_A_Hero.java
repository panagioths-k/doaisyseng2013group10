import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import java.awt.Cursor;

public class Pick_A_Hero extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel helpPanel, quitPanel;
	private Name_Frame name;
	private Board pista;
	private User xristis, xristis2;
	private Image background;
	private BackgroundPanel back;
	private JLabel title, pl1, pl2, pl3, pl4, pl5, pl6, lab1, lab2, lab3, lab4, lab5, lab6, align;
	private JButton quit, piso, play;
	private Clip clip;
	private AudioInputStream audio;
	private ImageIcon help;
	private Image help2;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Name_Frame frame = new Name_Frame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * @wbp.parser.constructor
	 */
	public Pick_A_Hero(User user) {
		xristis = user;
		try {
			background = ImageIO.read(new File("start.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		back = new BackgroundPanel(background);
		back.setTransparentAdd(true);
		setContentPane(back);
		back.setLayout(new BorderLayout(5, 5));
		
		try{
			audio = AudioSystem.getAudioInputStream(new File("battle_theme.wav").getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audio);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		//
		title = new JLabel("\u0394\u03B9\u03AC\u03BB\u03B5\u03BE\u03B5 \u03AE\u03C1\u03C9\u03B1");
		title.setFont(new Font("Sylfaen", Font.PLAIN, 40));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		back.add(title, BorderLayout.NORTH);
		
		//
		helpPanel = new JPanel();
		helpPanel.setBorder(new EmptyBorder(50, 200, 50, 200));
		back.add(helpPanel, BorderLayout.CENTER);
		helpPanel.setLayout(new GridLayout(5, 3, 10, 20));
		
		lab1 = new JLabel("Hero1");
		lab1.setHorizontalAlignment(SwingConstants.CENTER);
		lab1.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		helpPanel.add(lab1);
		
		lab2 = new JLabel("Hero2");
		lab2.setHorizontalAlignment(SwingConstants.CENTER);
		lab2.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		helpPanel.add(lab2);
		lab2.setLabelFor(pl2);
		
		lab3 = new JLabel("Hero3");
		lab3.setHorizontalAlignment(SwingConstants.CENTER);
		lab3.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		helpPanel.add(lab3);
		lab3.setLabelFor(pl3);
		
		pl1 = new JLabel("");
		pl1.setIcon(new ImageIcon("hero_pick_1.jpg"));
		pl1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helpPanel.add(pl1);
		
		pl2 = new JLabel("");
		pl2.setIcon(new ImageIcon("hero_pick_2.jpg"));
		pl2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helpPanel.add(pl2);
		
		pl3 = new JLabel("");
		pl3.setIcon(new ImageIcon("hero_pick_3.jpg"));
		pl3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helpPanel.add(pl3);
		
		lab4 = new JLabel("Hero4");
		lab4.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lab4.setHorizontalAlignment(SwingConstants.CENTER);
		helpPanel.add(lab4);
		
		lab5 = new JLabel("Hero5");
		lab5.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lab5.setHorizontalAlignment(SwingConstants.CENTER);
		helpPanel.add(lab5);
		
		lab6 = new JLabel("Hero6");
		lab6.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lab6.setHorizontalAlignment(SwingConstants.CENTER);
		helpPanel.add(lab6);
		
		pl4 = new JLabel("");
		pl4.setIcon(new ImageIcon("hero_pick_1.jpg"));
		pl4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helpPanel.add(pl4);
		
		pl5 = new JLabel("");
		pl5.setIcon(new ImageIcon("hero_pick_2.jpg"));
		pl5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helpPanel.add(pl5);
		
		pl6 = new JLabel("");
		pl6.setIcon(new ImageIcon("hero_pick_3.jpg"));
		pl6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helpPanel.add(pl6);
		
		align = new JLabel("");
		helpPanel.add(align);
		
		play = new JButton("\u03A0\u03B1\u03AF\u03BE\u03B5");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pick_A_Hero.this.setVisible(false);
				pista = new Board(xristis);
				pista.setVisible(true);
			}
		});
		play.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		helpPanel.add(play);
		
		//
		quitPanel = new JPanel();
		quit = new JButton("\u0388\u03BE\u03BF\u03B4\u03BF\u03C2");
		quit.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		quitPanel.setLayout(new BorderLayout(0, 0));
		
		piso = new JButton("\u03A0\u03AF\u03C3\u03C9");
		piso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clip.stop();
				Pick_A_Hero.this.setVisible(false);
				name = new Name_Frame();
				name.setVisible(true);
			}
		});
		piso.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		quitPanel.add(piso, BorderLayout.WEST);
		quitPanel.add(quit, BorderLayout.EAST);
		back.add(quitPanel, BorderLayout.SOUTH);
		
		Pick_A_Hero_Listener PHL = new Pick_A_Hero_Listener();
		pl1.addMouseListener(PHL);
		pl2.addMouseListener(PHL);
		pl3.addMouseListener(PHL);
		pl4.addMouseListener(PHL);
		pl5.addMouseListener(PHL);
		pl6.addMouseListener(PHL);
	}

	public Pick_A_Hero(User user, User user2) {
		xristis = user;
		xristis2 = user2;
		try {
			background = ImageIO.read(new File("start.jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		setUndecorated(true);
		back = new BackgroundPanel(background);
		back.setTransparentAdd(true);
		setContentPane(back);
		back.setLayout(new BorderLayout(5, 5));
		
		try{
			audio = AudioSystem.getAudioInputStream(new File("battle_theme.wav").getAbsoluteFile());
			clip = AudioSystem.getClip();
			clip.open(audio);
			clip.loop(Clip.LOOP_CONTINUOUSLY);
		}
		catch(Exception e){
			e.printStackTrace();
		}
		
		//
		title = new JLabel("\u0394\u03B9\u03AC\u03BB\u03B5\u03BE\u03B5 \u03AE\u03C1\u03C9\u03B1");
		title.setFont(new Font("Sylfaen", Font.PLAIN, 40));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		back.add(title, BorderLayout.NORTH);
		
		//
		helpPanel = new JPanel();
		helpPanel.setBorder(new EmptyBorder(50, 200, 50, 200));
		back.add(helpPanel, BorderLayout.CENTER);
		helpPanel.setLayout(new GridLayout(5, 3, 10, 20));
		
		lab1 = new JLabel("Hero1");
		lab1.setHorizontalAlignment(SwingConstants.CENTER);
		lab1.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		helpPanel.add(lab1);
		
		lab2 = new JLabel("Hero2");
		lab2.setHorizontalAlignment(SwingConstants.CENTER);
		lab2.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		helpPanel.add(lab2);
		lab2.setLabelFor(pl2);
		
		lab3 = new JLabel("Hero3");
		lab3.setHorizontalAlignment(SwingConstants.CENTER);
		lab3.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		helpPanel.add(lab3);
		lab3.setLabelFor(pl3);
		
		pl1 = new JLabel("");
		pl1.setIcon(new ImageIcon("hero_pick_1.jpg"));
		pl1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helpPanel.add(pl1);
		
		pl2 = new JLabel("");
		pl2.setIcon(new ImageIcon("hero_pick_2.jpg"));
		pl2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helpPanel.add(pl2);
		
		pl3 = new JLabel("");
		pl3.setIcon(new ImageIcon("hero_pick_3.jpg"));
		pl3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helpPanel.add(pl3);
		
		lab4 = new JLabel("Hero4");
		lab4.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lab4.setHorizontalAlignment(SwingConstants.CENTER);
		helpPanel.add(lab4);
		
		lab5 = new JLabel("Hero5");
		lab5.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lab5.setHorizontalAlignment(SwingConstants.CENTER);
		helpPanel.add(lab5);
		
		lab6 = new JLabel("Hero6");
		lab6.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		lab6.setHorizontalAlignment(SwingConstants.CENTER);
		helpPanel.add(lab6);
		
		pl4 = new JLabel("");
		pl4.setIcon(new ImageIcon("hero_pick_1.jpg"));
		pl4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helpPanel.add(pl4);
		
		pl5 = new JLabel("");
		pl5.setIcon(new ImageIcon("hero_pick_2.jpg"));
		pl5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helpPanel.add(pl5);
		
		pl6 = new JLabel("");
		pl6.setIcon(new ImageIcon("hero_pick_3.jpg"));
		pl6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		helpPanel.add(pl6);
		
		align = new JLabel("");
		helpPanel.add(align);
		
		play = new JButton("\u03A0\u03B1\u03AF\u03BE\u03B5");
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pick_A_Hero.this.setVisible(false);
				pista = new Board(xristis);
				pista.setVisible(true);
			}
		});
		play.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		helpPanel.add(play);
		
		//
		quitPanel = new JPanel();
		quit = new JButton("\u0388\u03BE\u03BF\u03B4\u03BF\u03C2");
		quit.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		quit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		quitPanel.setLayout(new BorderLayout(0, 0));
		
		piso = new JButton("\u03A0\u03AF\u03C3\u03C9");
		piso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				clip.stop();
				Pick_A_Hero.this.setVisible(false);
				name = new Name_Frame();
				name.setVisible(true);
			}
		});
		piso.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		quitPanel.add(piso, BorderLayout.WEST);
		quitPanel.add(quit, BorderLayout.EAST);
		back.add(quitPanel, BorderLayout.SOUTH);
		
		Pick_A_Hero_Listener PHL = new Pick_A_Hero_Listener();
		pl1.addMouseListener(PHL);
		pl2.addMouseListener(PHL);
		pl3.addMouseListener(PHL);
		pl4.addMouseListener(PHL);
		pl5.addMouseListener(PHL);
		pl6.addMouseListener(PHL);
	}
	
	class Pick_A_Hero_Listener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			if(e.getSource() == pl1){
				help = new ImageIcon("hero_pick_anim_1.gif"); 
				help2 = help.getImage().getScaledInstance(pl1.getWidth(), pl1.getHeight(), 0);
				pl1.setIcon(new ImageIcon(help2));
			}
			else if(e.getSource() == pl2){
				help = new ImageIcon("hero_pick_anim_2.gif"); 
				help2 = help.getImage().getScaledInstance(pl2.getWidth(), pl2.getHeight(), 0);
				pl2.setIcon(new ImageIcon(help2));
			}
			else if(e.getSource() == pl3){
				help = new ImageIcon("hero_pick_anim_3.gif"); 
				help2 = help.getImage().getScaledInstance(pl3.getWidth(), pl3.getHeight(), 0);
				pl3.setIcon(new ImageIcon(help2));
			}
			else if(e.getSource() == pl4){
				help = new ImageIcon("hero_pick_anim_1.gif"); 
				help2 = help.getImage().getScaledInstance(pl4.getWidth(), pl4.getHeight(), 0);
				pl4.setIcon(new ImageIcon(help2));
			}
			else if(e.getSource() == pl5){
				help = new ImageIcon("hero_pick_anim_2.gif"); 
				help2 = help.getImage().getScaledInstance(pl5.getWidth(), pl5.getHeight(), 0);
				pl5.setIcon(new ImageIcon(help2));
			}
			else if(e.getSource() == pl6){
				help = new ImageIcon("hero_pick_anim_3.gif"); 
				help2 = help.getImage().getScaledInstance(pl6.getWidth(), pl6.getHeight(), 0);
				pl6.setIcon(new ImageIcon(help2));
			}
		}

		@Override
		public void mouseExited(MouseEvent e) {
			if(e.getSource() == pl1){
				help = new ImageIcon("hero_pick_1.jpg"); 
				help2 = help.getImage().getScaledInstance(pl1.getWidth(), pl1.getHeight(), 0);
				pl1.setIcon(new ImageIcon(help2));
			}
			else if(e.getSource() == pl2){
				help = new ImageIcon("hero_pick_2.jpg"); 
				help2 = help.getImage().getScaledInstance(pl2.getWidth(), pl2.getHeight(), 0);
				pl2.setIcon(new ImageIcon(help2));
			}
			else if(e.getSource() == pl3){
				help = new ImageIcon("hero_pick_3.jpg"); 
				help2 = help.getImage().getScaledInstance(pl3.getWidth(), pl3.getHeight(), 0);
				pl3.setIcon(new ImageIcon(help2));
			}
			else if(e.getSource() == pl4){
				help = new ImageIcon("hero_pick_1.jpg"); 
				help2 = help.getImage().getScaledInstance(pl4.getWidth(), pl4.getHeight(), 0);
				pl4.setIcon(new ImageIcon(help2));
			}
			else if(e.getSource() == pl5){
				help = new ImageIcon("hero_pick_2.jpg"); 
				help2 = help.getImage().getScaledInstance(pl5.getWidth(), pl5.getHeight(), 0);
				pl5.setIcon(new ImageIcon(help2));
			}
			else if(e.getSource() == pl6){
				help = new ImageIcon("hero_pick_3.jpg"); 
				help2 = help.getImage().getScaledInstance(pl6.getWidth(), pl6.getHeight(), 0);
				pl6.setIcon(new ImageIcon(help2));
			}
		}

		@Override
		public void mousePressed(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}

		@Override
		public void mouseReleased(MouseEvent arg0) {
			// TODO Auto-generated method stub
		}	
	}
}