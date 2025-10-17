public class MainTugas {
    public static void main(String[] args) {
        DaftarGaji daftar = new DaftarGaji(3);

        Pegawai pegawai1 = new Pegawai("111", "Budi", "Jl. Mawar No. 1");
        Dosen dosen1 = new Dosen("222", "Siti", "Jl. Melati No. 2");
        dosen1.setSKS(8);

        Pegawai pegawai2 = new Pegawai("333", "Joko", "Jl. Anggrek No. 3");

        daftar.addPegawai(pegawai1);
        daftar.addPegawai(dosen1);
        daftar.addPegawai(pegawai2);

        daftar.printSemuaGaji();
    }
}