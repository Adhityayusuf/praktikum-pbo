public class Main {
    public static void main(String[] args) {
        GatotKaca g = new GatotKaca("Gatots", 99);
        CaptainIndonesia ci = new CaptainIndonesia("Caps", 77);

        g.serang(new Evil());
        ci.serang(new Evil());
        ci.serang(new Villain());
    }
}