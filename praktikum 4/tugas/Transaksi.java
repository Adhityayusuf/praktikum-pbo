public class Transaksi {
    private String kodeTransaksi;
    private String tglPinjam;
    private Buku[] daftarBuku;
    private int jumlahBuku;

    public Transaksi(String kodeTransaksi, String tglPinjam, int maksBuku) {
        this.kodeTransaksi = kodeTransaksi;
        this.tglPinjam = tglPinjam;
        this.daftarBuku = new Buku[maksBuku];
        this.jumlahBuku = 0;
    }

    public void addBuku(Buku buku) {
        if (jumlahBuku < daftarBuku.length) {
            daftarBuku[jumlahBuku] = buku;
            jumlahBuku++;
        } else {
            System.out.println("Kapasitas peminjaman sudah penuh.");
        }
    }

    public String getKodeTransaksi() {
        return kodeTransaksi;
    }

    public String getTglPinjam() {
        return tglPinjam;
    }
    
    public int getJumlahBuku() {
        return jumlahBuku;
    }
    
    public Buku[] getDaftarBuku() {
        return daftarBuku;
    }

    public String info() {
        String info = "";
        info += "  Kode Transaksi: " + kodeTransaksi + "\n";
        info += "  Tgl Pinjam: " + tglPinjam + "\n";
        info += "  Daftar Buku Dipinjam:\n";
        for (int i = 0; i < jumlahBuku; i++) {
            info += daftarBuku[i].info();
        }
        return info;
    }
}