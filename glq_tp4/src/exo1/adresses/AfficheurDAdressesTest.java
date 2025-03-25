package exo1.adresses;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class AfficheurDAdressesTest {

    private AfficheurDAdresses uneadresse;
    private ChercheurDAdresses chercheAdresse;

    @BeforeEach
    void setup() throws Exception {
        uneadresse = mock(AfficheurDAdresses.class);
        chercheAdresse = mock(ChercheurDAdresses.class);
        Adresse adresse1 = new Adresse("Anis", 92, "Boulevard Larrat", 13010, "Marseille");
        when(chercheAdresse.chercher("Anis")).thenReturn(adresse1);

        uneadresse = new AfficheurDAdressesImpl(chercheAdresse);
    }

    @Test
    void testNom() {
        System.out.println();
        System.out.println(uneadresse.afficher("Anis"));
    }

}
