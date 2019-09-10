package homework;

public class TestStackThread {

  public static void main(String[] args) {
    MyStack ms=new MyStack();
    new PopStack(ms).start();
    new PushStack(ms).start() ;

  }
}