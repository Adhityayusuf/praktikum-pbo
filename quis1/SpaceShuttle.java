class SpaceShuttle {
    private String kode;
    private int berat;
    private Roket roketUtama;
    private Generator generatorUtama;

    public SpaceShuttle(String kode, int berat, Roket roketUtama, Generator generatorUtama) {
        this.kode = kode;
        this.berat = berat;
        this.roketUtama = roketUtama;
        this.generatorUtama = generatorUtama;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public void setBerat(int berat) {
        this.berat = berat;
    }

    public void setRoketUtama(Roket roketUtama) {
        this.roketUtama = roketUtama;
    }

    public void setGeneratorUtama(Generator generatorUtama) {
        this.generatorUtama = generatorUtama;
    }

    public String getKode() {
        return kode;
    }

    public int getBerat() {
        return berat;
    }

    public Roket getRoketUtama() {
        return roketUtama;
    }

    public Generator getGeneratorUtama() {
        return generatorUtama;
    }
}