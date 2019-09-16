public class ExceptionTestWithOneTryCatch {
    public static void main(String[] args) {
        ExceptionTest t = new ExceptionTest();
        try {
            t.testMSException();
            t.testMException();
        } catch (MySpecialException e) {
            System.out.println("MySpecialException is caught");
        } catch (MyException e) {
            System.out.println("MyException is caught");
        } finally {
            System.out.println("Here is finally clause");
        }
        System.out.println("This is the end of main() method");
    }
    /*
    Reason: when the testMSException() was invoked, the exception had been thrown and
    catch, jumping over the testMException(). Then the println in finally was invoked.
     */
}
