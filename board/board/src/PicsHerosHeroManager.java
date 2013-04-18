import java.util.*;

import javax.swing.*;


public class PicsHerosHeroManager {
	
	private Uicons iconList;
	private ArrayList<ImageIcon> currList;
	private ArrayList<PicsHerosHero> heroes;
	private PicsHerosHero currHero;
	private String name;
	private ArrayList<String> heroNames;
	
	public PicsHerosHeroManager(){
		
		heroNames=new ArrayList<String>();
		addNames();
		//prosthiki onomatwn hrwwn		
		iconList=new Uicons();
		//gia na trabiskoume olh thn lista twn eikonidiwn
		currList=new ArrayList<ImageIcon>(iconList.getUsedIcons());
		heroes=new ArrayList<PicsHerosHero>();
	}
	
	public void addNames(){
		//methodos prosthikhs onomatwn
		//h prosthiki prepei na ginetai me thn idia seira pou mpainei kai h triada twn eikonwn
		heroNames.add("DEDALUS");
		heroNames.add("DIONYSUS");
		heroNames.add("HERCULES");
		heroNames.add("IASON");
		heroNames.add("ODYSSEUS");
		heroNames.add("PERSEUS");
		heroNames.add("PROMITHEUS");
		heroNames.add("THESEUS");
	}
	
	
	
	public void createHeroList(){
		int i;
		int j;
		int k;
		String currName="";
		for(i=0;i<((currList.size()-1)/3);i++){
			
		//perasma ths listas ana 3ada (afaireitai 1 apo to size giati mesa sthn lista yparxei kai to background
			
			ImageIcon[] currIcons=new ImageIcon[3];
			k=0;
			//deikths gia ton pinaka twn icons tou hero prepei na ftanei mexri to 3 kai na ksanamhdenizei
			//gia ton epomeno hrwa
			for(j=(i*3);j<((i*3)+3);j++){
			//perasma ths triadas pou briskomaste ana 1
			//edw to i pollaplasiazetai epi 3 giati sto panw loop auksanei mono kata ena (alliws kollaei)
				currName=heroNames.get(i);
				currIcons[k]=currList.get(j);
				k++;
			}
			heroes.add(new PicsHerosHero(currName,currIcons));
			//dhmiourgia telikou hrwa
		}	
		System.out.println(heroes.size());
	}
	
	public PicsHerosHero getHero(){
		 Random r = new Random();
		  return heroes.get(r.nextInt(heroes.size()));
	}
}
	
	
	


