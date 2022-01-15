package solirs.sshbrutewj;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SSHThread extends Thread {
    private JSch jsch = new JSch();

    public void attemptConnection(String password) throws JSchException {
        try {
            Session session = jsch.getSession(ProgramSettings.username, ProgramSettings.ip, ProgramSettings.port);
            session.setTimeout(ProgramSettings.timeout);
            session.setPassword(password);
        } finally {

        }
    }

    public void run() {
        jsch.setConfig("StrictHostKeyChecking", "no");
        while (!ProgramSettings.queue.isEmpty()) {
            String password = ProgramSettings.queue.remove();
            attemptConnection(password);
        }
    }
}