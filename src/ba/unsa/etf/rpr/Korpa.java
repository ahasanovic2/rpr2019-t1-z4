package ba.unsa.etf.rpr;

public class Korpa {
    private Artikl[] korpa = new Artikl[50];
    private int brojac = 0;
    public boolean dodajArtikl (Artikl a) {
        if (brojac >= 50) return false;
        korpa[brojac] = new Artikl(a.getNaziv(),a.getCijena(),a.getKod());
        brojac++;
        return true;
    }

    public Artikl[] getKorpa() {
        return korpa;
    }
    public Artikl izbaciArtiklSaKodom (String kod) {
        for (int i = 0; i<brojac;i++)
        {
            if (korpa[i].getKod().equals(kod)) {
                Artikl povrat = new Artikl(korpa[i].getNaziv(),korpa[i].getCijena(),korpa[i].getKod());
                korpa[i] = null;
                for (int j = i; j < brojac; j++) korpa[i] = korpa[i+1];
                korpa[brojac] = null;
                brojac--;
                return povrat;
            }
        }
        return null;
    }
    public int dajUkupnuCijenuArtikala () {
        int suma = 0;
        for (int i = 0; i < brojac; i++) suma = suma + korpa[i].getCijena();
        return suma;
    }

    public Artikl[] getArtikli() {
        return korpa;
    }
}
