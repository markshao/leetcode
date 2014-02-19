package concurrent.socket;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * Created by mark on 2/19/14.
 */
public class Master {
    static List<String> data = new ArrayList<String>();

    static {
        data.add("xcp");
        data.add("core_rest");
        data.add("xdb");
        data.add("xiaobo");
        data.add("kunpeng");
        data.add("mabna");
        data.add("kobe");

    }

    class Worker implements Runnable {
        private int port;

        public Worker(int port) {
            this.port = port;
        }

        @Override
        public void run() {
            try {
                Socket socket = new Socket("127.0.0.1", this.port);
                ObjectOutputStream outputStream = new ObjectOutputStream(socket.getOutputStream());
                outputStream.writeObject(data);

                System.out.print(socket.getInputStream().read());
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void service() {
        List<Worker> workers = new ArrayList<Worker>();
        workers.add(new Worker(5150));
        workers.add(new Worker(5151));

        ExecutorService pooledExecutor = // Executors.newFixedThreadPool(threadPoolSize);
                new ThreadPoolExecutor(2, 2,
                        100000, TimeUnit.MILLISECONDS,
                        new LinkedBlockingQueue<Runnable>(),
                        new ThreadFactory() {
                            @Override
                            public Thread newThread(Runnable r) {
                                Thread result = new Thread(r);
                                result.setName("SOCKET_TEST");
                                return result;
                            }
                        });

        List<Callable<Object>> callables = new ArrayList<Callable<Object>>();

        for (final Runnable task : workers) {
            callables.add(new Callable<Object>() {

                @Override
                public Object call() throws Exception {
                    task.run();
                    return null;
                }

            });
        }
        try {
            pooledExecutor.invokeAll(callables);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        pooledExecutor.shutdown();
    }


    public static void main(String[] args) {
        Master master = new Master();
        master.service();
    }
}
