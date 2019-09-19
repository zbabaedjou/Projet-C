package projet;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Scanner;

/**
 * @author NIANG Ndeye Fatou 
 * @author ELMCHICHI Maryem 
 * @author Ziadath BABAEDJOU
 */
public class Fonctionnalite { ////////////////CHANGER DEFAULT PROJECT ET CoNTEXT DANS NOTE
	
	private String conf_file="C:\\Users\\Ziadath BABAEDJOU\\Desktop\\note.txt";
	private String path;
	private String application;
	private String ascii_view;
	private String line;
	private List_Attribut instanceUniq;
	private BufferedReader bufferedReader;
	
	 /**
	  * Constructeur de la classe
	  * Il récupère le nom des applications externes a utiliser et le chemin du dossier d'enrégistrement des notes
	  * Aussi il récupère l'etat du singleton dans le fichier de sauvegard 
	  */
	public  Fonctionnalite() {
		String line="";
		try {
            FileReader fileReader = 
                new FileReader(conf_file);
            
            BufferedReader bufferedReader = 
                new BufferedReader(fileReader);

           			while((line = bufferedReader.readLine()) != null) {
           				if(line.length() != 0 && line.contains("PATH")){
           					String[] arrOfStr = line.split("=", 2); 
           						this.path=arrOfStr[1];           						
           						
                }
           				if(line.length() != 0 && line.contains("APP")){
           					String[] arrOfStr = line.split("=", 2); 						
       						this.application=arrOfStr[1];
       						}
           				
           				if(line.length() != 0 && line.contains("ASCII_VIEW")){
           					String[] arrOfStr = line.split("=", 2); 						
       						this.ascii_view=arrOfStr[1];
       						}
           			
            }   

            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                		conf_file + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + conf_file + "'");          
         
        }
		File tempFile = new File(this.path+"Saves.ser");
		if(tempFile.exists()==false) {
			this.instanceUniq=List_Attribut.getInstance();
		}
		else {
			this.deserialize();
		}
	}
	
	
	/**
	 * Editer(): Ouvre un fichier existant ou le créé qaudn il n'exista pas avant de l'ouvrir
	 * Lors de la créatin il rempli le fichier par défaut avec les attribut projet et contextes par défaut
	 * @param nom
	 * @throws IOException
	 * @throws InterruptedException
	 */
	
	public void editer(String nom ) throws IOException, InterruptedException {
		line = "";
		String project = "DefaultProject";
		String context="DefaultContext";
		Note note = null;
		File tempFile = new File(this.path+nom+".adoc");
	
		if(tempFile.exists()==false) {
			note=new Note
					.Builder(nom)
					.build();
			this.instanceUniq.ajouterNote(note);
			
			
			
			 try {
	             FileWriter fichier = new FileWriter(this.path+nom+".adoc");

	             BufferedWriter bufferedWriter = new BufferedWriter(fichier);

	             bufferedWriter.write("= "+note.getNom());
	             bufferedWriter.newLine();
	             bufferedWriter.write(""+note.getDate());
	             bufferedWriter.newLine();
	             bufferedWriter.write(":context: "+note.getContext());
	             bufferedWriter.newLine();
	             bufferedWriter.write(":project: "+note.getProjet());
	             bufferedWriter.newLine();
	             bufferedWriter.close();
	         }
	         catch(IOException ex) {
	        	 System.out.println(
	                 "Erreur lors de l'écriture dans le fichier'"
	                 + nom + ".adoc");
	         }	 		
		}
		
		else{
			note=this.instanceUniq.getNote(nom);
			if(note==null) {
				readFileAndAdd("DefaultProject", "DefaultContext", nom);
				note=this.instanceUniq.getNote(nom);

			}
		}
		
		project = note.getProjet();
		context= note.getContext();
		Process p = Runtime.getRuntime().exec(this.application+" "+this.path+nom+".adoc");
	    p.waitFor();		
		
	    try {
        
	    	readFileAndAdd(project, context, nom);
        }
        catch(FileNotFoundException ex) {
            System.out.println(
                "Unable to open file '" + 
                this.path+nom+".adoc" + "'");                
        }
        catch(IOException ex) {
            System.out.println(
                "Error reading file '" 
                + this.path+nom+".adoc" + "'");                  


        }
	    this.majFichier();
	    
	}
	
	public void readFileAndAdd(String pro, String cont, String nom) throws IOException {
		String project = pro;
		String context=cont;
		Note note=null;
		FileReader fileReader = null;
		
			fileReader = new FileReader(this.path+nom+".adoc");
		
            
            bufferedReader = new BufferedReader(fileReader);

           			
						while((line = bufferedReader.readLine()) != null) {
							if(line.length() != 0 && line.contains("project")){ 
								String[] arrOfStr = line.split(":", 3); 
								if(!project.equals(arrOfStr[2]))
									project = arrOfStr[2];      
								
							}       
						 if (line.length() != 0 && line.contains("context")){ 
								String[] arrOfStr = line.split(":", 3); 
								if(!context.equals(arrOfStr[2]))
									context = arrOfStr[2];  
								
							}
      
           if( note==null || project!=note.getProjet()||context!=note.getContext()) {
	           note=this.instanceUniq.getNote(nom);
	           this.instanceUniq.supprimerNote(note);
	           note=new Note
						.Builder(nom)
						.addProjet(project)
						.addContext(context)
						.build();
	           this.instanceUniq.ajouterNote(note);
           }
           
						}
           
	}

	/**
	 * lister()
	 * Cete fonction liste les notes existantes
	 */
	public boolean lister() {
		
		System.out.println(this.instanceUniq.listerNotes());
		if(!this.instanceUniq.listerNotes().equals(""))
			return true;
		else
			return false;
		
	}
	
	/**
	 * aperçu()

	 * affiche le visuel en ascidotor d'une note dans un navigateur
	 * @param nom  de la note
	 */
	
	public void apercu(String nom) {
		
		/*Asciidoctor asciidoctor=create();
		String[] result = asciidoctor.convertFiles(
			    Arrays.asList(new File(this.path+nom+".adoc")),
			    new HashMap<String, Object>());
				System.out.println(result.length);
				
		//		File  file= new File("test/test.html");*/
		
			try {
				Runtime.getRuntime().exec(new String[] {this.ascii_view,this.path+nom+".adoc"});
			} catch (Exception e) {
				System.out.println("Impossible d'ouvrire le fichier");
			}
			
	}
	
	
	/** Delete()
	 * Supprime une note
	 * Cette fonction supprime la note du singleton puis suprime le fichier qui lui est associé
	 * @param nom
	 */
	public boolean delete(String nom) {
		
		boolean exist=false;
		Note note=this.instanceUniq.getNote(nom);
		exist=this.instanceUniq.supprimerNote(note);
		if(exist==false)
			System.out.println("Impossible de supprimer le fichier car il n'existe pas");
		else {
				File MyFile = new File(this.path+nom+".adoc"); 
				MyFile.delete(); 
			
			
			this.majFichier();
		
		}
		
		return exist;
		
	}
	
	public boolean Rechercher(String mot) {
		
		File directory = new File(this.path);
        File[] files = directory.listFiles();
        String chaine = "";
        int count =0;

        for (int i = 0; i < files.length; i++) 
        {
            if (files[i].getName().endsWith(".adoc")) 
            {
                 Scanner s = null;
				try {
					s = new Scanner(files[i]);
				} catch (FileNotFoundException e) {
					System.out.println("Impossible d'ouvrir le fichier");
				}
                chaine = "";
                while (s.hasNextLine())
                {
                    chaine += s.nextLine();
                }

                if (chaine.toLowerCase().contains(mot.toLowerCase())) 
                {
                    System.out.println("Element trouvé dans: " + files[i].getName());
                    count++;
                }

            } 
        }
        
        if(count>0)
        	return true; 
        else 
        	return false;
		
	}
	
	
	/**majFichier : Met à jour le fichier index.adoc
	 * sera appelé après chaque modification: editer; delete;
	 * 
	 */
	public void majFichier() {
		 try {
             FileWriter fichier = new FileWriter(this.path+"index.adoc");

             BufferedWriter bufferedWriter = new BufferedWriter(fichier);
        

             bufferedWriter.write(this.instanceUniq.listerDansFichier());
             bufferedWriter.newLine();
             bufferedWriter.newLine();
             bufferedWriter.close();
         }
         catch(IOException ex) {
        	 System.out.println(
                 "Erreur lors de l'écriture dans le fichier index.adoc");
         }
		 
		 this.serialize();
		 
		
	}
	
	/**
	 * inconnu()
	 * Fonction appelé lorsque l'utilisatuer lance une commande non suppoeté par le programme
	 */
	public void inconnu(String nom) {
		System.out.println("Command '"+nom+"' non connu");
	}
	
	
	/**
	 * Serialize()
	 * Enrégistre le contenu du singleton dans un fichier afin de garder l'état du système de fichier
	 */
	public synchronized void serialize() {
		try {
			
			ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(
					this.path+"Saves.ser"));
	        out.writeObject(this.instanceUniq);
	        out.close();

		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * Deserialise retourne le contenu du singleton sauvegardé lors de la sérialisation
	 */
	public synchronized void deserialize() {
		try {
			ObjectInputStream in = new ObjectInputStream(new FileInputStream(
					 this.path+"Saves.ser"));
		        this.instanceUniq= (List_Attribut)in.readObject();
		        in.close();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
