package exercise1;

public class Radio extends AudioDevice {
    @Override
    public void increaseVol() {
        super.increaseVol();
        System.out.println("Radio has increased volume.");
    }

    @Override
    public void decreaseVol() {
        super.decreaseVol();
        System.out.println("Radio has decreased volume.");
    }
}
