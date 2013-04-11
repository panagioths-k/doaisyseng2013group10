import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

public class Board extends JFrame{
	
	private static final long serialVersionUID = 1L;
	private JButton diceButton;
	private JButton coinButton;
	private JLabel hero1Label;
	private JLabel hero2Label;
	private JTextArea hero1StatLabel;
	private JTextArea hero2StatLabel;
	private JLabel backLabel;
	private Random r;
	private JPanel mainPanel;
	private User xristis;
	private MyGlassPane myGlassPane;
	private int row, size;
	private int playerX;
	private int playerY;
	private int widthSize;
	private int heightSize;
	
	public Board(User user){
		xristis = user;
		row=1;
		playerX=0;
		playerY=0;
		
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double fwidth = screenSize.getWidth();
		double fheight = screenSize.getHeight();
		
		int iwidth=(int)fwidth;
		int iheight=(int)fheight;
		
		widthSize=iwidth/20;
		heightSize=iheight/10;
		
		myGlassPane=new MyGlassPane();
		this.setGlassPane(myGlassPane);
		myGlassPane.setVisible(true);
		
		setBounds(100, 100, iwidth, iheight);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		diceButton=new JButton("Roll");
		diceButton.setBounds((16*widthSize),(2*heightSize),(3*widthSize),(heightSize/2));
		//diceButton.setBackground(Color.BLACK);
		diceButton.setForeground(Color.RED);
		mainPanel.add(diceButton);
		
		coinButton=new JButton("Flip");
		coinButton.setBounds((13*widthSize),(2*heightSize),(3*widthSize),(heightSize/2));
		//coinButton.setBackground(Color.BLACK);
		coinButton.setForeground(Color.RED);
		mainPanel.add(coinButton);
		
		ButtonListener listener = new ButtonListener();
		coinButton.addActionListener(listener);
		diceButton.addActionListener(listener);
		//dokimastikoi listener
		
		ImageIcon  hero1Icon=new  ImageIcon("hero_pick_1.jpg");
		Image hero1Image=hero1Icon.getImage();
		hero1Label=new JLabel();
		hero1Label.setBounds((13*widthSize),(4*heightSize),(3*widthSize),(3*heightSize));
		Image hero1ResizedImage = hero1Image.getScaledInstance(hero1Label.getWidth(), hero1Label.getHeight(), 0);
		hero1Label.setIcon(new ImageIcon(hero1ResizedImage));
		
		mainPanel.add(hero1Label);
		//gia thn eikona tou hrwa
		
		
		ImageIcon  hero2Icon=new  ImageIcon("hero_pick_2.jpg");
		Image hero2Image=hero2Icon.getImage();
		hero2Label=new JLabel();
		hero2Label.setBounds((13*widthSize),(7*heightSize),(3*widthSize),(3*heightSize));
		Image hero2ResizedImage = hero2Image.getScaledInstance(hero2Label.getWidth(), hero2Label.getHeight(), 0);
		hero2Label.setIcon(new ImageIcon(hero2ResizedImage));
		
		mainPanel.add(hero2Label);
		//gia thn eikona tou antipalou
		
		hero1StatLabel=new JTextArea();
		hero1StatLabel.setFont(new Font("Times New Roman",Font.BOLD,32));
		hero1StatLabel.setForeground(Color.WHITE);
		hero1StatLabel.setText("Skills \n Life:10 \n Damage: 50");
		hero1StatLabel.setBounds((16*widthSize),(4*heightSize),(3*widthSize),(3*heightSize));
		hero1StatLabel.setBackground(Color.BLACK);
		hero1StatLabel.setEditable(false);
		//gia na min allazei
		mainPanel.add(hero1StatLabel);
		//gia to label me ta statistika tou hrwa
		
		hero2StatLabel=new JTextArea();
		hero2StatLabel.setFont(new Font("Times New Roman",Font.BOLD,32));
		hero2StatLabel.setForeground(Color.WHITE);
		hero2StatLabel.setText("Skills \n Life:10 \n Damage: 50");
		hero2StatLabel.setBounds((16*widthSize),(7*heightSize),(3*widthSize),(3*heightSize));
		hero2StatLabel.setBackground(Color.BLACK);
		hero2StatLabel.setEditable(false);
		mainPanel.add(hero2StatLabel);
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
		this.setUndecorated(true);
		this.setLocation(0,0);
		this.setSize(iwidth,iheight);
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
