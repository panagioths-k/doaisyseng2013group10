import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Board extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JButton diceButton;
	private JButton coinButton;
	private JLabel heroLabel;
	private JLabel monsterLabel;
	private JTextArea heroStatLabel;
	private JTextArea monsterStatLabel;
	private JLabel backLabel;
	private Random r;
	private JPanel mainPanel;
	private User xristis;
	private MyGlassPane myGlassPane;
	private int row, size;
	private int playerX;
	private int playerY;
	
	public Board(User user){
		xristis = user;
		row=1;
		playerX=0;
		playerY=0;
		
		myGlassPane=new MyGlassPane();
		this.setGlassPane(myGlassPane);
		myGlassPane.setVisible(true);
		
		setBounds(100, 100, 1800, 1000);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		diceButton=new JButton("Roll");
		diceButton.setBounds(1502,200, 298, 50);
		//diceButton.setBackground(Color.BLACK);
		diceButton.setForeground(Color.RED);
		mainPanel.add(diceButton);
		
		coinButton=new JButton("Flip");
		coinButton.setBounds(1200,200, 300, 50);
		//coinButton.setBackground(Color.BLACK);
		coinButton.setForeground(Color.RED);
		mainPanel.add(coinButton);
		
		ButtonListener listener = new ButtonListener();
		coinButton.addActionListener(listener);
		diceButton.addActionListener(listener);
		//dokimastikoi listener
		
		ImageIcon  heroIcon=new  ImageIcon("hero.jpg");
		Image heroImage=heroIcon.getImage();
		heroLabel=new JLabel();
		heroLabel.setBounds(1200,300,300,300);
		Image heroResizedImage = heroImage.getScaledInstance(heroLabel.getWidth(), heroLabel.getHeight(), 0);
		heroLabel.setIcon(new ImageIcon(heroResizedImage));
		
		mainPanel.add(heroLabel);
		//gia thn eikona tou hrwa
		
		
		ImageIcon  monsterIcon=new  ImageIcon("Cerberus.jpg");
		Image monsterImage=monsterIcon.getImage();
		monsterLabel=new JLabel();
		monsterLabel.setBounds(1200,600,300,300);
		Image monsterResizedImage = monsterImage.getScaledInstance(monsterLabel.getWidth(), monsterLabel.getHeight(), 0);
		monsterLabel.setIcon(new ImageIcon(monsterResizedImage));
		
		mainPanel.add(monsterLabel);
		//gia thn eikona tou antipalou
		
		heroStatLabel=new JTextArea();
		heroStatLabel.setFont(new Font("Times New Roman",Font.BOLD,32));
		heroStatLabel.setForeground(Color.WHITE);
		heroStatLabel.setText("Skills \n Life:10 \n Damage: 50");
		heroStatLabel.setBounds(1500,300,300,300);
		heroStatLabel.setBackground(Color.BLACK);
		heroStatLabel.setEditable(false);
		//gia na min allazei
		mainPanel.add(heroStatLabel);
		//gia to label me ta statistika tou hrwa
		
		monsterStatLabel=new JTextArea();
		monsterStatLabel.setFont(new Font("Times New Roman",Font.BOLD,32));
		monsterStatLabel.setForeground(Color.WHITE);
		monsterStatLabel.setText("Skills \n Life:10 \n Damage: 50");
		monsterStatLabel.setBounds(1500,600,300,300);
		monsterStatLabel.setBackground(Color.BLACK);
		monsterStatLabel.setEditable(false);
		mainPanel.add(monsterStatLabel);
		//gia to label me ta statistika tou teratos
		
		ImageIcon  background=new  ImageIcon("background.jpg");
		Image image=background.getImage();
		backLabel=new JLabel();
		backLabel.setBounds(0,0,this.getWidth(), this.getHeight());
		Image resizedImage = image.getScaledInstance(backLabel.getWidth(), backLabel.getHeight(), 0);
		backLabel.setIcon(new ImageIcon(resizedImage));
		//prosarmogh eikonas fontou
		
		
		
		mainPanel.add(backLabel);
		r=new Random(System.currentTimeMillis());
		//this.setContentPane(mainPanel);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(1760,1000);
		this.setVisible(true);
	}
	
	class MyGlassPane extends JComponent{
		private static final int ROWS =6;
		private static final int COLUMNS =6;
		//ενδεικτικά μεγέθη διαίρεσης τετραγώνων του board
		
		private int xCoord = 0;
		private int yCoord = 0;
		//αρχικές συντεταγμένες
		
		public void setXYCoordinates(int xValue, int yValue) {
			//μεθοδος καθορισμού συντεταγμένων
			xCoord = xValue;
			yCoord = yValue;
		}
		
		public void paintComponent(Graphics g) {
			//επικάλυψη της paintcomponent
			super.paintComponent(g);
			
			int sqSize = this.getHeight() / ROWS;
			size=sqSize;
			//για να αλλάζει το μέγεθος των γραμμών ανάλογα με το παράθυρο
			
			for(int i=0; i<ROWS; i++) {
				for(int j=0; j<COLUMNS; j++) {
					int x = j * sqSize;
					int y = i * sqSize;
					g.setColor(Color.YELLOW);
					g.drawRect(x, y, sqSize, sqSize);
					
				}
			}
			
			g.setColor(Color.RED);
			g.fillOval(xCoord, yCoord, sqSize, sqSize);
			//αν αλλάξει το παράθυρο αφού έχουν γίνει κάποιες κινήσεις το πιόνι χάνει την στοίχισή του μέσα
			//στο τετράγωνο... χρειάζεται άλλη μία repaint όταν κάνουμε resize το παράθυρο... ή να είναι fix
			//το μέγεθός του...
			
		}
		
	}
	
class ButtonListener implements ActionListener {
		int dice;
		public void actionPerformed(ActionEvent e) {
			
			
			dice=r.nextInt(6)+1;
			//zari kinhsewn
			System.out.println("zari "+dice);
			moveChar(getDice());
			myGlassPane.setXYCoordinates(playerX, playerY);
			myGlassPane.repaint();
		}
		public int getDice(){
			return dice;
		}
		public void moveChar(int dice){
			for (int i=0;i<dice;i++){
				if (row % 2==0){
					playerX=playerX-size;
					if((playerX)<0){
						if(row!=6){
						playerY=playerY+size;
						row++;
						//allagh seiras an to pioni feygei eksw apo to tamplo
						playerX=playerX+size;
						}
						else{
							
							i=dice;
							playerX=0;
							playerY=playerY;
							JOptionPane.showMessageDialog(null, "End of Stage");
						}
							
					}
					//kinish aristera
				}
				else{
					playerX=playerX+size;
					if (playerX+size>(6*size)){
						playerY=playerY+size;
						row++;
						//allagh seiras an to pioni feygei eksw apo to tamplo
						playerX=playerX-size;
					}
				//kinish deksia
				}
			}
			
		}
	}	
}
