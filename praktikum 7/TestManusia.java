public class TestManusia {
    public static void main(String[] args) {
        Manusia m1, m2, m3;

        m1 = new Manusia();
        m2 = new Dosen();
        m3 = new Mahasiswa();;

        System.out.println("\n--- Memanggil bernafas() ---");
        m1.bernafas();
        m2.bernafas();
        m3.bernafas();

        System.out.println("\n--- Memanggil makan() ---");
        m1.makan();
        m2.makan();
        m3.makan();
    }
}