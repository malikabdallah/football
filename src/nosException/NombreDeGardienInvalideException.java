package nosException;
/**
 * cette classe sert a generer une exception quand le nombre de gardien n'est pas valide , une equipe doit avoir un gardien , il doit etre le seul gardien de l'equipe
 * et doit etre dans l'equipe titulaire .
 * @author malik,timote
 * @version 1
 *
 */
@SuppressWarnings("serial")
public class NombreDeGardienInvalideException extends Exception {

	
	/**
	 * cette methode genere l'exception sans parametre.
	 */
	public NombreDeGardienInvalideException() {
		super();
		// TODO Auto-generated constructor stub
	}

	

	/**
	 * cette methode genere l exception avec un parametre 
	 * @param message de type String qui correspond au message d'indication sur l'exception .
	 */
	public NombreDeGardienInvalideException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	

}
