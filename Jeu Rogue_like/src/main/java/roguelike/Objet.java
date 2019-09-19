package roguelike;

import java.awt.Color;
import java.util.Random;

import asciiPanel.AsciiPanel;

public enum Objet implements ElementUnivers{
    SOL((char)250, AsciiPanel.yellow),
    MUR((char)177, AsciiPanel.yellow),
	POMME((char)233,AsciiPanel.green),
	PARCHEMIN_DE_FORCE('?',AsciiPanel.white),
	ESCALIER('E',AsciiPanel.white);    
    
	
	private char symbole;
    private Color color;
    
    public char get_symbole() { return symbole; }

    public Color get_color() { return color; }

    Objet(char symbole, Color color){
        this.symbole = symbole;
        this.color = color;
    }
    
    
    /**
     * Choisi un élément de Objet au hasard
     * @return un objet
     */
    public static Objet getRandomElement() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
    
    
    /**
     *  vérifi si un objet est remplaçable(si c'est un SOL)
     * @return true si l'élement est un sol, false sinon
     */
    public boolean estRemplacable() {
    	return this.symbole == SOL.symbole;
	}
    public boolean estDansSalle(int tableau[][], int x,int y) {
    	return tableau[x][y]== 1; // 1 signifit que c'est une salle
	}
    
}

