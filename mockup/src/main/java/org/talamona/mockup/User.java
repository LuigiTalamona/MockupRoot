/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.mockup;

/**
 *
 * @author luigi
 */
public class User implements Comparable{
    
    private String id, ARSSid, ARSSpwd;

    /**
     * @return the id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * @return the ARSSid
     */
    public String getARSSid() {
        return ARSSid;
    }

    /**
     * @param ARSSid the ARSSid to set
     */
    public void setARSSid(String ARSSid) {
        this.ARSSid = ARSSid;
    }

    /**
     * @return the ARSSpwd
     */
    public String getARSSpwd() {
        return ARSSpwd;
    }

    /**
     * @param ARSSpwd the ARSSpwd to set
     */
    public void setARSSpwd(String ARSSpwd) {
        this.ARSSpwd = ARSSpwd;
    }
    
    public String getClearARSSpwd(){
        Cripter c = new Cripter();
        String retValue = c.decriptString(this.ARSSpwd);
        return retValue;
    }

    public int compareTo(Object t) {
        int retValue = -1;
        if (t instanceof User){
            User u = (User)t;
            retValue = (u.getId().equals(this.id))? 0: -1;
            
            
        }
        return retValue;
    }
    
}
