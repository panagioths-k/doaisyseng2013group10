import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;


public class PicsHerosFrame extends JFrame{
	
	private JLabel photo1;
	private JLabel photo2;
	private JLabel photo3;
	
	private JTextArea nameArea;
	
	private JButton commitBt;
	private JLabel backlbl;
	
	private JPanel mainPanel;
	
	private PicsHerosHeroManager heroManager;
	private PicsHerosHero anyHero;
	
	private myButtonListener buttonListener;
	
	
	public PicsHerosFrame(PicsHerosHeroManager heroManager){
		super("3 photos 1 Hero");
		
		this.heroManager=heroManager;
		heroManager.createHeroList();
		//dhmiourgoume prwta thn lista hrwwn
		
		this.setSize(900, 680);
		//mpainei prin ta setBounds gia na doulepsei to this
		
		setBounds(100, 100,this.getWidth(), this.getHeight());
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
			
		anyHero = this.heroManager.getHero();
				
		photo1=new JLabel();
		photo1.setBounds(50,200,250,250);
		mainPanel.add(photo1);
				
		photo2=new JLabel();
		photo2.setBounds(310,200,250,250);
		mainPanel.add(photo2);
		
		photo3=new JLabel();
		photo3.setBounds(570,200,250,250);
		mainPanel.add(photo3);
				
		commitBt=new JButton("The pics are about...");
		commitBt.setBounds(200,500,150,30);
		
		buttonListener=new myButtonListener();
		commitBt.addActionListener(buttonListener);
		
		mainPanel.add(commitBt);
			
		nameArea=new JTextArea();
		nameArea.setBounds(350,500,300,30);
		nameArea.setBackground(Color.ORANGE);
		nameArea.setEditable(true);
		mainPanel.add(nameArea);
		//kataskeyh stoixeiwn parathyrou
		
		ImageIcon  background=new  ImageIcon("olympus.jpg");
		Image image=background.getImage();
		backlbl=new JLabel();
		backlbl.setBounds(0,0,this.getWidth(), this.getHeight());
		Image resizedImage = image.getScaledInstance(backlbl.getWidth(), backlbl.getHeight(), 0);
		backlbl.setIcon(new ImageIcon(resizedImage));
		//prosarmogh eikonas fontou
		mainPanel.add(backlbl);
		
		getNextHero();
		//yparxei gia na exoume enan arxiko hrwa alliws bgazei keno
				
		this.setResizable(false);
		//den epitrepei allagh megethous sto parathyro
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	
	public void getNextHero(){
		anyHero = this.heroManager.getHero();
		
		ImageIcon  icon1=anyHero.getIcon(0);
		Image image1=icon1.getImage();
		Image resizedImage1 = image1.getScaledInstance(photo1.getWidth(), photo1.getHeight(), 0);
		photo1.setIcon(new ImageIcon(resizedImage1));
			
		ImageIcon  icon2=anyHero.getIcon(1);
		Image image2=icon2.getImage();
		Image resizedImage2 = image2.getScaledInstance(photo2.getWidth(), photo2.getHeight(), 0);
		photo2.setIcon(new ImageIcon(resizedImage2));
		
		ImageIcon  icon3=anyHero.getIcon(2);
		Image image3=icon3.getImage();
		Image resizedImage3 = image3.getScaledInstance(photo3.getWidth(), photo3.getHeight(), 0);
		photo3.setIcon(new ImageIcon(resizedImage3));
		//prosarmogh eikonwn sta label
		
		System.out.println(anyHero.getName());
		//yparxei boithitika gia na fainetai to onoma
		
		nameArea.setText("");
		//katharizei to textArea
		
	}
	
	public class myButtonListener implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			String answer;
			answer=nameArea.getText();
			if(answer.length()!=0){
				//an den einai keno to onoma elegxoume an einai idio me ayto tou hrwa
				//h toUpperCase opws kai na grapsoume to onoma mikra kefalaia ktl ta metatrepei se
				//kefalaia na ta sygkrinei
				if((anyHero.getName()).equals(answer.toUpperCase().trim())) 
					getNextHero();
				else
					JOptionPane.showMessageDialog(null,"Wrong");
			}
			else
				JOptionPane.showMessageDialog(null,"You Have To Give A Name");
			
		}
		
	}
	

}
