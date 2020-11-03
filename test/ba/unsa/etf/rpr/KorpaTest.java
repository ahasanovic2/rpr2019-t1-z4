package ba.unsa.etf.rpr;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class KorpaTest {

    @Test
    void dodajArtikl() {
        Artikl novi = new Artikl("Biciklo", 1000, "387abc");
        Korpa tasna = new Korpa();
        boolean istina = tasna.dodajArtikl(novi);
        assertTrue(istina);
    }

    @Test
    void izbaciArtiklSaKodom() {
        Korpa tasna = new Korpa();
        for (int i = 0; i < 30; i++) {
            Artikl artikl = new Artikl("Biciklo", i * 1000, String.valueOf(i));
            tasna.dodajArtikl(artikl);
        }
        Artikl izbaceni = tasna.izbaciArtiklSaKodom(String.valueOf(29));
        assertEquals(29000, izbaceni.getCijena());
    }

    @Test
    void dajUkupnuCijenuArtikala() {
        Korpa tasna = new Korpa();
        for (int i = 0; i < 10; i++) {
            Artikl artiklic = new Artikl("Laptop", i * 10, String.valueOf(i));
            tasna.dodajArtikl(artiklic);
        }
        int ukupna = tasna.dajUkupnuCijenuArtikala();
        assertEquals(450, ukupna);
    }
    @Test
    void testPuneKorpe() {
        Korpa tasna = new Korpa();
        for (int i = 0; i < 50; i = i+1) {
            Artikl pomocni = new Artikl ("Laptop", i+50, String.valueOf(i));
            tasna.dodajArtikl(pomocni);
        }
        Artikl pomocni = new Artikl ("Laptop",1000,"dedekinde");
        boolean istina = tasna.dodajArtikl(pomocni);
        assertAll("Korpa je puna brt",
                ()->assertFalse(istina)
        );
    }

    @Test
    void testBrojaArtikala() {
        Korpa tasna = new Korpa();
        Artikl pomocni = new Artikl ("Laptop",1000,"dedekinde");

        assertNotEquals(1, tasna.getBrojArtikala());
        tasna.dodajArtikl(pomocni);
        assertEquals(1, tasna.getBrojArtikala());
    }

}