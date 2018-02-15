/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;


import converter.*;
import entities.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author Tuan Vu
 */
public class UserConvertList extends Converter<List<User>, List<String>> {
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
}