public class Homework03_1 {
    public static void main(String[] args) throws InterruptedException {
        long start=System.currentTimeMillis();
        Compute1 compute1 = new Compute1();
        compute1.start();
        compute1.join();
        System.out.println("Result 1："+compute1.getSum());
        System.out.println("Execution time："+ (System.currentTimeMillis()-start) + " ms");
    }
}
class Compute1 extends Thread
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
