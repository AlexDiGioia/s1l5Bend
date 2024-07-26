import multiMedia.ElementoMultimediale;
import multiMedia.Immagine;
import multiMedia.RegistrazioneAudio;
import multiMedia.Video;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ElementoMultimediale[] elementi = new ElementoMultimediale[5];
        boolean exit = false;

        while (!exit) {
            System.out.println("Scegli un'opzione:");
            System.out.println("1. Crea 5 elementi multimediali");
            System.out.println("2. Alza o abbassa il volume di un elemento");
            System.out.println("3. Alza o abbassa la luminosità di un elemento");
            System.out.println("4. Riproduci gli elementi");
            System.out.println("5. Exit");

            int scelta = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (scelta) {
                case 1:
                    for (int i = 0; i < 5; i++) {
                        System.out.println("Scegli il tipo di elemento (1.Immagine 2.Registrazione Audio 3.Video):");
                        int tipo = scanner.nextInt();
                        scanner.nextLine();  // Consume newline

                        System.out.println("Inserisci il titolo:");
                        String titolo = scanner.nextLine();

                        if (tipo == 1) {
                            System.out.println("Inserisci la luminosità:");
                            int luminosita = scanner.nextInt();
                            elementi[i] = new Immagine(titolo, luminosita);
                        } else if (tipo == 2) {
                            System.out.println("Inserisci il volume:");
                            int volume = scanner.nextInt();
                            System.out.println("Inserisci la durata:");
                            int durata = scanner.nextInt();
                            elementi[i] = new RegistrazioneAudio(titolo, volume, durata);
                        } else if (tipo == 3) {
                            System.out.println("Inserisci il volume:");
                            int volume = scanner.nextInt();
                            System.out.println("Inserisci la luminosità:");
                            int luminosita = scanner.nextInt();
                            System.out.println("Inserisci la durata:");
                            int durata = scanner.nextInt();
                            elementi[i] = new Video(titolo, volume, luminosita, durata);
                        }
                    }
                    break;

                case 2:
                    System.out.println("Scegli l'indice dell'elemento (0-4):");
                    int indiceVolume = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    if (elementi[indiceVolume] instanceof RegistrazioneAudio || elementi[indiceVolume] instanceof Video) {
                        System.out.println("1. Alza volume 2. Abbassa volume:");
                        int volumeScelta = scanner.nextInt();
                        System.out.println("Inserisci il valore:");
                        int valore = scanner.nextInt();
                        if (volumeScelta == 1) {
                            if (elementi[indiceVolume] instanceof RegistrazioneAudio) {
                                ((RegistrazioneAudio) elementi[indiceVolume]).alzaVolume(valore);
                            } else {
                                ((Video) elementi[indiceVolume]).alzaVolume(valore);
                            }
                        } else if (volumeScelta == 2) {
                            if (elementi[indiceVolume] instanceof RegistrazioneAudio) {
                                ((RegistrazioneAudio) elementi[indiceVolume]).abbassaVolume(valore);
                            } else {
                                ((Video) elementi[indiceVolume]).abbassaVolume(valore);
                            }
                        }
                    } else {
                        System.out.println("L'elemento scelto non supporta la regolazione del volume.");
                    }
                    break;

                case 3:
                    System.out.println("Scegli l'indice dell'elemento (0-4):");
                    int indiceLuminosita = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    if (elementi[indiceLuminosita] instanceof Immagine || elementi[indiceLuminosita] instanceof Video) {
                        System.out.println("1. Alza luminosità 2. Abbassa luminosità:");
                        int luminositaScelta = scanner.nextInt();
                        System.out.println("Inserisci il valore:");
                        int valore = scanner.nextInt();
                        if (luminositaScelta == 1) {
                            if (elementi[indiceLuminosita] instanceof Immagine) {
                                ((Immagine) elementi[indiceLuminosita]).aumentaLuminosita(valore);
                            } else {
                                ((Video) elementi[indiceLuminosita]).aumentaLuminosita(valore);
                            }
                        } else if (luminositaScelta == 2) {
                            if (elementi[indiceLuminosita] instanceof Immagine) {
                                ((Immagine) elementi[indiceLuminosita]).diminuisciLuminosita(valore);
                            } else {
                                ((Video) elementi[indiceLuminosita]).diminuisciLuminosita(valore);
                            }
                        }
                    } else {
                        System.out.println("L'elemento scelto non supporta la regolazione della luminosità.");
                    }
                    break;

                case 4:
                    for (ElementoMultimediale elemento : elementi) {
                        if (elemento instanceof Video) {
                            ((Video) elemento).play();
                        } else if (elemento instanceof RegistrazioneAudio) {
                            ((RegistrazioneAudio) elemento).play();
                        } else if (elemento instanceof Immagine) {
                            ((Immagine) elemento).show();
                        }
                    }
                    break;

                case 5:
                    exit = true;
                    break;

                default:
                    System.out.println("Opzione non valida. Riprova.");
                    break;
            }
        }

        scanner.close();
    }
}
