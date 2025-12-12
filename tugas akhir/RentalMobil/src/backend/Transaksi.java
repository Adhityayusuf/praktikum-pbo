/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

/**
 *
 * @author M.Adhitya Yusuf
 */
import java.util.ArrayList;
import java.sql.*;

public class Transaksi {
    private int idTransaksi;
    private Pelanggan pelanggan = new Pelanggan();
    private Kendaraan kendaraan; // Polimorfisme (bisa Mobil/Motor)
    private String tanggalSewa;
    private int lamaSewa;
    private double totalBayar;

    // Konstruktor kosong
    public Transaksi() {
    }

    // Konstruktor lengkap
    public Transaksi(Pelanggan pelanggan, Kendaraan kendaraan, String tanggalSewa, int lamaSewa, double totalBayar) {
        this.pelanggan = pelanggan;
        this.kendaraan = kendaraan;
        this.tanggalSewa = tanggalSewa;
        this.lamaSewa = lamaSewa;
        this.totalBayar = totalBayar;
    }

    // Getter Setter (Penting untuk akses data)
    public int getIdTransaksi() { return idTransaksi; }
    public void setIdTransaksi(int idTransaksi) { this.idTransaksi = idTransaksi; }
    public Pelanggan getPelanggan() { return pelanggan; }
    public void setPelanggan(Pelanggan pelanggan) { this.pelanggan = pelanggan; }
    public Kendaraan getKendaraan() { return kendaraan; }
    public void setKendaraan(Kendaraan kendaraan) { this.kendaraan = kendaraan; }
    public String getTanggalSewa() { return tanggalSewa; }
    public void setTanggalSewa(String tanggalSewa) { this.tanggalSewa = tanggalSewa; }
    public int getLamaSewa() { return lamaSewa; }
    public void setLamaSewa(int lamaSewa) { this.lamaSewa = lamaSewa; }
    public double getTotalBayar() { return totalBayar; }
    public void setTotalBayar(double totalBayar) { this.totalBayar = totalBayar; }

    // --- METHOD UTAMA ---

    public ArrayList<Transaksi> getAll() {
        ArrayList<Transaksi> ListTransaksi = new ArrayList<>();
        String sql = "SELECT t.*, p.nama AS nama_pel, k.jenis, k.merk, k.nopol " +
                     "FROM transaksi t " +
                     "JOIN pelanggan p ON t.id_pelanggan = p.id_pelanggan " +
                     "JOIN kendaraan k ON t.id_kendaraan = k.id_kendaraan";
        ResultSet rs = DBHelper.selectQuery(sql);
        try {
            while (rs.next()) {
                Transaksi t = new Transaksi();
                t.setIdTransaksi(rs.getInt("id_transaksi"));
                
                t.getPelanggan().setIdPelanggan(rs.getInt("id_pelanggan"));
                t.getPelanggan().setNama(rs.getString("nama_pel"));
                
                // Polimorfisme untuk Kendaraan
                String jenis = rs.getString("jenis");
                if (jenis.equalsIgnoreCase("Mobil")) {
                    t.setKendaraan(new Mobil());
                } else {
                    t.setKendaraan(new Motor());
                }
                t.getKendaraan().setId(rs.getInt("id_kendaraan"));
                t.getKendaraan().setMerk(rs.getString("merk"));
                t.getKendaraan().setNopol(rs.getString("nopol"));
                
                t.setTanggalSewa(rs.getString("tanggal_sewa"));
                t.setLamaSewa(rs.getInt("lama_sewa"));
                t.setTotalBayar(rs.getDouble("total_bayar"));
                
                ListTransaksi.add(t);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return ListTransaksi;
    }

    public void save() {
        // 1. Simpan Transaksi Baru
        String sql = "INSERT INTO transaksi (id_pelanggan, id_kendaraan, tanggal_sewa, lama_sewa, total_bayar) VALUES("
                + "'" + this.getPelanggan().getIdPelanggan() + "', "
                + "'" + this.getKendaraan().getId() + "', "
                + "'" + this.tanggalSewa + "', "
                + "'" + this.lamaSewa + "', "
                + "'" + this.totalBayar + "')";
        this.idTransaksi = DBHelper.insertQueryGetId(sql);
        
        // 2. UPDATE STATUS Kendaraan menjadi 'Keluar'
        String sqlUpdate = "UPDATE kendaraan SET status = 'Keluar' WHERE id_kendaraan = '" + this.getKendaraan().getId() + "'";
        DBHelper.executeQuery(sqlUpdate);
    }

    public void delete() {
        // LOGIKA HAPUS:
        // Sebelum menghapus transaksi, kita harus tahu dulu ID kendaraan yang disewa
        // agar statusnya bisa dikembalikan.
        
        // 1. Ambil ID Kendaraan dari database berdasarkan ID Transaksi ini
        String sqlGetId = "SELECT id_kendaraan FROM transaksi WHERE id_transaksi = '" + this.idTransaksi + "'";
        ResultSet rs = DBHelper.selectQuery(sqlGetId);
        int idKendaraan = 0;
        try {
            if(rs.next()){
                idKendaraan = rs.getInt("id_kendaraan");
            }
        } catch(Exception e){}

        // 2. Hapus Data Transaksi
        String sqlDelete = "DELETE FROM transaksi WHERE id_transaksi = '" + this.idTransaksi + "'";
        DBHelper.executeQuery(sqlDelete);
        
        // 3. KEMBALIKAN STATUS Kendaraan menjadi 'Tersedia'
        if(idKendaraan != 0){
            String sqlUpdate = "UPDATE kendaraan SET status = 'Tersedia' WHERE id_kendaraan = '" + idKendaraan + "'";
            DBHelper.executeQuery(sqlUpdate);
        }
    }
}