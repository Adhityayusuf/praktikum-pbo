/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package backend;

import java.util.ArrayList;
import java.sql.*;

/**
 *
 * @author M.Adhitya Yusuf
 */
public abstract class Kendaraan implements IPayable {
    protected int id;
    protected String merk;
    protected String nopol;
    protected double hargaPerHari;

    public abstract String getInfoSpesifik(); 
    
    // --- Implementation of Interface ---
    @Override
    public double hitungTotalBayar(int lamaSewa) {
        return this.hargaPerHari * lamaSewa;
    }
    
    // --- Getter and Setter ---
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public String getMerk() { return merk; }
    public void setMerk(String merk) { this.merk = merk; }
    public String getNopol() { return nopol; }
    public void setNopol(String nopol) { this.nopol = nopol; }
    public double getHargaPerHari() { return hargaPerHari; }
    public void setHargaPerHari(double hargaPerHari) { this.hargaPerHari = hargaPerHari; }

    // --- METHOD CRUD DATABASE ---

    public Kendaraan getById(int id) {
        Kendaraan k = null;
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM kendaraan WHERE id_kendaraan = '" + id + "'");
        try {
            if (rs.next()) {
                String jenis = rs.getString("jenis");
                
                // Polimorfisme: Instantiate child class berdasarkan data di DB
                if(jenis.equalsIgnoreCase("Mobil")){
                    k = new Mobil();
                } else {
                    k = new Motor();
                }
                
                k.setId(rs.getInt("id_kendaraan"));
                k.setMerk(rs.getString("merk"));
                k.setNopol(rs.getString("nopol"));
                k.setHargaPerHari(rs.getDouble("harga_per_hari"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return k;
    }

    public ArrayList<Kendaraan> getAll() {
        ArrayList<Kendaraan> ListKendaraan = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM kendaraan");
        try {
            while (rs.next()) {
                Kendaraan k;
                String jenis = rs.getString("jenis");
                
                // Polimorfisme
                if(jenis.equalsIgnoreCase("Mobil")){
                    k = new Mobil();
                } else {
                    k = new Motor();
                }
                
                k.setId(rs.getInt("id_kendaraan"));
                k.setMerk(rs.getString("merk"));
                k.setNopol(rs.getString("nopol"));
                k.setHargaPerHari(rs.getDouble("harga_per_hari"));
                
                ListKendaraan.add(k);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return ListKendaraan;
    }

    public void save() {
        // Tentukan jenis berdasarkan instance object saat ini
        String jenis = "";
        if(this instanceof Mobil){
            jenis = "Mobil";
        } else {
            jenis = "Motor";
        }

        if (getById(id) == null) { // Jika ID tidak ditemukan/baru -> INSERT
            String SQL = "INSERT INTO kendaraan (jenis, merk, nopol, harga_per_hari) VALUES("
                    + "'" + jenis + "', "
                    + "'" + this.merk + "', "
                    + "'" + this.nopol + "', "
                    + "'" + this.hargaPerHari + "')";
            this.id = DBHelper.insertQueryGetId(SQL);
        } else { // Jika ID sudah ada -> UPDATE
            String SQL = "UPDATE kendaraan SET "
                    + "jenis = '" + jenis + "', "
                    + "merk = '" + this.merk + "', "
                    + "nopol = '" + this.nopol + "', "
                    + "harga_per_hari = '" + this.hargaPerHari + "' "
                    + "WHERE id_kendaraan = '" + this.id + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM kendaraan WHERE id_kendaraan = '" + this.id + "'";
        DBHelper.executeQuery(SQL);
    }
}