package security;

import model.Permission;
import model.User;

import javax.ws.rs.ForbiddenException;

public class AuthUtils {

    public static boolean checkIfAdmin(User user){

        if(user.getTypes() == null)
            return false;

        boolean result = false;
        for(Permission permission: user.getTypes()){
            if(permission.getId() == 1)
                result = true;
        }

        return result;
    }

    public static boolean checkIfOperator(User user){

        if(user.getTypes() == null)
            return false;

        boolean result = false;
        for(Permission permission: user.getTypes()){
            if(permission.getId() == 2)
                result = true;
        }

        return result;
    }

    public static boolean checkIfSeller(User user){

        if(user.getTypes() == null)
            return false;

        boolean result = false;
        for(Permission permission: user.getTypes()){
            if(permission.getId() == 3)
                result = true;
        }

        return result;
    }

    public static boolean checkIfUser(User user){

        if(user.getTypes() == null)
            return false;

        boolean result = true;
        for(Permission permission: user.getTypes()){
           result = false;
        }

        return result;
    }

}
