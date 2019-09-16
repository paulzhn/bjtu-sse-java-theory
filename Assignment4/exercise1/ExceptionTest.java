public class ExceptionTest {
    public void testMException() throws MyException{
        System.out.println("MyException is thrown");
        throw new MyException();
    }

    public void testMSException() throws MySpecialException {
        System.out.println("MySpecialException is thrown");
        throw new MySpecialException();
    }

    public static void main(String[] args) {
        ExceptionTest t = new ExceptionTest();
        try {
            t.testMSException();
        } catch (MySpecialException e) {
            System.out.println("MySpecialException is caught");
        } finally {
            System.out.println("Here is finally clause");
        }
        try {
            t.testMException();
        } catch (MyException e) {
            System.out.println("MyException is caught");
        } finally {
            System.out.println("Here is finally clause");
        }
        System.out.println("This is the end of main() method");
    }
}
