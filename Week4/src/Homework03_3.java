import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Homework03_3 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start=System.currentTimeMillis();
        Compute3 compute3 = new Compute3();
        FutureTask<Integer> futureTask = new FutureTask<>(compute3);
        new Thread(futureTask).start();
        System.out.println("Result 3："+ futureTask.get());
        System.out.println("Execution time："+ (System.currentTimeMillis()-start) + " ms");
    }
}
class Compute3 implements Callable<Integer>
{
    @Override
    public Integer call()
    {
        FiboTest fiboTest = new FiboTest();
        return fiboTest.sum();
    }
}
