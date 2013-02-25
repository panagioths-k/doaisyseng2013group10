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
	//gia na emfanizetai proxeira sthn arxh o random arithmos
	private Random r;
	private int playerX;
	//syntetagmenh X gia to pioni
	private int playerY;
	//syntetagmenh Y gia to pioni
	private int size;
	//h pleyra tou tetragwnou kathe fora
	private ArrayList<Square> turnSteps;
	//krataei ta tetragwna sta opoia exei pathsei o paixths sthn seira tou
	private int totalMoves;
	//metrhths gia na apothikeyestai o arithmos kinisewn pou exei ginei hdh
	
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
		//dhmiourgia mhtras tyxaiwn arithmwn
		
		this.setVisible(true);
		this.setSize(500, 500);
		this.setTitle("ChessBoard");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	class BoardPanel extends JPanel {
		
		private static final int ROWS = 8;
		private static final int COLUMNS = 8;
		//endeiktika megethi diaireshs tetragwnwn sto board
		
		private int xCoord = 0;
		private int yCoord = 0;
		//arxikes syntetagmenes
		
		public void setXYCoordinates(int xValue, int yValue) {
			//methodos kathorismou syntetagmenwn
			xCoord = xValue;
			yCoord = yValue;
		}
		
		public void paintComponent(Graphics g) {
			//epikalypsh ths paintcomponent
			super.paintComponent(g);
			
			int sqSize = this.getHeight() / ROWS;
			size=sqSize;
			//gia na allazei to megethos twn grammwn analoga me to parathyro
			
			for(int i=0; i<ROWS; i++) {
				for(int j=0; j<COLUMNS; j++) {
					int x = j * sqSize;
					int y = i * sqSize;
					g.drawRect(x, y, sqSize, sqSize);
					
				}
			}
			
			g.setColor(Color.RED);
			g.fillOval(xCoord, yCoord, sqSize, sqSize);
			//an allaksei to parathyro afou ginoun kapoies kiniseis to pioni xanei thn stoixish tou mesa sto
			//tetragwno...xreiazetai allh mia repaint otan kanoume resize to parathyro h na exei to parathyro
			//fix megethos
			
		}
		
		
	}
	
	
	class MouseClickListener implements MouseListener {
		public void mouseClicked(MouseEvent e) {
			boolean found=false;
			//flag pou deixnei an brethike to tetragwno sthn lista
			int x = e.getX();
			int y = e.getY();
			//syntetagmenes tou klik
			
			
			if(turnSteps.size()>=totalMoves){
				System.out.println("Roll Again");
				//an h lista me ta bhmata den einai gemath mono tote kanei tis epipleon kiniseis
			}
			else{
			if ((x<(size*8))&&(y<(size*8))&&(x>(playerX+size))&&(y<(playerY+size))&&(y>playerY)){
				//epeidi edw to megethos twn tetragwnwn einai 8 gia ayto pollaplasiazw me to 8 to size
				//gia na mhn mporw na kanw klik ektws tou board
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
			//kinhsh paixth gia na mporei na kineitai mono katheta h orizontia kai oxi diagwnia
			//to pioni kineitai mono an ginei klik sto epomeno (h kapoio pio makrino tetragwno) pros thn 
			//idia kateythynsh... to pioni kathe fora kentrarei kai katalambanei olo to tetragwno
					
			
			Square sq=new Square(playerX,playerY);
			//dhmiourgia antikeimenou Square
			
			if (turnSteps.isEmpty()){
				//an h lista einai adeia to tetragwno mpainei xwris elegxo
				turnSteps.add(sq);
				sq.printSquare();
				}
			else{
				for(Square s: turnSteps){
					//elegxos an yparxei tetragwno stis idies syntatagmenes
					if((s.getCorrX()==sq.getCorrX())&&(s.getCorrY()==sq.getCorrY())){
						System.out.println("Dialekse allo tetragwno");
						//typwnetai gia elegxo
						found=true;
					}
				}
				
				if (!found){
					turnSteps.add(sq);
					sq.printSquare();
			//dhmiourgia antikeimenou tetragwnou kai prosthiki tou sthn lista me osa exei perasei o paixths
					
					
				}
				
				
				}
					
			boardPanel.setXYCoordinates(playerX, playerY);
			
			if (!found)			
			boardPanel.repaint();	
			//an to tetragwno den yparxei sthn lista tote kai mono tote kane repaint
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
			//se kathe zaria dhmiourgeitai mia kainouria arraylist gia na apothikeyontai oi kiniseis
			//an den pathsoume roll prwta kai pame na kounisoume to pioni petaei nullpointerexception giati
			//den dimiourgeitai to arraylist... isws prepei na prosthesoume ena try catch
			int dice=r.nextInt(6)+1;
			
			totalMoves=dice;
			//metrhths kinhsewn
			
			String result=Integer.toString(dice);
			diceResult.setText(result);
			System.out.println(dice);
			//proxeiros elegxos sthn konsola
			
			
				
		}
	}
}








