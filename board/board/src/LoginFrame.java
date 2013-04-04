import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;




public class LoginFrame extends JFrame{
	
	private JButton playButton;
	private JLabel backlbl;
	private JPanel mainPanel;
	private JLabel admin;
	private JLabel star1;
	private JLabel star2;
	private JComboBox playerCombo;
	private JLabel kionaslbl;
	private JLabel k2;
	private JLabel k3;
	private JLabel k4;
	private JLabel title;
	
	private User randomUser;
	// sysxetish me thn klash user
	private JLabel usernameLabel;
	private JLabel passwordLabel;
	private JTextField usernameTextField;
	private JPasswordField passwordTextField;
	//eidiko textfield gia password wste na emfanizontai asterakia kai oxi to pass
	private JButton loginButton;
	
	public LoginFrame(){
		
		
		
		playButton =new JButton("Play");
		
		setBounds(100, 100, 500, 500);
		mainPanel = new JPanel();
		mainPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(mainPanel);
		mainPanel.setLayout(null);
		
		
		ImageIcon  titleico=new  ImageIcon("title.gif");
		Image timage=titleico.getImage();
		title=new JLabel();
		title.setBounds(150,10,200, 180);
		Image tresizedImage = timage.getScaledInstance(title.getWidth(), title.getHeight(), 0);
		title.setIcon(new ImageIcon(tresizedImage));
		mainPanel.add(title);
		//title=new JLabel("Live Your Myth");
		//title.setFont(new Font("Segoe Script",Font.BOLD,33));
		//title.setForeground(Color.YELLOW);
		//title.setBounds(100,0,300,100);
		
		
		playButton =new JButton("Play Game");
		playButton.setFont(new Font("Jokerman",Font.BOLD,20));
		playButton.setBounds(150,200,200,35);
		mainPanel.add(playButton);
		
		admin=new JLabel("Whant To Be An Admin?");
		admin.setForeground(Color.WHITE);
		admin.setFont(new Font("Jokerman",Font.BOLD,15));
		admin.setBounds(150,260,250,50);
		mainPanel.add(admin);
		
		star1=new JLabel("*");
		star1.setForeground(Color.RED);
		star1.setFont(new Font("Jokerman",Font.BOLD,40));
		star1.setBounds(350,300,50,50);
		mainPanel.add(star1);
		
		star2=new JLabel("*");
		star2.setForeground(Color.RED);
		star2.setFont(new Font("Jokerman",Font.BOLD,40));
		star2.setBounds(350,330,50,50);
		mainPanel.add(star2);
		
		
		usernameLabel=new JLabel("Username: ");
		usernameLabel.setForeground(Color.WHITE);
		usernameLabel.setFont(new Font("Courier",Font.BOLD,15));
		usernameLabel.setBounds(50,297,100,50);
		mainPanel.add(usernameLabel);
		
		passwordLabel=new JLabel("Password: ");
		passwordLabel.setForeground(Color.WHITE);
		passwordLabel.setFont(new Font("Courier",Font.BOLD,15));
		passwordLabel.setBounds(50,325,100,50);
		mainPanel.add(passwordLabel);
		
		
		usernameTextField=new JTextField(5);
		usernameTextField.setBounds(150,310,200,20);
		mainPanel.add(usernameTextField);
			
		passwordTextField = new JPasswordField();
		passwordTextField.setBounds(150,340,200,20);
		mainPanel.add(passwordTextField);
		
		playerCombo=new JComboBox();
		setCombo(playerCombo);
		playerCombo.setBounds(200,385,100,20);
		mainPanel.add(playerCombo);
		
		//loginButton=new JButton("Login");
		
		myButtonListener loginListener=new myButtonListener();
		playButton.addActionListener(loginListener);
		//dhmiourgia kai prosthiki listener sto button
		
		
		//JPanel buttonPanel=new JPanel();
		//periexei mono to koumpi login
		//JPanel fillingPanel=new JPanel(new GridLayout(2,2));
		//periexei ta label kai ta textfield
		
		
		
		//buttonPanel.add(loginButton);
		//prosthesh stoixeiwn sto buttonpanel
		//fillingPanel.add(usernameLabel);
		//fillingPanel.add(usernameTextField);
		//fillingPanel.add(passwordLabel);
		//fillingPanel.add(passwordTextField);
		//prosthesh stoixeiwn sto fillingpanel
		//mainPanel.add(fillingPanel);
		//mainPanel.add(buttonPanel);
		//prosthiki stoixeiwn sto kentriko panel
		ImageIcon  kionas=new  ImageIcon("new2.gif");
		Image kimage=kionas.getImage();
		kionaslbl=new JLabel();
		kionaslbl.setBounds(0,0,100, this.getHeight());
		Image kresizedImage = kimage.getScaledInstance(kionaslbl.getWidth(), kionaslbl.getHeight(), 0);
		
		kionaslbl.setIcon(new ImageIcon(kresizedImage));
		k2=new JLabel(new ImageIcon(kresizedImage));
		k2.setBounds(400,0,100,this.getHeight());
		k3=new JLabel();
		k3.setBounds(70,50,90,380);
		kresizedImage= kimage.getScaledInstance(k3.getWidth(), k3.getHeight(), 0);
		k3.setIcon(new ImageIcon(kresizedImage));
		k4=new JLabel(new ImageIcon(kresizedImage));
		k4.setBounds(330,50,90,380);
		
		//prosarmogh eikonas fontou
		mainPanel.add(kionaslbl);
		mainPanel.add(k2);
		mainPanel.add(k3);
		mainPanel.add(k4);
		
		
		
		ImageIcon  background=new  ImageIcon("back.gif");
		Image image=background.getImage();
		backlbl=new JLabel();
		backlbl.setBounds(0,0,this.getWidth(), this.getHeight());
		Image resizedImage = image.getScaledInstance(backlbl.getWidth(), backlbl.getHeight(), 0);
		backlbl.setIcon(new ImageIcon(resizedImage));
		//prosarmogh eikonas fontou
		mainPanel.add(backlbl);
		
		
		//this.setContentPane(masterPanel);
		this.setTitle("Login");
		this.setSize(500, 500);
		this.setResizable(false);
		//den epitrepei allagh megethous sto parathyro
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	public void setCombo(JComboBox c){
		c.addItem("players: ");
		c.addItem("1");
		c.addItem("2");
		
		
	}
	
	public class myButtonListener implements ActionListener{
		//klash gia ton listener tou button
		@Override
		public void actionPerformed(ActionEvent arg0) {
			String usernameText=usernameTextField.getText();
			
			char[] c=(passwordTextField.getPassword());
			//h getPassword epistrefei char array kai prepei na ginei metatroph se string
			String passwordText=new String (c);
			//metatroph se string
			
			if((usernameText.length()!=0)&&(passwordText.length()!=0)){
				//an den einai kena
				User aUser=new User(usernameText,passwordText);
				int correctness=aUser.checkUserType(usernameText, passwordText);
				
				switch(correctness){
				case 1: JOptionPane.showMessageDialog(null, "You Are An Admin");
						break;
				case 2: JOptionPane.showMessageDialog(null, "Wrong Password");
						break;
				case 3: JOptionPane.showMessageDialog(null, "Wrong Username");
						break;
				//case 4: JOptionPane.showMessageDialog(null, "Wrond Password");
					//	break;
				//case 5: JOptionPane.showMessageDialog(null, "Wrong Username");
					//	break;
				
					
				}
			}
			else
				JOptionPane.showMessageDialog(null, "Fill Them All...");
			
		new Pick_A_Hero();
		}
		
	}
}
