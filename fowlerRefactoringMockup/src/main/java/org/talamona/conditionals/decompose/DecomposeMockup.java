package org.talamona.conditionals.decompose;

import java.text.DateFormat;
import java.text.ParseException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luigi
 */
class DecomposeMockup {

    private double quantity, winterRate, winterCharge;

    public DecomposeMockup(double quantity, double winterRate) {
        this.quantity = quantity;
        this.winterRate = winterRate;
        this.winterCharge = 100d;
    }

    public enum SummerLimits {

        SUMMER_START("21/06"),
        SUMMER_END("21/09");
        private Date limit;

        private SummerLimits(String stringDate) {
            this.limit = this.calculateDate(stringDate);
        }

        public Date getLimit() {
            return this.limit;
        }

        private Date calculateDate(String stringDate) {
            Date retValue = null;

            String[] tokens = stringDate.split("/");

            Calendar c = new GregorianCalendar();
            c.set(Calendar.DATE, Integer.valueOf(tokens[0]));
            c.set(Calendar.MONTH, Integer.valueOf(tokens[1]) - 1);
            retValue = c.getTime();
            return retValue;

        }
    }

    public double calculateAmount(Date date) {
        double retValue = 0d;
        if (date.before(SummerLimits.SUMMER_START.getLimit()) || date.after(SummerLimits.SUMMER_END.getLimit())) {
            retValue = this.quantity * this.winterRate + this.winterCharge;

        } else {
            retValue = this.quantity + (this.quantity * 0.2);
        }
        return retValue;
    }

    public double calculateAmountRefactored(Date date) {
        double retValue = 0d;
        if (this.notSummer(date)) {
            retValue = this.calculateWinterAmount();
        } else {
            retValue = this.calculateSummerAmount();
        }
        return retValue;
    }

    private boolean notSummer(Date date) {
        return date.before(SummerLimits.SUMMER_START.getLimit())
                || date.after(SummerLimits.SUMMER_END.getLimit());

    }

    private double calculateWinterAmount() {
        return this.quantity * this.winterRate + this.winterCharge;
    }

    private double calculateSummerAmount() {
        return this.quantity + (this.quantity * 0.2);
    }
}
