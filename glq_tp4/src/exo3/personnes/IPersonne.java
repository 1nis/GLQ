package exo3.personnes;

import java.time.LocalDate;

/**
 * Interface <tt>IPersonne</tt>.
 *
 * @author Lucile Torres
 * @see Personne
 */

public interface IPersonne {
    /**
     * Renvoie le nom de cette personne.
     *
     * @return le nom de cette personne.
     */
    String getNom();

    /**
     * Renvoie le prenom de cette personne.
     *
     * @return le prenom de cette personne.
     */
    String getPrenom();

    /**
     * Renvoie la date de naissance de cette personne.
     *
     * @return la date de naissance de cette personne.
     */
    LocalDate getDate();

    /**
     * Renvoie l'age de la personne a la date donnee.
     *
     * @param d la date a laquelle l'age de cette personne est calcule.
     * @return l'age de cette personne  a la date d.
     */
    int getAge(LocalDate d);

    /**
     * Renvoie l'age de la personne a la date d'aujourd'hui.
     *
     * @return l'age de cette personne a la date d'aujourd'hui.
     */
    int getAge();
}