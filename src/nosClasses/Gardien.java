package nosClasses;
import java.util.Calendar;

/**
 * <p>
 * cette classe donne le moule des instances gardien qui composent chaque equipe participantes . Il y a un seul 
 * Gardien par equipe et celui est forcement dans l'equipe titulaire . Cette classe herite de classe Joueur
 * et se distigngue avec un attribut supplementaire qui est : 
 * <br/>
 * La moyenne du gardien qui est un entier qui correspond à la performance du gardien à savoir sa capacite a encaisser 
 * le moins de buts possible ( sa valeur est calculer a chaque match grace  a l implementation de l interface Moyenne et 
 * ses methodes
 * </p>
 * 
 * 
 * @see Joueur
 * @see Licencie
 * @see Moyenne
 * 
 * 
 * 
 * @author malik,timote
 *@version 1
 */


public class Gardien extends Joueur implements Moyenne{
	
	
	/**
	 * cette attributs correspond à la moyenne du gardien sur 10, initialise au depart à 10 celle ci evoluera
	 * constament au fur des matchs .
	 * @see Gardien#calculerMoyenne(int)
	 */
	private int moyenne=10;
	
	
	
	
	
	/**
	 * cette methode issue de l interface Moyenne , permet de calculer la moyenne  du gardien suivant le nombre de but
	 * encaisse sur ce match et la moyenne des precedents matchs .
	 * 
	 * @param nbButEncaisser cette entier correspond au nombre de buts qui vient d'etre encaisser lors du dernier match joue
	 * 
	 *@see Moyenne
	 */
	public void calculerMoyenne(int nbButEncaisser){
		int evaluation=5 ; 
		switch(nbButEncaisser){
			case 0:evaluation=10; break;
			case 1:evaluation=9;break;
			case 2:evaluation=7;break;
			case 3:evaluation=3;break;
			case 4:evaluation=1;break;
			default: evaluation=0; break;
		}
		moyenne=(moyenne+evaluation)/2;
		
				
	}
	
	
	/**
	 * ce getter permet de recuperer a tout moment la moyenne du gardien 
	 * @return un entier qui correspond  a la moyenne du gardien 
	 */
	public int getMoyenne(){
		return moyenne; 
	}
	
	
	
	
	
	/**
	 * 
	 * @param num le numero de licence du gardien
	 * @param nom le nom du gardien
	 * @param prenom le prenom du gardien
	 * @param dateDeValidite la date de validite du gardien de type Calendar
	 * @param club le club du gardien
	 * @param poste le poste du gardien
	 * @param numMaillot le numero de maillot du gardien
	 * 
	 * 
	 * @see Club
	 * @see Joueur
	 * @see Equipe
	 * @see Licencie
	 * @see Joueur#Joueur(int, String, String, Calendar, Club, String, int)
	 * 
	 * Ce constructeur  se distingue des autres car il prend en parametre le numero de licence et le numero de maillot du Licencie
	 * 
	 * 
	 */
	public Gardien(int num,String nom, String prenom, Calendar dateDeValidite, Club club, String poste, int numMaillot) {
		super(num,nom, prenom, dateDeValidite, club, poste, numMaillot);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	/**
	 * 
	 * 
	 * @param nom le nom du gardien
	 * @param prenom le prenom du gardien
	 * @param dateDeValidité la date de validite du gardien de type Calendar
	 * @param club le club du gardien
	 * @param poste le poste du gardien
	 * @param numMaillot le numero de maillot du gardien
	 * 
	 * 
	 * @see Club
	 * @see Joueur
	 * @see Licencie
	 * @see Equipe
	 * @see Joueur#Joueur(String, String, Calendar, Club, String, int)
	 * 
	 * Ce constructeur se distingue des autres car il ne prend pas  en parametre le numero de licence
	 *  mais il prend le numero de maillot. Le numero de Licence sera obtenu grace a une valeur static qui compte
	 *  le nombre d instance de joueur et attribut cette valeur a l attribut numero de licencie .
	 *  
	 *
	 */
	
	public Gardien(String nom, String prenom, Calendar dateDeValid, Club club, String poste, int numMaillot) {
		super(nom, prenom, dateDeValid, club, poste, numMaillot);
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	/**
	 * 
	 * @param nom le nom du gardien
	 * @param prenom le prenom du gardien
	 * @param dateDeValidité la date de validite du gardien de type Calendar
	 * @param club le club du gardien
	 * @param poste le poste du gardien
	 * 
	 * @see Club
	 * @see Joueur
	 * @see Licencie
	 * @see Equipe
	 * @see Joueur#Joueur(String, String, Calendar, Club, String)
	 * 
	 * 
	 * Ce constructeur se distingue des autres car il ne prend pas en parametre le numero de licence et le numero de maillot
	 * Le numero de maillot sera choisit par defaut a zero .Ce constructreur est a choisir si dans l'equipe c'est toujours 
	 * le gardien qui a le numero zero pour eviter d'avoir a indique le numero de maillot dans les parametre .
	 */
	
	public Gardien(String nom, String prenom, Calendar dateDeValid, Club club, String poste){
		super(nom,prenom,dateDeValid,club,poste,0);
		
	}
	

	
		
}
