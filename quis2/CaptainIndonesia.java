public class CaptainIndonesia extends Hero {
    public int level;

    public CaptainIndonesia(String nama, int level) {
        this.nama = nama;
        this.level = level;
    }

    @Override
    public void serang(KillAble ka) {
        ka.dead();
        System.out.println(" Oleh " + this.nama);
    }
}