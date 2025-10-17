public class TelevisiModern extends Televisi {
    private String modusTampilan;
    private String dvd;

    public TelevisiModern(String mrk, int jmlChannel) {
        super();
        this.merek = mrk;
        this.jumlahChannel = jmlChannel;
        this.modusTampilan = "TV";
        this.dvd = "kosong";
    }

    public void gantiModusTampilan(String modus) {
        this.modusTampilan = modus;
    }

    public void mainkanDVD() {
        System.out.println("Sedang memainkan DVD: " + this.dvd);
    }

    public void masukkanDVD(String judulDVD) {
        this.dvd = judulDVD;
    }
}
