package nosClasses;

/**
 * 
 * <p>
 * 		Cette classe donne le moule des instances clubs qui composent les equipes et laquelle sont affilie les participants du tournoi
 *      <br/>
 *      Un club est caracterise par deux attributs : 
 * 		 <ul>

 * 				<li>Un nom  qui ne changera pas.</li>
				<li>Une ville qui ne changera pas</li>
 * 

 * 		</ul>
 * 
 * </p>
 * @see Equipe
 * @version 1
 * @author : Timote ,Malik
 */


public class Club {
	
	/**
	 * Cette attributs n'est pas modifiable  est permet d'identifie le nom du club.
	 * @see Club#Club(String,String)
	 * @see Club#getNom()
	 * @see Club#equals(Object)
	 */
	private String nom; 
	
	
	
	/**
	 * Cette attributs n'est pas modifiable  est permet d'identifié la ville du club.
	 * @see Club#Club(String,String)
	 * @see Club#getVille()
	 * @see Club#equals(Object)
	 */
	private String ville;
	
	
	
	/**
	 * Ce constructeur cree l objet de type club avec deux parametre  qui correspondent au nom et a la ville du club.
	 * @see Club#nom
	 * @see Club#ville
	 * @see Club#equals(Object)
	 * 
	 */
	public Club(String nom, String ville) {
		super();
		this.nom = nom;
		this.ville = ville;
	}
	 
    
	
	
	 /**
     * retourne une chaine de caractere qui est le nom du club 
     * @return le nom du club
     */
	public String getNom() {
		return nom;
	}


	/**
	 * retourne une chaine de caractere qui est le nom de la ville du club
	 * @return le nom de la ville du club
	 */
	public String getVille() {
		return ville;
	}


	
	/**
	 * @return retourne la chaine de caractere avec les informations du club.
	 */
	@Override
	public String toString() {
		return "Club [nom=" + nom + ", ville=" + ville + "]";
	}

	
	
	/**
	 * @return le hashCode du club, qui est un entier qui sert a identifié le club . Si deux objet ont le meme hashCode alors 
	 * ils sont egaux d'apres la methode equals . 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((ville == null) ? 0 : ville.hashCode());
		return result;
	}


	
	/**
	 * @return un booleen pour determine si deux objets de type club sont egaux
	 * @param obj ,prend un parametre objet et teste s'il est egal a l instance appelante 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Club other = (Club) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (ville == null) {
			if (other.ville != null)
				return false;
		} else if (!ville.equals(other.ville))
			return false;
		return true;
	} 
	
	
	
}
