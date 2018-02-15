/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;


import converter.*;
import entities.User;
import java.util.List;
import java.util.Vector;
import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author Tuan Vu
 */
public class UserConvert extends Converter<Vector<User>, Vector<String>> {
    @Override
    public Vector<String> convertForward(Vector<User> value) {
        Vector <String> u = new Vector<String>();
        for (int i = 0; i <value.size();i++) {
            u.add(value.elementAt(i).getUserName());
        }
        return u;
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Vector<User> convertReverse(Vector<String> value) {
        List<User> l = GlobalProperty.getInstance().getUserList();
        Vector<User> r  = new Vector<User>();
        for (int i = 0; i <l.size();i++) {
            r.add(l.get(i));
        }
        return r;
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}