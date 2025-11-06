import java.util.ArrayList;
import java.util.List;

class STUDENT {
    private String imie;
    private String nazwisko;
    private double ocena;
    private char plec;
    private String kierunek;

    private static List<STUDENT> lista = new ArrayList<>();

    public STUDENT(String imie, String nazwisko, double ocena, char plec, String kierunek) {
        this.imie = imie;
        this.nazwisko = nazwisko;
        this.ocena = ocena;
        this.plec = plec;
        this.kierunek = kierunek;
        lista.add(this);
        WyswietlInformacje();
    }

    public void WyswietlInformacje() {
        System.out.println("Informacje o studencie");
        System.out.println("Imię: " + imie);
        System.out.println("Nazwisko: " + nazwisko);
        System.out.println("Płeć: " + plec);
        System.out.println("Kierunek: " + kierunek);
        System.out.println("Ocena: " + ocena);
    }

    public void ZmienKierunek(String nkier) {
        this.kierunek = nkier;
        System.out.println("Kierunek został zmieniony na: " + nkier);
        WyswietlInformacje();
    }

    public void ZmienOcene(double nocen) {
        this.ocena = nocen;
        System.out.println("Ocena została zmieniona na: " + nocen);
        WyswietlInformacje();
    }

    public double ObliczSredniaOcen() {
        return ocena;
    }

    public void ZmienImie(String nimie) {
        this.imie = nimie;
        System.out.println("Imię zostało zmienione na: " + nimie);
    }

    public void ZmienNazwisko(String nnazw) {
        this.nazwisko = nnazw;
        System.out.println("Nazwisko zostało zmienione na: " + nnazw);
    }

    public boolean SprawdzZaliczenie() {
        return ocena >= 2.0;
    }

    public void UstawPlec(char nplec) {
        this.plec = nplec;
        System.out.println("Płeć została zmieniona na: " + nplec);
    }

    public static void WyswietlSredniaOcenaKierunku(String nkier) {
        double suma = 0;
        int licz = 0;
        for (STUDENT s : lista) {
            if (s.kierunek.equalsIgnoreCase(nkier)) {
                suma += s.ocena;
                licz++;
            }
        }
        if (licz > 0) {
            double sr = suma / licz;
            System.out.println("Średnia ocen dla kierunku " + nkier + " wynosi: " + sr);
        } else {
            System.out.println("Brak studentów na kierunku: " + nkier);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        STUDENT s1 = new STUDENT("Jacek", "Bryliński", 4.5, 'M', "Informatyka");
        STUDENT s2 = new STUDENT("Kasia", "Nowak", 3.0, 'K', "Informatyka");
        STUDENT s3 = new STUDENT("Bartek", "Kowalski", 5.0, 'M', "Mechanika");

        s1.ZmienOcene(5.0);
        s2.ZmienKierunek("Automatyka");
        s3.ZmienImie("Bartosz");

        System.out.println("Czy Jacek zaliczył? " + s1.SprawdzZaliczenie());
        STUDENT.WyswietlSredniaOcenaKierunku("Informatyka");
    }
}
