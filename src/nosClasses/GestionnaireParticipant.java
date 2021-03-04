package nosClasses;
import java.io.*;
import java.util.*;

import nosException.*;


/**
 * <p>
 * Cette classe reprensente l organisateur du tournoi est fourni les services pour le bon deroulement de celui .
 * Cette classe permet de gerer la liaison avec l utilisateur et lui fournir toutes les infos necessaires sur le tournoi .
 * Cette classe est compose de :
 * <br/>
 * - une Liste des equipes de depart du tournoi qui est fixe pour chaque tournoi 
 * <br/>
 * -Une liste des equipes qui representent le nombre d equipe encore en lice a chaque tour et qui sera amene a evolue a chaque 
 * tour 
 * <br/>
 * -Une liste de chaque tour du tournoi 
 * <br/>
 * -Une liste des arbitres de chaque match
 * <br/>
 * -un entier final qui represente le nombre de titulaire de l equipe qui est fixe au cours d un tournoi
 * <br/>
 * - un entier final qui represente le nombre maximal de remplacants par equipe qui est fixe et le meme pour chaque equipe
 * <br/>
 * - un entier nbEquipe qui represente le nombre d equipe du tournoi , ce nombre est fixe lors d un tournoi mais peut changer d un 
 * tournoi a l autre
 * <br/>
 * -Un tableau de nom qui facilite la creation aleatoire des joueurs 
 * 
 * </p>
 * @author malik,timote
 * @version 1
 *
 */

public class GestionnaireParticipant {
		
		private String[] tab={"john","mike","messi","ronaldo","matuidi","thiago","van persie","costa","jose","mauricio","jon","anderson","lyoto","vitor","cain","mike","zidane","chad",
		    "rashad","junior","stipe","overeem","chris","yoel","luke","michael","tyron","stephen","rory","george","nick","jacke","carlos","tj","dominick","renan"};//35 noms
		
		static Scanner lire =new Scanner(System.in);
		
		/**
		 * Le nombre d equipe participant au tournoi , peut evoluer mais doit rester une puissance de deux
		 */
		private int  nbEquipe;
		
		
		
		
		
		
		/**
		 * le nombre de titulaire du tournoi 
		 */
		private int nbTitulaire; //9
		
		
		/**
		 * les equipes en lices a chaque tour , evolue au cour du tournoi
		 * @see Equipe
		 */
		private List<Equipe> listeEquipeEncoreParticipante ; 
		
		/**
		 * les equipes participantes , reste fixe au cour d un tournoi
		 * @see Equipe
		 */
		private List<Equipe> listeEquipeDepart ; 
		
		/**
		 * la liste des tours du tournoi , evolue au cour du tournoi
		 */
		public	List<Tour> listeRecapTour;
		
		/**
		 * La liste des arbitres du tournoi
		 */
		private List<Arbitre>listeArbitre;
		
		
		private Equipe gagnantTournoi; 
		
		/**
		 * ce contucteur envoie sur la page d acceuil de l application qui est fait par la methode mode
		 *@see GestionnaireParticipant#mode()
		 */
		
		public GestionnaireParticipant(){
				mode(); 
		}
		
		
		
	private int combienDeMatch() {
		int cpt=0;
		Iterator<Tour> it=this.listeRecapTour.iterator();
		while(it.hasNext()){
			Tour x=it.next();
			cpt=cpt+x.getListeMatch().size();
		}
		return cpt; 
	}
	
		
	
	
	/**
	 * cette methode affiche les stats du tournoi
	 */
	private void afficherStatsTournoi() {
		System.out.println(); 
		if(this.gagnantTournoi==null) {
			System.out.println("Le tournoi n a pas encore commence");
		}else {
			System.out.println("                                                                 STATISTIQUES TOURNOI                                                                   ");
			System.out.println("========================================================================================================================================================="); 
			System.out.println("Le nombre d'equipe participants au tournoi est :"+this.nbEquipe);
			System.out.println("Le nombre de titulaire pour chaque equipe(dont un gardien):"+this.nbTitulaire);
			System.out.println("Une equipe peut avoir entre 1 et "+(Equipe.getNbJoueurMaximalParEquipe()-this.nbTitulaire)+" joueur remplacant ");
			System.out.println("Il y a eu "+this.listeRecapTour.size()+" tour durant ce tournoi qui ont vu ce deroule "+combienDeMatch()+" matchs");
			System.out.println("L equipe gagante du tournoi est "+this.gagnantTournoi.getClub().getNom());
			System.out.println("Le meilleur gardien du tournoi est :"+meilleurGoal().toString()); 
			System.out.println("Le meilleur buteur du tournoi est : "+meilleurButeurTournoi().toString()+" avec "+meilleurButeurTournoi().getNbBut()+" buts");
			System.out.println("========================================================================================================================================================");
			
			
			
		}
		
		System.out.println(); 
		
		
		
	}
		
	
	public Joueur meilleurButeurTournoi() {
		int x=-1;
		Iterator<Equipe>it=this.listeEquipeDepart.iterator();
		Joueur b=null; 
		while(it.hasNext()){
			Equipe a=it.next();
			if(a.getMeilleurButeur().getNbBut()>x){
				b=a.getMeilleurButeur();
				x=b.getNbBut();
			}
			
		}
		return b; 
		
		
		
	}
	
		
		
		
	/**
	 * cette methode affiche la page d acceuil de l application et propose a l utilisateur de selectionner le menu voulu
	 * @see GestionnaireParticipant#lancerTournoi()
	 *
	 */
		
		public void mode(){
			
			System.out.println("****************************************************************************************"); 
			System.out.println("################################TOURNOI DE FOOTBALL#####################################"); 
		    System.out.println("#############################                         ##################################"); 
			System.out.println("########################                                    ############################"); 
			System.out.println("****************************************************************************************"); 
			System.out.println("=========================================================================================");
			System.out.println("||                                                                                      ||");
			System.out.println("||                                                                                      ||");
			System.out.println("||                 *************                 _________________________________      ||");
			System.out.println("||            ******** ________*****             |                |               |     ||");
			System.out.println("||          ********* ____________****           |                |               |     ||");
			System.out.println("||          * *** ____** ________* __**          |                |               |     ||");
			System.out.println("||        * __*________$ ______ $______**        |                |               |     ||");
			System.out.println("||       *___$ _________ $$$$$$$$_______**       |                |               |     ||");
			System.out.println("||      *___$$ ________ $$$$$$$$$________**      |_____           |          _____|     ||");
			System.out.println("||     *$___$ _________ $$$$$$$$$$________*      |__   |          |         |   __|     ||");
			System.out.println("||     *___$$ _______$$$$$$$$$$$$$$_______*      |  |  |,        ,|,       ,|  |  |     ||");
			System.out.println("||     *__$$$$$ __ $$$___$$$$$$$__ $$$$___**     |  |  | )      ( | )     ( |  |  |     ||");
			System.out.println("||     *$$$$$$$$$$ _______ $$$________******     |__|  |'        '|'       '|  |__|     ||");          
			System.out.println("||     *_$$$$$$$ __________ $__________*****     |_____|          |         |_____|     ||");
			System.out.println("||     *_$$$$$$$ __________ $__________****      |                |               |     ||");
			System.out.println("||      *_$$$$$$ _________ $$__________ ***      |                |               |     ||");
			System.out.println("||       *_$$__$$ ________ $_________** **       |                |               |     ||");
			System.out.println("||        **_____$$$ ___ $$$$$____$$$___*        |                |               |     ||");
			System.out.println("||         ** _____ $$$$$$$$$$$$$$$___**         |                |               |     ||");
			System.out.println("||          *** _____ $$$$$$$$$$____**           |                |               |     ||");
			System.out.println("||            **** __ $$$$$$$$$__***             |________________|_______________|     ||");
			System.out.println("||             ***** _____ ****                                                         ||");
			System.out.println("||                                                                                      ||");
			System.out.println("=========================================================================================");

			
		
			boolean active=true; 
			while(active){
				
				if(active){
			
					
					
					
					System.out.println(); 
					System.out.println(); 
					System.out.println("MENU");
					System.out.println("1:Lancer tournoi ");
					System.out.println("2:Statistiques des equipes");
					System.out.println("3:Rechercher une rencontre");
					System.out.println("4:Statistiques du Tournoi");
					System.out.println("5:Afficher les compositions des equipes participantes");
					System.out.println("6:Notice aux utilisateurs");
					System.out.print("7:Quitter");
				}
				System.out.println(); 
				System.out.println("Quel menu souhaitez vous ?");
				System.out.println(); 
				int n=donnerUnEntier(); 
				while(n<1 || n>7){
					System.out.println("Saisie inccorecte ! choisir parmis les 7 menus possibles");
					n=donnerUnEntier() ; 
				}
				switch(n){
				case 1: this.lancerTournoi(); break;
				case 2: this.rechercherStats();break;
				case 3: this.rechercherMatch();break; 
				case 4: this.afficherStatsTournoi(); break;
				case 5: this.afficherListeChaqueEquipe(); break;
				case 6: this.notice(); break;
				case 7: active=false; break;
				
				}
			}
			messageDeFin();
				
		}
		
		
		
		/**
		 * cette methode lance un tournoi , elle commence par appele la methode initialisation pour obtenir le nombre
		 * d equipe participant au tournoi qui doit etre une puissance de deux inferieur a 128 , par defaut il y aura 16 equipes
		 * , le nombre de titulaire qui par defaut est de deux et enfin le nombre de remplacants qui par defaut est de un .
		 * Apres les equipes sont initialise , la creation des equipes par l utilisateur est lance .
		 * 
		 * @see GestionnaireParticipant#initialisation()
		 * @see GestionnaireParticipant#creationParUtilisateur()
		 */
		private void lancerTournoi(){
			initialisation() ;
			this.gagnantTournoi=null;
			if(this.listeEquipeDepart!=null ){
				this.listeEquipeDepart=null;
				this.listeEquipeEncoreParticipante=null;
				
			
			}
			if(this.listeArbitre!=null){
				this.listeArbitre=null;
			}
			
			this.listeEquipeDepart=new ArrayList<Equipe>();
			this.listeEquipeEncoreParticipante=new ArrayList<Equipe>();
			this.listeArbitre=new ArrayList<Arbitre>(); 
			System.out.println(); 
			//System.out.println("Le Tournoi va commencer  !!!!!!!!!!");
			System.out.println("Dans ce tournoi participeront "+this.nbEquipe+" equipes ");
			System.out.println("Chaque equipe est composé de "+this.nbTitulaire+" titulaire et de 1 à "+(Equipe.getNbJoueurMaximalParEquipe()-Equipe.getNbTitulaire())+" remplacants");
			System.out.println("Avant de commencer le tournoi , on va proceder à l'etape d enregistrement des equipes participantes et de leur joueur");
			creationParUtilisateur(); 
		}
		
		
		
		
		
		
		
		/**
		 * avec cette methode , l utilsateur peut saisir le nombre d equipe qui participe au tournoi qui doit etre une puissance de deux inferieur a 128 
		 * dont la valeur par defaut est de 16. Mais l utilisateur renseigne aussi le nombre de joueur qui compose l equipe titulaire et remplacante
		 * , il faut au moins 2 titulaire ( minimum un gardien et un joueur ) et au moins un remplacants .
		 */
		private void initialisation () {
			//determine le nombre d equipe participant au tournoi
			System.out.println("Combien d'equipes participent au tournoi ? (la valeur doit etre une puissance de deux inferieur a 128 et superieur a 1 ,dans le cas contraire la valeur par defaut sera prise qui vaut 16 )");
			
			int nbEquipeUtilisateur=donnerUnEntier(); 
			if(!estPuissanceDeDeux(nbEquipeUtilisateur)){
				System.out.println("Valeur inccorecte , la Valeur par defaut est selectionné et le nombre d'equipe participante sera de 16");
				nbEquipeUtilisateur=16;
			}

			this.nbEquipe=nbEquipeUtilisateur;	
			
			//determine combien de titulaire participe au tournoi
			System.out.println("Combien de titulaire pour les equipes du tournoi ? (donner un entier superieur a 2 dans le cas contraire la valeur par defaut sera prise et elle vaut 9)");
			
			int NbTitulaireUtilisateur=donnerUnEntier(); 
			if(NbTitulaireUtilisateur<2){
				System.out.println("Valeur inccorecte , la valeur par defaut sera prise et le nombre de titulaire par equipe est de 9");
				NbTitulaireUtilisateur=9;
			}
			this.nbTitulaire=NbTitulaireUtilisateur;
			Equipe.setNbTitulaire(nbTitulaire);
			
			
			System.out.println("Quelle est le nombre maximal de remplacant par equipe ?(donner un entier superieur ou egal a 1 dans le cas contraire la valeur par defaut sera prise et elle vaut 5");
			int nbRemplacants=donnerUnEntier(); 
			if(nbRemplacants<1){
					System.out.println("Valeur inccorecte , valeur par defaut prise ,le nombre maximal de remplacants par equipe est de 5");
					nbRemplacants=5;
			}
			
			Equipe.setNbJoueurMaximalParEquipe(this.nbTitulaire+nbRemplacants);

		}
		
		
		
		
		
		
		
		
		/**
		 * permet de s assurer que le nombre d equipe donner est correcte et si celui est inccorecte alors le nombre d equipe
		 * sera choisit par defaut a 16 comme dans la consigne
		 * @param nbEquipe le nombre d equipe participant au tournoi
		 * @return un boolean pour indiquer si le nomnbre est correcte , il faut qu il soit une puissance de deux different de 1
		 */
		private boolean estPuissanceDeDeux (int nbEquipe){
			if(nbEquipe %2 == 0){
				if(nbEquipe==2 || nbEquipe==4 || nbEquipe==8 || nbEquipe==16 || nbEquipe==32 || nbEquipe==64){
					return true; 
				}
			}
			return false;
			
		}
		
		
		

		/**
		 * cette methode permet de creer les clubs qui vont compose chaque equipe , cette tache revient a l utilisateur cependant
		 * il peut se trouver que a la longue ce travail devient penible auquel cas une option existe pour releguer a  l ia la creation 
		 * des clubs .En effet l utilisateur peut a tout moment saisir la lettre 'q' pour indiquer qu'il souhaiter sauter cette etape
		 * et c est l ia qui creera le reste des clubs manquant pour avoir un nombre de club comforme au nombre d equipe participant
		 * .A la suite de cela , la methode passe le relai a la methode creationEquipeDynamique qui va cree les equipes a partir des clubs .
		 * 
		 * @see Club
		 * @see Equipe
		 * @see GestionnaireParticipant#creationEquipeParUtilisateur(List)
		 */
		public void creationParUtilisateur(){
			System.out.println(); 
			System.out.println("Premiere etape : Enregistrement des clubs participants ");
			System.out.println("Si vous souhaitez avancer cette étape et laisser notre staff s'en chargé vous pouvez tapper la lettre 'q' a n'importe qu'elle moment au cours de l'enregistrement et notre staff enregistra le reste des clubs ");
			ArrayList<Club>listeClub=new ArrayList<Club>();
			boolean staff=false;
			String v,n;
			System.out.println(); 
			for(int i=1; i<=this.nbEquipe; i++){
				System.out.println("club :"+i);
				System.out.println("Quel est le nom du club ?");
				 n=lire.next(); 
				if(n.equals("q")){
					staff=true;
					break;
				}
				System.out.println("quelle est nom de la ville du club ?");
				v=lire.next(); 
				if(v.equals("q")){
					staff=true;
					break;
				}
				Club x=new Club(n,v);
				listeClub.add(x);
				
			}
			if(staff==true){
				int nb=this.nbEquipe-listeClub.size();
				String [] listeVille={"Paris","Lyon","Marseille","Saint-Etienne","Grenoble","Lille","Rouen","Toulon","Toulouse","Aix-en-Provence",
						            "Bordeaux","Strasbourg","Angers","Dijon","Rennes","Melun","Evry","Orleans","Nantes","Nice","Avignon","Nancy",
						              "Blois","Saint-Denis","Nimes","Vannes","Courbevoie","Chambery"};//28 noms
				String [] listeNomClub={"fc Paris","fc Lyon","fc Marseille","fc Saint-Etienne","fc Grenoble","fc Lille","fc Rouen","fc Toulon","fc Toulouse","fc Aix-en-Provence",
			            "fc Bordeaux","fc Strasbourg","fc Angers","fc Dijon","fc Rennes","fc Melun","fc Evry","fc Orleans","fc Nantes","fc Nice","fc Avignon","fc Nancy",
			              "fc Blois","fc Saint-Denis","fc Nimes","fc Vannes","fc Courbevoie","fc Chambery"
						
				};
				for(int i=1; i<=nb; i++){
					Club x; 
					if(i<=27){
						 x=new Club(listeNomClub[i-1],listeVille[i-1]);
					}else {
						 x=new Club(listeNomClub[(int)(Math.random()*27)+0],listeVille[(int)(Math.random()*27)+0]);
					}
					listeClub.add(x);
				}
			}
			
			creationEquipeParUtilisateur(listeClub); 
			
			
		}
		
		
		
		
		/**
		 * cette methode cree les equipes a partir des clubs obtenu dans la methode creationParUtilisateur
		 * elle cree automatiquement un entraineur pour chaque club ,cette charge etant epargne a l utilisateur ,et ajoute
		 * ces equipes a la liste des equipes de depart du tournoi .Une fois les equipes cree , le relai est passe a la methode
		 * creationJoueurDynamique pour cree les joueurs qui composent l equipe .
		 * @param listeClub la liste des clubs participant herite de la obtenu dans la methode creationParUtilisateur
		 * @see Club
		 * @see Equipe
		 * @see GestionnaireParticipant#listeEquipeDepart
		 * @see GestionnaireParticipant#creationParUtilisateur()
		 * @see GestionnaireParticipant#creationJoueurParUtilisateur()
		 */
		public void creationEquipeParUtilisateur(List<Club>listeClub) {
			Iterator<Club>it=listeClub.iterator();
			Equipe.setNbInstanceEquipe(0);
			while(it.hasNext()){
				Club x=it.next();
				Entraineur y=new Entraineur(tab[(int)(Math.random()*33)+0],tab[(int)(Math.random()*33)+0],Calendar.getInstance(),x);
				Equipe z=new Equipe(x,y);
				this.listeEquipeDepart.add(z);
			}
			
			System.out.println(); 
			System.out.println("Liste des equipes participantes, entre parenthese se trouve leur identifiant" );
			affichageEquipeParticipante();
			System.out.println(); 
			System.out.println("Premiere étape termine avec succés !");
			System.out.println("Deuxieme étape :Enregistrement des Joueurs dans leurs equipes respectifs");
			System.out.println(); 
			
			creationJoueurParUtilisateur(); 
			
			
		}
		
		
		/**
		 * cette methode affiche la liste des equipes participantes avec entre parenthese leur identifiant !
		 */
		public void affichageEquipeParticipante() {
			Iterator<Equipe>it2=this.listeEquipeDepart.iterator();
			while(it2.hasNext()){
				Equipe x=it2.next();
				System.out.println("Equipe :"+x.getClub().getNom()+" ( identifiant:"+x.getIdentifiant()+" )");
			}
			
		}
		
		
		
		
		
		
		
		/**
		 * cette methode s assure que l utilisateur saisit un entier et retourne la valeur de l entier
		 * @return un entier
		 */
		public int donnerUnEntier (){
			int x; 
			while(!lire.hasNextInt()){
				System.out.println("Saisit inccorect ,il faut saisir un entier !");
				lire.next(); 
			}
			x=lire.nextInt(); 
			return x; 
		}
		
		
		
		
		/**
		 * ce sous programme s assure que l utilisateur saisit une date au format jj/mm/aaaa et s assure de la validite 
		 * de la date avec la methode nonValide qui prend une chaine de caractere et teste si les donner entre 
		 * peuvent correspondre a une date valide cette chaine de caractere est validite par la methode nonValide et sera plus
		 * tard converti en Calendar avec la methode StringToCalendar
		 * @return une chaine au format JJ/MM/AAAA
		 *@see GestionnaireParticipant#nonValide(String)
		 *@see GestionnaireParticipant#stringToCalendar(String)
		 */
		public String donnerUneDateFormatValide(){
			String date; 
			do{
				System.out.println("Donner la date de validité du joueur sous le format JJ/MM/AAAA : par exemple pour le 4 janvier 2016 on notera 04/01/2016");
				//date = sc.nextLine();
				date=lire.nextLine(); 
			}while(!date.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}"));
			while(!nonValide(date)){
				do{
					System.out.println("Donner une date valide , veuillez ressaisir une date au format (JJ/MM/AAAA) : par exemple pour le 4 janvier 2016 on saisira 04/01/2016");
					date=lire.nextLine();
				}while(!date.matches("[0-9]{2}/[0-9]{2}/[0-9]{4}"));		
			}
			return date; 
		}
		
		
		
	
		/**
		 * 
		 * cette methode verifie si la chaine donner permet de creer une date valable , elle sert a eviter les invraisemblance
		 * dans la date , par exemple le 99 janvier 2016 . En revanche elle ne verifie pas la vraisemblance de l annee car nous
		 * somme partis du principe que chaque annee est possible meme s'il est peu vraisemblable que la licence du joueur continue
		 * jusqu'en l an 9999.
		 * Pour verifie les jours et les mois , ont prend respectivement le premier et le deuxieme caracte que l on transforme en entier
		 * que l on additionne et l on fait de meme avec le 4eme et 5eme caractere qui represente le mois .
		 * Puis on verifie si cette valeur est possible .
		 * Par exemple si le jour vaut 11 il sera correcte s'il vaut 40 non .
		 * 
		 * @param date une chaine de caractere au format JJ/MM/AAAA
		 * @return un boolean pour indiquer si la date est correcte
		 */
		private boolean nonValide (String date) {
			char t0=date.charAt(0);
			char t1=date.charAt(1);
			String s0=t0+"";
			String s1=t1+"";
			int jour=Integer.parseInt(s0)*10+Integer.parseInt(s1);	
			char t3=date.charAt(3); 
			char t4=date.charAt(4); 
			String s3=t3+"";
			String s4=t4+"";
			int mois=Integer.parseInt(s3)*10+Integer.parseInt(s4); 
			if (mois==4 || mois==6 || mois==9 || mois ==11) {
				if(jour>30) {
					System.out.println("Le nombre de jour est inccorecte !  "); 
					return false; 
				}
			}
			if(mois==2) {
				if(jour>28) {
					System.out.println("Le nombre de jour est inccorecte !") ; 
					return false; 
				}
			}
			if(mois<1 || mois>12) {
				System.out.println("Le nombre de mois est inccorecte ! il doit etre compris entre 1 et 12") ; 
				return false; 
			}
			if(jour<1 || jour>31) {
				System.out.println("le nombre de jour est inccorecte ! ") ; 
				return false; 
			}
			return true; 
			
		}
		
		
		
		/**
		 * cette methode reçoit une chaine de caractere entre parenthese qui correspond a la date de validite du joueur
		 * sous format JJ/MM/AAAA , cette methode converti cette date en objet de type Calendar . 
		 * Elle recupere le jour , le mois et l annee sous forme d entier separement , puis cree un objet Calendar avec 
		 * cette donner qu elle retourne ensuite
		 * @param chaine une chaine de caractere de format JJ/MM/AAAA correspondant a une date
		 * @return un objet de type Calendar qui represente la date de validite du joueur
		 */
		private Calendar stringToCalendar(String chaine) {
			Calendar date=Calendar.getInstance(); 
			char t0=chaine.charAt(0);
			char t1=chaine.charAt(1);
			String s0=t0+"";
			String s1=t1+"";
			int jour=Integer.parseInt(s0)*10+Integer.parseInt(s1);
			
			char t3=chaine.charAt(3); 
			char t4=chaine.charAt(4); 
			String s3=t3+"";
			String s4=t4+"";
			int mois=Integer.parseInt(s3)*10+Integer.parseInt(s4); 
			char t6=chaine.charAt(6); char t7=chaine.charAt(7);char t8=chaine.charAt(8); char t9=chaine.charAt(9); 
			String s6,s7,s8,s9; s6=t6+""; s7=t7+""; s8=t8+""; s9=t9+""; 
			int annee=Integer.parseInt(s6)*1000+Integer.parseInt(s7)*100+Integer.parseInt(s8)*10+Integer.parseInt(s9); 
			date.set(annee, mois, jour);
			return date; 
	
		}
		
		
		
		
		/**
		 * cette methode sert a creer les joueurs qui vont compose l equipe , pour ce faire
		 * on calcule le nombre maximal de joueur possible (nb equipe participante multiplie par nb maximal de joueur par equipe)
		 * et on fait une boucle pour creer chacun de ces joueurs , cependant cette tache pouvant etre fastidieuse au bout d un moment
		 * il est possible a la fin de la creation d un joueur de confier la creation du restes des joueurs a l ia . Pour ce faire l ia parcours
		 * chaque equipe et verifie s'il y a bien le nombre de titulaire requis et s il y a au moins un remplacants auquel cas elle va se charger de creer
		 * les joueurs neccessaires .
		 * Dans cette methode on demande successivement a l utilisateur de donner le numero de licence du joueur cree , son nom , son prenom , sa date de validite
		 * s'il s agit d un gardien , si non preciser son poste et enfin son numero de maillot .
		 * Des methodes comme donnerUnEntier et donnerUneDateFormatValide allege le code et s assure que l utilisateur saisit correctement les infos demandes .
		 * Puis enfin on demande dans quel club il joue puis le joueur est cree , enfin vient le moment d affecte le joueur a l equipe
		 * on demande a l utilisateur l'equipe ou le joueur va etre enregistre puis une methode d affectation est faite qui determine
		 * si toutes les conditions sont requise .
		 * @see GestionnaireParticipant#affecterJoueurAEquipe(Joueur)
		 * @see GestionnaireParticipant#donnerUneDateFormatValide()
		 * @see GestionnaireParticipant#donnerUnEntier()
		 * @see GestionnaireParticipant#creationJoueurParStaff()
		 */
		public void creationJoueurParUtilisateur(){
			System.out.println(); 
			System.out.println("Vous allez saisir les informations des joueurs puis les affecter aux equipes du tournoi, vous etes libre a tout moment d'arreter le processus d'enregistrement à la fin de chaque affectation  et notre staff se chargera de la suite et affectera les joueurs aux bonnes equipes  ");
			System.out.println("L'affectation des joueurs se fera en deux temps ,d'abord vous donnerez les informations des joueurs puis vous les affecterez dans la bonne equipe en saisisant l'identifiant de l equipe ");
			System.out.println(); 
			int cpt=1;
			boolean cour=true; 
			int nbMaximalJoueur=this.listeEquipeDepart.size()*Equipe.getNbJoueurMaximalParEquipe();
			//System.out.println("Le nombre de joueur maximal possible pour le tournoi est : "+nbMaximalJoueur);
			while(cour==true && cpt<=nbMaximalJoueur){
				System.out.println("Affectation numero°"+cpt);
				System.out.println("Donner le numero de licence du joueur :");
				int numLicence=donnerUnEntier();  
				lire.nextLine();
				System.out.println("Donner le nom du joueur");
				String nom=lire.nextLine();
				System.out.println("Donner le prenom du Joueur");
				String prenom=lire.nextLine();
				String date=donnerUneDateFormatValide(); 
				System.out.println("Le joueur joue t-il au poste de gardien ? o/n(par defaut le joueur ne sera pas un gardien)");
				String rep=lire.nextLine(); 
				String poste; 
				if(rep.equals("o") || rep.equals("O")){
					poste="Gardien";
				}else {
					System.out.println("Alors qu'elle est son poste ? ");
					poste=lire.nextLine(); 	
				}
				System.out.println("Enfin quel est son numero de maillot ?");
				int numero=donnerUnEntier(); 
				lire.nextLine(); 
				System.out.println("Dans quel Equipe joue ce joueur ? entrer l'identifiant de l'equipe ");
				affichageEquipeParticipante(); 
				while(!lire.hasNextInt() ){
					System.out.println("donner un entier");
					lire.next();
				}
				int choix=lire.nextInt(); 
				while(choix<1 || choix>this.listeEquipeDepart.size()){
					System.out.println("Identifiant inccorect !  ");
					affichageEquipeParticipante();
					while(!lire.hasNextInt()){
						lire.next(); 
						System.out.println("Donner un entier");		
					}
					choix=lire.nextInt();		
				}
				Calendar dateValidite=stringToCalendar(date);
				Equipe A=chercherEquipe(choix) ;
				Joueur joueur;
				if(!poste.equals("Gardien")){
					 joueur=new Joueur(numLicence,nom,prenom,dateValidite,A.getClub(),poste,numero);
				}else{
					 joueur=new Gardien(numLicence,nom,prenom,dateValidite,A.getClub(),poste,numero);
				}
				boolean affectationReussi=affecterJoueurAEquipe(joueur); 
				if(affectationReussi){
					cpt++;
				}else {
					System.out.println("Le joueur "+joueur.getNom()+" n' as malheureusement pas pu intégré l'effectif ");
				}
			
				System.out.println("Souhaitez-vous laisser notre staff continuer les affectations de joueurs? (o/n) ");
				String reponse=lire.next(); 
				if(reponse.equals("o")|| reponse.equals("O")){
					System.out.println("Notre staff prendra la releve et enregistra les joueurs pour chaques equipes en tenant compte des exigences souhaitez par l'organisteur");
					cour=false; 
				}	
			}
			int nb=combienDeJoueurDansChaqueEquipe();
			int nbMinJoueur=this.listeEquipeDepart.size()*Equipe.getNbTitulaire()+this.listeEquipeDepart.size();
			if(nb<nbMinJoueur){
				creationJoueurParStaff() ; 
			}
		    System.out.println(); 
			this.simulerTournoi();
		}
		
		
		
		
		
		/**
		 * retourne le nombre de participant joueur au tournoi
		 * @return un entier qui correspond au nombre de joueur qui participent au tournoi
		 */
		private int combienDeJoueurDansChaqueEquipe() {
			int nb=0;
			Iterator<Equipe> it=this.listeEquipeDepart.iterator();
			while(it.hasNext()){
				Equipe x=it.next();
				nb=nb+x.nbJoueur();
			}
			return nb; 
			
			
			
		}
		
		
		
		
		
		
		
		
		/**
		 * cette methode prend l identifiant d une equipe en parametre et retourne cette equipe .
		 * @param id l identifiant de l equipe
		 * @return l equipe dont l identifiant a ete passe en parametre
		 */
		private Equipe chercherEquipe(int id){
			Iterator<Equipe>it=this.listeEquipeDepart.iterator(); 
			Equipe x; 
			while(it.hasNext()){
				x=it.next();
				if(x.getIdentifiant()==id){
					return x; 
				}
			}
			return null; 
			
		}
		
		
		
		
		
		
		
		
		
		
		
		/**
		 * pour chaque equipe du tournoi on affiche le resultat de la methode afficherEquipe qui donne la liste de chaque joueur
		 * des equipes d abord titulaire puis remplacants
		 */
		private void afficherListeChaqueEquipe(){
			
			if(this.listeEquipeDepart!=null){
				Iterator<Equipe>it=this.listeEquipeDepart.iterator();
				while(it.hasNext()){
					Equipe x=it.next();
					System.out.println("======================================================");
					x.afficherEquipe();
					System.out.println("======================================================");
					System.out.println(); 
				}
			}else {
				System.out.println("Le tournoi n'a pas encore commencé ");
			}
			
			
			
		}
		
		
		
		
		/**
		 * cette methode creer les joueurs manquant pour chaque equipe , on parcours la liste des equipes participante et on 
		 * regarde si le nombre de titulaire est valide si non alors des titulaires sont cree avec les bonnes donnes 
		 * pareil avec l equipe des remplacants .
		 */
		private void creationJoueurParStaff(){
			Iterator<Equipe> it=this.listeEquipeDepart.iterator();
			String[] postePossible={"defenseur","defenseur-central","milieu-defensif","milieu-offensif","attaquant"};
			while(it.hasNext()){
				Equipe x=it.next();
				if(x.nbJoueur()<Equipe.getNbTitulaire()){
					if(x.nbGardien()==0){
						Joueur y=new Gardien(this.tab[(int)(Math.random()*tab.length-1)+0],(this.tab[(int)(Math.random()*tab.length-1)+0]),Calendar.getInstance(),x.getClub(),"gardien",0);
						x.getEquipe().add(y);
						x.getEquipeTitulaire().add(y);
					}
					while(x.nbJoueur()<Equipe.getNbTitulaire()){
						Joueur y=new Joueur(this.tab[(int)(Math.random()*tab.length-1)+0],(this.tab[(int)(Math.random()*tab.length-1)+0]),Calendar.getInstance(),x.getClub(),postePossible[(int)(Math.random()*5)+0]);
						x.getEquipe().add(y);
						x.getEquipeTitulaire().add(y);
						
						
					}	
				}
				if(x.nbRemplacants()==0){
					Joueur y=new Joueur(this.tab[(int)(Math.random()*tab.length-1)+0],(this.tab[(int)(Math.random()*tab.length-1)+0]),Calendar.getInstance(),x.getClub(),postePossible[(int)(Math.random()*5)+0]);
					x.getEquipe().add(y);
					x.getRemplacants().add(y);
					
				}
			}
			
			
		}
		
		
		
		
		
		
		
		
		/**
		 * 
		 * l'utilisateur choisit l equipe dans laquelle il souhaite placer le joueur en saisisant l identifiant de l equipe 
		 * l equipe est recuperer avec la methode chercherEquipe(int id) qui retourne l adresse de l equipe dont on met
		 * l identifiant en parametre .
		 * Ensuite on appele la methode ajouter de l equipe choisit et on attrape les eventuelles exceptions lance .
		 * Certaine exception empeche definitivement d ajouter le joueur a la liste , comme l exception
		 * EquipePleineException qui signifie que le nombre maximal de joueur dans l equipe a ete atteind en revanche d autre
		 * exception comme le fait d avoir selectionner le mauvais club ne sont pas definitive et l utilisateur aura une seconde
		 * chance pour saisir la bonne information .
		 * 
		 * @see GestionnaireParticipant#chercherEquipe(int)
		 * @see EquipePleineException
		 * @see JoueurDejaPresentDansEquipeException
		 * @see JoueurLicencieAutreClubException
		 * @see LicenceInvalideException
		 * @se NombreDeGardienInvalideException
		 * @see Equipe
		 * @see Equipe#ajouterJoueur(Joueur)
		 * 
		 * 
		 * @param A le joueur cree precedement et qui va etre affecte a l equipe chosit par l utilisateur
		 * @return un boolean pour indiquer si le joueur a bien ete ajoute
		 
		 * 
		 */
		private boolean affecterJoueurAEquipe(Joueur A) {
		 while(true){
			System.out.println("information du joueur "+A.toString());
			System.out.println(); 
			affichageEquipeParticipante(); 
			System.out.println();
			System.out.print("Dans qu'elle equipe souhaitez vous l'affectez ? "); 
			int choix=donnerUnEntier();
			while(choix<1 || choix>this.listeEquipeDepart.size()){
				System.out.println("Donner un nombre qui correspond a l' identifiant  d'une equipe du tournoi ");
				choix=donnerUnEntier(); 		
			}	
			Equipe equipe=chercherEquipe(choix);
			try {
				equipe.ajouterJoueur(A);
				System.out.println("Affectation reussie ! le joueur "+A.getNom()+" a integré l equipe :"+A.getClub().getNom());
				return true ;  
			}catch (JoueurLicencieAutreClubException exp1){
				System.out.println(exp1.getMessage());
				System.out.println("Le joueur doit aller dans l'equipe "+A.getClub().getNom());
				
			}catch(JoueurDejaPresentDansEquipeException exp2){
				System.out.println(exp2.getMessage());
				return false; 	
			}
			catch (NombreDeGardienInvalideException e2) {
				System.out.println(e2.getMessage());
				return false; 
			}
			catch(LicenceInvalideExcepion  lie){
				System.out.println(lie.getMessage());
				lire.nextLine(); 
				System.out.println("Si vous souhaitez remettre sa licence a jour pour qu il puisse integrer l'equipe, tapper 1 sinon tapper une autre touche");
				String cpt=lire.nextLine();
				if(cpt.equals("1")){
					A.mettreAJourLicence();
					if(!equipe.numDejaPresent(A) && verifGardien(equipe,A)){
						equipe.getEquipe().add(A);
						equipe.getEquipeTitulaire().add(A);
						System.out.println("Affectation reussie ! le joueur "+A.getNom()+" a integré l equipe :"+A.getClub().getVille());
						return true;
					}else {
						if(!verifGardien(equipe,A)){
							System.out.println("Il y a deja un gardien dans l'equipe donc le joueur "+A.getNom()+" ne pourra pas integré l'equipe");	
						}
						if(equipe.numDejaPresent(A)){
							System.out.println("Le joueur avec le numero de licence :"+A.getNumeroDeLicence()+" est deja integré dans l'effectif , ce numero de licence ne peut pas être affecté a deux joueurs et doit etre unique au sein d'une equipe ") ; 
						}
						return false; 
					}
				}else {
					return false; 
				}
			}catch(EquipePleineException e3){
				System.out.println(e3.getMessage());
				return false;
			}

		 }
	
		}
		
		
		
		
		
		/**
		 * dans le cas ou un joueur a une date de validite inccorecte on propose a l utilisateur de la remettre a jour et si oui
		 * on ajoute le joueur directement sans passer par la methode ajouter de Equipe
		 *  mais en verifiant certaine condition dont celle ci pour s assurer que le nombre de gardien soit toujours egal a un .
		 * @param e representel equipe ou le joueur va etre ajoute
		 * @param a represente le joueur a ajoute
		 * @return un boolean pour indiquer  si le nombre de gardien est correcte
		 */
		private boolean verifGardien(Equipe e, Joueur a){
			if (e.nbGardien()==1){
				if(a instanceof Gardien){
					return false;
				}
			}
			return true; 
		}
		

		public void afficherDonnerChaqueJoueur(){
			 Iterator<Equipe>it=this.listeEquipeDepart.iterator();
			    while(it.hasNext()){
			    	Equipe x=it.next();
			    	System.out.println(x.toStringTitulaire());
			    	System.out.print("-----------------------------------------------------------------------------------------------------------------------------------------------");
			    }
			
		}
			
		

		/**
		 * ce getter permet d obtenir la liste des equipes participantes
		 * @return la liste des equipes participantes
		 */
		public List<Equipe> getListeEquipeDepart(){
			return this.listeEquipeDepart;
		}
		
		
		
		
		/**
		 * cette methode affiche la liste des equipes participante sans leur id 
		 */
		public void afficherListeEquipeSansId(){
			Iterator<Equipe>it=this.listeEquipeDepart.iterator();
			while(it.hasNext()){
				Equipe x=it.next();
				System.out.println("Equipe : "+x.getClub().getNom());
			}
			
		}
		
		
		
		
		/**
		 * cette methode permet de simuler un tournoi  pour ce faire , une liste bis est cree avec toutes les equipes participantes
		 * puis on parcourt la liste original listeEquipeEncoreParticipante tant qu'elle ne vaut pas un , on utilise un objet Tour
		 * qui va enregistrer tous les matchs de paire possible avec cette premiere liste et a chaque fois organise un match 
		 * entre paire et supprimer de la liste bis le perdant du match . A la fin d un tour la liste EquipeEncoreParticipante ne garde
		 * que les equipes qui sont encore dans la liste bis qui represente les equipes qui ont gagne leur match et sont encore en lice
		 * dans le tournoi . Puis on passe au tour suivant et ainsi de suite jusqu'a ce qu il ne reste que une equipe qui 
		 * represente l equipe gagnante du tournoi .
		 * Pour terminer les differents resultats sont enregister  avec la methode enregistrement et on affiche a l ecran les vainqueurs du tournoi
		 * et les recompenses puis on retourne a la methode mode ou cette fois ci les options qui n etaient pas accessible au 
		 * depart le seront notament celle pour rechercher une rencontre ou afficher les stats des equipes .
		 * 
		 * @see Tour
		 * @see Match
		 * @see Equipe
		 * @see GestionnaireParticipant#mode()
		 * @see GestionnaireParticipant#enregistrement()
		 * 
		 */
		public void simulerTournoi(){
			System.out.println(); 
			System.out.println(); 
			System.out.println("Le tournoi va commencer !!!!");
			System.out.println("Il y aura "+this.nbEquipe+" Equipe participantes ");
			System.out.println("Chaque equipe est compose de "+this.nbTitulaire+" titulaire , chaque equipe doit avoir des remplacants et peut en avoir jusqu'a "+(Equipe.getNbJoueurMaximalParEquipe()-Equipe.getNbTitulaire()));
			System.out.println("Voici la liste des equipes ");
			this.afficherListeEquipeSansId();
			System.out.println("Bonne chance a chacune des équipes !!!");
			System.out.println();  
			System.out.println(); 
			listeRecapTour=new ArrayList<Tour>() ;
			this.listeEquipeEncoreParticipante.addAll(this.listeEquipeDepart);
			Calendar debut=Calendar.getInstance();
			ArrayList <Equipe>enLice=new ArrayList<Equipe>();
			Iterator<Equipe>it=this.listeEquipeEncoreParticipante.iterator();
			while(it.hasNext()){
				Equipe x=it.next();
				enLice.add(x);
			}
			int cpt=1;
			while(this.listeEquipeEncoreParticipante.size()!=1){
				System.out.println(); 
				System.out.println("Il y a "+listeEquipeEncoreParticipante.size()+" equipe en lice dans le tournoi  !!") ;
				int i=0;Tour table=new Tour(); 
				System.out.println();
				System.out.println("=========================================================================================");
				System.out.println("TOUR :"+cpt);
				int m=1;
				while(i<listeEquipeEncoreParticipante.size()){
					System.out.println(); 
					System.out.print("Match :"+m);
					System.out.println(); 
					Arbitre b=new Arbitre("nom","prenom",Calendar.getInstance(),new Club("nom","ville")); 
					Match x=new Match(listeEquipeEncoreParticipante.get(i),listeEquipeEncoreParticipante.get(i+1),b,debut); 
					
					Equipe G=x.getGagnant(); 
					if(G==listeEquipeEncoreParticipante.get(i)) {
						System.out.println("L equipe "+listeEquipeEncoreParticipante.get(i+1).getClub().getNom()+" est eliminé du tournoi"); 
						enLice.remove(listeEquipeEncoreParticipante.get(i+1));
					}else {
						System.out.println("L equipe "+listeEquipeEncoreParticipante.get(i).getClub().getNom()+" est eliminé du tournoi"); 
						enLice.remove(listeEquipeEncoreParticipante.get(i));
					}
					System.out.println(); 
					table.getListeMatch().add((Match)x); 
					i=i+2;
					m++;
					
				
			}
				System.out.println("=========================================================================================");
				cpt++;
				debut.add(1, Calendar.DAY_OF_MONTH);
				listeRecapTour.add(table); 
				listeEquipeEncoreParticipante.retainAll(enLice); 
				
				
			}
			enregistrement();
			System.out.println(); 
			System.out.println("LE TOURNOI EST TERMINÉ , LE GAGNANT DU TOURNOI EST L'EQUIPE DE  "+listeEquipeEncoreParticipante.get(0).getClub().getNom()+"  FÉLICITATION À EUX !!!"); 
			this.gagnantTournoi=listeEquipeEncoreParticipante.get(0);
			Gardien meilleurG=meilleurGoal(); 
			System.out.println("Meilleur gardien du tournoi :"+meilleurG.getNom()+" du club "+meilleurG.getClub().getNom());
			System.out.println("Meilleur buteur du tournoi :"+meilleurButeurTournoi().getNom()+" du club "+meilleurButeurTournoi().getClub().getNom()+" avec "+meilleurButeurTournoi().getNbBut()+" buts");
			System.out.println("Felicitation à tous les participants pour ce magnifique tournoi !");
			System.out.println(); 
			
			
			
		}
		
		
		
		
		
		
		/**
		 * on recupere dans un premier temps dans une liste les gardien de chaque equipe participante
		 * pour trouver le gardien avec la meilleur moyennne et le retourner.
		 * @return le meilleur gardien de la competion
		 * @see Gardien
		 */
		private  Gardien meilleurGoal() {
			List<Gardien>listeGoal=new ArrayList<Gardien>();
			Iterator<Equipe>it=this.listeEquipeDepart.iterator();
			while(it.hasNext()){
				Equipe x=it.next();
				listeGoal.add(x.getGardien());
			}
			int moyenne=-1;
			Gardien meilleur=null; 
			Iterator<Gardien>it2=listeGoal.iterator();
			while(it2.hasNext()){
				Gardien x=it2.next();
				if(x.getMoyenne()>moyenne){
					meilleur=x; 
					moyenne=x.getMoyenne();
				}
			}
			return meilleur; 
		}
		
		
		
		/**
		 * cette methode enregistre dans deux fichiers respectivement le resume des rencontres du tournoi 
		 * et les informations relatives aux equipes (les titulaire , les remplacants etc ). 
		 */
		public void enregistrement(){
			try {
				
			PrintWriter fichier; 
			PrintWriter fichier2;
			File f2=new File("Resumé-des-rencontres-du-tournoi");
		    File f = new File ("Information-equipes-tournoi ");
		    fichier2=new PrintWriter(f2);
		    fichier = new PrintWriter(f); 
		    fichier.println("Composition des equipes participants au tournoi :");
		    fichier.println(); 
		    fichier2.println("Résume des rencontres du tournoi ");
		    fichier2.println(); 
		    
		    Iterator<Tour> it1=this.listeRecapTour.iterator();
		    while(it1.hasNext()){
		    	Tour x=it1.next();
		    	fichier2.print(x.toString());
		    	fichier2.println(); 
		    }
		    Iterator<Equipe>it=this.listeEquipeDepart.iterator();
		    while(it.hasNext()){
		    	Equipe x=it.next();
		    	fichier.print("Equipe:"+x.getIdentifiant()+"("+x.getClub().getNom()+")");
		    	fichier.println(); 
		    	fichier.print("Entraineur : "+x.getEntraineur().getNom()+"  "+x.getEntraineur().getPrenom());
		    	fichier.print(x.toStringTitulaire());
		    	fichier.print(x.toStringRemplacants());
		    	fichier.println(); 
		    	fichier.println(); 
		    }
		    fichier2.close();
		    fichier.close();
				
			}catch (Exception e) {
				e.printStackTrace();
			}
			
			
		}

		
		

		/**
		 * cette methode affiche notice pour donner quelques explications sur le fonctionnement de l application
		 */
		private void notice () {
			System.out.println(); 
			System.out.println("1-La creation des equipes ai laissé à la charge de l'utilisateur cependant cette tache pouvant être pénible à la longue , il est possible à tout moment de laisser l'ordinateur s'en charger.");
			System.out.println("2-Certaine option de ce programme ne sont disponible que une fois qu'un tournoi à eu lieu comme par exemple la recherche d'un match.");
			System.out.println("3-Si un tournoi à deja eu lieu et que l'on lance un nouveau tournoi alors les resultats du précedent tournoi sera oublié.");
			
			
			System.out.println(); 
			
		}
		

		/**
		 * message de fin quand l utilisateur quitte l'application
		 */
		private void messageDeFin(){
			System.out.println(); 
			System.out.println("Nous vous remercions d'avoir utilise notre application et nous ésperons vous retrouver bientôt");

		}
		
		
		
		
		
		
		
		
		
		
	
		
		
		/**
		 * cette methode permet a l utilisateur de rechercher les stats d une equipe en particulier 
		 */
		public void rechercherStats(){
			
			if(this.listeEquipeDepart!=null){
				System.out.println("Voici la liste des equipes :");
			
				while(true){
					for(int i=0; i<this.listeEquipeDepart.size(); i++){
						System.out.println("equipe :"+this.listeEquipeDepart.get(i).getClub().getNom()+" (tapper "+i+")");
					}
					System.out.println(); 
					System.out.println("De quelle equipe voulez vous les stats ?");
					int x=donnerUnEntier();
					while(x<0 || x>this.listeEquipeDepart.size()-1){
						System.out.println("saisie incorrecte"); 
						x=donnerUnEntier();
					
					}
				
					this.listeEquipeDepart.get(x).afficherStats();
					break;
				
				
			}
			}else {
				System.out.println("Le tournoi n'a pas encore commencer");
			}
			
		}
		
		
		
		
		
		
		/**
		 * 
		 * @param table la liste des tour qui ont eu lieu pendant le championnat
		 * @param indice l indice du match rechercher
		 */
		public void afficherMatch(List<Tour>table,int indice){
			int cpt=0;
			Iterator<Tour>it1=table.iterator();
			Match y=null;
			while(cpt<=indice){
				Tour x=it1.next();
				Iterator<Match>it2=x.getListeMatch().iterator();
				while(it2.hasNext() && cpt<=indice){
					y=it2.next();
					cpt++;
				}
			}
			System.out.println(y.getG().getClub().getNom()+"       VS        "+y.getD().getClub().getNom());
			System.out.println(y.getScore());
			System.out.println("Vainqueur : "+y.getGagnant().getClub().getNom());
		}



		/**
		 * cette methode permet a l utilisateur de rechercher un match
		 */
		public  void rechercherMatch(){
			int i=0; 
			if(this.listeRecapTour!=null){
				System.out.println("Voici la liste des match du tournoi( du premier match jusqu'au dernier)");
				Iterator<Tour> it1=this.listeRecapTour.iterator();
				while(it1.hasNext()){
					Tour x=it1.next(); 
					Iterator<Match>it2=x.getListeMatch().iterator();
					while(it2.hasNext()){
						Match y=it2.next();
						System.out.println("match:"+i+" opposant "+y.getG().getClub().getNom()+" VS "+y.getD().getClub().getNom()+"  (tapper "+i+")" );
						i++;
					}
				}
				System.out.println();
				System.out.println("De quelle match souhaitez-vous avoir les statistiques");
				int choix=donnerUnEntier(); 
				while(choix<0 || choix>i-1){
					System.out.println("Saisie inccorect");
					choix=donnerUnEntier(); 
				}
					afficherMatch(this.listeRecapTour,choix);
					System.out.println(); 
			}else {
				System.out.println("Le tournoi n' as pas encore commencer");
			}
		}

}
