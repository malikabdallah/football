package nosClasses;
import nosClasses.compositeLogique.*;

public class LancementTournoi {

	/**
	 * main qui lance le tournoi de football
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		@SuppressWarnings("unused")
		//GestionnaireParticipant x=new GestionnaireParticipant();
		
		int s=7000;
		int h=s/3600;
		s=s%3600;
		int m=s/60;
		s=s%60;
		
		System.out.println(h+"/"+m+"/"+s);
		AndOperateur f=new AndOperateur(new Feuille(false),new Feuille(false));
    	System.out.println("false && false = "+f.evaluer());
	}

}
