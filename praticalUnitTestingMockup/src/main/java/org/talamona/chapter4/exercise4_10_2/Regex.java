package org.talamona.chapter4.exercise4_10_2;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author luigi
 */
class Regex {

    public String extractNumbers(String input) {
        // Search for 3 digit in input string
        Pattern pattern = Pattern.compile("\\d{3,}");
        Matcher matcher = pattern.matcher(input);
        List rawData = this.buildRawData(matcher);
        return this.buildResponse(rawData);
    }
    private String buildResponse(List matches){
        StringBuilder b = new StringBuilder();
        int i = matches.size();
        for(int k = 0; k < i; k ++){
            b.append((k > 0 && k < i)? ",":"");
            b.append(matches.get(k));
        }
        return (b.length() == 0)? null: b.toString();
    }
    private List buildRawData(Matcher matcher){
        List retValue = new ArrayList();
        while (matcher.find()) {
            retValue.add(matcher.group());
        }
        return retValue;
    }
}
