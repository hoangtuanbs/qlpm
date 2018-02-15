/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import javax.swing.table.DefaultTableCellRenderer;

/**
 *
 * @author Tuan Vu
 */
public class GenderRenderer extends DefaultTableCellRenderer {
    @Override
    public void setValue(Object value) {
        if (value == null) setText("");
        //String s="";
        Short arg = (Short) value;
        setText((arg==0)? "Nữ":"Nam");
        //setText((value == null) ? "" : formatter.format(value));
    }

}
