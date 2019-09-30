public class MyStack {
    private static MyStack instance;
    private char[] array = new char[5];

    public static MyStack getInstance() {
        if (instance == null) {
            instance = new MyStack();
        }
        return instance;
    }

    public synchronized void push(char c) {
        for (int i = 0; i < 5; i++) {
            if (array[i] == '\0') {
                System.out.println("P: Push letter " + c);
                array[i] = c;
                notify();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return;
            }
        }
        try {
            System.out.println("P: The array is full.");
            wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public synchronized char pop() {
        while (true) {
            for (int i = 0; i < 5; i++) {
                if (array[i] != '\0') {
                    System.out.println("C: Pop letter " + array[i]);
                    char temp = array[i];
                    array[i] = '\0';
                    notify();
                    try {
                        Thread.sleep(200);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    return temp;
                }
            }
            try {
                System.out.println("C: The array is empty.");
                // 等待太长时间，说明已经全部输出完，直接exit
                long start = System.currentTimeMillis();
                wait(1000);
                long end = System.currentTimeMillis();
                if (end - start > 1000) {
                    System.exit(0);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
