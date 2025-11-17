public class MainBinatang {
    public static void main(String[] args) {
        Keledai kedelai = new Keledai("Kedelai", 4, "Hehehehe", "Abu-Abu");
        Gorilla gorilla = new Gorilla("Gulali", 4, "Haaum Hauum", "Hitam Manis");
        Singa singa = new Singa("CingaCing", 4, "Roaar Roaaar", "Coklat");

        kedelai.displayData();
        System.out.println();

        gorilla.displayData();
        System.out.println();

        singa.displayData();
    }
}