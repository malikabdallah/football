package nosClasses;
import java.util.Calendar;

/**
 * <p>
 * Cette classe represente le moule globale des participants du tournoi , cette classe est abstraite et fournit 
 * l'essentiel des caracteristiques des participants . Elle est compose de plusieurs attributs :
 * <br/>
 * - le numero de licence qui est un entier , dont la valeur ne change pas et qui est unique au sein d'une equipe . Dans une meme equipe
 * il ne peut pas y a voir de joueur avec le meme numero de licence .
 * <br/>
 * -le nom du  licencie
 * <br/>
 * -le prenom du licencie
 * <br/>
 * -la date de validite du licencie qui est de type calendar 
 * <br/>
 * -le club du licencie 
 * </p>
 * 
 * 
 * 
 * 
 * @see Equipe
 * @see Arbitre
 * @see Entraineur
 * @see Joueur
 * @see Gardien
 * @see Club
 * @see Equipe
 * 
 * @author malik,timote
 * @version 1
 * 
 * 
 * 
 * 
 *
 */



public abstract class Licencie {
	
	
	/**
	 * cette attribut static sert a compter le nombre d instance de type licencie
	 */
	private static int nbInstance=0;
	
	
	
	/**
	 * cette attribut qui n est pas changable correspond au numero de licence du joueur est doit etre unique dans une meme equipe
	 */
	private int numeroDeLicence;
	
	
	
	/**
	 * cette attribut correspond au nom du licencie
	 */
	private String nom;
	
	
	/**
	 * cette attribut correspond au prenom du licencie
	 */
	private String prenom;
	
	
	
	/**
	 * cette attribut correspond a la date de validite du licencie , pour ajouter un joueur a une equipe sa date de validite
	 * doit etre correcte , il reste cependant possible de mettre la licence a jour 
	 * @see Joueur#mettreAJourLicence()
	 * @see Licencie#setDateDeValidité(Calendar)
	 */
	private Calendar dateDeValidite; 
	
	
	/**
	 * cette attribut correspond au club ou le licencie est affilie et est par consequent unique et inchangable
	 * @see Club
	 */
	private Club club ;
	
	
	
	/**
	 * 
	 * 
	 * Le numero de licence n etend pas donne en parametre , il est obtenu grace a la variable
	 * nbInstance qui s auto-incremente  a chque fois qu' un Licencie est instancie . 
	 * Cette valeur du nombre d'instance de type Licencie est affecte au numero de Licence .
	 * Par consequent si lorseque on va creer le dizieme licencie , son numero de licence sera dix .
	 * 
	 * 
	 * 
	 * @param nom correspond au nom du Licencie
	 * @param prenom correspond au prenom du Licencie
	 * @param dateDeValidite correspond a la date
	 * @param club correspond au club ou est affilié le le Licencie
	 */
	public Licencie(String nom, String prenom, Calendar dateDeValidite,
			Club club) {
		super();
		this.numeroDeLicence=nbInstance;
		nbInstance++;
		this.nom = nom;
		this.prenom = prenom;
		this.dateDeValidite = dateDeValidite;
		this.club = club;
	}
	
	
	
	
	
	/**
	 * 
	 * @param nb correspond au numero de licence du Licencie
	 * @param n correspond au nom du Licencie
	 * @param prenom correspond au prenom du Licencie
	 * @param date correspond a la date de validite du Licencie  de type Calendar
	 * @param club correspond au club ou est affilié le Licencie
	 * 
	 * Toutes les valeurs des attributs sont données en parametre y compris le numero de licence
	 * la valeur du nbInstance s'auto-incremente au cas ou plus tard un appel au deuxieme constructeur est lieu
	 * 
	 *@see Club
	 *@see Licencie#Licencie(String, String, Calendar, Club)
	 *
	 * 
	 */
	public Licencie(int nb ,String n, String prenom, Calendar date , Club club){
		this.numeroDeLicence=nb;
		nbInstance++;
		this.nom=n;
		this.prenom=prenom;
		this.dateDeValidite=date; 
		this.club=club;
	}
	
	
	
	/**
	 *ce setter permet de modifier la date de validite du Licencie dans le cas ou celle ci ne serait pas valide 
	 *
	 *@see Licencie#dateDeValidite
	 *@see Joueur#mettreAJourLicence()
	 */
	public void setDateDeValidite(Calendar object){
		this.dateDeValidite=object;
	}
	

	
	/**
	 * ce getter permet de savoir combien d objet Licencie ont ete instancie
	 * @return un int qui compte le nombre d instance de type Licencie
	 */
	public int getNbInstance() {
		return nbInstance;
	}


	
	/**
	 * ce getter permet d obtenir le numero de licence du Licencie
	 * @return le numero de licence du Licencie
	 * @see Licencie#numeroDeLicence
	 */
	public int getNumeroDeLicence() {
		return numeroDeLicence;
	}




	/**
	 * ce getter permet d obtenir le nom du Licencie
	 * @return le nom du Licencie
	 */
	public String getNom() {
		return nom;
	}



	/**
	 * ce getter permet d obtenir le prenom du Licencie
	 * @return le prenom du Licencie
	 */
	public String getPrenom() {
		return prenom;
	}




	/**
	 * ce getter permet d obtenir la date de validite du Licencie
	 * @return la date de validite du Licencie
	 */
	public Calendar getDateDeValidite() {
		return dateDeValidite;
	}




	/**
	 * ce getter permet d obtenir le club du licencie
	 * @return le club du Licencie
	 */
	public Club getClub() {
		return club;
	}





	/**
	 * retourne une chaine de caractere avec toutes les informations du Licencie
	 */
	public String toString() {
		return "Licencie [numeroDeLicence=" + numeroDeLicence + ", nom=" + nom
				+ ", prenom=" + prenom + ", dateDeValidité=" + dateDeValidite.get(Calendar.DAY_OF_MONTH)+"/"+(dateDeValidite.get(Calendar.MONTH)+1)+"/"+dateDeValidite.get(Calendar.YEAR)
				+ ", club=" + club.getVille() + "]";
	}




	/**
	 * un entier qui correspond au hashCode du joueur,qui est un entier qui sert a identifié le Licencie . Si deux objet ont le meme hashCode alors 
	 * ils sont egaux d'apres la methode equals .
	 */
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + numeroDeLicence;
		return result;
	}





	/**
	 * sert a definir si deux objets de type Licencie sont egaux ,ici le critere d'egalite est le numero de licence
	 * deux Licencie sont egaux si et seulement si ils ont le meme numero de licence .
	 * @param obj passe un objet en parametre de type Licencie et on teste s'il est egal  a l objet appelant
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Licencie other = (Licencie) obj;
		if (numeroDeLicence != other.numeroDeLicence)
			return false;
		return true;
	} 
	
	
	
	
}
