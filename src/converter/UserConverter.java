/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package converter;

import entities.User;
import java.util.List;


import org.jdesktop.beansbinding.Converter;

/**
 *
 * @author Tuan Vu
 */
public class UserConverter extends Converter <User, String>{
    public String convertForward(User arg) {
        return arg.getUserName();
    }

    public User convertReverse(String arg) {
        List<User> l = GlobalProperty.getInstance().getUserList();
        for (int i=0; i<l.size();i++){
            if (l.get(i).getUserName().compareTo(arg)==0)
                    return l.get(i);
        }
        return l.get(0);
    }
}
