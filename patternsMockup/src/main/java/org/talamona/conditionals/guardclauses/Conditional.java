/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.talamona.conditionals.guardclauses;

/**
 *
 * @author luigi
 */
class Conditional {

    private Status status;

    public enum Status {

        TEMPORARY, RETIRED, SUSPENDED;
    }

    public double getAmount() {
        double retValue = 0;
        if (this.status == Status.TEMPORARY) {
            retValue = 100d;
        } else if (this.status == Status.RETIRED) {
            retValue = 50d;
        } else if (this.status == Status.SUSPENDED) {
            retValue = 20d;
        } else {
            retValue = 500d;
        }


        return retValue;
    }

    public double getAmountRevised() {
        if (this.status == Status.TEMPORARY) {
            return 100d;
        }
        if (this.status == Status.RETIRED) {
            return 50d;
        }
        if (this.status == Status.SUSPENDED) {
            return 20d;
        }
        return 500d;
    }

    void setStatus(Status status) {
        this.status = status;
    }
}
