package exercise1;

public class AudioDevice implements ElectricalDevice {
    public void increaseVol() {
        System.out.println("The device has increased volume.");
    }

    public void decreaseVol() {
        System.out.println("The device has decreased volume.");
    }

    @Override
    public void turnOn() {
        System.out.println("The device has turned on.");
    }

    @Override
    public void turnOff() {
        System.out.println("The device has turned off.");
    }
}
