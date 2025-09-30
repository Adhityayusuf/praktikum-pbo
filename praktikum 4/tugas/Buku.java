public class Buku {
    private String kodeBuku;
    private String judul;
    private Penulis penulis;

    public Buku(String kodeBuku, String judul, Penulis penulis) {
        this.kodeBuku = kodeBuku;
        this.judul = judul;
        this.penulis = penulis;
    }

    public void setKodeBuku(String kodeBuku) {
        this.kodeBuku = kodeBuku;
    }

    public String getKodeBuku() {
        return kodeBuku;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getJudul() {
        return judul;
    }

    public void setPenulis(Penulis penulis) {
        this.penulis = penulis;
    }

    public Penulis getPenulis() {
        return penulis;
    }

    public String info() {
        String info = "";
        info += "    Kode: " + kodeBuku + "\n";
        info += "    Judul: " + judul + "\n";
        info += "    Penulis: " + penulis.getNama() + "\n"; 
        return info;
    }
}