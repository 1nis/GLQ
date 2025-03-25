package adresses;
import java.util.Objects;

/**
 * Adresse postale decrite par un nom, un numero de rue, un nom de rue, un code
 * postal et une ville. Le numero peut etre absent. Le nom de l'habitant, le nom
 * de la rue et la ville ne peuvent pas etre vides.
 *
 */
public class Adresse {
	private String nom;
	private int numero;
	private String rue;
	private int codePostal;
	private String ville;
	
	/**
	 * Construction d'une adresse complete.
	 * @param nom
	 * @param numero
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @throws NullPointerException si le nom, la rue ou la ville donnes sont null.
	 * @throws IllegalArgumentException si le numero de rue est negatif ou si le nom de rue est vide.
	 */
	public Adresse(String nom, int numero, String rue, int codePostal, String ville) {
		Objects.requireNonNull(nom);
		Objects.requireNonNull(rue);
		Objects.requireNonNull(ville);
		if ( numero < 0 || rue.length() == 0 )  
			throw new IllegalArgumentException();
		this.nom = nom;
		this.numero = numero;
		this.rue = rue;
		this.codePostal = codePostal;
		this.ville = ville;
	}
	
	/**
	 * Construction d'une adresse sans numero de rue.
	 * @param nom
	 * @param rue
	 * @param codePostal
	 * @param ville
	 * @throws NullPointerException si le nom, la rue ou la ville donnes sont null.
	 * @throws IllegalArgumentException si le nom de rue est vide.
	 */
	public Adresse(String nom, String rue, int codePostal, String ville) {
		this(nom, 0, rue, codePostal, ville);
	}
	
	/**
	 * Renvoie le nom de l'habitant.
	 * 
	 * @return le nom de l'habitant.
	 */
	public String nom() { return nom; }
	
	/**
	 * Renvoie le numero de la rue.
	 * 
	 * @return le numero de la rue.
	 */
	public int numero() { return numero; }
	
	/**
	 * Renvoie le nom de la rue.
	 * 
	 * @return le nom de la rue.
	 */
	public String rue() { return rue; }
	
	/**
	 * Renvoie le code postal de l'adresse.
	 * 
	 * @return le code postal.
	 */
	public int codePostal() { return codePostal; }
	
	/**
	 * Renvoie la ville de l'adresse.
	 * 
	 * @return la ville.
	 */
	public String ville() { return ville; }
}
