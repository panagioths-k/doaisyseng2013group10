import java.util.*;

import javax.swing.*;


public class Uicons extends ImageIcon {
	
	private ArrayList<ImageIcon> usedIcons;
	
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
	
	}

	public ArrayList<ImageIcon> getUsedIcons() {
		return usedIcons;
	}

	public void setUsedIcons(ArrayList<ImageIcon> usedIcons) {
		this.usedIcons = usedIcons;
	}
	
	
	
}
