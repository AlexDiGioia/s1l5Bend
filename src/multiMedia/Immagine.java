package multiMedia;

public class Immagine extends ElementoMultimediale {
    private int luminosita;

    public Immagine(String titolo, int luminosita) {
        super(titolo);
        this.luminosita = luminosita;
    }

    public int getLuminosita() {
        return luminosita;
    }

    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }

    public void aumentaLuminosita(int n) {
        setLuminosita(this.getLuminosita() + n);
    }

    public void diminuisciLuminosita(int n) {
        setLuminosita(this.getLuminosita() - n);
    }

    public void show() {
        String out = "Titolo: " + this.getTitolo() + ": " + "*".repeat(Math.max(0, this.getLuminosita()));
        System.out.println(out);
    }
}
