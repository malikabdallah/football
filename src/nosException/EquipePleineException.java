package nosException;
import nosClasses.*;
/**
 * Cette classe sert a generer une exception quand l'equipe ou un joueur va etre ajoute est pleine , ce qui signifie
 * que le nombre maximal autorise pour l'equipe titulaire et pour l'equipe remplcantes est atteind , par 
 * consequent le joueur ne pourra pas integre l'equipe.
 * 
 * @version 1 
 * @author malik,Timoté
 *@see Equipe
 *@see Joueur
 *@see Licencie
 *@see Gardien
 */
@SuppressWarnings("serial")
public class EquipePleineException extends Exception {

	
	
	/**
	 * cette methode genere l'exception sans parametre.
	 */
	public EquipePleineException() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	/**
	 * cette methode genere l exception avec un parametre 
	 * @param message qui correspond au message d'indication sur l'exception.
	 */
	public EquipePleineException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	
	
	

}
