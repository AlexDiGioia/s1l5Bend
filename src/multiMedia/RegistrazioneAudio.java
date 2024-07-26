package multiMedia;

import multiMedia.interfacce.ConSuono;
import multiMedia.interfacce.Riproducibile;

public class RegistrazioneAudio extends ElementoMultimediale implements Riproducibile, ConSuono {
    private int volume;
    private int durata;

    public RegistrazioneAudio(String titolo, int volume, int durata) {
        super(titolo);
        this.volume = volume;
        this.durata = durata;
    }

    public int getVolume() {
        return volume;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void abbassaVolume(int n) {
        setVolume(this.getVolume() - n);
    }

    public void alzaVolume(int n) {
        setVolume(this.getVolume() + n);
    }

    @Override
    public int getDurata() {
        return durata;
    }

    @Override
    public void setDurata(int durata) {
        this.durata = durata;
    }

    public void play() {
        StringBuilder out = new StringBuilder();
        out.append("Titolo: ");
        for (int i = 0; i < this.getDurata(); i++) {
            out.append(i).append(": ").append(this.getTitolo()).append(" ");
        }
        out.append("!".repeat(Math.max(0, this.getVolume())));
        System.out.println(out);
    }
}
