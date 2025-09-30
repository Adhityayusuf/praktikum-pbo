public class Processor {
    private String merk;
    private double canche;
    public Processor() {
    }
    public Processor(String merk, double canche) {
        this.merk = merk;
        this.canche = canche;
    }
    public void setMerk(String merk){
        this.merk = merk;
    }
    public String getMerk(){
        return merk;
    }
    public void setCanche(double canche){
        this.canche = canche;
    }
    public double getCanche(){
        return canche;
    }
    public void info(){
        System.out.printf("Merk Processor = %s\n", merk);
        System.out.printf("Canche Memory = %.2f\n", canche);
    }
}