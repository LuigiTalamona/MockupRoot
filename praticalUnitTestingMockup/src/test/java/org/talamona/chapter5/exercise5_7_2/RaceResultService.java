package org.talamona.chapter5.exercise5_7_2;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author luigi
 */
public class RaceResultService {
    
    private Set<Client> clients;
    
    public RaceResultService(){
        this.clients = new HashSet<Client>();
    }

    void addSubscriber(Client c) {
        this.clients.add(c);
    }

    void send(Message m) {
        for(Client client : this.clients){
            client.receive(m);
        }
    }

    void removeSubscriber(Client client) throws UnsubscribedClientException{
        if (!this.clients.remove(client)){
            throw new UnsubscribedClientException("Client doesn't exist");
        }
    }

    void send(Message message, MessageLogger logger) {
        this.send(message);
        logger.logMessage(message.getText(), message.getDate());
    }
    
}
