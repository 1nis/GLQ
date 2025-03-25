package exo3.personnes;

import java.time.LocalDate;


/**
 * Implementation de l'interface <tt>ISalarie</tt>,
 * sous-classe de Personne
 *
 * @author Lucile Torres
 * @see ISalarie
 * @see Personne
 */


public class Salarie extends Personne implements ISalarie {

    /** Le NIRPP (numero d'inscription au repertoire des personnes physiques)
     *  du salarie, qui constitue son identifant.
     */
    private String nirpp_;

    /** Le salaire du salarie. */
    private double salaireAnnuel_;

    /**
     * Construit un salarie avec le nom, le prenom, la date de naissance, le
     * NIRPP et le salaire annuel donnes.
     *
     * @param 	prenom	le prenom de la personne.
     * @param 	nom 	le nom de la personne.
     * @param 	naissance 		la date de naisssance de la personne.
     * @param 	nirpp 	le NIRPP de la personne.
     * @param 	salaire le salaire annuel.
     * @throws 	NullPointerException si le nom, le prenom ou la date de naissance
     * 			sont {@code null}.
     *
     */
    public Salarie(String nom, String prenom, LocalDate naissance, String nirpp, double salaire) {
        super( nom, prenom, naissance);
        nirpp_ = nirpp;
        salaireAnnuel_ = salaire;
    }

    /**
     * Renvoie le NIRPP du salarie.
     *
     * @return le NIRPP de ce salarie.
     */
    @Override
    public String getIdUnique() { return nirpp_; }

    /**
     * Modifie le salaire annuel du salarie avec le nouveau salaire donne.
     *
     * @param nouveauSalaire e nouveau salaire annuel de ce salarie.
     */
    @Override
    public void setSalaire(double nouveauSalaire) { salaireAnnuel_ = nouveauSalaire; }

    /**
     * Renvoie le salaire annuel du salarie.
     *
     * @return le salaire annuel de ce salarie.
     */
    @Override
    public double getSalaire()  { return salaireAnnuel_; }

    /**
     * Renvoie une representationn textuelle du salarie.
     *
     * @return une representation du salarie sous forme de String.
     */
    @Override
    public String toString() {
        return super.toString() + " salaire=" + salaireAnnuel_ + "â‚¬";
    }
}