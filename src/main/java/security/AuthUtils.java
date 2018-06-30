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

}
