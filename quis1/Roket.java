class Roket {
    private String tipe;
    private int power;

    public Roket(String tipe, int power) {
        this.tipe = tipe;
        this.power = power;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getTipe() {
        return tipe;
    }

    public int getPower() {
        return power;
    }
}