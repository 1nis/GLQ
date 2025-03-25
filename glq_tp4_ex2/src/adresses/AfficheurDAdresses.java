package adresses;
/**
 * Interface definissant les outils d'affichage des adresses postales.
 * Les adresses affichees sont fournies par un ChercheurDAdresses. L'interface
 * fournit une methode d'affichage.
 */
public interface AfficheurDAdresses {
	String afficher(String nom);
}
