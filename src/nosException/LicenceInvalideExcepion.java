package nosException;
/**
 * 
 * cette classe sert a generer une exception quand la licence du joueur a ajoute n'est pas valide donc quand sa date de validite 
 * est depasse.
 * @author malik,timote
 *@version 1
 *
 */
@SuppressWarnings("serial")
public class LicenceInvalideExcepion extends Exception {

	
	/**
	 * cette methode genere l'exception sans parametre.
	 */
	public LicenceInvalideExcepion() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * cette methode genere l exception avec un parametre 
	 * @param message de type String qui correspond au message d'indication sur l'exception .
	 */
	public LicenceInvalideExcepion(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

}
