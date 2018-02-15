/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;


import converter.*;
import entities.User;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Vector;
import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author Tuan Vu
 */
public class UserSelectorConvert extends Converter<User, String> {
    //@Override
    public List<String> convertForward(List<User> value) {
        List <String> u = new ArrayList<String>();
        for (int i = 0; i <value.size();i++) {
            u.add(value.get(i).getUserName());
        }
        return u;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    //@Override
    public List<User> convertReverse(List<String> value) {
        List<User> l = GlobalProperty.getInstance().getUserList();
        List<User> r  = new ArrayList<User>();
        for (int i = 0; i <l.size();i++) {
            r.add(l.get(i));
        }
        return r;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public String convertForward(User value) {
        return value.getUserName();//"Not supported yet.");
    }

    @Override
    public User convertReverse(String value) {
        List<User> l = GlobalProperty.getInstance().getUserList();
        if (l== null || l.size()<=0) return null;
        User u =null;
        for (int i= 0; i < l.size(); i++) {
            if (l.get(i).getUserName().compareTo(value) ==0 ) {
                return l.get(i);
            }
        }
        return u;
       // throw new UnsupportedOperationException("Not supported yet.");
    }
}