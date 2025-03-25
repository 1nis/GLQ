package adresses;

import org.junit.jupiter.api.BeforeEach;

import static org.mockito.Mockito.*;

public class AfficheurDAdressesTest {

    private Adresse uneadresse;
    private AfficheurDAdressesImpl afficheadresse;

    @BeforeEach
    void setup() throws Exception {
        uneadresse = mock(Adresse.class);
        afficheadresse = mock(AfficheurDAdressesImpl.class);

    }

}
