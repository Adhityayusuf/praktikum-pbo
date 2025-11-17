public abstract class Zombie implements Destroyable {
    protected int health;
    protected int level;

    public abstract void heal();
    public abstract String getZombieInfo();
}