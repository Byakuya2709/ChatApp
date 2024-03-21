/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;
import com.corundumstudio.socketio.SocketIOClient;
import java.net.Socket;
/**
 *
 * @author admin
 */
public class Model_Client {
    private Socket client;
    private Model_User user;
      public Model_Client(Socket client, Model_User user) {
        this.client = client;
        this.user = user;
    }
    public Model_Client(){
    
    }

    /**
     * @return the client
     */
    public Socket getClient() {
        return client;
    }

    /**
     * @param client the client to set
     */
    public void setClient(Socket client) {
        this.client = client;
    }

    /**
     * @return the user
     */
    public Model_User getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(Model_User user) {
        this.user = user;
    }
 
    
}
