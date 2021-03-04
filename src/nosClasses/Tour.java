package nosClasses;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>
 * Cette classe represente un tour d'un tournoi , un tour est compose de :
 * </br>
 * une liste de match de type ArrayList car le nombre de match d un tour n est pas limite
 * <br/>
 * un numero de tour 
 *
 *</p>
 * @author malik,timote
 * @version 1
 
 *
 *@see Match
 *
 */

public class Tour {

	/**
	 * la liste des match qui ont eu lieu pendant le tour. Il s agit d un arrayList car il n y a pas de limite de taille
	 * au nombre de match contenu dans un tour . 
	 * 
	 *@see Match
	 */
	private ArrayList<Match> listeMatch ;
	
	
	/**
	 * sert variable sert a compter le nombre de tour instancier et est s auto-incremente a chaque fois
	 */
	static int tour=1 ;
	
	
	/**
	 * represente le numero du tour 
	 */
	private int nbTour ;
	
	
	/**
	 * constructeur par defaut
	 */
	public Tour() {
		listeMatch=new ArrayList<Match>();
		nbTour=tour;
		tour++;
	} 
	
	
	/**
	 * retour la liste des matchs qui ont lieu pendant ce tour
	 * @return la liste des matchs qui ont lieu pendant ce tour
	 */
	public List<Match> getListeMatch() {
		return listeMatch;
	}
	
	
	
	
	/**
	 * renvoie une chaine de caractere qui renvoie les infos de chaque matchs qui ont lieu pendant ce tour 
	 * @see Match#toString()
	 */
	public String toString () {
		String s="Tour:"+this.nbTour+"\n";
		for( int i=0; i<listeMatch.size(); i++) {
			s=s+listeMatch.get(i).toString(); 
						
		}
		return s; 
		
	}
	
	
	
	
	
		
}
