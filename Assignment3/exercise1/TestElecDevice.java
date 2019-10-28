package exercise1;

public class TestElecDevice {
    public static void main(String[] args) {
        ElectricalDevice ed = new Refrigerator();
        AudioDevice ad;
        ed.turnOn();
        ed.turnOff();
        try {
            if (args[0].equals("TV")) {
                ad = new TV();
            } else if (args[0].equals("Radio")) {
                ad = new Radio();
            } else {
                ad = new AudioDevice();
            }
        } catch (Exception e) {
            ad = new AudioDevice();
        }

        ad.turnOn();
        ad.increaseVol();
        ad.decreaseVol();
        ad.turnOff();

    }
}
