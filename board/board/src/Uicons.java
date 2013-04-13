import java.util.*;

import javax.swing.*;


public class Uicons extends ImageIcon {
	
	private ArrayList<ImageIcon> usedIcons;
	private ArrayList<CardLabel> mmg_icons;//Memory Game
	
	public Uicons(){		
		
	usedIcons=new ArrayList<ImageIcon>();
		
	ImageIcon iconDedalus1=new ImageIcon("dedalos_labyrinth.jpg");
	ImageIcon iconDedalus2=new ImageIcon("dedalos_talos.jpg");
	ImageIcon iconDedalus3=new ImageIcon("dedalos.gif");
	
	usedIcons.add(iconDedalus1);
	usedIcons.add(iconDedalus2);
	usedIcons.add(iconDedalus3);
	
	ImageIcon iconDionysus1=new ImageIcon("dioniysus_Pan.jpg");
	ImageIcon iconDionysus2=new ImageIcon("dionysus_wine.jpg");
	ImageIcon iconDionysus3=new ImageIcon("dionysus.jpg");
	
	usedIcons.add(iconDionysus1);
	usedIcons.add(iconDionysus2);
	usedIcons.add(iconDionysus3);
	
	ImageIcon iconHercules1=new ImageIcon("Hercules_hydra.png");
	ImageIcon iconHercules2=new ImageIcon("Hercules_nemealion.jpg");
	ImageIcon iconHercules3=new ImageIcon("Hercules_snake.jpg");
	
	usedIcons.add(iconHercules1);
	usedIcons.add(iconHercules2);
	usedIcons.add(iconHercules3);
	
	ImageIcon iconIaswnas1=new ImageIcon("iaswnas_argw.jpg");
	ImageIcon iconIaswnas2=new ImageIcon("iaswnas_sympligades.jpg");
	ImageIcon iconIaswnas3=new ImageIcon("iaswnas_xderas.jpg");
	
	usedIcons.add(iconIaswnas1);
	usedIcons.add(iconIaswnas2);
	usedIcons.add(iconIaswnas3);
	
	ImageIcon iconOdysseas1=new ImageIcon("odysseas_doureios.jpg");
	ImageIcon iconOdysseas2=new ImageIcon("odysseas_kirki.jpg");
	ImageIcon iconOdysseas3=new ImageIcon("odysseas_polyfimos.jpg");
	
	usedIcons.add(iconOdysseas1);
	usedIcons.add(iconOdysseas2);
	usedIcons.add(iconOdysseas3);
	
	ImageIcon iconPerseas1=new ImageIcon("perseus_argos.jpg");
	ImageIcon iconPerseas2=new ImageIcon("perseus_medusa.jpg");
	ImageIcon iconPerseas3=new ImageIcon("perseus_zeus.jpg");
	
	usedIcons.add(iconPerseas1);
	usedIcons.add(iconPerseas2);
	usedIcons.add(iconPerseas3);
	
	ImageIcon iconPromitheas1=new ImageIcon("promitheas_caucasus.gif");
	ImageIcon iconPromitheas2=new ImageIcon("promitheas_fwtia.png");
	ImageIcon iconPromitheas3=new ImageIcon("promitheas.jpg");
	
	usedIcons.add(iconPromitheas1);
	usedIcons.add(iconPromitheas2);
	usedIcons.add(iconPromitheas3);	
	
	ImageIcon iconThiseas1=new ImageIcon("thiseas_gyrismos.jpg");
	ImageIcon iconThiseas2=new ImageIcon("thiseas_minotauros.png");
	ImageIcon iconThiseas3=new ImageIcon("thiseas_taurosmarathona.jpg");
	
	usedIcons.add(iconThiseas1);
	usedIcons.add(iconThiseas2);
	usedIcons.add(iconThiseas3);
	
	ImageIcon iconOlympus=new ImageIcon("olympus.jpg");
	usedIcons.add(iconOlympus);
	//Memory Game Stuff
	mmg_icons=new ArrayList<CardLabel>();

	ImageIcon dedault_back_mmg=new ImageIcon("pattern_mmg.jpg"); // 0
	ImageIcon hermes_mmg=new ImageIcon("hermes_mmg.jpg");   //  1
	ImageIcon pegasus_mmg=new ImageIcon("pegasus_mmg.jpg");  // 2
	ImageIcon medusa_mmg=new ImageIcon("medusa_mmg.jpg");   //  3
	ImageIcon hades_mmg=new ImageIcon("hades_mmg.jpg");   //    4
	ImageIcon warrior_mmg=new ImageIcon("warrior_mmg.jpg");//   5
	ImageIcon kouros_mmg=new ImageIcon("kouros_mmg.jpg");   //  6
	ImageIcon yphestos_mmg=new ImageIcon("yphestos_mmg.jpg");// 7
	ImageIcon minotaur_mmg=new ImageIcon("minotaur_mmg.jpg");// 7
	
	mmg_icons.add(new CardLabel(dedault_back_mmg,  "default") );
	
	mmg_icons.add(new CardLabel(hermes_mmg,         "hermes") );  //We need twice each icon
	mmg_icons.add(new CardLabel(hermes_mmg,         "hermes") );
	
	mmg_icons.add(new CardLabel(pegasus_mmg,       "pegasus") );
	mmg_icons.add(new CardLabel(pegasus_mmg,       "pegasus") );
	
	mmg_icons.add(new CardLabel(medusa_mmg,         "medusa") );	
	mmg_icons.add(new CardLabel(medusa_mmg,         "medusa") );
	
	mmg_icons.add(new CardLabel(hades_mmg,           "hades") );
	mmg_icons.add(new CardLabel(hades_mmg,           "hades") );
	
	mmg_icons.add(new CardLabel(warrior_mmg,       "warrior") );
	mmg_icons.add(new CardLabel(warrior_mmg,       "warrior") );
	
	mmg_icons.add(new CardLabel(kouros_mmg,         "kouros") );
	mmg_icons.add(new CardLabel(kouros_mmg,         "kouros") );
	
	mmg_icons.add(new CardLabel(yphestos_mmg,     "yphestos") );
	mmg_icons.add(new CardLabel(yphestos_mmg,     "yphestos") );
	
	mmg_icons.add(new CardLabel(minotaur_mmg,     "minotaur") );
	mmg_icons.add(new CardLabel(minotaur_mmg,     "minotaur") );

	
	}

	public ArrayList<ImageIcon> getUsedIcons() {
		return usedIcons;
	}

	public void setUsedIcons(ArrayList<ImageIcon> usedIcons) {
		this.usedIcons = usedIcons;
	}
	//Memory Game
	public ArrayList<CardLabel> getMMGIcons() {
		return mmg_icons;
	}

	public void setMMGIcons(ArrayList<CardLabel> usedIcons) {
		this.mmg_icons = usedIcons;
	}
	
	
	
}
