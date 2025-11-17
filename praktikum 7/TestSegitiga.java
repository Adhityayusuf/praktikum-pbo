public class TestSegitiga {
    public static void main(String[] args) {
        Segitiga sgt = new Segitiga();

        System.out.println("--- Testing Overloading totalSudut ---");
        System.out.println("Total sudut (1 param): " + sgt.totalSudut(60));
        System.out.println("Total sudut (2 param): " + sgt.totalSudut(60, 30));

        System.out.println("\n--- Testing Overloading keliling ---");
        System.out.println("Keliling (3 param): " + sgt.keliling(10, 10, 10));
        System.out.println("Keliling (2 param/siku-siku): " + sgt.keliling(3, 4));
    }
}