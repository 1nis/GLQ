package adresses;
/**
 * Interface definisant les outils de recherche d'adresses postales par nom.
 * Les adresses sont stockees dans un fichier, ou une base de donnees, 
 * ou une structure de donnees, etc. L'interface fournit une methode de recherche.
 */
public interface ChercheurDAdresses {
	Adresse chercher(String nom);
}
