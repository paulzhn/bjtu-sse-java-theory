public class Producer implements Runnable {
    @Override
    public void run() {
        MyStack instance = MyStack.getInstance();
        for (char iter = 'a'; iter <= 'z'; iter++) {
            instance.push(iter);
        }
    }
}
