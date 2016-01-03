import java.io.*;
import java.net.*;
import java.lang.ProcessBuilder;
 
public class ClientSide {
    public static void main(String[] args) throws IOException {
         
        if (args.length != 2) {
            System.err.println(
                "Usage: java EchoClient <host name> <port number>");
            System.exit(1);
        }
 
        String hostName = args[0];
        //int portNumber = Integer.parseInt(args[1]);
        int portNumber = 2000;
 
        try (
            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out =
                new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in =
                new BufferedReader(
                    new InputStreamReader(echoSocket.getInputStream()));
            BufferedReader stdIn =
                new BufferedReader(
                    new InputStreamReader(System.in))
        ) {
            String userInput;
            while ((userInput = stdIn.readLine()) != null) {
                //out.println(userInput);
                //System.out.println("echo: " + in.readLine());
                Process p = new ProcessBuilder(userInput).start();
                p = Runtime.getRuntime().exec(userInput);
                //p.waitFor();

                BufferedReader reader = new BufferedReader(new InputStreamReader(p.getInputStream()));

                String line = "";           
                while ((line = reader.readLine())!= null) {
                    StringBuffer sb = new StringBuffer(userInput);
                    sb.append(line + "\n");
                }
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        } 
    }
}