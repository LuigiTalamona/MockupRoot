package org.talamona.N1ChooseDescriptiveNames;

/**
 * Created with IntelliJ IDEA.
 * User: luigi
 * Date: 6/4/13
 * Time: 9:11 AM
 */
public class Example {
    private int[] l;

    public int x(){
        int q = 0, z = 0;
        for (int kk = 0; kk < 10; kk ++){
            if (l[z] == 10){
                q += 10 + (l[z+1] + l[z+2]);
                z += 1;
            }
            else if(l[z] + l[z + 1] == 10){
                q += 10 + l[z+2];
                z += 2;
            }else{
                q += l[z] + l[z+1];
                z += 2;
            }
        }
        return q;
    }
}
