import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.DropMode;
import javax.swing.JFormattedTextField;
import java.awt.Color;


public class AncientArcadeFrame extends JFrame {

	private JPanel contentPane;
	private ArrayList<String> Info ; //info about images: hereos and symbols

	private JLabel Heroes_tip;   //TIPS//
	private	JLabel Symbols_tip;

	private JLabel Hero_lbl_1;   //** HERO_LABELS ** //
	private JLabel Hero_lbl_2;
	private JLabel Hero_lbl_3;
	private JLabel Hero_lbl_4;
	private JLabel Hero_lbl_5;
	private JLabel Hero_lbl_6;

	private JLabel Symbol_lbl_1 ;   //** SYMBOL_LABELS **//
	private JLabel Symbol_lbl_2;
	private JLabel Symbol_lbl_3;
	private JLabel Symbol_lbl_4;
	private JLabel Symbol_lbl_5;
	private JLabel Symbol_lbl_6;

	private JLabel Hero_lbl_gen ;
	private JLabel Symbol_lbl_gen ;
	private JFormattedTextField symbol_info;
	private JScrollPane scrollPane_1;

	private JTextPane test;
	private JTextArea heroArea;
	private JTextArea symbolArea;
	private JFormattedTextField hero_info;
	private JScrollPane scrollPane;
	/**
	 * Create the frame.
	 */
	public AncientArcadeFrame() {
		Info = new ArrayList<String>();           //info about Zeus
		Info.add("King of the gods, the ruler of Mount Olympus and the god of \n the sky" +
				", weather, thunder, lightning, law, order, and fate.");

		Info.add("Poseidon or Posidon is one of the twelve Olympian deities \n of the pantheon" +
				" in Greek mythology. His main domain is \n the ocean, and he is  called the 'God of the Sea'.");

		Info.add("Hercules is the Roman name for the Greek divine \n hero Heracles, who was the son of Zeus " +
				"and the mortal \n Alcmene. In classical mythology, Hercules is famous for his \n strength and for his" +
				" numerous far-ranging adventures.");

		Info.add("Theseus was the mythical founder-king of Athens,\n son of Aegeus and Poseidon, both of whom \n Aethra had " +
				"slept with in one night. Theseus was \n a founder-hero , like Perseus, Cadmus, or Heracles,");
		
		Info.add("Odysseus also known by the Roman name Ulysses \n, was a legendary Greek king of Ithaca and \n a" +
		      		" hero of Homer's epic poem the Odyssey.");
		
		Info.add("Perseus the legendary founder of Mycenae and \n the Perseid dynasty of Danaans there, was the \n first of the" +
				" heroes of Greek mythology whose exploits \n in defeating various archaic monsters provided \n the founding myths of the" +
				" Twelve Olympians.\n Perseus was a demi-god, the Greek hero who killed the \n Gorgon Medusa, and claimed Andromeda, having " +
				"rescued \n her from a sea monster sent by Poseidon in retribution \n for Queen Cassiopeia declaring that her daughter, \n " +
				"Andromeda, was more beautiful than the Nereids");
		
		Info.add("Cerberus or Kerberos, in Greek and Roman \n mythology, is a multi-headed (usually three-headed) \n dog, whi" +
				"ch guards the gates of the Underworld \n, to prevent those who have" +
				" crossed \n the river Styx from ever escaping. ");
	
		Info.add("In Greek mythology, the Minotaur \n was a creature with the head of a bull on the body \n of a man." +
				" \n He dwelt at the center of the Cretan Labyrinth, \n which was an elaborate maze-like construction" +
				" designed \n by the architect Daedalus and his son Icarus,\n on the command of King Minos of Crete." +
				" \n The Minotaur was eventually killed by the Athenian \n hero Theseus.");
		
		Info.add("Mount Olympus is the highest mountain \n in Greece, located in the Olympus Range on the border \n between Thessaly " +
				"and Macedonia \n In Greek mythology Olympus was regarded as the home \n of the Twelve Olympian gods of the ancient \n Greek world." +
				" \n It formed itself after the gods defeated the Titans \n in the Titan War, and soon the palace was inhabited \n by the gods.");
		
		Info.add("In Greek mythology Medusa was a monster, \n a Gorgon, generally described as having the face of \n a hideous human female with living " +
			     	"venomous \n snakes in place of hair. \n Gazing directly upon her would turn onlookers to stone");
	
		Info.add("In Greek mythology, Scylla was a monster \n that lived on one side of a narrow channel of water,\n opposite its counterpart Charybdis. " +
				"\n The two sides of the strait were within an arrow's range \n of each other—so close that sailors attempting \n to avoid Charybdis would " +
		   		"pass too close to Scylla \n and vice versa.");
		
		Info.add("In ancient Greece, the sea world was one \n of the most important things, as the fish was a basic part \n of Greek" +
			          	" nutrition. \n They also used sea to trade with other civilizations");
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		Heroes_tip = new JLabel();
		Heroes_tip.setBounds(116, 41, 69, 24);
		contentPane.add(Heroes_tip);

		Symbols_tip = new JLabel();
		Symbols_tip.setBounds(359, 41, 81, 24);
		contentPane.add(Symbols_tip);
		// labels(images) about heroes
		Hero_lbl_1 = new JLabel(new ImageIcon("zeus.jpg"));  //zeus   --> 1
		Hero_lbl_1.setBounds(0, 67, 114, 64);
		Hero_lbl_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(Hero_lbl_1);

		Hero_lbl_2 = new JLabel(new ImageIcon("poseidon.jpg"));   //poseidon --> 2
		Hero_lbl_2.setBounds(0, 142, 114, 64);
		Hero_lbl_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(Hero_lbl_2);

		Hero_lbl_3 = new JLabel(new ImageIcon("hercules.jpg"));   // hercules --> 3
		Hero_lbl_3.setBounds(0, 222, 114, 64);
		Hero_lbl_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(Hero_lbl_3);

		Hero_lbl_4 = new JLabel(new ImageIcon("theseus.jpg"));
		Hero_lbl_4.setBounds(0, 294, 114, 64);
		Hero_lbl_4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(Hero_lbl_4);

		Hero_lbl_5 = new JLabel(new ImageIcon("odysseus.jpg"));
		Hero_lbl_5.setBounds(0, 369, 114, 64);
		Hero_lbl_5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(Hero_lbl_5);

		Hero_lbl_6 = new JLabel(new ImageIcon("perseus.jpg"));
		Hero_lbl_6.setBounds(0, 445, 114, 64);
		Hero_lbl_6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(Hero_lbl_6);

		//labels(images) about symbos
		Symbol_lbl_1 = new JLabel(new ImageIcon("cerberus1.jpg"));
		Symbol_lbl_1.setBounds(460, 67, 114, 64);
		Symbol_lbl_1.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(Symbol_lbl_1);

		Symbol_lbl_2 = new JLabel(new ImageIcon("minotaur.jpg"));
		Symbol_lbl_2.setBounds(460, 142, 114, 64);
		Symbol_lbl_2.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(Symbol_lbl_2);

		Symbol_lbl_3 = new JLabel(new ImageIcon("olympus2.jpg"));
		Symbol_lbl_3.setBounds(460, 222, 114, 64);
		Symbol_lbl_3.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(Symbol_lbl_3);

		Symbol_lbl_4 = new JLabel(new ImageIcon("medusa.jpg"));
		Symbol_lbl_4.setBounds(460, 294, 114, 64);
		Symbol_lbl_4.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(Symbol_lbl_4);

		Symbol_lbl_5 = new JLabel(new ImageIcon("scylla.jpg"));
		Symbol_lbl_5.setBounds(460, 369, 114, 64);
		Symbol_lbl_5.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(Symbol_lbl_5);

		Symbol_lbl_6 = new JLabel(new ImageIcon("sea.jpg"));
		Symbol_lbl_6.setBounds(460, 445, 114, 64);
		Symbol_lbl_6.setCursor(new Cursor(Cursor.HAND_CURSOR));
		contentPane.add(Symbol_lbl_6);

		Hero_lbl_gen = new JLabel();     //here are compared the connentions between Heroes-Symbols
		Hero_lbl_gen.setBounds(0, 512, 114, 60);
		contentPane.add(Hero_lbl_gen);

		Symbol_lbl_gen = new JLabel();
		Symbol_lbl_gen.setBounds(460, 512, 114, 60);
		contentPane.add(Symbol_lbl_gen);

		JButton btnVerify = new JButton("Verify");
		btnVerify.setFont(new Font("MingLiU_HKSCS", Font.PLAIN, 17));
		btnVerify.setBounds(241, 378, 89, 23);
		btnVerify.addActionListener(new BListener());
		contentPane.add(btnVerify);

		ImageIcon  back_anime=new  ImageIcon("backround.gif");

		scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(116, 512, 344, 60);
		contentPane.add(scrollPane_1);
		
		symbolArea=new JTextArea();
		symbol_info = new JFormattedTextField();
		symbolArea.setDropMode(DropMode.INSERT);
		scrollPane_1.setViewportView(symbolArea);

		scrollPane = new JScrollPane();
		scrollPane.setBounds(116, 435, 344, 60);
		contentPane.add(scrollPane);
		
		heroArea=new JTextArea();
		hero_info = new JFormattedTextField();
		scrollPane.setViewportView(heroArea);
		
		JLabel back_lbl = new JLabel(back_anime); //this label holds the backround image
		back_lbl.setBounds(0, 0, 584, 572);
		
				contentPane.add(back_lbl);

		MListener ML = new MListener();
		Hero_lbl_1.addMouseListener(ML);
		Hero_lbl_2.addMouseListener(ML);
		Hero_lbl_3.addMouseListener(ML);
		Hero_lbl_4.addMouseListener(ML);
		Hero_lbl_5.addMouseListener(ML);
		Hero_lbl_6.addMouseListener(ML);

		Symbol_lbl_1.addMouseListener(ML);
		Symbol_lbl_2.addMouseListener(ML);
		Symbol_lbl_3.addMouseListener(ML);
		Symbol_lbl_4.addMouseListener(ML);
		Symbol_lbl_5.addMouseListener(ML);
		Symbol_lbl_6.addMouseListener(ML);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(600, 610);
		this.setVisible(true);

	}
	class BListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
			
			if(Hero_lbl_gen.getIcon().toString()=="zeus.jpg" && Symbol_lbl_gen.getIcon().toString()=="olympus.jpg"){

				Hero_lbl_1.setEnabled(false);
				Symbol_lbl_3.setEnabled(false);
			    JOptionPane.showMessageDialog(null, "Correct !");
			}
			else if(Hero_lbl_gen.getIcon().toString()=="poseidon.jpg" && Symbol_lbl_gen.getIcon().toString()=="sea.jpg"){

				Hero_lbl_2.setEnabled(false);
				Symbol_lbl_6.setEnabled(false);
			    JOptionPane.showMessageDialog(null, "Correct !");
			}
			else if(Hero_lbl_gen.getIcon().toString()=="hercules.jpg" && Symbol_lbl_gen.getIcon().toString()=="cerberus.jpg"){

				Hero_lbl_3.setEnabled(false);
				Symbol_lbl_1.setEnabled(false);
			    JOptionPane.showMessageDialog(null, "Correct !");
			}
			else if(Hero_lbl_gen.getIcon().toString()=="theseus.jpg" && Symbol_lbl_gen.getIcon().toString()=="minotaur.jpg"){

				Hero_lbl_4.setEnabled(false);
				Symbol_lbl_2.setEnabled(false);
			    JOptionPane.showMessageDialog(null, "Correct !");
			}
			else if(Hero_lbl_gen.getIcon().toString()=="odysseus.jpg" && Symbol_lbl_gen.getIcon().toString()=="scylla.jpg"){

				Hero_lbl_5.setEnabled(false);
				Symbol_lbl_5.setEnabled(false);
			    JOptionPane.showMessageDialog(null, "Correct !");
			}
			else if(Hero_lbl_gen.getIcon().toString()=="perseus.jpg" && Symbol_lbl_gen.getIcon().toString()=="medusa.jpg"){

				Hero_lbl_6.setEnabled(false);
				Symbol_lbl_4.setEnabled(false);
			    JOptionPane.showMessageDialog(null, "Correct !");
			
			}
		}
		
	}

	class MListener implements java.awt.event.MouseListener{


		@Override
		public void mouseClicked(MouseEvent e) {
			if(e.getSource()==Hero_lbl_1){            //HEROES LISTENER
				Hero_lbl_gen.setIcon(new ImageIcon("zeus.jpg"));
				Heroes_tip.setText("ZEUS");
				heroArea.setText(Info.get(0));
			

			} 
			else if(e.getSource()==Hero_lbl_2){
				Hero_lbl_gen.setIcon(new ImageIcon("poseidon.jpg"));
				Heroes_tip.setText("POSEIDON");
				heroArea.setText(Info.get(1));

			}
			else if(e.getSource()==Hero_lbl_3){
				Hero_lbl_gen.setIcon(new ImageIcon("hercules.jpg"));
				Heroes_tip.setText("HERCULES");
				heroArea.setText(Info.get(2));

			}
			else if(e.getSource()==Hero_lbl_4){
				Hero_lbl_gen.setIcon(new ImageIcon("theseus.jpg"));
				Heroes_tip.setText("THESEUS");
				heroArea.setText(Info.get(3));

			}
			else if(e.getSource()==Hero_lbl_5){
				Hero_lbl_gen.setIcon(new ImageIcon("odysseus.jpg"));
				Heroes_tip.setText("ODYSSEUS");
				heroArea.setText(Info.get(4));

			}
			else if(e.getSource()==Hero_lbl_6){
				Hero_lbl_gen.setIcon(new ImageIcon("perseus.jpg"));
				Heroes_tip.setText("PERSEUS");
				heroArea.setText(Info.get(5));

			}
			else if(e.getSource()== Symbol_lbl_1){      //SYMBOLS LISTENER
				Symbol_lbl_gen.setIcon(new ImageIcon("cerberus.jpg"));
				Symbols_tip.setText("CERBERUS");
				symbolArea.setText(Info.get(6));

			}
			else if(e.getSource()== Symbol_lbl_2){
				Symbol_lbl_gen.setIcon(new ImageIcon("minotaur.jpg"));
				Symbols_tip.setText("MINOTAUR");
				symbolArea.setText(Info.get(7));
			}
			else if(e.getSource()== Symbol_lbl_3){
				Symbol_lbl_gen.setIcon(new ImageIcon("olympus2.jpg"));
				Symbols_tip.setText("OLYMPUS");
				symbolArea.setText(Info.get(8));
			}
			else if(e.getSource()== Symbol_lbl_4){
				Symbol_lbl_gen.setIcon(new ImageIcon("medusa.jpg"));
				Symbols_tip.setText("MEDUSA");
				symbolArea.setText(Info.get(9));
			}
			else if(e.getSource()== Symbol_lbl_5){
				Symbol_lbl_gen.setIcon(new ImageIcon("scylla.jpg"));
				Symbols_tip.setText("SCYLLA");
				symbolArea.setText(Info.get(10));
			}
			else if(e.getSource()== Symbol_lbl_6){
				Symbol_lbl_gen.setIcon(new ImageIcon("sea.jpg"));
				Symbols_tip.setText("SEA WORLD");
				symbolArea.setText(Info.get(11));
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

}
