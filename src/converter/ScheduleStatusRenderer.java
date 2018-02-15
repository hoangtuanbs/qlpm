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
public class ScheduleStatusRenderer extends DefaultTableCellRenderer {
    @Override
    public void setValue(Object value) {
        if (value == null) setText("");
        String s ;
        Integer i = (Integer) value;
        switch (i) {
            case 0: s = "Chưa thực hiện"; break;
            case 1: s = "Đã thực hiện";break;
            default: s = "Lỗi";
        }
        setText(s);
        //setText((value == null) ? "" : formatter.format(value));
    }

}
