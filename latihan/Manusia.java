public class Manusia {
    public void MakanBuah(Buah x) {
        if (x instanceof Apel) {
            System.out.println("Apel langsung dimakan");
            ((Apel) x).TampilkanBiji();
        }
        else if (x instanceof Pisang) {
            System.out.println("Pisang dikupas dulu kulitnya");
            ((Pisang) x).TampilkanKulit();
        }
        else if (x instanceof Durian) {
            System.out.println("Durian dibelah dulu kulitnya");
            ((Durian) x).TampilkanKulit();
        }
        System.out.println("Rasanya " + x.Rasa);
    }
}