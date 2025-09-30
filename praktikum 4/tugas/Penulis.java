public class Penulis {
    private String nik;
    private String nama;

    public Penulis(String nik, String nama) {
        this.nik = nik;
        this.nama = nama;
    }

    public void setNik(String nik) {
        this.nik = nik;
    }

    public String getNik() {
        return nik;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public String info() {
        return "  NIK: " + nik + "\n  Nama: " + nama;
    }
}