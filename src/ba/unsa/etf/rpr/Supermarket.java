package ba.unsa.etf.rpr;

public class Supermarket {
    private Artikl[] sve = new Artikl[1000];
    private int brojac = 0;
    public boolean dodajArtikl (Artikl a) {
        if (brojac >= 50) return false;
        sve[brojac] = new Artikl(a.getNaziv(),a.getCijena(),a.getKod());
        brojac++;
        return true;
    }

    public Artikl[] getSve() {
        return sve;
    }
    public Artikl izbaciArtiklSaKodom (String kod) {
        for (int i = 0; i < brojac; i++) {
            if (sve[i].getKod().equals(kod))
            {
                Artikl povrat = new Artikl(sve[i].getNaziv(),sve[i].getCijena(),sve[i].getKod());
                sve[i] = null;
                for (int j = i; j < brojac; j++) sve[i] = sve[i+1];
                sve[brojac] = null;
                brojac--;
                return povrat;
            }
        }
        return null;
    }

    public Artikl[] getArtikli() {
        return sve;
    }

}
