package homework;

public class MyStack {
   private int idx = 0;
   private char [] data = new char[ 6];
   private boolean full=false;
   private boolean empty=true;

   public synchronized  void push( char c) {
      while (full == true) {
         try {
           wait();
         } catch (InterruptedException e) { }
      }

      data[ idx] = c;
      System.out.println(Thread.currentThread().getName() +": idx"+idx+" "+c);
      idx++;
      if(idx==data.length ) full=true;
      if(empty==true){
        empty=false;
        notifyAll();
      }
  }

  public synchronized  char pop(){
    while (empty == true) {
       try {
         wait();
       } catch (InterruptedException e) { }
    }

   idx--;
   if(idx==0) empty=true;
   System.out.println(Thread.currentThread().getName() +
                      ": idx"+idx+" "+data[idx]);
   if(full==true){
     full=false;
     notifyAll();
   }
   return data[idx];
 }
}