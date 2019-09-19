package roguelike;

import java.awt.event.KeyEvent;
import asciiPanel.AsciiPanel;


public class EcranPerdu implements InterfaceAffichage {

    public void displayOutput(AsciiPanel terminal) {
        terminal.writeCenter("Vous avez Perdu", 10);
        terminal.writeCenter("ENTRER: Reprendre", 22);
    }

    public InterfaceAffichage respondToUserInput(KeyEvent key) {
        return key.getKeyCode() == KeyEvent.VK_ENTER ? new EcranJeu() : this;
    }

}
