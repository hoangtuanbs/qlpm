/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package entities;

import java.util.Calendar;

/**
 *
 * @author Tuan Vu
 */
public class TimeProcessor {
    Calendar c = Calendar.getInstance();
    private TimeProcessor() {
    }

    public static TimeProcessor getInstance() {
        return TimeProcessorHolder.INSTANCE;
    }

    private static class TimeProcessorHolder {
        private static final TimeProcessor INSTANCE = new TimeProcessor();
    }

    public int getIntegerFromCurrentDate() {
        int i =0;
        c = Calendar.getInstance();
        //c.get(Calendar.M)
        i = c.get(Calendar.DAY_OF_MONTH)*1000000 +
                (c.get(Calendar.MONTH)+1) * 10000+
                c.get(Calendar.YEAR);
        return i;
    }
 }
