package projet;

import java.util.Scanner;
/**
 * @author NIANG Ndeye Fatou 
 * @author ELMCHICHI Maryem 
 * @author Ziadath BABAEDJOU
 * 
 */
public class Verification {
	private Invoker control;
	private Fonctionnalite fonction;
	private Command editer;
	private Command supprimer;
	private Command view;
	private Command rechercher;
	private Command lister;
	private Command inconnu;
	private Scanner sc;
	
	public Verification() {
		this.control = new Invoker();
		this.fonction = new Fonctionnalite();
		this.editer = new Editer(fonction);
		this.supprimer = new Supprimer(fonction);
		this.view = new View(fonction);
		this.rechercher = new Rechercher(fonction);
		this.lister = new Lister(fonction);
		this.inconnu = new Inconnu(fonction);
		sc = new Scanner(System.in);
	}
	
	public void process(String [] arg) {
		
		String [] args = {"",""} ;
		if(arg.length==0) {
			
			System.out.println("\n \t \t \t  PRISE DE NOTE \n");
			System.out.println(" e|edit 'nom de la note'    :    Pour créer ou modifier une note");
			System.out.println(" v|view 'nom de la note'    :    Pour visualiser une note");
			System.out.println(" d|delete 'nom de la note'  :    Pour supprimer une note");
			System.out.println(" s|search 'mot clé'         :    Pour chercher un mot clé dans les notes");
			System.out.println(" ls|list                    :    Pour affichier la liste des fichiers du répertoire ");
			
			String str="";
		  do {			  
			  System.out.print(">");
			   str = sc.nextLine();
		  }while(str.equals(""));
		  String[] arrOfStr = str.split(" ", 2);  
		  if(arrOfStr.length==1 ) {
			  args[0]=str;
			  if(!args[0].equalsIgnoreCase("ls") && !args[0].equalsIgnoreCase("list")) {
				  do {			  
		  			  System.out.print(">");
		  			   str = sc.nextLine();
		  		  }while(str.equals(""));
				  args[1]=str;
			  }
		  }	  
		  else if(arrOfStr.length>1) {
			  args[0]=arrOfStr[0]; 
			  args[1]=arrOfStr[1];
		  }
			  
		}
		else if(arg.length==1) {
			args[0]=arg[0];
			String str="";
			if(!args[0].equalsIgnoreCase("ls") && !args[0].equalsIgnoreCase("list")) {
				  do {			  
		  			  System.out.print(">");
		  			   str = sc.nextLine();
		  		  }while(str.equals(""));
				  args[1]=str;
			}
		}
		else
			args=arg;
		
		 if(args[0].equalsIgnoreCase("edit")||args[0].equalsIgnoreCase("e") ) {
		    	control.setCommand(editer);
		    	control.pressButton(args[1]);	
		    }
		 
		 else if(args[0].equalsIgnoreCase("list")||args[0].equalsIgnoreCase("ls") ) {
		    	control.setCommand(lister);
		    	control.pressButton("");
		    
		    }
		 else if(args[0].equalsIgnoreCase("view")||args[0].equalsIgnoreCase("v") ) {
		    	control.setCommand(view);
		 	    
		    }
		    
		 else if(args[0].equalsIgnoreCase("search")||args[0].equalsIgnoreCase("s") ) {
		    	control.setCommand(rechercher);
		    	control.pressButton(args[1]);
		    	
		    }
		 else if(args[0].equalsIgnoreCase("delete")||args[0].equalsIgnoreCase("d") ) {
		    	control.setCommand(supprimer);
		    	control.pressButton(args[1]);    
		    }
		    else {
		    	control.setCommand(inconnu);
		    	control.pressButton(args[0]);
		    }
		    	
		    
		  }
	
	
	
}
