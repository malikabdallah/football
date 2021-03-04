package nosClasses;
import java.util.Calendar;

/**
 * <p>
 * 		cette classe definit les caracteristique d un match les matchs compose le tournoi , un match est compose de <br/>
 * 		-deux Equipes que nous appelerons G et D 
 * 		<br/>
 * 		-Un arbitre 
 * 		<br/>
 * 		-Un score 
 * 		<br/>
 * 		-une equipe gagnant , donc soit G soit D 
 * 		<br/>
 * 		-Une date qui est l'heure a laquelle commence le match
 * 		<br/>
 * 		-deux entiers qui correspondent au score de chaque equipe 
 * 		<br/> 
 * </p>
 * 
 * @see Equipe
 * @see Arbitre
 * @see Tour
 * @see GestionnaireParticipant
 * 
 * @author malik,timote
 *@version 1
 *
 */
public class Match {
	
	/**
	 * une des deux equipes du match 
	 * @see Equipe
	 */
	private Equipe G;
	
	/**
	 * une des deux equipes du match
	 * @see Equipe
	 */
	private Equipe D;
	
	/**
	 * L arbitre de la rencontre
	 */
	private Arbitre arbitre;
	
	
	/**
	 * le score de la rencontre
	 */
	private String score ; 
	
	/**
	 * le gagnant de la rencontre , par defaul la valeur est null
	 */
	private Equipe Gagnant=null ;
	
	/**
	 * la date de la rencontre
	 */
	private Calendar date; 
	
	
	/**
	 * le score de l equipe G
	 */
	private int scoreG;
	
	
	/**
	 * le score de l equipe d
	 * 
	 */
	private int scoreD;
	
	
	/**
	 * retourne le score de l equipe G
	 * @return le score de l eqioê g
	 */
	public int getScoreG() {
		return scoreG;
	}
	
	
	
	/**
	 * 
	 * @return le score de l equipe D
	 */
	public int getScoreD(){
		return scoreD;
	}
	
	
	
	
	/**
	 * 
	 * @param g l equipe G de la rencontre
	 * @param d l equipe D de la rencontre
	 * @param arbitre l arbitre de la rencontre
	 * @param date la date de la rencontre
	 */
	public Match(Equipe g, Equipe d, Arbitre arbitre,Calendar date) {
		G = g;
		D = d;
		this.arbitre = arbitre;
		this.simulerMatchAleatoirement(G,D,arbitre) ; 
		this.date=date;

	} 

	
	/**
	 * retourne l equipe G du match
	 * @return l 'equipe G
	 */
	public Equipe getG() {
		return G;
	}
	
	
	/**
	 * retourne la date de la rencontre
	 * @return la date de la rencontre
	 */
	public Calendar getDate(){
		
		return this.date;
	}

	
	/**
	 * retourne l equipe D du match
	 * @return l equipe D du match
	 */
	public Equipe getD() {
		return D;
	}


	
	/**
	 * retourne l arbitre de la renconte
	 * @return l arbitre de la renconte
	 */
	public Arbitre getArbitre() {
		return arbitre;
	}


	
	/**
	 * retourne le resultat de la rencontre
	 * @return le score de la rencontre
	 */
	public String getScore() {
		return score;
	}

	
	
	/**
	 * retourne le gagnant du match
	 * @return le gagnant du match
	 */
	public Equipe getGagnant() {
		return Gagnant;
	}


	
	/**
	 * retourne le perdant de la rencontre
	 * @return le perdant de la rencontre 
	 */
	public Equipe getPerdant(){
		if(this.D==this.Gagnant){
			return this.G;
		}else {
			return this.D;
		}
	}
	
	
	
	/**
	 * 
	 * @param G l equipe G de la rencontre
	 * @param D l equipe D de la rencontre
	 * @param a l arbitre de la renconte
	 * 
	 * cette methode simule aleatoirement l issue de la rencontre à l aide de Math.random, met a jour les moyennes des gardiens
	 * des deux equipes , determine l equipe gagnante de la rencontre et si le resultat est nul organise un concour de jongle
	 * 
	 */
	
	
	private void simulerMatchAleatoirement(Equipe G,Equipe D,Arbitre a) {
		System.out.println("La rencontre va commencer ") ; 
		System.out.println("L'équipe "+G.getClub().getNom()+" de "+G.getClub().getVille()+" affronte l'equipe "+D.getClub().getNom()+" de "+D.getClub().getVille()) ; 
		int scoreMiTempsEquipeG=(int)(Math.random()*3)+0; 
		int socreMiTempsEquipeD=(int)(Math.random()*3)+0;
		System.out.println("Le score à la mi-temps est de : \n"+G.getClub().getNom()+" :"+scoreMiTempsEquipeG+"  VS   "+socreMiTempsEquipeD+" :"+D.getClub().getNom());
		int scoreFinDeMatchEquipeG=scoreMiTempsEquipeG+(int)(Math.random()*3)+0;
		int scoreFinDeMatchEquipeD=socreMiTempsEquipeD+(int)(Math.random()*3)+0;
		System.out.println("Le score à la fin du match est de : \n"+G.getClub().getNom()+" :"+scoreFinDeMatchEquipeG+"  VS   "+scoreFinDeMatchEquipeD+" :"+D.getClub().getNom());
		this.score=String.valueOf(scoreFinDeMatchEquipeG)+"          :         "+String.valueOf(scoreFinDeMatchEquipeD); 
		moyenneGardien(scoreFinDeMatchEquipeG,scoreFinDeMatchEquipeD); 
		notificationButeur(scoreFinDeMatchEquipeG,scoreFinDeMatchEquipeD);
		if(scoreFinDeMatchEquipeG>scoreFinDeMatchEquipeD) {
			this.Gagnant=G;
			G.gagner();
			D.perdre();
		}else {
			if(scoreFinDeMatchEquipeD>scoreFinDeMatchEquipeG) {
				this.Gagnant=D; 
				D.gagner();
				G.perdre();
			}
			else {
				this.Gagnant=jonglage(G,D) ; 
				this.Gagnant.gagner();
				this.getPerdant().perdre();
			}
		}
		
		quiAgagne(); 
				
	}
	
	
	/**
	 * Cette methode attribut le nombre de but marque a un joueur de l equipe tirer au hasard
	 * @param nbButEquipeD nombre d ebut de l equipe G
	 * @param nbButEquipeG nombre de but de l equipe D
	 */
	private void notificationButeur(int nbButEquipeG,int nbButEquipeD){
	
		if(nbButEquipeG!=0){
			this.scoreG=nbButEquipeG; 
		
			Joueur jequipeG=G.tirerUnJoueurAuSort();
			jequipeG.ajouterBut(nbButEquipeG);
			System.out.println("Le buteur "+jequipeG.getNom()+" de l equipe "+G.getClub().getNom()+" a marque les "+nbButEquipeG+" de son equipe !");
		}
		if(nbButEquipeD!=0){
			this.scoreD=nbButEquipeD; 	
		
			Joueur jequipeD=D.tirerUnJoueurAuSort();
			jequipeD.ajouterBut(nbButEquipeD);
			System.out.println("Le buteur "+jequipeD.getNom()+" de l equipe "+D.getClub().getNom()+" a marque les "+nbButEquipeD+" de son equipe !");
		}
		
	}
	
	
	
	
	/**
	 * 
	 * @param scoreEquipeGauche le nombre de but mis par l equipe G
	 * @param scoreEquipeDroite le nombbre de but mis par l equipe D
	 * 
	 * met a jour les moyennes des gardiens suivants le nombre de but mis par l equipe adverse
	 */
	public void moyenneGardien(int scoreEquipeGauche,int scoreEquipeDroite){
			G.getGardien().calculerMoyenne(scoreEquipeDroite);
			D.getGardien().calculerMoyenne(scoreEquipeGauche);
	}
	
	
	
	
	/**
	 * affiche un message pour dire qui est l equipe gagnante
	 */
	public void quiAgagne () {
		System.out.println("L'equipe gagnante est :"+this.Gagnant.getClub().getNom());
	}
	
	
	
	
	/**
	 * renvoie une chaine de caractere avec les infos de la rencontre , a savoir qui sont les deux equipes qui s affrontent
	 * l heure de la rencontre et le score .
	 */
	@SuppressWarnings("static-access")
	public String toString(){
		
		String s="Rencontre "+this.G.getClub().getNom()+"  VS  "+this.D.getClub().getNom();
		s=s+"  Heure de debut rencontre:"+date.HOUR+"H"+":"+this.date.MINUTE+" le "+this.date.get(Calendar.DAY_OF_MONTH)+"/"+(this.date.get(Calendar.MONTH)+1)+"/"+this.date.get(Calendar.YEAR);
		s=s+"\n"+this.score+"\n"+"Vainqueur :"+this.Gagnant.getClub().getNom()+"\n \n"; 
		return s; 
	}
	
	
	
	/**
	 * 
	 * @param G equipe G
	 * @param D equipe D
	 * @return l equipe gagnant du concours de jongle
	 * 
	 * cette methode est lance si a l issue de la rencontre les deux equipes ont le meme score , dans ce cas on les departage
	 * avec cette methode
	 * 
	 */
	public Equipe jonglage (Equipe G, Equipe D) {
		
		System.out.println("Les equipes n'ayant pas reussi a se departager , un concour de jongles est organisé pour determiné l'equipe gagnante \n tour 1") ; 
		int tour=1;
		int x=(int)(Math.random()*100)+1;
		int y=(int)(Math.random()*100)+1;
		System.out.println(" Equipe :"+G.getClub().getNom()+"   jongles :"+x);
		System.out.println(" Equipe :"+D.getClub().getNom()+"   jongles :"+y);
		while(x==y) {
			tour=tour+1;
			System.out.println("tour "+tour) ;
			x=(int)(Math.random()*100)+1;
			y=(int)(Math.random()*100)+1;
			System.out.println(" Equipe :"+G.getClub().getNom()+"   jongles :"+x);
			System.out.println(" Equipe :"+D.getClub().getNom()+"   jongles :"+y);
		}
		this.score=this.score+"\n Resultat Jongle("+x+" contre "+y+")";
		if(x>y) {
			return G;
		}else {
			return D; 
		}
	}

	
	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((D == null) ? 0 : D.hashCode());
		result = prime * result + ((G == null) ? 0 : G.hashCode());
		return result;
	}

	
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Match other = (Match) obj;
		if (D == null) {
			if (other.D != null)
				return false;
		} else if (!D.equals(other.D))
			return false;
		if (G == null) {
			if (other.G != null)
				return false;
		} else if (!G.equals(other.G))
			return false;
		return true;
	}
	
	
	

}
