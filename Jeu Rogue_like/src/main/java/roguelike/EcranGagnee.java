package roguelike;


import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public class EcranGagnee implements InterfaceAffichage {
	

	    public void displayOutput(AsciiPanel terminal) {
	        //terminal.write("Vous avez gagné.", 1, 1);
	       // terminal.writeCenter("-- Appuyez [entrer] pour reprendre --", 22);
	    }

	    public InterfaceAffichage respondToUserInput(KeyEvent key) {
	        return key.getKeyCode() == KeyEvent.VK_ENTER ? new EcranJeu() : this;
	    }
	

}
