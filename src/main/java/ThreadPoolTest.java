import java.util.concurrent.*;

/**
 * <类的详细说明：线程池的使用>
 *
 * @Author: Huanghai
 * @Version: 2017/1/7
 **/
public class ThreadPoolTest {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newCachedThreadPool();

        for(int i=0;i<20;i++){
            MyTask myTask = new MyTask(i);
            executor.execute(myTask);
//            System.out.println("线程池中线程数目："+executor.getPoolSize()+"，队列中等待执行的任务数目："+
//                    executor.getQueue().size()+"，已执行玩别的任务数目："+executor.getCompletedTaskCount());
        }
        executor.shutdown();
    }
}


class MyTask implements Runnable {
    private int taskNum;

    public MyTask(int num) {
        this.taskNum = num;
    }

    @Override
    public void run() {
        System.out.println("正在执行task "+taskNum);
        try {
            Thread.currentThread().sleep(4000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("task "+taskNum+"执行完毕");
    }
}
