public class Main {
    public static void main(String[] args) {
        Penulis penulis1 = new Penulis("111", "J.K. Rowling");
        Penulis penulis2 = new Penulis("222", "Tere Liye");

        Buku buku1 = new Buku("B001", "Harry Potter", penulis1);
        Buku buku2 = new Buku("B002", "Bumi", penulis2);
        Buku buku3 = new Buku("B003", "Bulan", penulis2);

        Anggota anggota1 = new Anggota("A01", "Budi Sanjaya");

        Transaksi trx1 = new Transaksi("TRX01", "25-09-2025", 5);
        trx1.addBuku(buku1);
        trx1.addBuku(buku2);
        trx1.addBuku(buku3);

        anggota1.setTransaksi(trx1);
        System.out.println(anggota1.info());
    }
}