package solirsayple.sshbrutewj;

import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

// the data from this class is accesed by multiple
// other classes in the program. It's used to keep
// track of data like arguments and the passwords from
// the wordlist.
public class ProgramSettings {
    public static String ip;
    public static Integer port;
    public static String username;
    public static String wordlist;
    public static Boolean verboseMode;
    public static int threadCount;
    public static int timeout = 200;
    public static ReentrantLock lock = new ReentrantLock(); 
    public static BlockingQueue<String> queue = new LinkedBlockingQueue<>();
    public static ThreadPoolExecutor executor = (ThreadPoolExecutor) Executors.newFixedThreadPool(10);
}

