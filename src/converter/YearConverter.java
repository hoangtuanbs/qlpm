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
public class YearConverter extends Converter<Short, Integer> {

    public Integer convertForward(Short arg) {
        Integer value = (Integer) (arg+0) ;
        return value;
    }

    public Short convertReverse(Integer arg) {
        short value = (short) (arg-0);
        return  value;
    }
}