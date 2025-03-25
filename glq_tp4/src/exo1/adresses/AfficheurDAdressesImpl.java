package exo1.adresses;
/**
 * Une implementation de l'interface <tt>AfficheurDAdresses</tt>.
 *
 */
public class AfficheurDAdressesImpl implements AfficheurDAdresses {
	private ChercheurDAdresses chercheur;
	
	public AfficheurDAdressesImpl(ChercheurDAdresses c) { 
		chercheur = c; 
	}
	
	@Override
	public String afficher(String nom) {
		Adresse a = chercheur.chercher( nom);
		if ( a == null) throw new IllegalArgumentException();
		String resultat = a.nom() + "\n";
		int num = a.numero();
		if ( num != 0) resultat += num +  " "; // un seul appel à numero()
		//if ( a.numero() != 0) resultat += a.numero() +  " "; // deux appels à numero()
		resultat += a.rue() + "\n";
		resultat += a.codePostal() +  " " + a.ville();
		return resultat;
	}
}
