/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.mockup.isp.ok;

import java.util.Date;

/**
 *
 * @author luigi
 */
public interface TimerClient {
    public void setTimeout(Date time);
    public Date getTimeout();
    public void allarme();
    
}
