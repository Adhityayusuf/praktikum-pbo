public class TestTelevisi {
    public static void main(String[] args) {
        TelevisiModern tv = new TelevisiModern("Samsong", 100);
        
        System.out.println("Channel aktif: " + tv.getChannelAktif());
        tv.pindahChannel(20);
        System.out.println("Channel aktif sekarang: " + tv.getChannelAktif());

        tv.mainkanDVD();

        tv.masukkanDVD("The Matrix");
        tv.mainkanDVD();
    }
}