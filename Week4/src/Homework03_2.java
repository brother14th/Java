public class Homework03_2 {
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        Compute2 compute2 = new Compute2();
        Thread test = new Thread(compute2);
        test.start();
        test.join();
        System.out.println("Result 2："+ compute2.getSum());
        System.out.println("Execution time："+ (System.currentTimeMillis()-start) + " ms");
    }
}
class Compute2 implements Runnable
{
    private int sum;
    public void run()
    {
        FiboTest fiboTest = new FiboTest();
        sum = fiboTest.sum();
    }
    public int getSum()
    {
        return sum;
    }
}
