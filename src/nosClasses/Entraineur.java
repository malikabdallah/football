package nosClasses;
import java.util.Calendar;

/**
 * 
 * <p>
 * Cette classe represente les entraineurs des equipes du tournoi , elle herite de la classe abstraite Licencie avec un seul attribut supplementaire:
 * <br/>
 * 		Le niveau de l'entaineur qui est un entier dont la valeur ne changera pas
 * 
 * 
 * </p>
 * 
 * @see Licencie
 * @author malik,timote
 * @version 1
 *
 *@see Equipe
 *@see Licencie
 */






public class Entraineur extends Licencie {
	

	/**
	 * Correspond au niveau de l'entraineur  qui est un entier entre 1 et 5
	 * @see Entraineur#getNiveau()
	 * @see Entraineur#Entraineur(String, String, Calendar, Club)
	 * 
	 * @author malik,timote
	 * @version 1
	 * 
	 */
	private int niveau;

	
	
	
	
	/**
	 * 
	 * @param nom correspond au nom de l'entraineur
	 * @param prenom correspond au prenom de l'entraineur
	 * @param dateDeValidite correspond a la date de validite de l'entraineur de type Calendar
	 * @param club correspond au club ou est affecte l'entraineur
	 * 
	 * 
	 * @see Licencie
	 * @see Club
	 * @see Licencie#Licencie(String, String, Calendar, Club)
	 * 
	 * 
	 * Ce constructeur reçoit les parametres necessaire au constructeur de la classe parente licencie et le niveau de l'entaineur
	 * est choisie aleatoirement avec un Math.random.
	 * 
	 */
	public Entraineur(String nom, String prenom, Calendar dateDeValidite,
			Club club) {
		super(nom, prenom, dateDeValidite, club);
		this.niveau=(int)(Math.random()*5)+1;
		// TODO Auto-generated constructor stub
	}

	
	
	
	/**
	 * ce getter permet de recuperer au besoin le niveau de l'entraineur
	 * @return le niveau de l arbitre
	 */
	public int getNiveau() {
		return niveau;
	} 
	
	

	
	

}
