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
            System.out.println("4. Riproduci un elemento");
            System.out.println("5. Exit");

            int scelta = scanner.nextInt();
            scanner.nextLine();

            switch (scelta) {
                case 1:
                    for (int i = 0; i < 5; i++) {
                        System.out.println("Scegli il tipo di elemento (1.Immagine 2.Registrazione Audio 3.Video):");
                        int tipo = scanner.nextInt();
                        scanner.nextLine();

                        System.out.println("Inserisci il titolo:");
                        String titolo = scanner.nextLine();

                        switch (tipo) {
                            case 1:
                                int luminosita;
                                do {
                                    System.out.println("Inserisci la luminosità, da 1 a 10:");
                                    luminosita = scanner.nextInt();
                                } while (luminosita < 1 || luminosita > 10);
                                elementi[i] = new Immagine(titolo, luminosita);
                                break;
                            case 2:
                                int volume;
                                int durata;
                                do {
                                    System.out.println("Inserisci il volume, da 1 a 10:");
                                    volume = scanner.nextInt();
                                } while (volume < 1 || volume > 10);
                                do {
                                    System.out.println("Inserisci la durata, da 1 a 10:");
                                    durata = scanner.nextInt();
                                } while (durata < 1 || durata > 10);
                                elementi[i] = new RegistrazioneAudio(titolo, volume, durata);
                                break;
                            case 3:
                                int vol, lum, dur;
                                do {
                                    System.out.println("Inserisci il volume, da 1 a 10:");
                                    vol = scanner.nextInt();
                                } while (vol < 1 || vol > 10);
                                do {
                                    System.out.println("Inserisci la luminosità, da 1 a 10:");
                                    lum = scanner.nextInt();
                                } while (lum < 1 || lum > 10);
                                do {
                                    System.out.println("Inserisci la durata:");
                                    dur = scanner.nextInt();
                                } while (dur < 1 || dur > 10);
                                elementi[i] = new Video(titolo, vol, lum, dur);
                                break;
                            default:
                                System.out.println("Tipo di elemento non valido.");
                                i--;
                                break;
                        }
                    }
                    break;

                case 2:
                    System.out.println("Scegli l'elemento, da 1 a 5:");
                    int indiceVolume = scanner.nextInt() - 1;
                    scanner.nextLine();  // Consume newline
                    if (indiceVolume >= 0 && indiceVolume < 5) {
                        ElementoMultimediale elementoVolume = elementi[indiceVolume];
                        switch (elementoVolume.getClass().getSimpleName()) {
                            case "RegistrazioneAudio":
                            case "Video":
                                System.out.println("1. Alza volume 2. Abbassa volume:");
                                int volumeScelta = scanner.nextInt();
                                do {
                                    System.out.println("Inserisci il valore:");
                                    int valore = scanner.nextInt();
                                    int volumeCorrente = 0;
                                    int nuovoVolume = 0;

                                    if (elementoVolume instanceof RegistrazioneAudio registrazione) {
                                        volumeCorrente = registrazione.getVolume();
                                        nuovoVolume = volumeScelta == 1 ? volumeCorrente + valore : volumeCorrente - valore;
                                    } else if (elementoVolume instanceof Video video) {
                                        volumeCorrente = video.getVolume();
                                        nuovoVolume = volumeScelta == 1 ? volumeCorrente + valore : volumeCorrente - valore;
                                    }

                                    if (nuovoVolume > 10 || nuovoVolume < 1) {
                                        System.out.println("Volume fuori dai limiti (1-10). Reinserisci il valore.");
                                    } else {
                                        System.out.println("Volume attuale: " + volumeCorrente);
                                        if (elementoVolume instanceof RegistrazioneAudio registrazione) {
                                            if (volumeScelta == 1) {
                                                registrazione.alzaVolume(valore);
                                            } else if (volumeScelta == 2) {
                                                registrazione.abbassaVolume(valore);
                                            }
                                            System.out.println("Nuovo volume: " + registrazione.getVolume());
                                        } else if (elementoVolume instanceof Video video) {
                                            if (volumeScelta == 1) {
                                                video.alzaVolume(valore);
                                            } else if (volumeScelta == 2) {
                                                video.abbassaVolume(valore);
                                            }
                                            System.out.println("Nuovo volume: " + video.getVolume());
                                        }
                                        break;
                                    }
                                } while (true);
                                break;
                            default:
                                System.out.println("L'elemento scelto non supporta la regolazione del volume.");
                                break;
                        }
                    } else {
                        System.out.println("Indice non valido. Inserisci un numero da 1 a 5.");
                    }
                    break;

                case 3:
                    System.out.println("Scegli l'elemento, da 1 a 5:");
                    int indiceLuminosita = scanner.nextInt() - 1;
                    scanner.nextLine();  // Consume newline
                    if (indiceLuminosita >= 0 && indiceLuminosita < 5) {
                        ElementoMultimediale elementoLuminosita = elementi[indiceLuminosita];
                        switch (elementoLuminosita.getClass().getSimpleName()) {
                            case "Immagine":
                            case "Video":
                                System.out.println("1. Alza luminosità 2. Abbassa luminosità:");
                                int luminositaScelta = scanner.nextInt();
                                do {
                                    System.out.println("Inserisci il valore:");
                                    int valore = scanner.nextInt();
                                    int luminositaCorrente = 0;
                                    int nuovaLuminosita = 0;

                                    if (elementoLuminosita instanceof Immagine immagine) {
                                        luminositaCorrente = immagine.getLuminosita();
                                        nuovaLuminosita = luminositaScelta == 1 ? luminositaCorrente + valore : luminositaCorrente - valore;
                                    } else if (elementoLuminosita instanceof Video video) {
                                        luminositaCorrente = video.getLuminosita();
                                        nuovaLuminosita = luminositaScelta == 1 ? luminositaCorrente + valore : luminositaCorrente - valore;
                                    }

                                    if (nuovaLuminosita > 10 || nuovaLuminosita < 1) {
                                        System.out.println("Luminosità fuori dai limiti (1-10). Reinserisci il valore.");
                                    } else {
                                        System.out.println("Luminosità attuale: " + luminositaCorrente);
                                        if (elementoLuminosita instanceof Immagine immagine) {
                                            if (luminositaScelta == 1) {
                                                immagine.aumentaLuminosita(valore);
                                            } else if (luminositaScelta == 2) {
                                                immagine.diminuisciLuminosita(valore);
                                            }
                                            System.out.println("Nuova luminosità: " + immagine.getLuminosita());
                                        } else if (elementoLuminosita instanceof Video video) {
                                            if (luminositaScelta == 1) {
                                                video.aumentaLuminosita(valore);
                                            } else if (luminositaScelta == 2) {
                                                video.diminuisciLuminosita(valore);
                                            }
                                            System.out.println("Nuova luminosità: " + video.getLuminosita());
                                        }
                                        break;
                                    }
                                } while (true);
                                break;
                            default:
                                System.out.println("L'elemento scelto non supporta la regolazione della luminosità.");
                                break;
                        }
                    } else {
                        System.out.println("Indice non valido. Inserisci un numero da 1 a 5.");
                    }
                    break;

                case 4:
                    System.out.println("Scegli l'elemento, da 1 a 5:");
                    int indiceRiproduci = scanner.nextInt() - 1;
                    scanner.nextLine();  // Consume newline
                    if (indiceRiproduci >= 0 && indiceRiproduci < 5) {
                        ElementoMultimediale elementoRiproduci = elementi[indiceRiproduci];
                        switch (elementoRiproduci.getClass().getSimpleName()) {
                            case "Video":
                                ((Video) elementoRiproduci).play();
                                break;
                            case "RegistrazioneAudio":
                                ((RegistrazioneAudio) elementoRiproduci).play();
                                break;
                            case "Immagine":
                                ((Immagine) elementoRiproduci).show();
                                break;
                            default:
                                System.out.println("Tipo di elemento non supportato.");
                                break;
                        }
                    } else {
                        System.out.println("Indice non valido. Inserisci un numero da 1 a 5.");
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
