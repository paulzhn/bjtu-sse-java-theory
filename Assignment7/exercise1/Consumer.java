public class Consumer implements Runnable {
    @Override
    public void run() {
        MyStack instance = MyStack.getInstance();
        while (true) {
            instance.pop();
        }
    }
}
