package homework;

public class PopStack extends Thread{
  private MyStack ms;

  public PopStack(MyStack ms) {
    super("popStack");
    this.ms=ms;
  }

  public void run(){
    char result='0';
    for(int i=0;i<12;i++){
      result = ms.pop();

/*
      try {
        sleep((int)(Math.random() * 100));
      } catch (InterruptedException e) { }
*/
   }
 }
}
