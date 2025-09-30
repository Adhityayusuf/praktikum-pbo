public class Anggota {
    private String noAnggota;
    private String nama;
    private Transaksi transaksi;

    public Anggota(String noAnggota, String nama) {
        this.noAnggota = noAnggota;
        this.nama = nama;
    }

    public void setNoAnggota(String noAnggota) {
        this.noAnggota = noAnggota;
    }

    public String getNoAnggota() {
        return noAnggota;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getNama() {
        return nama;
    }

    public void setTransaksi(Transaksi transaksi) {
        this.transaksi = transaksi;
    }

    public Transaksi getTransaksi() {
        return transaksi;
    }

    public String info() {
        String info = "========================================\n";
        info += "INFORMASI ANGGOTA\n";
        info += "========================================\n";
        info += "No Anggota: " + noAnggota + "\n";
        info += "Nama: " + nama + "\n\n";
        if (transaksi != null) {
            info += "Detail Peminjaman:\n" + getTransaksi().info(); 
        } else {
            info += "Belum ada transaksi peminjaman.\n";
        }
        info += "========================================\n";
        return info;
    }
}