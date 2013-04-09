import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.text.Document;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.Color;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;

public class Name_Frame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JPanel helpPanel, quitPanel;
	private Pick_A_Hero hero;
	private User user, user2;
	private Start_Frame start;
	private Image background;
	private BackgroundPanel back;
	private JLabel title, label, player1, player2;
	private JButton play, quit, piso;
	private JTextField name1, name2;
	private Document doc, doc2;
	private Clip clip;
	private AudioInputStream audio;
	@SuppressWarnings("rawtypes")
	private JComboBox comboBox;
	private boolean flag;

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
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public Name_Frame() {
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
		title = new JLabel("\u03A1\u03C5\u03B8\u03BC\u03AF\u03C3\u03B5\u03B9\u03C2 \u03C0\u03B1\u03B9\u03C7\u03BD\u03B9\u03B4\u03B9\u03BF\u03CD");
		title.setFont(new Font("Sylfaen", Font.PLAIN, 40));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		back.add(title, BorderLayout.NORTH);
		
		//
		helpPanel = new JPanel();
		helpPanel.setBorder(new EmptyBorder(250, 500, 200, 500));
		back.add(helpPanel, BorderLayout.CENTER);
		helpPanel.setLayout(new GridLayout(4, 2, 0, 30));
		
		label = new JLabel("\u0391\u03C1\u03B9\u03B8\u03BC\u03CC\u03C2 \u03C0\u03B1\u03B9\u03C7\u03C4\u03CE\u03BD");
		label.setForeground(Color.ORANGE);
		label.setFont(new Font("Sylfaen", Font.BOLD, 20));
		helpPanel.add(label);
		
		flag = false;
		comboBox = new JComboBox();
		comboBox.setToolTipText("");
		comboBox.setMaximumRowCount(2);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (comboBox.getSelectedItem().equals("2"))
				{
					player2.setVisible(true);
					name2.setVisible(true);
					flag = true;
				}
				else
				{
					player2.setVisible(false);
					name2.setVisible(false);
				}
			}
		});
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"1", "2"}));
		helpPanel.add(comboBox);
		comboBox.setPreferredSize(new Dimension(10,10));
		
		player1 = new JLabel("\u03A0\u03B1\u03AF\u03BA\u03C4\u03B7\u03C2 1");
		player1.setForeground(Color.ORANGE);
		player1.setFont(new Font("Sylfaen", Font.BOLD, 20));
		helpPanel.add(player1);
		
		name1 = new JTextField();
		helpPanel.add(name1);
		name1.setColumns(10);
		
		player2 = new JLabel("\u03A0\u03B1\u03AF\u03BA\u03C4\u03B7\u03C2 2");
		player2.setForeground(Color.ORANGE);
		player2.setFont(new Font("Sylfaen", Font.BOLD, 20));
		helpPanel.add(player2);
		player2.setVisible(false);
		
		name2 = new JTextField();
		helpPanel.add(name2);
		name2.setColumns(10);
		name2.setVisible(false);
		play = new JButton("\u03A0\u03B1\u03AF\u03BE\u03B5");
		play.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		play.setEnabled(false);
		doc = name1.getDocument();
		doc2 = name2.getDocument();
		doc.addDocumentListener(new JButtonStateController(play));
		doc2.addDocumentListener(new JButtonStateController(play));
		play.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				clip.stop();
				user = new User(name1.getText());
				if (flag) 
				{
					user2 = new User(name2.getText());
					Name_Frame.this.setVisible(false);
					hero = new Pick_A_Hero(user, user2);
					hero.setVisible(true);
				}
				else
				{
					Name_Frame.this.setVisible(false);
					hero = new Pick_A_Hero(user);
					hero.setVisible(true);
				}
			}
		});
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
				Name_Frame.this.setVisible(false);
				start = new Start_Frame();
				start.setVisible(true);
			}
		});
		piso.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		quitPanel.add(piso, BorderLayout.WEST);
		quitPanel.add(quit, BorderLayout.EAST);
		back.add(quitPanel, BorderLayout.SOUTH);
	}
}

class JButtonStateController implements DocumentListener {
	 JButton button;
	  
	  JButtonStateController(JButton button) {
	     this.button = button ;
	  }

	  public void changedUpdate(DocumentEvent e) {
	    disableIfEmpty(e);
	  }

	  public void insertUpdate(DocumentEvent e) {
	    disableIfEmpty(e);
	  }

	  public void removeUpdate(DocumentEvent e) {
	    disableIfEmpty(e);
	  }

	  public void disableIfEmpty(DocumentEvent e) {
	    button.setEnabled(e.getDocument().getLength() >= 4 || e.getDocument().getLength() >= 8);
	  }
}
