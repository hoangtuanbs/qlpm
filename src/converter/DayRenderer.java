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

public class DayRenderer extends DefaultTableCellRenderer {
    @Override

    public void setValue(Object value) {
        if (value == null) setText("");
        String s="";
        Integer arg = (Integer) value;

        int year = arg %10000;
        int month = (arg % 1000000 -year)/10000;
        int date = arg /1000000 ;

        s = (date<10? "0": "") + date;
        s += "."+(month<10? "0": "") + month;
        s += "." + year;

        setText(s);
        //setText((value == null) ? "" : formatter.format(value));
    }
}
