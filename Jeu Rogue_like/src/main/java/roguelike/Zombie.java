package roguelike;

import java.awt.Color;

import asciiPanel.AsciiPanel;

public class Zombie extends Monstre{
	
	final static char symbole=('Z');
	final static Color color=AsciiPanel.red;
	
	
	public Zombie(int x, int y){
		super(x,y);
		this.set_PV_actuel(100);
		this.set_attaque(1+(int)(Math.random() *5));
		this.set_armure(0);
		this.set_xp_value(1);
		this.set_direction_x(1);
		this.set_direction_y(0);
	
	}
	
	public char get_symbole() { return symbole; }
	
	
	public Color get_color() { return color; }

	
}
