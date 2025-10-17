public class DaftarGaji {
    public Pegawai[] listPegawai;
    private int jumlahPegawai = 0;

    public DaftarGaji(int jumlah) {
        listPegawai = new Pegawai[jumlah];
    }

    public void addPegawai(Pegawai pegawai) {
        if (jumlahPegawai < listPegawai.length) {
            listPegawai[jumlahPegawai] = pegawai;
            jumlahPegawai++;
        } else {
            System.out.println("Kapasitas daftar gaji sudah penuh.");
        }
    }

    public void printSemuaGaji() {
        System.out.println("===============================");
        System.out.println("     Daftar Gaji Pegawai");
        System.out.println("===============================");
        for (int i = 0; i < jumlahPegawai; i++) {
            System.out.println("Nama   : " + listPegawai[i].getNama());
            System.out.println("Gaji   : Rp " + listPegawai[i].getGaji());
            System.out.println("-------------------------------");
        }
    }
}