package nosClasses.compositeLogique;


public class AndOperateur extends OperateurLogique {
	
		public	AndOperateur(Formulelogique f1,Formulelogique f2) {
			super(f1,f2);
		}
		

		@Override
		public
		boolean evaluer() {
			// TODO Auto-generated method stub
			return this.op1.evaluer() && this.op2.evaluer();
		}
	  
}
