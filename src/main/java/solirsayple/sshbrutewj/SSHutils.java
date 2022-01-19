package solirsayple.sshbrutewj;

import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;
import java.net.*;

public class SSHutils {

    public static void performCheck(){
        Socket socket;
        SocketAddress sockaddr;
        sockaddr = new InetSocketAddress(ProgramSettings.ip, ProgramSettings.port);
        socket = new Socket();
    
        try {
            Main.outputText(Colors.BLUE, "Checking if server is up...");
            socket.connect(sockaddr, ProgramSettings.timeout);
            socket.close();
            Main.outputText(Colors.GREEN, "Server is up continuing!");

        } catch (Exception e) {
            System.out.println(e);
            Main.outputText(Colors.RED, "FATAL: An error has occured when trying to connect to target.\n Read the exception above for more details. This could be happening because your target is down or innaccessible.\n If you think this is a mistake please submit an issue at: https://github.com/Solirs/sshbrute");
            System.exit(1);
            
        }
    
    }
    
}
