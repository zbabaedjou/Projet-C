package roguelike;
	import java.awt.event.KeyEvent;
	import asciiPanel.AsciiPanel;
public class EcranDemarage implements InterfaceAffichage{
	

	

	    public void displayOutput(AsciiPanel terminal) {
	    	terminal.writeCenter("RogueLike Game " ,1,AsciiPanel.red);
	    	terminal.writeCenter("-- Appuyez sur [entrer] pour démarer --", 45);
	    }

	    public InterfaceAffichage respondToUserInput(KeyEvent key) {
	        return key.getKeyCode() == KeyEvent.VK_ENTER ? new EcranJeu() : this;//si la touche entré est pressé renvoyer à l'écran de jeu
	    }
	


}
