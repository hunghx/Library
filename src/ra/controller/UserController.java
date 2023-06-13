package ra.controller;

import ra.model.User;
import ra.service.UserService;

public class UserController {
    private UserService userService = new UserService();
    public User[] getAll(){
        return userService.getAll();
    }
    public void save(User user){
        userService.save(user);
    }
    public User findById(int id){
        return userService.findById(id);
    }
    public void delete(int id){
        userService.delete(id);
    }
    public  int getSize(){
        return userService.getSize();
    }
    public User login(String username, String password){
        return userService.login(username,password);
    }
    public int getNewId(){
        return userService.getNewId();
    }
}
