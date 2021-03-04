package nosException;
/**
 * 
 * cette classe sert a generer une exception si le joueur est ajoute dans le mauvais club , un joueur ne peut pas rejoindre un club
 * s'il n'est pas inscrit dans ce club. 
 * @author malik,timote
 * @version 1
 *
 *
 *
 */
@SuppressWarnings("serial")
public class JoueurLicencieAutreClubException extends Exception{

	/**
	 * cette methode genere l'exception sans parametre.
	 */
	public JoueurLicencieAutreClubException() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * cette methode genere l exception avec un parametre 
	 * @param message de type String qui correspond au message d'indication sur l'exception .
	 */
	public JoueurLicencieAutreClubException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
