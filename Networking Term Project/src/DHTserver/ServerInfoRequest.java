package DHTserver;

//This class represent server info request between servers.  Each server will add its own info and pass it on to the next server
//until original sender is reached again.
public class ServerInfoRequest implements Message {

    final String messageType="Server Info Request";
    String [][] serverInfo=new String[4][2];
    int senderID;
    int originalSender;

    public ServerInfoRequest( String[][] serverInfo, int senderID, int originalSender) {
        this.serverInfo = serverInfo;
        this.senderID = senderID;
        this.originalSender = originalSender;

    }

    @Override
    public void processMessage() {
    }

    @Override
    public String getMessageType() {
        return messageType;
    }

    public void setServerInfo(String[][] serverInfo) {
        this.serverInfo = serverInfo;
    }

    public int getSenderID() {
        return senderID;
    }

    public void setSenderID(int senderID) {
        this.senderID = senderID;
    }

    public int getOriginalSender() {
        return originalSender;
    }

    public void setOriginalSender(int originalSender) {
        this.originalSender = originalSender;
    }

    //server info kept in array indexed as serverID-1
    public void addServerInfo(String hostName, int socket, int serverID){
        String[] temp={hostName , socket+""};
        serverInfo[serverID-1]=temp;
    }

    public String[][] getServerInfo(){
        return serverInfo;
    }

}
