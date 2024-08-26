import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Bitte geben Sie die Zeichenkette ein (z.B. derArtikel[Notebook]wurdebestelltvon[Max Mustermann]):");
        String eingabe = scanner.nextLine();

        String artikel = extrahiereZwischenKlammern(eingabe, "derArtikel[", "]");
        String besteller = extrahiereZwischenKlammern(eingabe, "wurdebestelltvon[", "]");

        if (artikel != null && besteller != null) {
            System.out.println("Artikelbezeichnung: " + artikel);
            System.out.println("Besteller: " + besteller);
        } else {
            System.out.println("Fehler: Die Eingabe konnte nicht verarbeitet werden.");
        }
    }

    // Methode zur Extraktion eines Strings zwischen zwei spezifischen Markierungen
    public static String extrahiereZwischenKlammern(String text, String startMarker, String endMarker) {
        int start = text.indexOf(startMarker);
        int end = text.indexOf(endMarker, start + startMarker.length());

        // Überprüfen, ob die Markierungen gefunden wurden und sicherstellen, dass die Indizes gültig sind
        if (start == -1 || end == -1 || end <= start + startMarker.length()) {
            return null;
        }

        // Entfernen von führenden und nachfolgenden Leerzeichen im extrahierten Text
        return text.substring(start + startMarker.length(), end).trim();
    }
}
