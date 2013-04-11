import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.util.Random;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class Board extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JButton diceButton, coinButton, piso, quit;
	private JLabel title, imageLabel, attack, defence,life;
	private Random r;
	private JPanel buttonPanel, imagePanel, quitPanel;
	private User xristis;
	private MyGlassPane myGlassPane;
	private int row, size, playerX, playerY, widthSize, heightSize;
	private BackgroundPanel back;
	private Image background, hero, resize;
	private Clip clip;
	private AudioInputStream audio;
	private Pick_A_Hero pick;
	private ButtonListener listener;
	private ImageIcon image;
	
	public Board(User user, ImageIcon heroimage){
		xristis = user;
		image = heroimage;
		row = 1;
		playerX = 0;
		playerY = 0;
		
		try {
			background = ImageIO.read(new File("background.jpg"));
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
		
		listener = new ButtonListener();
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double fwidth = screenSize.getWidth();
		double fheight = screenSize.getHeight();
		int iwidth = (int)fwidth;
		int iheight = (int)fheight;
		widthSize = iwidth / 7;
		heightSize = iheight / 3;
		
		//
		title = new JLabel("\u03A4\u03B1\u03BC\u03C0\u03BB\u03CC");
		title.setFont(new Font("Sylfaen", Font.PLAIN, 40));
		title.setHorizontalAlignment(SwingConstants.CENTER);
		back.add(title, BorderLayout.NORTH);
		
		myGlassPane = new MyGlassPane();
		this.setGlassPane(myGlassPane);
		myGlassPane.setVisible(true);
		back.add(myGlassPane, BorderLayout.CENTER);
		
		//
		buttonPanel = new JPanel();
		back.add(buttonPanel, BorderLayout.WEST);
		GridBagLayout gbl_buttonPanel = new GridBagLayout();
		gbl_buttonPanel.rowHeights = new int[] {10, 10};
		gbl_buttonPanel.columnWidths = new int[] {10, 10};
		buttonPanel.setLayout(gbl_buttonPanel);
		
		diceButton = new JButton("\u0396\u03AC\u03C1\u03B9");
		diceButton.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_diceButton = new GridBagConstraints();
		gbc_diceButton.fill = GridBagConstraints.BOTH;
		gbc_diceButton.insets = new Insets(0, 0, 0, 5);
		gbc_diceButton.gridx = 0;
		gbc_diceButton.gridy = 0;
		buttonPanel.add(diceButton, gbc_diceButton);
		diceButton.addActionListener(listener);
		
		coinButton = new JButton("\u039A\u03AD\u03C1\u03BC\u03B1");
		coinButton.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		GridBagConstraints gbc_coinButton = new GridBagConstraints();
		gbc_coinButton.fill = GridBagConstraints.BOTH;
		gbc_coinButton.gridx = 0;
		gbc_coinButton.gridy = 3;
		buttonPanel.add(coinButton, gbc_coinButton);
		coinButton.addActionListener(listener);
		
		imagePanel = new JPanel();
		back.add(imagePanel, BorderLayout.EAST);
		GridBagLayout gbl_imagePanel = new GridBagLayout();
		imagePanel.setLayout(gbl_imagePanel);
		
		imageLabel = new JLabel("");
		hero = image.getImage();
		resize = hero.getScaledInstance(widthSize, heightSize, 0);
		imageLabel.setIcon(new ImageIcon(resize));
		GridBagConstraints gbc_imageLabel = new GridBagConstraints();
		gbc_imageLabel.insets = new Insets(0, 0, 0, 5);
		gbc_imageLabel.gridx = 0;
		gbc_imageLabel.gridy = 0;
		imagePanel.add(imageLabel, gbc_imageLabel);
		
		attack = new JLabel("\u0388\u03C0\u03AF\u03B8\u03B5\u03C3\u03B7: "+user.getAttack());
		attack.setForeground(Color.ORANGE);
		attack.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_attack = new GridBagConstraints();
		gbc_attack.insets = new Insets(0, 0, 0, 5);
		gbc_attack.gridx = 0;
		gbc_attack.gridy = 1;
		imagePanel.add(attack, gbc_attack);
		
		defence = new JLabel("\u0386\u03BC\u03C5\u03BD\u03B1: "+user.getDefence());
		defence.setForeground(Color.ORANGE);
		defence.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_defence = new GridBagConstraints();
		gbc_defence.insets = new Insets(0, 0, 0, 5);
		gbc_defence.gridx = 0;
		gbc_defence.gridy = 2;
		imagePanel.add(defence, gbc_defence);
		
		life = new JLabel("\u0396\u03C9\u03AE: "+user.getHealth());
		life.setForeground(Color.ORANGE);
		life.setFont(new Font("Sylfaen", Font.BOLD, 20));
		GridBagConstraints gbc_life = new GridBagConstraints();
		gbc_life.gridx = 0;
		gbc_life.gridy = 3;
		imagePanel.add(life, gbc_life);
		
		r = new Random(System.currentTimeMillis());
		
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
				Board.this.setVisible(false);
				pick = new Pick_A_Hero(xristis);
				pick.setVisible(true);
			}
		});
		piso.setFont(new Font("Sylfaen", Font.PLAIN, 20));
		quitPanel.add(piso, BorderLayout.WEST);
		quitPanel.add(quit, BorderLayout.EAST);
		back.add(quitPanel, BorderLayout.SOUTH);
	}
	
	@SuppressWarnings("serial")
	class MyGlassPane extends JComponent{
		private static final int ROWS = 6;
		private static final int COLUMNS = 6;
		private int xCoord = 0;
		private int yCoord = 0;
		
		public void setXYCoordinates(int xValue, int yValue) {
			xCoord = xValue;
			yCoord = yValue;
		}
		
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			int sqSize = this.getHeight() / ROWS;
			size = sqSize;
			
			for(int i = 0; i < ROWS; i++) {
				for(int j = 0; j < COLUMNS; j++) {
					int x = j * sqSize;
					int y = i * sqSize;
					g.setColor(Color.YELLOW);
					g.drawRect(x, y, sqSize, sqSize);
				}
			}
			
			g.setColor(Color.RED);
			g.fillOval(xCoord, yCoord, sqSize, sqSize);
		}	
	}
	
class ButtonListener implements ActionListener {
		int diceButton;
		
		public void actionPerformed(ActionEvent e) {
			diceButton = r.nextInt(6) + 1;
			System.out.println("zari "+diceButton);
			moveChar(getDice());
			myGlassPane.setXYCoordinates(playerX, playerY);
			myGlassPane.repaint();
		}
		
		public int getDice(){
			return diceButton;
		}
		
		public void moveChar(int dice){
			for (int i = 0; i < dice; i++)
			{
				if (row % 2 == 0)
				{
					playerX -= size;
					if(playerX < 0)
					{
						if(row != 6)
						{
						playerY += size;
						row++;
						playerX += size;
						}
						else
						{
							i = dice;
							playerX = 0;
							playerY = playerY;
							JOptionPane.showMessageDialog(null, "End of Stage");
						}	
					}
				}
				else
				{
					playerX = playerX + size;
					if (playerX + size > (6 * size))
					{
						playerY += size;
						row++;
						playerX -= size;
					}
				}
			}
		}
	}	
}
