public class EncapDemo {
    private String name;
    private int age;

    public String getName() {
        return name;
    }
    public void setNama(String newName) {
        name = newName;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int newAge) {
        if (newAge > 30 || newAge < 18) {
            System.out.println("umur harus antara 18-30");
        } else {
            age = newAge;
        }
    }
}