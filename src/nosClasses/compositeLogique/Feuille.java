package nosClasses.compositeLogique;


public class Feuille extends Formulelogique {
	
	public boolean valeur;
	
	boolean evaluer() {
		return valeur;
	}
	
	public Feuille(boolean valeur) {
		this.valeur=valeur;
	}
	

}
