package exercise1;

public class TV extends AudioDevice {
    @Override
    public void increaseVol() {
        super.increaseVol();
        System.out.println("TV has increased volume.");
    }

    @Override
    public void decreaseVol() {
        super.decreaseVol();
        System.out.println("TV has decreased volume.");
    }
}
