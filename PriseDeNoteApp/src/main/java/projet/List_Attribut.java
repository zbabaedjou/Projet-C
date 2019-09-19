package projet;

import java.io.Serializable;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author NIANG Ndeye Fatou 
 * @author ELMCHICHI Maryem 
 * @author Ziadath BABAEDJOU
 * 
 * Cette classe est l'élément composé du composite.
 * Elle permet de créer des groupes d'attribut qui sont: 
 * Soit un Context: type=1
 * Soit un Projet: type=2
 * Soit une Date: type=3
 * 
 */
public class List_Attribut extends Attribut implements Serializable {


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static List_Attribut uniqueInstance;
	private ArrayList<Note>list_all;
	private ArrayList<Groupe>projets;
	private ArrayList<Groupe>contextes;
	private ArrayList<Groupe>dates;



	private List_Attribut() {
		this.list_all=new ArrayList<Note>();
		this.projets=new ArrayList<Groupe>();
		this.contextes=new ArrayList<Groupe>();
		this.dates=new ArrayList<Groupe>();
	}

	public static List_Attribut getInstance()
	    {
	            if(uniqueInstance==null)
	            {
	                    uniqueInstance = new List_Attribut();
	            }
	            return uniqueInstance;
	}
	   
	
	/**ajouterNote-------------------------------------------------------------------------
	 * @param
	 * @return
	 */
	@Override
	public void ajouterNote(Note note) {
		
		int exist=0; 
		Groupe gr;
		this.list_all.add(note);
		for(Groupe n : this.projets)
			if(n.getNom().equals(note.getProjet())) {
				n.ajouterNote(note);
				exist=1;
				break;
			}
		if(exist==0) {
			gr=new Groupe(note.getProjet(),2);
			gr.ajouterNote(note);			
			this.projets.add(gr);		
		}
		
		exist=0; 
		for(Groupe n : this.contextes)
			if(n.getNom().equals(note.getContext())) {
				n.ajouterNote(note);
				exist=1;
				break;
			}
		if(exist==0) {
			gr=new Groupe(note.getContext(),1);
			gr.ajouterNote(note);			
			this.contextes.add(gr);
			
		}
		
		exist=0; 
		Format formatter = new SimpleDateFormat("MMMM");  
	    String s = formatter.format(note.getDate());
		for(Groupe n : this.dates)
			if(n.getNom().equals(s)) {
				n.ajouterNote(note);
				exist=1;
				break;
			}
		if(exist==0) {
			gr=new Groupe(s,3);
			gr.ajouterNote(note);			
			this.dates.add(gr);
		}
		
	}
	
	/**listerNotes
	 * @param
	 * @return
	 */
	@Override
	public String listerNotes() {
			String listeNote="";
		   ArrayList<String> temp = new ArrayList<String>();
		for(Note n: this.list_all) {
			temp.add(n.getNom()+".adoc \n");
		}
		Collections.sort(temp);
		
		for(String word: temp){
			listeNote+="          "+word;
		}
		
		listeNote+="     "+temp.size()+ " Note(s) \n";
		return listeNote;
		
	}

	
	
	/**listerDansFichier-----------------------------------------------------------------------------------
	 * 
	 * @return list String qui contient toutes les infos
	 */
	public String listerDansFichier() {
		String list,list_note, list_projet, list_context,list_date;
 
		Collections.sort(this.list_all, new Comparator<Note>() {
		    public int  compare(Note n1, Note n2) {
		    	 return n1.getNom().compareTo(n2.getNom());
		    }
		});
		list_note=" \n == Toutes les notes \n \n \n";
		for(Note n: this.list_all) {
			list_note= list_note+"\n \n            *"+n.getNom()+"* _Context_: "+n.getContext()+" _Projet_: "+n.getProjet()+" _Date_: "+n.getDate()+"\n";
		}
		
		list_projet="== Par Projet:\n \n \n";
		for(Groupe n : this.projets)
			list_projet=list_projet+n.listerNotes()+"\n \n";
		
		list_context="== Par Context:\n \n \n";
		for(Groupe n : this.contextes)
			list_context=list_context+n.listerNotes()+"\n \n";
		
		list_date="== Par Date:\n \n \n";
		for(Groupe n : this.dates)
			list_date=list_date+n.listerNotes()+"\n \n";
		
		list="= Index \n \n \n  "+list_note+"\n \n \n \n"+list_projet+"\n \n \n \n"+list_context+"\n \n \n \n"+list_date;
		
		return list;
	}
	

	/**supprimerNote
	 * @param Note à supprimer
	 * @return true si le fichier est trouvé et supprimé et false sinon
	 */
	@Override
	public boolean supprimerNote(Note note) {
		
		if(this.list_all.contains(note)) {
			
			for(Groupe n: this.contextes)
				if(n.getNom().equals(note.getContext())) {
					n.supprimerNote(note);
					
			}
			
			for(Groupe n: this.projets)
				if(n.getNom().equals(note.getProjet())) {
					n.supprimerNote(note);
					
			}
			
			Format formatter = new SimpleDateFormat("MMMM");  
		    String s = formatter.format(note.getDate());
			for(Groupe n: this.dates)
				if(n.getNom().equals(s)) {
					n.supprimerNote(note);
			}
							
			this.list_all.remove(note);			
	
			return true;			
		}
		
		else
			return false;

		
	}

	
	 /**getters
	  * 
	  * @return array of note or note
	  */
	public ArrayList<Note> getList_all() {
		return this.list_all;
	}

	public ArrayList<Groupe> getProjets() {
		return this.projets;
	}

	

	public ArrayList<Groupe> getContextes() {
		return this.contextes;
	}

	

	public ArrayList<Groupe> getDates() {
		return this.dates;
	}

	
	public Note getNote(String nom) {
		for(Note n : this.list_all) {
			if(n.getNom().equals(nom)) 
				return n;
		}
		return null;
			
	}
	
	/**
	 * Evite de cr�er une nouvelle instance de l'objet lors de la d�s�rialisation. 
	 * Ce qui permet de conserver le patern singleton
	 * @return
	 */
	protected List_Attribut readResolve() {
	    return getInstance();
	}

}
