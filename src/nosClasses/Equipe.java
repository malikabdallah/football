package nosClasses;
import java.util.*;
import nosException.*;

/**
 * 
 * @author malik,timote
 * @version 1
 * @see Club
 * @see Licencie
 * @see Match
 * @see Entraineur
 * @see Joueur
 * <p>
 * cette classe  decrit les caracteristiques des classes equipes , les equipes sont composé de joueurs dont certains sont
 * titulaire et d autre sont remplacants .Chaque joueur qui compose une equipe est unique et s identifie grace a son numero
 * de licence.Les equipes participent à des matchs , gagne ou perde .Pour qu'un joueur integre une equipe il faut qu il valide
 * des conditions (sa licence doit etre valide , l equipe ne doit pas etre pleine , il doit etre affilie au club etc ). 
 * Une equipe est compose de : 
 * <br/>
 * -un attribut static nbJoueurMaximalParEquipe qui correspond au nombre de joueur maximal d une equipe lors d un tournoi , 
 * en effet bien que le nombre de titulaire soit fixe , celui de remplacants va de 1 jusqu'a une valeur fixe par l utilisateur
 * <br/>
 * -un attribut static nbTitulaire qui correspond au nombre de titulaire des equipes du tournoi qui doit etre fixe et le meme
 * pour chaque equipe 
 * <br/>
 * -un attribut static int nbInstanceEquipe initialise a zero qui sert a compte le nombre d equipe cree et qui s auto incremente
 * permettant a chaque equipe d avoir un identifiant different
 * <br/>
 * -un identifiant pour differencie chaque equipe ,sa valeur est determine a partir du nbInstanceEquipe.
 * <br/>
 * -deux attributs de type int victoire et defaite initialise a zero et qui compte respectivement le nombre de victoire
 * et defaite de l equipe dans le tournoi 
 * <br/>
 * -Ces classes est aussi compose de trois Collection de type Set avec comme parametre generique la classe Joueur ,ces trois
 * attributs sont JoueurEquipe,equipeTitulaire et remplacants. Le Set a ete choisit car chaque joueur qui compose l equipe 
 * est unique.L'attribut Joueur comprend tous les joueurs de l equipe qu il soit titulaire ou remplacants , l attribut
 * equipeTitulaire contient uniquement les titulaires et remplacants uniquement les remplacants .
 * <br/>
 * -un attribut club de type Club qui correspond au club de l equipe
 * <br/>
 * -un attribut coach de type Entraineur qui correspond a l entraineur de l equipe
 * <br/>

 * 
 * 
 * 
 *</p>
 */
public class Equipe {
	
	
	static Scanner lire=new Scanner(System.in);	
	
	/**
	 * Correspond au nombre maximal de joueur pour une equipe , cette valeur est commune a toutes les equipes
	 */
	private static int nbJoueurMaximalParEquipe;
	
	
	
	/**
	 * Correspond au nombre de titulaire requis dont au moins un gardien , cette valeur est commune a toutes les equipes
	 */
	private static int nbTitulaire;
	
	
	
	/**
	 * cette valeur sert a compte le nombre d objet Equipe qui ont ete instancie
	 */
	private static int nbInstanceEquipe=0;
	
	
	
	/**
	 * compte le nombre de victoire de l equipe , initialise a zero
	 */
	private int victoire=0;
	
	/**
	 * compte le nombre de defaite de l equipe , initialise a zero
	 */
	private int defaite=0;
	
	
	/**
	 * l identifiant de l equipe est unique , qui permet de differencie les equipes 
	 */
	private int identifiant ; 
	
	
	
	/**
	 * Collection des joueurs de toutes l equipes , titulaires et remplacants
	 */
	private Set<Joueur> JoueurEquipe; 
	
	
	
	/**
	 * Collection des joueurs uniquement titulaire
	 */
	private Set<Joueur> equipeTitulaire; 
	
	/**
	 * Collection des joueurs uniquement remplacants
	 */
	private Set<Joueur> remplacants; 
	
	
	/**
	 * Le club de l equipe
	 */
	private Club club;
	
	
	
	/**
	 * l entraineur de l equipe
	 */
	private Entraineur coach;
	
	
	/**
	 * 
	 * Ce constructeur initie les valeurs clubs et coach , instancie les Collections de joueurs que ce soit JoueurEquipe
	 * equipeTItulaire et remplacants .Enfin il affecte a l identifiant de l equipe la valeur de la variable static 
	 * nbInstanceEquipe qui s auto incremente et compte le nombre d instance cree .De cette maniere chaque identifiant est 
	 * unique a l equipe . 
	 * @param club le club de l equipe
	 * @param coach le coach de l equipe
	 */
	public Equipe(Club club, Entraineur coach) {
		super();
		this.JoueurEquipe=new TreeSet<Joueur>(); 
		this.equipeTitulaire=new TreeSet<Joueur>(); 
		this.remplacants=new TreeSet<Joueur>(); 
		nbInstanceEquipe++;
		this.identifiant=Equipe.nbInstanceEquipe;
		this.club = club;
		this.coach = coach;
	}

	
	
	
	
	
	/**
	 * cette methode est utile quand un tournoi a deja eu lieu et qu un tournoi est organise pour reprendre a zero
	 * la creation des equipes .Car sinon les equipes cree lors d un nouveau tournoi auront des identifiants  qui commencenront
	 * la ou ce sont arrete les identifiant du precendent ce qui peut devenir problematique
	 * @param nb parametre du nombre d instance d equipe
	 */
	public static void setNbInstanceEquipe(int nb){
		Equipe.nbInstanceEquipe=0;
	}
	
	
	/**
	 * 
	 * @param nb correspond au nombre maximal de joueur que peut contenir une equipe 
	 */
	public static void setNbJoueurMaximalParEquipe(int nb){
		nbJoueurMaximalParEquipe=nb;
	}
	
	
	/**
	 * ce getter permet de savoir le nombre maximal de joueur qui peuvent compose une equipe c est a dire titulaire plus 
	 * remplacants
	 * @return la valeur du nombre maximal de joueur par equipe
	 */
	public static int getNbJoueurMaximalParEquipe(){
		return nbJoueurMaximalParEquipe;
	}
	
	
	/**
	 * cela renvoie le nombre de joueur total de l equipe
	 * @return le npmbre de joueur qui compose l equipe de maniere globale
	 */
	public int nbJoueur() {
		return JoueurEquipe.size();
		
	}
	
	
	
	
	
	/**
	 * cela renvoie le nombre de remplacants que contient l equipe
	 * @return le nombre de remplacants de l equipe
	 */
	public int nbRemplacants() {
		return remplacants.size();
	}
	
	

	
	
	/**
	 * cette methode parcours la liste des joueurs pour cherche s il y a un gardien et si oui le renvoyer sinon renvoie null
	 * @return le gardien de l equipe
	 */
	public Gardien getGardien(){
		Iterator<Joueur> it=JoueurEquipe.iterator();
		while(it.hasNext()){
			Joueur x=it.next();
			if(x instanceof Gardien){
				return (Gardien)x;
			}
		}
		return null;
	}
	
	
	
	
	/**
	 * ce getter permet d avoir le nombre requis de joueur dans l equipe titulaire
	 * @return le nombre de titulaire que doit contenir une equipe
	 */
	public static int getNbTitulaire(){
		return nbTitulaire;
	}
	
	
	
	/**
	 * retourne le nombre de match gagne par l equipe
	 * @return le nombre de victoire de l equipe
	 */
	public int getNbVictoire (){
		return this.victoire;
	}
	
	
	
	/**
	 * retourne le nombre de match perdu par l equipe
	 * @return le nombre de defaite de l equipe
	 */
	public int getNbDefaite(){
		return this.defaite; 
	}
	
	
	/**
	 * ce getter permet d'obtenir l entraineur de l equipe
	 * @return l entraineur de l equipe
	 */
	public Entraineur getEntraineur (){
		return this.coach;
	}
	
	
	/**
	 * ce getter permet d obtenir l identifiant de l equipe
	 * @return l identifiant de l equipe
	 */
	public int getIdentifiant (){
		return this.identifiant;
	}
	
	
	
	
	/**
	 * ce getter permet d obtenir le club de l equipe
	 * @return le club de l equipe
	 */
	public Club getClub() {
		return club;
	}


	/**
	 * ce getter permet d avoir la liste complete des joueurs de l equipe
	 * @return la liste des joueurs total de l equipe a savoir titulaire plus remplacants
	 */
	public Set<Joueur> getEquipe(){
	
		return JoueurEquipe;
	}

	
	
	/**
	 *  ce getter permet de recuperer l equipe titulaire 
	 * @return l equipe titulaire
	 */
	public Set<Joueur> getEquipeTitulaire() {
		return equipeTitulaire;
	}
	

	
	/**
	 * permet de fixer le nombre de titulaire dans chaque equipe
	 * @param nb permet de fixer le nombre de titulaire de l equipe , commun a chaque equipe et fixe pendant le tournoi
	 */
	public static void setNbTitulaire(int nb){
		nbTitulaire=nb;
	}
	
	
	
	
	/**
	 * cette  methode incremente le nombre de victoire de l equipe
	 */
	public void gagner () {
		this.victoire++;
	}
	
	/**
	 * cette methode incremente le nombre de defaite de l equipe
	 */
	public void perdre(){
		this.defaite++;
	}
	


	
	
	/**
	 * retourne une chaine de caractere avec l ensemble des infos sur les joueurs titulaire
	 * un TreeSet a ete utilisé car la methode joueur implemente l interface comparable en se basant
	 * sur le numero de maillot de joueur.De cette façon , les infos sur les joueurs sont tries 
	 * en commancant par le joueur qui a le maillot 0
	 */
	
	public String toStringTitulaire() {
		Set<Joueur> bis=new TreeSet<Joueur>(equipeTitulaire); 
		Iterator<Joueur> it=bis.iterator();
		String s="Equipe Titulaire:"+"\n";
		while(it.hasNext()){
			Joueur x=it.next();
			s=s+x.toString();
			
		}
		return "\n"+s; 
	}
	
	
	
	
	/**
	 * retourne une chaine de caractere avec l ensemble des infos sur les joueurs remplacants
	 * un TreeSet a ete utilisé car la methode joueur implemente l interface comparable en se basant
	 * sur le numero de maillot de joueur.De cette façon , les infos sur les joueurs sont tries  en fonction du numero
	 * de maillot
	 */
	public String toStringRemplacants(){
		Set<Joueur> bis=new TreeSet<Joueur>();
		bis.addAll(remplacants);
		Iterator<Joueur>it=bis.iterator();
		String s="Equipe remplacants :"+"\n";
		while(it.hasNext()){
			Joueur x=it.next();
			s=s+x.toString();
		}
		return "\n"+s+"\n"+"\n"; 
	}
	



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + identifiant;
		return result;
	}
	
	
	

	
	
	
	/**
	 * deux equipes sont differenciable par leur identifiant (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Equipe other = (Equipe) obj;
		if (identifiant != other.identifiant)
			return false;
		return true;
	}




	
	
	/**
	 * teste si la licence du joueur passé en parametre est invalide
	 * compare la date de validité du joueur et la date actuelle
	 * si la premiere est inferieur ou egal a la deuxieme cela signifie 
	 * que la licence du joueur est encore valide
	 */
	private boolean licenceInvalide(Joueur a){
		if(a.getDateDeValidite().compareTo(Calendar.getInstance())<=0){	
			return true; 	
		}
		return false;
	}
	
	
	
	
	public Joueur tirerUnJoueurAuSort() {
		int x=(int)(Math.random()*Equipe.nbTitulaire)+1;
		int cpt=0;
		Joueur a=null; 
		Iterator<Joueur>it=this.equipeTitulaire.iterator();
		while(cpt<x){
			cpt++;
			if(it.hasNext()){
				a=it.next();
			}
			
		}
		if(a instanceof Gardien){
			return tirerUnJoueurAuSort(); 
		}else {
			return a; 
		}
		
		
		
	}
	
	
	
	/**
	 * cette methode permet de savoir si le joueur passe en parametre se trouve dans l equipe des joueurs total .
	 * Cette methode a ete cree pour permettre de gerer tous les cas de figure , en effet si on utilise la methode add ou contains
	 * de la Collection celle ci retourne un boolean pour indiquer si le joueur et present et a ete ajoute cependant
	 * la methode equals retourne faux quand deux objets ne sont pas de meme classe . Par consequent un gardien et un joueur non 
	 * gardien pourront avoir le meme numero de licence ce qui est problematique .Avec cette methode , on parcours la liste
	 * des joueurs et si le numero de licence du joueur passe en parametre s y trouve alors on retourne un boolean vrai
	 * pour indiquer que ce joueur est deja present .
	 * @param A Passe une instance de la classe Joueur en parametre
	 * @return un boolean pour indiquer si l identifiant du joueur se trouve dans l equipe
	 */
	public boolean numDejaPresent (Joueur A) {
		Iterator<Joueur> it=this.getEquipe().iterator();
		
		while( it.hasNext()){
			Joueur x=it.next();
			if(x.getNumeroDeLicence()==A.getNumeroDeLicence()){
				return true; 
			}
		}
		
		
		return false; 
	}

	
	
	
	


	/**
	 * 
	 * cette methode ajoute un joueur passe en parametre a l equipe si toutes les conditions sont valides (
	 * il est licencie dans le bon club , sa date de validite est incorecte , si le joueur est deja present dans l equipe,
	 * si le nombre de gardien est invalide , si l equipe ou le joueur est affecte n est pas remplie ) . 
	 * Pour ajouter un joueur on s assure que il y a de la place dans l equipe de titulaire pour placer le joueur , s'il n y a pas de place
	 * on verifie chez les remplacants et si la non plus le nombre maximal est atteind alors le joueur ne peut pas integre l equipe .
	 * 
	 * @param A c est le joueur qui est ajoute  a l equipe
	 * @throws JoueurLicencieAutreClubException si le joueur est licencie dans un autre club
	 * @throws LicenceInvalideExcepion si la date de validite du joueur ajoute n est pas valide
	 * @throws JoueurDejaPresentDansEquipeException si le joueur est deja present dans l equipe
	 * @throws NombreDeGardienInvalideException si le nombre de gardien est inccorecte , il doit y avoir un et un seul gardien par equipe
	 * @throws EquipePleineException si le nombre de joueur maximal dans l equipe est atteind
	 */
	public void ajouterJoueur (Joueur A)throws JoueurLicencieAutreClubException,LicenceInvalideExcepion,JoueurDejaPresentDansEquipeException,NombreDeGardienInvalideException,EquipePleineException{
		System.out.println(); 
		System.out.println("Nombre de titulaire requis dont un gardien : "+Equipe.nbTitulaire+"   Nombre de titulaire actuelle :"+this.getEquipe().size());
		System.out.println("Nombre de remplacants requis :entre 1 et "+(Equipe.nbJoueurMaximalParEquipe-Equipe.nbTitulaire)+"  Nombre remplacants actuelle:"+this.remplacants.size());
		System.out.println("Composition Equipe : "+this.getClub().getNom());
		System.out.println(); 
		this.afficherEquipe();
		System.out.println(); 

		//teste si le joueur est bien licencié dans cette equipe 
		if(!this.club.equals(A.getClub())){
			throw new JoueurLicencieAutreClubException("le joueur "+A.getNom()+"  n'est pas la licencié dans ce club ,  pour jouer dans le club "+this.club.getNom()+",Attendez que sa licence se termine avec son club "+A.getClub().getNom()+" avant de le signer dans ce club");
		}
		//teste si la licence du joueur est valide
		if(licenceInvalide(A)){
			throw new LicenceInvalideExcepion ("le joueur "+A.getNom()+" a une licence qui n est pas a jour , pour pouvoir integrer l effectif il devra remettre sa licence a jour");
		}	
		//teste sile nombre maximal de joueur n est pas deja atteind
		if(this.JoueurEquipe.size()==Equipe.nbJoueurMaximalParEquipe){
			throw new EquipePleineException("Le nombre de joueur maximal pour cette equipe à ete atteind , vous ne pourrez pas rajouter d'autre joueur");
		}	

		//teste si le joueur n est pas deja present dans l equipe
		if(numDejaPresent(A)){
			throw new JoueurDejaPresentDansEquipeException("Le joueur avec le numero de licence :"+A.getNumeroDeLicence()+" est deja integré dans l'effectif ") ; 
		}

		if(A instanceof Gardien){
			
			//teste le nombre de gardien actuelle dans l equipe , si il y a deja un gardien ; exception est lancé 
			if(this.nbGardien()==1){
				throw new NombreDeGardienInvalideException("Il y a deja un gardien dans cette equipe !le joueur "+A.getNom()+" ne peut donc pas jouer en tant que gardien car chaque equipe ne peut avoir que un gardien ");
			}else {

			JoueurEquipe.add(A);
			System.out.println("Le gardien est automatiquement placé dans l'equipe des titulaires ");
			equipeTitulaire.add(A);
	
			}

		}else {
			if(this.nbGardien()==1){					
					if(this.getEquipe().size()<Equipe.nbTitulaire){
						JoueurEquipe.add(A);
						equipeTitulaire.add(A);
					}else{
						if(this.remplacants.size()<(Equipe.nbJoueurMaximalParEquipe-Equipe.nbTitulaire)){
							JoueurEquipe.add(A);
							remplacants.add(A);
						}else{
							throw new EquipePleineException("Le nombre de joueur maximal pour cette equipe à ete atteind , vous ne pourrez pas rajouter d'autre joueur");
						}
					}

			}else {
					if(this.getEquipe().size()<Equipe.nbTitulaire-1){
						JoueurEquipe.add(A);
						equipeTitulaire.add(A);
					}else{
						if(this.remplacants.size()<(Equipe.nbJoueurMaximalParEquipe-Equipe.nbTitulaire)){
							JoueurEquipe.add(A);
							remplacants.add(A);
						}else{
							throw new EquipePleineException("Le joueur ne peut pas aller dans l'equipe titulaire car il ne reste qu une place reserve au gardien , et l'equipe remplacante est pleine "); 
						}
					}					
				}
			}	
		}

	

		
	
	
	
		
	/**
	 * avec cette methode on compte le nombre d instance de gardien dans l equipe
	 * @return un entier qui correspond au nombre de gardien que contient l equipe
	 */
	public int nbGardien() {
		int nb=0;
		Iterator<Joueur> it=this.JoueurEquipe.iterator();
		while(it.hasNext()){
			Joueur x=it.next();
			if(x instanceof Gardien){
				nb++;
			}
		}
		return nb ; 
	}
	
	
	
	
	/**
	 * cette methode permet d afficher tous les joueurs contenu dans l equipe , d abord les titulaires puis les remplacants
	 */
	public void afficherEquipe(){
		System.out.println("Equipe :"+this.getClub().getNom());
		System.out.println("Nombre de joueur:"+this.JoueurEquipe.size());
		Iterator<Joueur> it1=this.equipeTitulaire.iterator();
		Iterator<Joueur>it2=this.remplacants.iterator();
		System.out.println("Equipe Titulaire "); 
		while(it1.hasNext()){
			Joueur x=it1.next(); 
			System.out.println("["+x.donneImportante()+"]");
		}
		System.out.println();
		System.out.println("Equipe Remplacants");
		while(it2.hasNext()){
			Joueur x=it2.next(); 
			System.out.println("["+x.donneImportante()+"]");
		}
	
	}
	
	
	
	
	/**
	 * ce getter permet d obtenir la liste des remplacants de l equipe 
	 * @return un Set<Joueur> qui contient l ensemble des joueurs remplacants de l equipe
	 */
	public Set<Joueur>getRemplacants () {
		return this.remplacants;
	}
	
	
	
	/**
	 *cette methode permet d afficher la liste des titulaires de l equipe
	 */
	public void afficherEquipeTitulaire(){
		Iterator<Joueur> it=equipeTitulaire.iterator();
		while(it.hasNext()){
			Joueur p=it.next();
			System.out.println(p);
			System.out.println(); 
		}
	}
	
	
	

	
	
	
	/**
	 * cette methode permet d afficher la liste des remplacants de l equipe
	 */
	public void afficherRemplacant(){
		Iterator<Joueur> it=remplacants.iterator();
		while(it.hasNext()){
			Joueur p=it.next();
			System.out.println(p);
			System.out.println(); 
		}
	}
	


	
	
	
	/**
	 * cette permet d afficher les stats de l equipe a savoir son nom , son nombre de victoire et de defaite .
	 */
	public void afficherStats (){
		
		System.out.println("Nom du club:"+this.getClub().getNom());
		System.out.println("Nombre de victoire:"+this.victoire);
		System.out.println("Nombre de defaite:"+this.defaite);
	}
	
	
	/**
	 * retourne le mmeilleur buteur de l equipe en cas d egalite c est le premier rencontre qui est selectionne
	 * 
	 * @return le meilleur buteur de l equipe
	 */
	public Joueur getMeilleurButeur() {
		Iterator<Joueur>it=this.equipeTitulaire.iterator();
		int max=-1;
		Joueur x ; 
		Joueur meilleur=null; ; 
		while(it.hasNext()){
			 x=it.next();
			 if(x.getNbBut()>max){
				 max=x.getNbBut();
				 meilleur=x; 
			 }
		}
		return meilleur ; 
	}
	
}	
	

