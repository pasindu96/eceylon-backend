package lk.ac.eceylon.validation;

import lk.ac.eceylon.dto.UserDTO;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUser {

    private Pattern pattern;
    private Matcher matcher;

    private String mailPattern="^[_A-Za-z0-9-.\\\\+]+(\\\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]{0,9}[.][A-Za-z]{0,5}$";
    private String namePattern="^[A-Za-z]+([\\ A-Za-z]+)$";
    private String mobilePattern="^([0-9]{10})$";

    public boolean validateEmail(String email){
        pattern=Pattern.compile(mailPattern);
        matcher=pattern.matcher(email);
        System.out.println(matcher.matches()+"---->mail");
        return matcher.matches();
    }
    public boolean validateName(String name){
        pattern=Pattern.compile(namePattern);
        matcher=pattern.matcher(name);
        System.out.println(matcher.matches()+" ---->name");
        return matcher.matches();
    }
    public boolean validateMobile(String mobile){
        pattern=Pattern.compile(mobilePattern);
        matcher=pattern.matcher(mobile);
        System.out.println(matcher.matches() + " ---->mobile");
        return matcher.matches();
    }
    public boolean validatePassword(String password){
        return true;
    }
    private enum UserTypes{
        seller,buyer,admin
    }
    public boolean validateUserType(String type){
//        System.out.println(UserTypes.buyer.toString());
        if(type.equals("buyer") || type.equals("seller") || type.equals("admin")){
            System.out.println("type ---> true");
            return true;
        }
        else{
            System.out.println("type ---> false");
            return false;
        }

    }
    public boolean validate(UserDTO user){
        if(validateName(user.getFullname())&& validateEmail(user.getEmail()) &&validateMobile(user.getMobile()) &&validateUserType(user.getType()))
            return true;
        else
            return false;
    }
}
