package nosClasses;
/**
 * 
 * @author malik,timote
 * @version 1
 *<p>
 * cette interface definit les methodes a implementer pour calculer la moyenne pour les objets de type gardiens.
 * Elle definit un seul methode abstraite calculerMoyenne qui prend un parametre correspondant au nombre de but
 * encaiser .
 * </p>
 * 
 *@see Gardien
 */
public interface Moyenne {
	
	/**
	 * 
	 * @param butEncaiser nb de but encaisser par le goal
	 */
	public void calculerMoyenne (int butEncaiser);
	
	
	

}
