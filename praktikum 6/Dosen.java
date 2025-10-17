public class Dosen extends Pegawai {
    public int jumlahSKS;
    public int TARIF_SKS = 120000;
    public Dosen(String nip, String nama, String alamat) {
        super(nip, nama, alamat);
    }
    public void setSKS(int jumlahSKS) {
        this.jumlahSKS = jumlahSKS;
    }
    public int getGaji() {
        return super.getGaji() + (this.jumlahSKS * this.TARIF_SKS);
    }
}