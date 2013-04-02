/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.chapter5.exercise5_7_1;

/**
 *
 * @author luigi
 */
interface UserService {

    public void setDao(UserDAO dao);

    public void setSecurityService(SecurityService ss);

    public void assignPassword(User user) throws Exception;
    
}
