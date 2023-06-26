/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Class;

/**
 *
 * @author cristian
 */
public class SessionManager {
    
    private static SessionManager instance;
    private String userId;
    
    private SessionManager(){
        
    }
    
    public static SessionManager getInstance(){
        if(instance == null){
            instance = new SessionManager();
        }
        return instance;
    }
    
    public String getUserId(){
        return userId;
    }
    
    public void setUserId(String userId){
        this.userId=userId;
    }
    
    public void destroySession() {
        this.userId = null;
    }

}
