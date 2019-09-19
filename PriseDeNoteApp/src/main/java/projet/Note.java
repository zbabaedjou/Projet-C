package projet;


import java.io.Serializable;
import java.util.Date;

/**
 * @author NIANG Ndeye Fatou 
 * @author ELMCHICHI Maryem 
 * @author Ziadath BABAEDJOU
 * 
 */
public class Note  implements Serializable{
	/**
	 * @author NIANG Ndeye Fatou 
	 * @author ELMCHICHI Maryem 
	 * @author Ziadath BABAEDJOU
	 * 
	 */
	private static final long serialVersionUID = 1L;
		private String nom;
	    private String projet;
	    private String context;
	    private Date  date;

	    
	    
	    public String getNom() {
			return nom;
		}
	    public String getProjet() 
	        {
	            return projet;
	        }

	    public String getContext() 
	        {
	            return context;
	        }


	    public Date getDate()

	        {
	            return date;
	        }
	    
	    public Note (Builder builder)
	        {

	    		this.nom =builder.buildnom; 
	             this.projet=builder.buildprojet;
	             this.context=builder.buildcontext;
	             this.date=builder.builddate;

	        }

	           
	     public static class Builder
	        {

	                 private String buildnom;
	    	 		 private String buildprojet;
	                 private String buildcontext;
	                 private Date builddate;
	                 
	             public Builder (String nom)
	                {
	            	 	this.buildnom=nom;
	            	 	this.builddate=new Date();

	                    this.buildprojet="DefaultProject";
	                    this.buildcontext="DefaultContext";
	                   
	                }
	         
	                
	                      public Note build() 
	                      {
	                      return new Note(this);
	                      }
	              public Builder addProjet(String projet) {
	                      	  this.buildprojet=projet;
	                      	  return this;
	                      			  }
	              public Builder addContext(String context) {
	                      	  this.buildcontext=context;
	                      	  return this;
	                        }
	                	
	        }
	
}
