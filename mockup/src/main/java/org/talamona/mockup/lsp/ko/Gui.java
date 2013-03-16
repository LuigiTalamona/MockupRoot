package org.talamona.mockup.lsp.ko;

/**
 *
 * @author luigi
 */
public class Gui {
    public boolean draw(Shape s){
        boolean retValue = true;
        if (s instanceof Rectangle){
            Rectangle r = (Rectangle)s;
            retValue = r.paint(); 
        }else if (s instanceof Circle){
            Circle c = (Circle)s;
            retValue = c.paint();
        }
        return retValue;
    }
}
