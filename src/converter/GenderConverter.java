/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;


import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author Tuan Vu
 */
public class GenderConverter extends Converter<Short, String> {

    public String convertForward(Short arg) {
        String value = null;
        switch (arg) {
            case 0: value="Nữ"; break;
            case 1: value="Nam"; break;
            default: value = "Nam";
        }
        return value;
    }

    public Short convertReverse(String arg) {
        short value = 0;
        if ("Nữ".equals(arg)) {
            value = 0;
        } else if ("Nam".equals(arg)) {
            value = 1;
        }
        return  value;
    }
}