package lk.ac.eceylon.service;

import lk.ac.eceylon.dto.ChangePasswordDTO;
import lk.ac.eceylon.dto.UserDTO;
import lk.ac.eceylon.entity.User;

public interface UserService {

    User authenticatebyEmail(String email,String password);
    //boolean authenticatebyUsername(String username,String password);
    boolean saveUser(UserDTO user);
    //boolean findByemail(String email);
    User findByemail(String email);
    boolean updateUser(User user);
    String  updatePassWord(ChangePasswordDTO dto);

}
