import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Current {
    public static void main(String[] args) {

        String server_IP = "";

        try {
            InetAddress iAddress = InetAddress.getLocalHost();
            server_IP = iAddress.getHostAddress();
            System.out.println("Server IP address : " + server_IP);

        } catch (Exception e) {
            // ignore
        }
        Socket clientSocket;
        try {
//            clientSocket = new Socket("127.0.0.1", 5000);
//            InetSocketAddress socketAddress = (InetSocketAddress) clientSocket.getRemoteSocketAddress();
//            System.out.println("Your Current IP Address: " + socketAddress.getAddress().getHostAddress());
            String ip = Inet4Address.getByName("somets.noip.com").getCanonicalHostName();
            InetSocketAddress sa = new InetSocketAddress(ip, 5000);
            System.out.println(ip+ sa);
        } catch (IOException e) {
            // ignore
            System.out.println("Exception: "+e);
        }

        // Find public IP address
        String systemipaddress = "";
        try
        {
            URL url_name = new URL("https://api6.ipify.org/?format=text");

            BufferedReader sc = new BufferedReader(new InputStreamReader(url_name.openStream()));

            // reads system IPAddress
            systemipaddress = sc.readLine().trim();
        }
        catch (Exception e)
        {
            systemipaddress = "Cannot Execute Properly";
        }
        System.out.println("Public IP Address: " + systemipaddress +"\n");
    }
}
