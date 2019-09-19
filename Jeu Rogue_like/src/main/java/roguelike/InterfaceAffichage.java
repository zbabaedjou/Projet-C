package roguelike;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;

public interface InterfaceAffichage {
	

	    public void displayOutput(AsciiPanel terminal);

	    public InterfaceAffichage respondToUserInput(KeyEvent key);
	
}
