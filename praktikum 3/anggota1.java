public class anggota1 {
    private String noKTP;
    private String nama;
    private int limitPinjaman;
    private int jumlahPinjaman;
    public anggota1(String noKTP, String nama, int limitPinjaman) {
        this.noKTP = noKTP;
        this.nama = nama;
        this.limitPinjaman = limitPinjaman;
        this.jumlahPinjaman = 0;
    }
    public String getNoKTP() {
        return noKTP;
    }
    public String getNama() {
        return nama;
    }
    public int getLimitPinjaman() {
        return limitPinjaman;
    }
    public int getJumlahPinjaman() {
        return jumlahPinjaman;
    }
    public void pinjam(int uang) {
        if (jumlahPinjaman + uang > limitPinjaman) {
            System.out.println("Maaf, jumlah pinjaman melebihi limit.");
        } else {
            jumlahPinjaman += uang;
        }
    }
    public void angsur(int uang) {
        if (jumlahPinjaman == 0) {
            System.out.println("Tidak ada pinjaman yang perlu diangsur.");
        } else {
            int minimalAngsuran = (int)(jumlahPinjaman * 0.1);
            if (uang < minimalAngsuran) {
                System.out.println("Maaf, angsuran harus 10% dari jumlah pinjaman.");
            } else {
                jumlahPinjaman -= uang;
                if (jumlahPinjaman < 0) {
                    jumlahPinjaman = 0;
                }
            }
        }
    }
}