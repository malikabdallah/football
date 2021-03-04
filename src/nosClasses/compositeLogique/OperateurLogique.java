package nosClasses.compositeLogique;


public abstract class OperateurLogique extends Formulelogique {
	
	public Formulelogique op1;
	public Formulelogique op2;
	
	public OperateurLogique (Formulelogique f1,Formulelogique f2) {
		//super(f1,f2);
		this.op1=f1;
		this.op2=f2;
	}
	
	

}
