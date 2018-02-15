/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

/**
 *
 * @author Tuan Vu
 */
public class StringConverter {

    private StringConverter() {
    }

    public static StringConverter getInstance() {
        return StringConverterHolder.INSTANCE;
    }

    private static class StringConverterHolder {
        private static final StringConverter INSTANCE = new StringConverter();
    }

    public String getFormattedNumber (double d) {
        String s = ""+d;
        int i = s.lastIndexOf('.');
        if (i==-1) {
            i = s.length()-1;
        }
        while (i-3 >0) {
            String a = s.substring(i);
            String b = s.substring(0, i-1);
            s = a +","+b;
            i = i-3;
        }
        return s;
    }
 }
