package projet;
/**
 * @author NIANG Ndeye Fatou 
 * @author ELMCHICHI Maryem 
 * @author Ziadath BABAEDJOU
 * 
 */
public class Invoker {
	
	 private Command command;
	  public void setCommand(Command command){
	    this.command = command;
	  }
	  public void pressButton(String mot){
	    command.execute(mot);
	  }

}
