package DHTserver;

//DHTworker is a worker thread spawned by DHT server
//This class will perform all the work required by DHT server

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.concurrent.BlockingQueue;

public class DHTworker implements Runnable {
    BlockingQueue<Message> messagesQueue; //Queue to hold thread messages (used for communication between server and client threads on the same server
    Socket clientSocket; //socket that was created to accept new connection and passed to the worker
    int serverID; //ID of the server
    String hostname;//Hostname of the server

    DHTworker(BlockingQueue queue, Socket socket, int serverID, String hostname){
        this.messagesQueue=queue;
        this.clientSocket=socket;
        this.serverID=serverID;
        this.hostname=hostname;
    }

    @Override
    public void run() {
        try {
            ObjectInputStream objectInput = new ObjectInputStream(clientSocket.getInputStream()); //server's input stream
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(clientSocket.getOutputStream()); //server's output stream

            while (true) {
                Message receivedMessage = (Message) objectInput.readObject(); //check for messages from client (from other server)

                interpretMessage(receivedMessage); //process message
            }
        } catch (IOException e) {
            System.out.println("Thread error:" + e.getMessage());
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void interpretMessage(Message receivedMessage) {
        if(receivedMessage.getMessageType().equals("Server Info Request")){
            ServerInfoRequest tempMessage=(ServerInfoRequest) receivedMessage;
            int originalSender=tempMessage.getOriginalSender();

            if(originalSender!=serverID) {
                tempMessage.setSenderID(serverID);
                String[][] serverInfoUpdated=tempMessage.getServerInfo();
                tempMessage.addServerInfo(hostname,clientSocket.getLocalPort(),serverID);
                messagesQueue.add(tempMessage);
            }
            else {
                //send it to the user who requested it.
            }


        }
    }
}
