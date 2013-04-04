import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JTextField;
import javax.swing.JTextArea;


public class Pick_A_Hero extends JFrame {

	private JPanel contentPane;
	private JLabel hero_pick_lbl_1;
	private JLabel hero_pick_lbl_2;
	private JLabel hero_pick_lbl_3;
	private JLabel hero_pick_lbl_4;
	private JLabel hero_pick_lbl_5;
	private JLabel hero_pick_lbl_6;
	private JLabel Anim_lbl;
	
	private Image back_anim_img;
	private ImageIcon back_anim_icon;
	private JLabel hero_name_lbl_2;
	private JLabel hero_name_lbl_3;
	private JLabel hero_name_lbl_4;
	private JLabel hero_name_lbl_5;
	private JLabel hero_name_lbl_6;

	private continueButtonListener contBtLst;
	
	

	public Pick_A_Hero() {
		
		
		contentPane = new JPanel();
		
		setContentPane(contentPane);
		contentPane.setLayout(null);

	
		back_anim_icon= new ImageIcon("fire.gif"); 
		
	
		
		                                           //This JLabel is hidden behind the backround image and when a hero is clicked
		Anim_lbl = new JLabel();                         //it receives the ImageIcon and the bounds are changing
		Anim_lbl.setBounds(495, 484, 179, 198);                                                  
		contentPane.add(Anim_lbl);
		
		
		hero_pick_lbl_1 = new JLabel();
		hero_pick_lbl_1.setBounds(10, 30, 179, 198);  
		ImageIcon heriIcon_1= new ImageIcon("hero_pick_1.jpg");   //heroIcon_1
		Image h_1 = heriIcon_1.getImage().getScaledInstance(hero_pick_lbl_1.getWidth(), hero_pick_lbl_1.getHeight(), 0);
		hero_pick_lbl_1.setIcon(new ImageIcon(h_1));
		hero_pick_lbl_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(hero_pick_lbl_1);
		
		
		
		hero_pick_lbl_2 = new JLabel();
		hero_pick_lbl_2.setBounds(247, 30, 179, 198);
		ImageIcon heriIcon_2= new ImageIcon("hero_pick_2.jpg");   //heroIcon_2
		Image h_2 = heriIcon_2.getImage().getScaledInstance(hero_pick_lbl_2.getWidth(), hero_pick_lbl_2.getHeight(), 0);
		hero_pick_lbl_2.setIcon(new ImageIcon(h_2));
		hero_pick_lbl_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(hero_pick_lbl_2);
		
		hero_pick_lbl_3 = new JLabel();
		hero_pick_lbl_3.setBounds(495, 30, 179, 198);
		ImageIcon heriIcon_3= new ImageIcon("hero_pick_3.jpg");   //heroIcon_3
		Image h_3 = heriIcon_3.getImage().getScaledInstance(hero_pick_lbl_3.getWidth(), hero_pick_lbl_3.getHeight(), 0);
		hero_pick_lbl_3.setIcon(new ImageIcon(h_3));
		hero_pick_lbl_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(hero_pick_lbl_3);
		
		hero_pick_lbl_4 = new JLabel("New label");
		hero_pick_lbl_4.setBounds(10, 260, 179, 198);
		hero_pick_lbl_4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(hero_pick_lbl_4);
		
		hero_pick_lbl_5 = new JLabel("New label");
		hero_pick_lbl_5.setBounds(247, 260, 179, 198);
		hero_pick_lbl_5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(hero_pick_lbl_5);
		
		hero_pick_lbl_6 = new JLabel("New label");
		hero_pick_lbl_6.setBounds(495, 260, 179, 198);
		hero_pick_lbl_6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(hero_pick_lbl_6);
		
		
		ImageIcon  heroIcon=new  ImageIcon("anim.gif");
		Image heroImage=heroIcon.getImage();
		
		
		JButton btnContinue = new JButton("Continue"); //button for after choise
		btnContinue.setBackground(Color.BLACK);
		btnContinue.setForeground(Color.WHITE);
		btnContinue.setFont(new Font("Snap ITC", Font.PLAIN, 17));
		btnContinue.setBounds(280, 618, 146, 44);
		
		contBtLst=new continueButtonListener();
		btnContinue.addActionListener(contBtLst);
		
		contentPane.add(btnContinue);
		ImageIcon  backimgIcon=new  ImageIcon("backimg.jpg");
		Image backImage=backimgIcon.getImage();
		
		JLabel hero_name_lbl_1 = new JLabel("Hero 1 name");
		hero_name_lbl_1.setForeground(Color.WHITE);
		hero_name_lbl_1.setFont(new Font("Algerian", Font.PLAIN, 13));
		hero_name_lbl_1.setBounds(10, 0, 179, 28);
		contentPane.add(hero_name_lbl_1);
		
		hero_name_lbl_2 = new JLabel("Hero 2 name");
		hero_name_lbl_2.setForeground(Color.WHITE);
		hero_name_lbl_2.setFont(new Font("Algerian", Font.PLAIN, 13));
		hero_name_lbl_2.setBounds(247, 0, 179, 28);
		contentPane.add(hero_name_lbl_2);
		
		hero_name_lbl_3 = new JLabel("Hero 3 name");
		hero_name_lbl_3.setForeground(Color.WHITE);
		hero_name_lbl_3.setFont(new Font("Algerian", Font.PLAIN, 13));
		hero_name_lbl_3.setBounds(495, 0, 179, 28);
		contentPane.add(hero_name_lbl_3);
		
		hero_name_lbl_4 = new JLabel("Hero 4 name");
		hero_name_lbl_4.setForeground(Color.WHITE);
		hero_name_lbl_4.setFont(new Font("Algerian", Font.PLAIN, 13));
		hero_name_lbl_4.setBounds(10, 226, 179, 28);
		contentPane.add(hero_name_lbl_4);
		
		hero_name_lbl_5 = new JLabel("Hero 5 name");
		hero_name_lbl_5.setForeground(Color.WHITE);
		hero_name_lbl_5.setFont(new Font("Algerian", Font.PLAIN, 13));
		hero_name_lbl_5.setBounds(247, 221, 179, 28);
		contentPane.add(hero_name_lbl_5);
		
		hero_name_lbl_6 = new JLabel("Hero 6 name");
		hero_name_lbl_6.setForeground(Color.WHITE);
		hero_name_lbl_6.setFont(new Font("Algerian", Font.PLAIN, 13));
		hero_name_lbl_6.setBounds(495, 221, 179, 28);
		contentPane.add(hero_name_lbl_6);
		
		
		JLabel back_lbl = new JLabel();
		back_lbl.setBounds(0, 0, 684, 682);
		Image backResizedImage = backImage.getScaledInstance(back_lbl.getWidth(), back_lbl.getHeight(), 0);
		back_lbl.setIcon(new ImageIcon(backResizedImage));
		
		
		contentPane.add(back_lbl);
		
		
		
		Pick_A_Hero_Listener PHL = new Pick_A_Hero_Listener();
		hero_pick_lbl_1.addMouseListener(PHL);
		hero_pick_lbl_2.addMouseListener(PHL);
		hero_pick_lbl_3.addMouseListener(PHL);
		hero_pick_lbl_4.addMouseListener(PHL);
		hero_pick_lbl_5.addMouseListener(PHL);
		hero_pick_lbl_6.addMouseListener(PHL);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(700, 720);
		this.setVisible(true);
	}
	
	class Pick_A_Hero_Listener implements MouseListener{

		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==hero_pick_lbl_1){
				back_anim_icon= new ImageIcon("hero_pick_anim_1.gif"); 
				back_anim_img = back_anim_icon.getImage().getScaledInstance(Anim_lbl.getWidth(), Anim_lbl.getHeight(), 0); 
			
				Anim_lbl.setIcon(new ImageIcon(back_anim_img));
				Anim_lbl.setBounds(hero_pick_lbl_1.getX(), hero_pick_lbl_1.getY(), hero_pick_lbl_1.getWidth(), hero_pick_lbl_1.getHeight());
			}
			else if(e.getSource()==hero_pick_lbl_2){
				back_anim_icon= new ImageIcon("hero_pick_anim_2.gif"); 
				back_anim_img = back_anim_icon.getImage().getScaledInstance(Anim_lbl.getWidth(), Anim_lbl.getHeight(), 0); 
				
				Anim_lbl.setIcon(new ImageIcon(back_anim_img));
				Anim_lbl.setBounds(hero_pick_lbl_2.getX(), hero_pick_lbl_2.getY(), hero_pick_lbl_2.getWidth(), hero_pick_lbl_2.getHeight());
			}
			else if(e.getSource()==hero_pick_lbl_3){
				back_anim_icon= new ImageIcon("hero_pick_anim_3.gif"); 
				back_anim_img = back_anim_icon.getImage().getScaledInstance(Anim_lbl.getWidth(), Anim_lbl.getHeight(), 0); 
				
				Anim_lbl.setIcon(new ImageIcon(back_anim_img));
				Anim_lbl.setBounds(hero_pick_lbl_3.getX(), hero_pick_lbl_3.getY(), hero_pick_lbl_3.getWidth(), hero_pick_lbl_3.getHeight());
			}
			
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
			// TODO Auto-generated method stub
			
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
	
	public class continueButtonListener implements ActionListener{

		
		public void actionPerformed(ActionEvent arg0) {
			new Board();
			//na mpei elegxos gia ena h gia dyo paixtes
			
		}
		
	}
	}
