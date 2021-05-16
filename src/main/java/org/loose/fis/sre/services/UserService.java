package org.loose.fis.sre.services;
import org.dizitart.no2.Nitrite;
import org.dizitart.no2.objects.ObjectRepository;
import org.loose.fis.sre.exceptions.FieldNotCompletedException;
import org.loose.fis.sre.exceptions.PasswordConfirmationException;
import org.loose.fis.sre.exceptions.UsernameAlreadyExistsException;
import org.loose.fis.sre.exceptions.UsernameDoesNotExistsException;
import org.loose.fis.sre.exceptions.WeakPasswordException;
import org.loose.fis.sre.exceptions.WrongPasswordException;
import org.loose.fis.sre.model.User;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

import static org.loose.fis.sre.services.FileSystemService.getPathToFile;

public class UserService {

    private static ObjectRepository<User> userRepository;

    public static void initDatabase() {
        Nitrite database = Nitrite.builder()
                .filePath(getPathToFile("registration-example.db").toFile())
                .openOrCreate("test", "test");

        userRepository = database.getRepository(User.class);
    }


    public static void addUser(String username, String password, String passwordconfirm, String firstname,
                               String secondname, String phonenumber, String address,String email,String role)  throws UsernameAlreadyExistsException, FieldNotCompletedException,PasswordConfirmationException,WeakPasswordException {
        UserDoesNotAlreadyExist(username);
        FieldsCompleted(username, password, firstname, passwordconfirm, secondname,phonenumber,address);
        PasswordformatException(password);
        PasswordsMach(password, passwordconfirm);
        userRepository.insert(new User(username, encodePassword(username, password),encodePassword(username, passwordconfirm), firstname, secondname, phonenumber,  address,email,role));
    }

    private static void UserDoesNotAlreadyExist(String username) throws UsernameAlreadyExistsException {
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                throw new UsernameAlreadyExistsException(username);
        }
    }
    public static void PasswordsMach(String password, String passwordconfirm) throws PasswordConfirmationException {
        if (!password.trim().equals(passwordconfirm.trim())) {
            throw new PasswordConfirmationException();
        }
    }

    private static String encodePassword(String salt, String password) {
        MessageDigest md = getMessageDigest();
        md.update(salt.getBytes(StandardCharsets.UTF_8));

        byte[] hashedPassword = md.digest(password.getBytes(StandardCharsets.UTF_8));

        // This is the way a password should be encoded when checking the credentials
        return new String(hashedPassword, StandardCharsets.UTF_8)
                .replace("\"", "");
    }

    private static MessageDigest getMessageDigest() {
        MessageDigest md;
        try {
            md = MessageDigest.getInstance("SHA-512");
        } catch (NoSuchAlgorithmException e) {
            throw new IllegalStateException("SHA-512 does not exist!");
        }
        return md;}
        public static ObjectRepository<User>  getUsers(){
            return  userRepository;
        }
    public static void loginUser(String username, String password,String role) throws UsernameDoesNotExistsException, WrongPasswordException {
        checkUserDoesAlreadyExist(username);
        checkPassword(password,username);
    }
    public static void checkPassword(String password, String username) throws WrongPasswordException {
        int ok=0;
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername())) {
                if (Objects.equals(encodePassword(username,password), user.getPassword())) {
                    ok = 1;
                }
            }
        }
        if(ok==0) {
            throw new WrongPasswordException();
        }
    }
    public static void checkUserDoesAlreadyExist(String username) throws UsernameDoesNotExistsException {
        int ok=0;
        for (User user : userRepository.find()) {
            if (Objects.equals(username, user.getUsername()))
                ok=1;
        }
        if(ok==0){
            throw new UsernameDoesNotExistsException();
        }
    }
    public static void FieldsCompleted(String username, String password, String firstname,String secondname, String passwordconfirm
                                              , String phonenumber,String address) throws FieldNotCompletedException {
        if (username.trim().isEmpty() || password.trim().isEmpty()|| firstname.trim().isEmpty() || secondname.trim().isEmpty() ||
                passwordconfirm.trim().isEmpty()|| phonenumber.trim().isEmpty() || address.trim().isEmpty()) {
            throw new FieldNotCompletedException();
        }
    }
    public static void PasswordformatException(String password) throws WeakPasswordException {
        if (password.length()<6)
            throw new WeakPasswordException();
    }

    public static ObjectRepository<User>  getUserRepository(){
        return userRepository;
    }

}