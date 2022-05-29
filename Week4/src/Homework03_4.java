import java.util.concurrent.*;

public class Homework03_4 {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        long start=System.currentTimeMillis();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<Integer> future = executorService.submit(new Callable<Integer>() {
            public Integer call() {
                FiboTest fiboTest = new FiboTest();
                return fiboTest.sum();
            }
        });
        System.out.println("Result 4："+ future.get());
        System.out.println("Execution time："+ (System.currentTimeMillis()-start) + " ms");
    }
}
