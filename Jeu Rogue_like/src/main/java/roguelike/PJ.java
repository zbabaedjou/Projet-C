package roguelike;

import java.awt.Color;

import asciiPanel.AsciiPanel;

public class PJ extends Joueur{

	final static char symbole=((char)72);
	final static Color color=AsciiPanel.white;
	
	public PJ(int x,int y) {
		super(x,y);
		this.set_PV_actuel(100);
		this.set_attaque(20);
		this.set_armure(0);
		this.set_xp_value(1);
		this.set_direction_x(1);
		this.set_direction_y(0);
		
	}
	
	public char get_symbole() { return symbole; }
	
	
	public Color get_color() { return color; }
	
	
	
}
