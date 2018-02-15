/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;


import converter.*;
import entities.User;
import java.util.List;
import java.util.Vector;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author Tuan Vu
 */
public class UserSelectorConverter extends Converter<User, String> {



    //@Override
    public String convertForward(User value) {
        return value.getUserName();
        //throw new UnsupportedOperationException("Not supported yet.");
    }

    //@Override
    public User convertReverse(String value) {
        List<User> l = GlobalProperty.getInstance().getUserList();
        for (int i=0; i<l.size();i++){
            if (l.get(i).getUserName().compareTo(value)==0)
                return l.get(i);
        }
        return l.get(0);
        //throw new UnsupportedOperationException("Not supported yet.");
    }
}