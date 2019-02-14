package silly_app.roy;

public class Fortschritt {
	
	// Zahl zwischen 0 und 100 merken
	private Integer iFortschritt;

	public Fortschritt() {
		// TODO Auto-generated constructor stub
		this.iFortschritt = 0 ;
	}
	
	public int Set( int iWert ) {
		int iReturn = 0 ;
		
		if ( iWert < 0 || iWert > 100 ) 
			iReturn = -1 ;
		else
			this.iFortschritt = iWert ;
		
		return iReturn;
	}
	
	public Integer Get() {
		return this.iFortschritt ;
	}
	
}
