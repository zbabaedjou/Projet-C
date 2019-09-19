	package roguelike;

import java.util.*;
import java.util.Stack;
import java.util.Random;
/**
 * objectif 
 * @author Ziadath BABAEDJOU, Benjamin MATIR, Fatou NDEYE
 * 
 * 1 genere un perfect maze = aucune case n'est innacessible
 * 1.1 backtracking version avec des trous (4/25 non_exploré)
       theoriquement inaccessibles mais 
       la generation de sale ignorera ce defaut
  2 faire des salles numeroté( percage )
 		une liste de sale (nouvelle class ?)
 3 placer le joueur dans la sale 1 
 4 placer l'escalier dans la derniere sale
 5 placer des monstres dans les salles
 *
 */ 

public class GenerUnivers {
	private int width;
	private int height;
	private int niveau;
	private ElementUnivers[][] elements;
	public Stack<Integer> a_visiter_x;
	public Stack<Integer> a_visiter_y;
	public Stack<Integer> pere_x;
	public Stack<Integer> pere_y;
	
	public ElementUnivers[][] get_elements(){
		return this.elements;
	}
	public GenerUnivers(int width, int height) {
		this.width = width;
		this.height = height;
		this.elements = new ElementUnivers[width][height];
		this.a_visiter_x = new Stack<Integer>();
		this.a_visiter_y = new Stack<Integer>();
		this.pere_x = new Stack<Integer>();
		this.pere_y = new Stack<Integer>();
		this.niveau=1;
	}
	
	
	/*ENvoie du tableau généré dans le l'univers
	 * Cette fonction créé une instance de Univers et lui 
	 * envoie le tableau généré en paramettre
	 */
	public Univers generer() {
		//return new Univers(randomizeElement());
		//return new Univers(walling());
		this.mazing();
		
		int salles[][] =new int[this.width][this.height];
		this.creerSalles(salles);
		this.ajout_monstres(salles);
		this.addEscalier(salles);
		this.addPomme();
		this.addPNJ(salles);
		
		return new Univers(this.elements);
	}
	
	
	
	/*Fonction de generation alléatoire de l'espace 
	 * Cette fonction remplis aléatoirement les cases du tableau éléments	
	 */
	public ElementUnivers[][] randomizeElement() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				elements[x][y] =  Objet.getRandomElement();
			}
		}
		return elements;
	}
	
	public ElementUnivers[][] walling() {
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				elements[x][y] =  Objet.MUR;
			}
		}
		return elements;
	}
	
	public ElementUnivers[][] mazing() {
		this.walling();
			
		this.a_visiter_x.push(1);
		this.a_visiter_y.push(1);
		this.pere_x.push(1);
		this.pere_y.push(1);
	
	
		int x_actuel;
		int y_actuel;
		int prevx;
		int prevy;
			
		
			
		// problem de non random
	      List<String> arrlist = new ArrayList<String>();
	      String priorite="A";
	      arrlist.add("A");
		  arrlist.add("B");
		  arrlist.add("C"); 
		  arrlist.add("D"); 
		     
		  while(!this.a_visiter_x.empty()) {// on s'arrete des que la liste est vide
			  Collections.shuffle(arrlist);
				
			
			  x_actuel=this.a_visiter_x.pop();
			  y_actuel=this.a_visiter_y.pop();
			  prevx=this.pere_x.pop();
			  prevy=this.pere_y.pop();
			  if(this.elements[x_actuel][y_actuel] ==  Objet.MUR) {
				  this.elements[x_actuel][y_actuel] =  Objet.SOL;
				  this.elements[(x_actuel+prevx)/2][(y_actuel+prevy)/2] =  Objet.SOL;
			
				
	
			    for(int r=0;r<4;r++) {
			    	
			    	priorite=(String)arrlist.get(r);
			    	
			    
					if((x_actuel+2<this.width-1) && priorite=="A") {// x+2 y+0
						this.a_visiter_x.push(x_actuel+2);
						this.a_visiter_y.push(y_actuel);
						this.pere_x.push(x_actuel);
						this.pere_y.push(y_actuel);
					}
					if(x_actuel-2>0  && priorite=="B") {// x-2 y+0
						this.a_visiter_x.push(x_actuel-2);
						this.a_visiter_y.push(y_actuel);
						this.pere_x.push(x_actuel);
						this.pere_y.push(y_actuel);
					}
					if((y_actuel+2<this.height-1)  && priorite=="C") {// x+0 y+2
						this.a_visiter_x.push(x_actuel);
						this.a_visiter_y.push(y_actuel+2);
						this.pere_x.push(x_actuel);
						this.pere_y.push(y_actuel);
					}
					if(y_actuel-2>0  && priorite=="D") {// x+0 y-2
						this.a_visiter_x.push(x_actuel);
						this.a_visiter_y.push(y_actuel-2);
						this.pere_x.push(x_actuel);
						this.pere_y.push(y_actuel);
					}
			    }
			}
			}
			
		return elements;
	}// end mazing
	
	private int getRandomNumberInRange(int min, int max) {// [min,max]

		if (min >= max) {
			throw new IllegalArgumentException("max must be greater than min");
		}

		Random r = new Random();
		return r.nextInt((max - min) + 1) + min;
	}
	
	
	public void creerSalles(int[][] tab) {// 1 signifit que c'est une salle
		for (int x = 0; x < tab.length; x++) {
			for (int y = 0; y < tab[0].length; y++) {
				tab[x][y] = 0;
			}
		}
		int x1,y1;
		int sizex,sizey;
		int droit=0;
		

		
		for (int i = 0; i <this.niveau+5; i++) {
			// le nombre de tentative de creation de salles
			
			sizex=this.getRandomNumberInRange(5,tab.length/5);
			sizey=this.getRandomNumberInRange(4,tab[0].length/5);
			x1= this.getRandomNumberInRange(1,tab.length - sizex-1);
			y1= this.getRandomNumberInRange(1,tab[0].length - sizey-1);
			for (int x = x1; x < sizex; x++) {
				for (int y = y1; y < sizey; y++) {
					if(tab[x][y] ==1) droit=1;
				}
			}
			if(droit==0) {

				for (int x = x1; x < x1+sizex; x++) {
					for (int y = y1; y < y1+sizey; y++) {
						
						tab[x][y] =1;
					}
				}
			}else {
				droit=0;
			}
			
		}
		for (int x = 0; x < tab.length; x++) {
			for (int y = 0; y < tab[0].length; y++) {
				if(tab[x][y] ==1) {
					this.elements[x][y]=Objet.SOL;	
				}
			}
		}
		//return tab;    // tab est modifiée dirrectement
	}
	
	public boolean est_dans_salle(int[][] tab,int x,int y) {// 1 for yes
		if(tab[x][y] ==1) return true;
		else
		return false;
	}
	
	public ElementUnivers[][] ajout_monstres(int[][] tab_salle) {
		int chance=10;
	      List<String> arrlist = new ArrayList<String>();
	      String priorite="A";
	      arrlist.add("A");
		  arrlist.add("B");
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				if(est_dans_salle(tab_salle, x, y)&& (this.elements[x][y]== Objet.SOL))
					
					if( chance > this.getRandomNumberInRange(0,100)){
						
						Collections.shuffle(arrlist);
				    	priorite=(String)arrlist.get(0);
				    	
					    
						if( priorite=="A") {// x+2 y+0
							this.elements[x][y] =  new Golbin( x,  y);
						}
						if(priorite=="B") {// x-2 y+0
							this.elements[x][y] =  new Zombie( x,  y);
						}
						
					}
					
			}
		}
		return elements;
	}
	
	public void addEscalier(int[][] tab_salle){
		int x;
		int y;
		x = (int)(Math.random() * width);
		y = (int)(Math.random() * height);
		while( ( (elements[x][y] != Objet.SOL) ) || !(est_dans_salle(tab_salle, x, y)))
		{
			x = (int)(Math.random() * width);
			y = (int)(Math.random() * height);
			
		}
		
		elements[x][y]=Objet.ESCALIER;

		
		
	}
	public void addPomme(){
		int x;
		int y;
		x = (int)(Math.random() * width);
		y = (int)(Math.random() * height);
		for(int w=0;w<5;w++){
			
			while( ( (elements[x][y] != Objet.SOL) ))
			{
				x = (int)(Math.random() * width);
				y = (int)(Math.random() * height);
				
			}
			elements[x][y]=Objet.POMME;
		}
	}
	
		public void addPNJ(int[][] tab_salle){
			int x;
			int y;
			x = (int)(Math.random() * width);
			y = (int)(Math.random() * height);
			while( ( (elements[x][y] != Objet.SOL) ) || !(est_dans_salle(tab_salle, x, y)))
			{
				x = (int)(Math.random() * width);
				y = (int)(Math.random() * height);
				
			}
			
			elements[x][y]=new PNJ( x,  y);

			
			
		}
	
	
	
	
	
	
	
	
	
	
	//////////////     //////////
}
