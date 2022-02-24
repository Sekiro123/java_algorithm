package �߳�;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class SemaphoreDemo {
    // ���������
    private static final int threadCount = 550;

    public static void main(String[] args) throws InterruptedException {
        // ����һ�����й̶��߳��������̳߳ض�����������̳߳ص��߳�������̫�ٵĻ���ᷢ��ִ�еĺ�����
        ExecutorService threadPool = Executors.newFixedThreadPool(300);
        // һ��ֻ������ִ�е��߳�������
        final Semaphore semaphore = new Semaphore(20);

        for (int i = 0; i < threadCount; i++) {
            final int threadnum = i;
            threadPool.execute(() -> {// Lambda ���ʽ������
                try {
                    semaphore.acquire();// ��ȡһ����ɣ����Կ������߳�����Ϊ20/1=20
                    test(threadnum);
                    semaphore.release();// �ͷ�һ�����
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }

            });
        }
        threadPool.shutdown();
        System.out.println("finish");
    }

    public static void test(int threadnum) throws InterruptedException {
        Thread.sleep(1000);// ģ������ĺ�ʱ����
        System.out.println("threadnum:" + threadnum);
        Thread.sleep(1000);// ģ������ĺ�ʱ����
    }

}
