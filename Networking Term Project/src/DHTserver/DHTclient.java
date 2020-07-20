package DHTserver;

import java.io.*;

import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.BlockingQueue;

public class DHTclient implements Runnable {

    static String serverName; //name of the server we're trying to connect to
    static int port; //port of the server we're trying to connect to
    public String nextServer;
    BlockingQueue<Message> queue=null;

    DHTclient(BlockingQueue<Message> queue, String serverName, int portNumber){
        this.nextServer=serverName;
        this.port=portNumber;
        this.queue=queue;

    }

    @Override
    public void run() {
        try(Socket socket = new Socket(serverName,port)) {
            ObjectInputStream objectInput = new ObjectInputStream(socket.getInputStream()); //client's input stream
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(socket.getOutputStream()); //client's output stream

            while (true) {

                    Message receivedMessage = queue.take(); //check for messages from client (from other server)
               interpretMessage(receivedMessage);
            }
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void interpretMessage(Message receivedMessage) {
        if(receivedMessage.getMessageType().equals("Server Info Request")){

        }
    }

}
