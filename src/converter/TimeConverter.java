/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.StringTokenizer;
import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author Tuan Vu
 */
public class TimeConverter extends Converter <Integer, String>{
    public String convertForward(Integer arg) {
        String value = "";
        int year = arg %10000;
        int month = (arg % 1000000 -year)/10000;
        int date = arg /1000000 ;

        value = "Ngày " + date;
        value += " tháng " + month;
        value += " năm " + year;
        return value;
    }

    public Integer convertReverse(String arg) {
        int y,m,d;
        //Date d = new Date(year, month, date);
        StringTokenizer tokenizer = new StringTokenizer(arg);
        tokenizer.nextToken();
        d =  Integer.parseInt((String) tokenizer.nextElement());
        tokenizer.nextToken();
        m =  Integer.parseInt((String) tokenizer.nextElement());
        tokenizer.nextToken();
        y =  Integer.parseInt((String) tokenizer.nextElement());
        return  d*1000000+m*10000+y;
    }
}
