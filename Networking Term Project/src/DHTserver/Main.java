package DHTserver;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int portNumber;
        String hostName;
        int hostPort;
        int serverID;
        BlockingQueue<Message> queue=new ArrayBlockingQueue<Message>(10);

        Scanner scanner=new Scanner(System.in);
        System.out.println("Please enter server socket number: ");
        portNumber=scanner.nextInt();
        System.out.println("Please assign ID number: ");
        serverID=scanner.nextInt();


      DHTserver server=new DHTserver(portNumber,queue,serverID);
      new Thread(server).start();
        Thread.sleep(1000);

        System.out.println("Please enter server name: ");
        hostName=scanner.next();
        System.out.println("Please enter server port: ");
        hostPort=scanner.nextInt();


        DHTclient client=new DHTclient(hostName,hostPort);

        new Thread(client).start();




    }

}
