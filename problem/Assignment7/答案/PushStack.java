package homework;

public class PushStack extends Thread{
  private MyStack ms;

  public PushStack(MyStack ms) {
    super("pushStack");
    this.ms=ms;
  }

  public void run(){
    char ch='a';
    for(int i=0;i<12;i++){
      ms.push(ch);

      ch++;
   /*   try {
        sleep((int)(Math.random() * 100));
      } catch (InterruptedException e) { }
*/
   }
  }
}