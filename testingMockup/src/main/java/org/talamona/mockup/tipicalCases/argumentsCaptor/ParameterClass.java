package org.talamona.mockup.tipicalCases.argumentsCaptor;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 8/7/13
 * Time: 2:38 PM
 */
public class ParameterClass {

    private String parameterValue;

    public ParameterClass(){
        this.parameterValue = this.getClass().getCanonicalName();
    }


    public String getParameterValue() {
        return parameterValue;
    }

    public void setParameterValue(String parameterValue) {
        this.parameterValue = parameterValue;
    }
}
