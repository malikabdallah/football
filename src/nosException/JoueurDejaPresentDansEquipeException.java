package nosException;

/**
 * 
 * cette classe sert a generer une exception quand le joueur que l'on va ajoute dans l'equipe s'y trouve deja car chaque equipe 
 * est evidement compose de joueur unique et il ne peut pas y avoir deux fois le meme joueur .
 * 
 * @author malik,timote
 * @version 1
 *
 */
@SuppressWarnings("serial")
public class JoueurDejaPresentDansEquipeException extends Exception {


	/**
	 * cette methode genere l'exception sans parametre.
	 */
	public JoueurDejaPresentDansEquipeException() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * cette methode genere l exception avec un parametre 
	 * @param message de type String qui correspond au message d'indication sur l'exception .
	 */
	public JoueurDejaPresentDansEquipeException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	

}
