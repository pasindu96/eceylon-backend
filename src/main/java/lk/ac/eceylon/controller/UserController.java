package lk.ac.eceylon.controller;

import lk.ac.eceylon.dto.ChangePasswordDTO;
import lk.ac.eceylon.dto.UserDTO;
import lk.ac.eceylon.entity.User;
import lk.ac.eceylon.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value = "api/eceylon")
public class UserController {

    @Autowired
    private UserService userService;

//    @PostMapping(value="/login",consumes= MediaType.APPLICATION_JSON_VALUE,
//            produces = MediaType.APPLICATION_JSON_VALUE)
//    public User authenticateUser(@RequestBody UserDTO user){
//        //System.out.println(user);
//        if(user.getEmail()!=null){
//            return userService.authenticatebyEmail(user.getEmail(),user.getPassword());
//        }
//        else
//            return null;
//    }

    @PostMapping(value="/userlogin",consumes= MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> loginUser(@RequestBody UserDTO user){
        User loggedUser;
        if(user.getEmail()!=null){
            loggedUser=userService.authenticatebyEmail(user.getEmail(),user.getPassword());
            if(loggedUser != null){
                return new ResponseEntity<User>(loggedUser, HttpStatus.OK);
            }
            return new ResponseEntity<User>(new User(), HttpStatus.BAD_REQUEST);

        }
        else
            return new ResponseEntity<User>(new User(), HttpStatus.BAD_REQUEST);
    }

    @PostMapping(value="/signin",consumes= MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveUser(@RequestBody UserDTO user) throws Exception {
            return userService.saveUser(user);
    }

   @GetMapping(value="/user/{id}",produces= MediaType.APPLICATION_JSON_VALUE)
    public User findByemail(@PathVariable  String id) throws Exception {
//        id=id.replace("id=","");
       System.out.println(id);
        return userService.findByemail(id);
    }
    @PostMapping(value="/user/update",consumes= MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean updateUser(@RequestBody User user){
        System.out.println(user);
        return userService.updateUser(user);
    }
    @PostMapping(value="/user/update/password",consumes= MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public String changePassword(@RequestBody ChangePasswordDTO dto){
        return userService.updatePassWord(dto);
    }
}
