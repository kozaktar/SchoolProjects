package DHTserver;

//Generic message interface

public interface Message {
    void processMessage();
    String getMessageType();

    int getOriginalSender();
}
