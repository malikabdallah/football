package nosClasses;
import java.util.Calendar;

/**
 * <p>
 * Cette classe donne le moule des objets de type de joueur , les joueurs composent les equipes et sont les acteurs
 * principaux des matchs .Cette classe herite de la classe abrstraite Licencie  et possede trois attributs en plus . 
 * <br/>
 * -le poste qui est une chaine de caractere qui ne changera pas 
 * <br/>
 * -le numero de maillot qui est un entier qui ne changera pas
 * <br/>
 * -le nombre de buts marque par le joueur qui est initialise a zero , 
 * 
 * </p>
 * 
 * @see Licencie
 * @see Gardien
 * @see Equipe
 * 
 * @author malik,timote
 * @version 1
 *
 */


public class Joueur extends Licencie implements Comparable<Joueur> {
	
	
	
	/**
	 * cette attribut correspond au poste du joueur , il s'agit d'une chaine de caractere dont la valeur ne changera pas
	 */
	private String poste; 
	
	
	/**
	 * cette attribut correspond au numero de maillot de chaque joueur , il s'agit d un entier dont la valeur ne changera pas 
	 */
	private int numMaillot;
	
	
	/**
	 * cette attribut correspond au nombre du but du joueur au cours du tournoi
	 */
	private int nbButs; 
	
	
	
	/**
	 * 
	 * @param nom correspond au nom du joueur
	 * @param prenom correspond au prenom du joueur
	 * @param dateDeValidité correspond a la date de validite du joueur de type Calendar
	 * @param club correspond au club du joueur, un joueur joue dans un seul club 
	 * @param poste correspond au poste du joueur
	 * @param numMaillot correspond au numero de maillot du joueur
	 * 
	 * 
	 * cette methode fait appel au constructeur de la classe parente qui ne prend pas en parametre le numero de licence mais
	 * genere le numero grace a un entier static qui correspond au nombre d'instance de type licencie .Avec ce constructeur , 
	 * le 10 joueur crée aura 10 pour numero de licence ,le 11eme joueur cree aura 11 pour numero de licence et ainsi de suite .
	 * il prend aussi en parametre le numero de maillot .
	 * 
	 * 
	 * @see Licencie
	 * @see Equipe
	 * @see Club
	 * @see Licencie#Licencie(String, String, Calendar, Club)
	 */
	public Joueur(String nom, String prenom, Calendar dateDeValid,Club club, String poste, int numMaillot) {
		super(nom, prenom, dateDeValid, club);
		this.poste = poste;
		this.nbButs=0;
		this.numMaillot = numMaillot;
	}
	

	
	
	
	
	/**
	 * 
	 * @param nom correspond au nom du joueur
	 * @param prenom correspond au prenom du joueur
	 * @param dateDeValidité correspond a la date de validite du joueur de type Calendar
	 * @param club correspond au club du joueur , un joueur joue dans un seul club
	 * @param poste correspond au poste du joueur
	 * 
	 * cette methode fait appel au constructeur de la classe parente qui ne prend pas en parametre le numero de licence mais
	 * genere le numero grace a un entier static qui correspond au nombre d'instance de type licencie .Avec ce constructeur , 
	 * le 10 joueur crée aura 10 pour numero de licence ,le 11eme joueur cree aura 11 pour numero de licence et ainsi de suite .
	 * Ce constructeur a aussi pour particularite de ne pas prendre en parametre le numero de maillot du joueur  , on affectera donc
	 * la valeur du numero de licence au numero de maillot . Par consequent le joueur avec numero de licence 10 aura 10 comme numero de
	 * maillot
	 * 
	 * 
	 * @see Licencie
	 * @see Equipe
	 * @see Club
	 * @see Licencie#Licencie(String, String, Calendar, Club)
	 * 
	 */
	public Joueur(String nom, String prenom, Calendar dateDeValid, Club club, String poste) {
		super(nom, prenom, dateDeValid, club);
		this.poste = poste;
		this.nbButs=0;
		this.numMaillot = super.getNumeroDeLicence();
	}
	
	
	
	
	
	
	
	/**
	 * 
	 * @param nb correspond au numero de licence affecte au joueur
	 * @param nom correspond au nom du joueur
	 * @param prenom correspond au prenom du joueur
	 * @param date correspond a la date de validite du joueur de type Calendar
	 * @param club correspond au club du joueur, un joueur joue dans un seul club 
	 * @param poste correspond au poste du joueur
	 * @param numeroMaillot correspond au numero de maillot du joueur 
	 * 
	 * dans cette version du constructeur tous les parametres  de la classe et sa classe parente sont donne en parametre .
	 * @see Licencie
	 * @see Club
	 * @see Equipe
	 * @see Licencie#Licencie(int, String, String, Calendar, Club)
	 * 
	 * 
	 */
	public Joueur (int nb , String nom , String prenom , Calendar date , Club club, String poste , int numeroMaillot){
		super(nb,nom,prenom,date,club);
		this.poste=poste;
		this.nbButs=0;
		this.numMaillot=numeroMaillot; 
	}

   
	
	
	
	
	/**
	 * ce getter permet d'obtenir le numero de maillot d un joueur
	 * @return un entier qui corespond au numero de maillot du joueur
	 */
	public int getNumMaillot(){
		return this.numMaillot;
	}
	
	
	
	
	
	public String toString() {
		return "Numero de licence:"+this.getNumeroDeLicence()+"  Date de validité "+this.getDateDeValidite().get(Calendar.DAY_OF_MONTH)+"/"+(this.getDateDeValidite().get(Calendar.MONTH)+1)+"/"+this.getDateDeValidite().get(Calendar.YEAR)+"  Nom:"+this.getNom()+"(Maillot:"+this.numMaillot+")"+" Poste:"+this.poste+"  Ville-Club:"+this.getClub().getVille()+"-"+this.getClub().getNom()+"\n";
	} 
	
	
	
	/**
	 * ce getter permet d obtenir le poste du joueur
	 * @return le poste du joueur represente par une chaine
	 */
	public String getPoste() {
		
		return this.poste;
	}
	
	
	
	
	/**
	 * cette methode permet de mettre a jour la licence d'un joueur . Il pourra arrive parfois que des joueurs aient une licence dont la date de validite est depasse 
	 * empechant le joueur d'integre l effectif de son equipe . cette methode permet à l utilisateur ,qui souhaite ajouté un joueur dont la licence est invalide , 
	 * de pouvoir integré le joueur en mettant sa licence a jour . 
	 * 
	 * 
	 * @see Licencie#setDateDeValidite(Calendar)
	 */
	public void mettreAJourLicence(){
		Calendar jour=Calendar.getInstance();
		jour.add(Calendar.YEAR, 1);
		this.setDateDeValidite(jour);
		System.out.println("La licence du joueur a bien été mise a jour");
	}
	
	
	/**
	 * Un joueur a beaucoup de parametre , retourne une chaine contenant tout les parametres peut s'averer fastidieux et peut 
	 * comprehensible avec cette methode on ne retourne que l essentiel a savoir son numero de licence , son nom , poste et numero de maillot .
	 * @return une chaine de caractere correspondant à l'ensemble des parametres les plus importants du joueurs
	 */
	public String donneImportante () {
		return "Numero licence:"+this.getNumeroDeLicence()+"   Nom:"+this.getNom()+"   Poste:"+this.poste+"(Maillot:"+this.numMaillot+")";
	}
	
	
	
	/**
	 * quand le joueur marque , on augmente son compteur de but
	 * @param nb le nombre de but marque par le joueur
	 */
	public void ajouterBut(int nb){
		this.nbButs=this.nbButs+nb;
	}

	
	/**
	 * retourne le nombre de but du joueur
	 * @return le nombe de but du joueur
	 */
	public int getNbBut() {
		return this.nbButs;
	}
	
	/**
	 * cette compare les joueurs pour pouvoir les tries plus tard en se basant en premier lieu sur leur numero de maillot
	 * @return un entier positif si l objet appelant est plus grand que l objet en parametre , negatif s'il est plus petit et nul si les deux objets sont egaux
	 * @param a , prend un parametre de type Joueur que l on va compare a l objet appelant
	 */
	public int compareTo(Joueur a){
		int cpt=this.numMaillot-a.getNumMaillot();
		if(cpt==0){
			cpt=this.getNumeroDeLicence()-a.getNumeroDeLicence();
		}
		if(cpt==0){
			cpt=this.getDateDeValidite().compareTo(a.getDateDeValidite());		
		}
		if(cpt==0){
			cpt=this.poste.compareTo(a.poste);
		}
		
		return cpt; 
	}
	
	

}
