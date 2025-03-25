package exo3.personnes;

/**
 * Interface <tt>ISalarie</tt>.
 * implemente l'interface IPersonne
 *
 * @author Lucile Torres
 *
 */

public interface ISalarie extends IPersonne {

    /**
     * Renvoie un identifiant unique pour le salarie
     * sous forme d'une chaine de caracteres.
     *
     * @return l'identifiant de ce salarie.
     */
    String getIdUnique();

    /**
     * Modifie le salaire du salarie avec le montant donne.
     *
     * @param salaire	le nouveau salaire de ce salarie.
     */

    void setSalaire(double salaire);

    /**
     * Renvoie un identifiant unique pour le salarie.
     *
     * @return l'identifiant de ce salarie.
     */
    double getSalaire();
}