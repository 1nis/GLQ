package exo3.personnes;

import java.time.LocalDate;
import java.time.Period;
import java.util.Objects;

/**
 * Implementation de l'interface <tt>IPersonne</tt>.
 *
 * @author Lucile Torres
 * @see IPersonne
 */

public class Personne implements IPersonne, Comparable<Personne>{

    /** Le nom de la Personne */
    private final String nom_;

    /** Le prenom de la Personne */
    private final String prenom_;

    /** La date de naissance de la Personne */
    private final LocalDate dateNaissance_;

    /**
     * Construit une personne avec le nom, le prenom et la date de naissance donnes.
     *
     * @param 	prenom le prenom de la personne.
     * @param 	nom le nom de la personne.
     * @param 	d la date de naisssance.
     * @throws 	NullPointerException si le nom, le prenom ou la date de naissance
     * 			sont {@code null}.
     *
     */
    public Personne (String prenom, String nom, LocalDate d) {
        super();
        if (nom == null || prenom == null || d == null)
            throw new NullPointerException();
        nom_ = nom; prenom_ = prenom; dateNaissance_ = d;
    }

    /**
     * Renvoie le nom de cette personne.
     *
     * @return le nom de cette personne.
     */
    public String getNom() { return nom_; }

    /**
     * Renvoie le prenom de cette personne.
     *
     * @return le prenom de cette personne.
     */
    public String getPrenom() { return prenom_; }

    /**
     * Renvoie la date de naissance de cette personne.
     *
     * @return la date de naissance de cette personne.
     */
    public LocalDate getDate() { return dateNaissance_; }

    private static int calculeAge(LocalDate naissance, LocalDate courante) {
        if ((naissance == null) || (courante == null))
            return 0;
        return Period.between(naissance, courante).getYears();
    }

    /**
     * Renvoie l'age de la personne a la date donnee.
     *
     * @param d la date a laquelle l'age de cette personne est calcule.
     * @return l'age de cette personne  a la date d.
     */
    public int getAge(LocalDate d) {
        return calculeAge( dateNaissance_, d);
    }

    /**
     * Renvoie l'age de la personne a la date d'aujourd'hui.
     *
     * @return l'age de cette personne a la date d'aujourd'hui.
     */
    public int getAge() {
        return getAge( LocalDate.now());
    }

    /**
     * Renvoie une representationn textuelle de la personne.
     *
     * @return une representation de la personne sous forme de String.
     */
    public String toString() {
        return prenom_ + " " + nom_ + " (" + dateNaissance_ + ")";
    }

    /**
     * Renvoie une valeur de hachage pour la personne.
     *
     * @return une valeur de hachage pour cette personne.
     * @see #equals(java.lang.Object)
     */
    public int hashCode() {
        return Objects.hash( nom_, prenom_, dateNaissance_);
    }

    /**
     * Indique si un autre objet est egal a cette personne.
     *
     * @param o
     * @return {@code true} si cette personne est la mÃªme que
     *          l'argument o, {@code false} sinon.
     * @see #hashCode()
     * @see #compareTo(Personne)
     */
    public boolean equals(Object o) {
        return (o != null && (o instanceof Personne)
                && nom_.equals(((Personne)o).nom_)
                && prenom_.equals(((Personne)o).prenom_)
                && dateNaissance_.equals(((Personne)o).dateNaissance_));
    }

    /**
     * Compare deux personnes par ordre lexicographique de leurs noms
     * si elles ont des noms differents, par ordre lexicographique de
     * leurs prenoms sinon. Et si les personnes sont homonymes, les personnes
     * sont comparÃ©es par date de naissance croissante.
     *
     * @param 	autrePersonne l'autre personne a comparer a cette personne
     * @return 	la valeur <code>0</code> si l'argument autrePersonne est egal
     * 			a cette personne, une valeur inferieure a <code>0</code> si
     * 			cette personne est inferieure a l'argument autrePersonne, et
     * 			une valeur superieure a <code>0</code> si cette personne est
     * 			superieure a l'argument autrePersonne.
     * @see #equals(java.lang.Object)
     */
    public int compareTo(Personne autrePersonne) {
        int comparaisonNoms = nom_.compareTo(autrePersonne.nom_);
        if ( comparaisonNoms != 0 ) return comparaisonNoms;
        else {
            int comparaisonsPrenoms = prenom_.compareTo(autrePersonne.prenom_);
            return ( comparaisonsPrenoms != 0 ? comparaisonsPrenoms
                    : dateNaissance_.compareTo(autrePersonne.dateNaissance_) );
        }
    }
}