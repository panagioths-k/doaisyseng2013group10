import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.*;

public class ChessBoard extends JFrame {

	private JPanel mainPanel;
	private BoardPanel boardPanel;
	private JPanel buttonPanel;
	private JButton resultButton;
	
	
	private JLabel diceResult;
	//για να εμφανίζεται πρόχειρα για αρχή ο random αριθμός
	private Random r;
	private int playerX;
	//συντεταγμένη Χ για το πιόνι
	private int playerY;
	//συνταταγμένη Υ για το πιόνι
	private int size;
	//η πλευρά του τετραγώνου κάθε φορά
	private ArrayList<Square> turnSteps;
	//κρατάει τα τετράγωνα στα οποία έχει πατήσει ο παίχτης στην σειρά του
	private int totalMoves;
	//μερτητής για να αποθηκεύεται ο αριθμός κινήσεων που έχει γίνει ήδη
	
	public ChessBoard() {
		playerX=0;
		playerY=0;
		
		mainPanel = new JPanel();
		boardPanel = new BoardPanel();
		buttonPanel = new JPanel();
		resultButton = new JButton("Roll");
		diceResult=new JLabel();
		
		BorderLayout layout = new BorderLayout();
		mainPanel.setLayout(layout);
		
		buttonPanel.add(resultButton);
		buttonPanel.add(diceResult);
		
		
		mainPanel.add(boardPanel, BorderLayout.CENTER);
		mainPanel.add(buttonPanel, BorderLayout.SOUTH);
		
		this.setContentPane(mainPanel);
		
		ButtonListener listener = new ButtonListener();
		resultButton.addActionListener(listener);
				
		MouseClickListener mlistener = new MouseClickListener();
		boardPanel.addMouseListener(mlistener);
		
		r=new Random(System.currentTimeMillis());
		//δημιουργία μήτρας τυχαίων αριθμών
		
		this.setVisible(true);
		this.setSize(500, 500);
		this.setTitle("ChessBoard");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class BoardPanel extends JPanel {
		
		private static final int ROWS = 8;
		private static final int COLUMNS = 8;
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
	
	
	class MouseClickListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			boolean found=false;
			//flag που δείχνει αν βρέθηκε το τετράγωνο στην λίστα
			int x = e.getX();
			int y = e.getY();
			//συντεταγμένες του κλικ
			
			
			if(turnSteps.size()>=totalMoves){
				System.out.println("Roll Again");
				//αν η λίστα με τα βήματα δεν είναι γεμάτη μόνο τότε κάνει επιπλέον κινήσεις
			}
			else{
			if ((x<(size*8))&&(y<(size*8))&&(x>(playerX+size))&&(y<(playerY+size))&&(y>playerY)){
				//επειδή εδώ το rows και το columns είναι 8 για αυτό πολλαπλασιάζω το 8 με το μέγεθος των τετραγώνων
				//για να μην μπορώ να κάνω κλικ εκτός του board
				playerX=playerX+size;
				}
			else if((x<(size*8))&&(y<(size*8))&&(x<playerX)&&(y<(playerY+size))&&(y>playerY)){
				playerX=playerX-size;	
			}
			else if ((x<(size*8))&&(y<(size*8))&&(y>(playerY+size))&&(x<(playerX+size))&&(x>playerX)){
				playerY=playerY+size;
			}
			else if ((x<(size*8))&&(y<(size*8))&&(y<playerY)&&(x<(playerX+size))&&(x>playerX)){
				playerY=playerY-size;
			}
			//κίνηση παίχτη ώστε να μπορεί να κινείται μόνο οριζόντια ή κάθετα και όχι διαγώνια
			//το πιόνι κινείται μόνο αν γίνει κλικ στο επόμενο (ή κάποιο πιο μακρινό τετράγωνο) προς την ίδια κατεύθυνση
			//το πιόνι κάθε φορά κεντράει και καταλαμβάνει όλο το τετράγωνο
			
			
			
			Square sq=new Square(playerX,playerY);
			//δημιουργία αντικειμένου τετραγώνου
			
			if (turnSteps.isEmpty()){
				//αν η λίστα είναι άδεια το τετράγωνο μπαίνει χωρίς έλεγχο
				turnSteps.add(sq);
				sq.printSquare();
				}
			else{
				for(Square s: turnSteps){
					//έλεγχος αν υπάρχει τετράγωνο με τις ίδιες συνταταγμένες
					if((s.getCorrX()==sq.getCorrX())&&(s.getCorrY()==sq.getCorrY())){
						System.out.println("Dialekse allo tetragwno");
						//τυπώνεται για έλεγχο
						found=true;
					}
				}
				
				if (!found){
					turnSteps.add(sq);
					sq.printSquare();
			//δημιουργία αντικειμένου τετραγώνου και προσθήκη του στην λίστα με όσα έχει περάσει ο παίχτης
					
					
				}
				
				
				}
					
			boardPanel.setXYCoordinates(playerX, playerY);
			
			if (!found)			
			boardPanel.repaint();	
			//αν το τετράγωνο δεν υπάρχει στην λίστα τοτε και μονο τότε κάνε repaint
		}}
		
		public void mousePressed(MouseEvent e) {
			
			
		}
		
		public void mouseReleased(MouseEvent e) {
			
		}
		
		public void mouseEntered(MouseEvent e) {
			
		}
		
		public void mouseExited(MouseEvent e) {
			
		}
	}
	
	class ButtonListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) {
			
			turnSteps=new ArrayList<Square>();
			//σε κάθε ζαριά δημιουργείται μία καινούρια arraylist για να αποθηκεύει τις κινήσεις
			int dice=r.nextInt(6)+1;
			
			totalMoves=dice;
			//μετρητής κινήσεων
			
			String result=Integer.toString(dice);
			diceResult.setText(result);
			System.out.println(dice);
			//πρόχειρος έλεγχος στην κονσόλα
			
			
				
		}
	}
}








