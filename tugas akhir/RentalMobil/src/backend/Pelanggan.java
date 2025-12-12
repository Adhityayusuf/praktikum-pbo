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
public class Pelanggan {
    private int idPelanggan;
    private String nama;
    private String nik;
    private String noTelp;

    public Pelanggan() {
    }

    public Pelanggan(String nama, String nik, String noTelp) {
        this.nama = nama;
        this.nik = nik;
        this.noTelp = noTelp;
    }

    public int getIdPelanggan() { return idPelanggan; }
    public void setIdPelanggan(int idPelanggan) { this.idPelanggan = idPelanggan; }
    public String getNama() { return nama; }
    public void setNama(String nama) { this.nama = nama; }
    public String getNik() { return nik; }
    public void setNik(String nik) { this.nik = nik; }
    public String getNoTelp() { return noTelp; }
    public void setNoTelp(String noTelp) { this.noTelp = noTelp; }

    public Pelanggan getById(int id) {
        Pelanggan p = new Pelanggan();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pelanggan WHERE id_pelanggan = '" + id + "'");
        try {
            while (rs.next()) {
                p.setIdPelanggan(rs.getInt("id_pelanggan"));
                p.setNama(rs.getString("nama"));
                p.setNik(rs.getString("nik"));
                p.setNoTelp(rs.getString("no_telp"));
            }
        } catch (Exception e) { e.printStackTrace(); }
        return p;
    }

    public ArrayList<Pelanggan> getAll() {
        ArrayList<Pelanggan> ListPelanggan = new ArrayList<>();
        ResultSet rs = DBHelper.selectQuery("SELECT * FROM pelanggan");
        try {
            while (rs.next()) {
                Pelanggan p = new Pelanggan();
                p.setIdPelanggan(rs.getInt("id_pelanggan"));
                p.setNama(rs.getString("nama"));
                p.setNik(rs.getString("nik"));
                p.setNoTelp(rs.getString("no_telp"));
                ListPelanggan.add(p);
            }
        } catch (Exception e) { e.printStackTrace(); }
        return ListPelanggan;
    }

    public void save() {
        if (getById(idPelanggan).getIdPelanggan() == 0) {
            String SQL = "INSERT INTO pelanggan (nama, nik, no_telp) VALUES("
                    + "'" + this.nama + "', "
                    + "'" + this.nik + "', "
                    + "'" + this.noTelp + "')";
            this.idPelanggan = DBHelper.insertQueryGetId(SQL);
        } else {
            String SQL = "UPDATE pelanggan SET "
                    + "nama = '" + this.nama + "', "
                    + "nik = '" + this.nik + "', "
                    + "no_telp = '" + this.noTelp + "' "
                    + "WHERE id_pelanggan = '" + this.idPelanggan + "'";
            DBHelper.executeQuery(SQL);
        }
    }

    public void delete() {
        String SQL = "DELETE FROM pelanggan WHERE id_pelanggan = '" + this.idPelanggan + "'";
        DBHelper.executeQuery(SQL);
    }
}
