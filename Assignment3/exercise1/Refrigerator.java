package exercise1;

public class Refrigerator implements ElectricalDevice{
    public void setFreezingLevel() {
        System.out.println("The freezing level has set.");
    }

    @Override
    public void turnOn() {
        System.out.println("Fridge turns on.");
    }

    @Override
    public void turnOff() {
        System.out.println("Fridge turns off.");
    }
}
