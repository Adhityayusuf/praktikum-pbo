public class GatotKaca extends Hero {
    public int speed;

    public GatotKaca(String nama, int speed) {
        this.nama = nama;
        this.speed = speed;
    }

    @Override
    public void serang(KillAble ka) {
        ka.dead();
        System.out.println(" Oleh " + this.nama);
    }
}