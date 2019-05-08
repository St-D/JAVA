package MidiSequencer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class DailyAdviceClient {

    public void start() {

        try {
//            Socket s = new Socket("127.0.0.1", 7654);
//            Socket s = new Socket("172.20.1.150", 7654); // Руслан
//            Socket s = new Socket("172.20.1.81", 7654))// Костя

            ServerSocket serverSocket = new ServerSocket(7654);

            while (true) {
                Socket s = serverSocket.accept();

                InputStreamReader streamReader = new InputStreamReader(s.getInputStream());
                BufferedReader reader = new BufferedReader(streamReader);
                String advice = reader.readLine();
                System.out.println("____" + advice);

                s = new Socket(s.getInetAddress().toString().replaceAll("/", ""), 7654);
                PrintWriter writer = new PrintWriter(s.getOutputStream());
                String answer = "ok";
                writer.println(answer);

                reader.close();
                writer.close();

                System.out.println(answer);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        DailyAdviceClient client = new DailyAdviceClient();
        client.start();
    }
}
