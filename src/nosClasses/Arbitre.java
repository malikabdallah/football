package nosClasses;
import java.util.Calendar;

/**
 * <p>
 * Cette classe represente les arbitres du tournoi qui officie lors des matchs , elle herite de la classe abstraite Licencie avec un seul attribut supplementaire:
 * <br/>
 * 		-La categorie de type entier qui ne changera pas 
 * </p>
 * 
 * 
 * @author malik,timote
 * @version 1
 * @see Licencie
 */


public class Arbitre extends Licencie{
	
	
	/**
	 * Correspond a la cateogrie de l'arbitre  qui est un entier entre 1 et 3 
	 * @see Arbitre#getCategorie()
	 * @author malik,timote
	 * @version 1
	 * 
	 */
	private int categorie;
	
	
	
	/**
	 * 
	 * @param nom correspond au nom de l'arbitre 
	 * @param prenom correspond au prenom de l'arbitre
	 * @param dateDeValidite correspond à la date de validite de l'arbitre de type Calendar
	 * @param club correspond au club ou est affecte l arbitre
	 * 
	 * @see Arbitre#categorie
	 * @see Licencie
	 * @see Club
	 * @see Licencie#Licencie(String, String, Calendar, Club)
	 * 
	 * 
	 * Ce constructeur reçoit les parametres necessaire au constructeur de la classe parente licencie et la categorie de l'arbitre
	 * est choisie aleatoirement avec un Math.random.
	 */
	
	public Arbitre(String nom, String prenom, Calendar dateDeValidite, Club club) {
		super(nom, prenom, dateDeValidite, club);
		this.categorie=(int)(Math.random()*3)+1;
		// TODO Auto-generated constructor stub
	}


	
	
	
	/**
	 * ce getter permet de recuperer au besoin la categorie de l arbitre 
	 * @return un entier correspondant  a la categorie de l arbitre
	 */
	public int getCategorie() {
		return categorie;
	} 
	
	
	
	
	

}
