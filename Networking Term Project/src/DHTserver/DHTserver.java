package DHTserver;

import javax.print.attribute.standard.RequestingUserName;
import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.concurrent.BlockingQueue;

public class DHTserver implements Runnable {


    public String hostname;
    public Socket socket;
    public int serverID;
    public int socketNum;
    BlockingQueue <Message> queue;

    public DHTserver(int socket, BlockingQueue<Message> queue, int serverID) {
        this.socketNum = socket;
        this.queue=queue;
        this.serverID=serverID;

    }

    public void run() {

        InetAddress ip;


        try {
            ip = InetAddress.getLocalHost();
            hostname = ip.getHostName();
            System.out.println("Listening on socket: " + socketNum+"");
            System.out.println("Server Hostname : " + hostname + "\n\n");

        } catch (UnknownHostException e) {

            e.printStackTrace();
        }

        try (ServerSocket serverSocket = new ServerSocket(socketNum)){
            while (true){
                Socket clientSocket=serverSocket.accept();
                new Thread(
                        new DHTworker(queue,clientSocket,serverID,hostname)
                ).start();
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }


}

