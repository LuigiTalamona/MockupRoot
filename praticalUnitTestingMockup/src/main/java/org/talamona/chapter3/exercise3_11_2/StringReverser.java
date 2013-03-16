package org.talamona.chapter3.exercise3_11_2;

/**
 *
 * @author luigi
 */
public class StringReverser {

    public StringReverser() {
    }
/* Before refactoring ********************************************
    public String doReverse(String input){
        List<String> tempArray = new ArrayList<String>();
        for (int i = 0; i < input.length(); i++) {
            tempArray.add(input.substring(i, i + 1));
        }
        StringBuilder sb = new StringBuilder(input.length());
        for (int i = tempArray.size() - 1; i >= 0; i--) {
            sb.append(tempArray.get(i));
        }
        return sb.toString();
    }
    */
    /* After refactoring *******************************************/
    public String doReverse(String input){
        StringBuilder sb = new StringBuilder(input.length());
        for (int i = input.length() - 1; i >= 0; i--) {
            sb.append(input.charAt(i));
        }
        return sb.toString();
    }
    
}
