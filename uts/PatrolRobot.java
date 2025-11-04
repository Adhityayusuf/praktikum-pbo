public class PatrolRobot extends Robot {
    public Battery robotBattery;
    public PatrolRobot(String name, int cpuspeed, int power, Battery battery) {
        this.Name = name; 
        this.CPUSpeed = cpuspeed;
        this.Power = power;
        this.robotBattery = battery;
    }
    public void increasePower() {
        this.Power += 20;
    }
}