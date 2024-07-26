package multiMedia;

import multiMedia.interfacce.Riproducibile;

public class Video extends ElementoMultimediale implements Riproducibile {
    private int volume;
    private int luminosita;
    private int durata;

    public Video(String titolo, int volume, int luminosita, int durata) {
        super(titolo);
        this.volume = volume;
        this.luminosita = luminosita;
        this.durata = durata;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public int getLuminosita() {
        return luminosita;
    }

    public void setLuminosita(int luminosita) {
        this.luminosita = luminosita;
    }

    @Override
    public int getDurata() {
        return durata;
    }

    @Override
    public void setDurata(int durata) {
        this.durata = durata;
    }

    public void abbassaVolume(int n) {
        setVolume(this.getVolume() - n);
    }

    public void alzaVolume(int n) {
        setVolume(this.getVolume() + n);
    }

    public void aumentaLuminosita(int n) {
        setLuminosita(this.getLuminosita() + n);
    }

    public void diminuisciLuminosita(int n) {
        setLuminosita(this.getLuminosita() - n);
    }

    public void play() {
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < this.getDurata(); i++) {
            out.append(i).append(": ").append(this.getTitolo()).append(" ");
        }
        out.append("!".repeat(Math.max(0, this.getVolume())));
        out.append(" ");
        out.append("*".repeat(Math.max(0, this.getLuminosita())));
        System.out.println(out);
    }
}
