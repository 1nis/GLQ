package exo1.adresses;
/**
 * Interface definisant les outils de recherche d'exo1.adresses postales par nom.
 * Les exo1.adresses sont stockees dans un fichier, ou une base de donnees,
 * ou une structure de donnees, etc. L'interface fournit une methode de recherche.
 */
public interface ChercheurDAdresses {
	Adresse chercher(String nom);
}
