
package projet;
import java.util.List;
import java.util.ArrayList;
/**
 * @author NIANG Ndeye Fatou 
 * @author ELMCHICHI Maryem 
 * @author Ziadath BABAEDJOU
 * 
 */
public class Lucene 
{
	public List_Attribut list;
//Creation d'index
private  List<Note> comp=new ArrayList<Note>();

public void add (Note n)
{
  comp.add(n);
} 

public List<Note>getlist()
{
    return comp;
}
}


