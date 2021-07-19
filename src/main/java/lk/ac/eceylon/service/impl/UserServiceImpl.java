package lk.ac.eceylon.service.impl;

import lk.ac.eceylon.dto.ChangePasswordDTO;
import lk.ac.eceylon.dto.UserDTO;
import lk.ac.eceylon.entity.User;
import lk.ac.eceylon.repository.UserRepository;
import lk.ac.eceylon.service.UserService;
import lk.ac.eceylon.validation.ValidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly =  true)
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;


    @Override
    public User authenticatebyEmail(String email, String password) {
        boolean exists =userRepository.existsById(email);
        if (!exists){
            return null;
        }

        User user = userRepository.findById(email).get();

        if(user.getPassword().equals(password)){
            user.setPassword(null);
            return user;
        }
        else
            return null;
    }


    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveUser(UserDTO newUser) {

        boolean exists =userRepository.existsById(newUser.getEmail());
        if (!exists){
            //return false if the given email is exists in the database
            return false;
        }

        ValidateUser validate=new ValidateUser();
        if(!validate.validate(newUser))
            return false;

        User user=new User();
        user.setUsername(newUser.getUsername());
        user.setPassword(newUser.getPassword());
        user.setMobile(newUser.getMobile());
        user.setFullname(newUser.getFullname());
        user.setAddress(newUser.getAddress());
        user.setEmail(newUser.getEmail());
        user.setType(newUser.getType());

        if(userRepository.save(user)!=null)
            return true;
        else
            return false;

    }


    @Override
    public User findByemail(String email) {
        try {
            User u=new User();
            u= userRepository.findById(email).get();
            if(u!=null){
                return u;
            }else{
                u.setEmail("No user");
                return u;
            }
        }catch(Exception ex){
            User u=new User();
            u.setEmail("No user");
            return u;
        }
    }

    @Override
    public boolean updateUser(User user) {
        User userToUpdate= userRepository.getOne(user.getEmail());
        userToUpdate.setFullname(user.getFullname());
        userToUpdate.setAddress(user.getAddress());
        userToUpdate.setMobile(user.getMobile());
        if(userRepository.save(userToUpdate)!=null)
            return true;
        else
            return false;
    }

    @Override
    public String updatePassWord(ChangePasswordDTO dto) {

        if(dto.getCurrentPassword().equals(userRepository.findById(dto.getEmail()).get().getPassword())){
            User userToUpdate= userRepository.getOne(dto.getEmail());
            userToUpdate.setPassword(dto.getNewPassword());
            userRepository.save(userToUpdate);
            return "Password updated successfully...";

        }else{
            return "Please check the current password and proceed !";
        }
    }
}
