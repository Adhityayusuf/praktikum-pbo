package frontend;

import backend.*;

public class TestBackendAnggota {
    public static void main(String[] args) {
        // 1. Buat objek Anggota baru
        Anggota ang1 = new Anggota("Timur", "Jl. Surabaya 12", "0812345678");
        Anggota ang2 = new Anggota("Barat", "Jl. Jakarta 66", "0819876543");
        Anggota ang3 = new Anggota("Selatan", "Jl. Malang 99", "0856789123");

        // 2. Test Insert
        ang1.save();
        ang2.save();
        ang3.save();

        // 3. Test Update
        // Mengubah alamat anggota ke-2
        ang2.setAlamat("Jl. Bandung 100");
        ang2.save();

        // 4. Test Delete
        // Menghapus anggota ke-3
        ang3.delete();

        // 5. Test Select All
        System.out.println("--- Menampilkan Semua Data Anggota ---");
        for(Anggota a : new Anggota().getAll()) {
            System.out.println("Nama: " + a.getNama() + ", Alamat: " + a.getAlamat() + ", Telepon: " + a.getTelepon());
        }

        // 6. Test Search
        System.out.println("\n--- Pencarian Anggota (Keyword: 'Timur') ---");
        for(Anggota a : new Anggota().search("Timur")) {
            System.out.println("Nama: " + a.getNama() + ", Alamat: " + a.getAlamat() + ", Telepon: " + a.getTelepon());
        }
    }
}