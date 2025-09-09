public class TestPerbankan 
{
    public static void main(String[] args) {
        Nasaba nsb1 = new Nasaba();
        Nasaba nsb2 = new Nasaba();

        nsb1.nama = "Bill gates";
        nsb1.saldo = 1000;

        nsb2.nama = "Ridwan Rismanto";
        nsb2.saldo = 9999;

        nsb1.tampilkansaldo("IDR");
        nsb2.tampilkansaldo("IDR");
    }
}