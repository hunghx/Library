package ra.run;

import ra.config.Config;
import ra.controller.UserController;
import ra.model.User;

import javax.jws.soap.SOAPBinding;

public class Library {
    private static UserController userController = new UserController();
    private static User[] listUsers ;
    public static void main(String[] args) {
        listUsers = userController.getAll();
        System.out.println("----------------LIBRARY--------------");
        System.out.println("1. Đăng nhâp");
        System.out.println("2. Đăng kí");
        System.out.println("3. Thoát");
        int choice = Config.scanner().nextInt();
        switch (choice){
            case 1:
                // login
                login();
                break;
            case 2:
                    // register
                register();
                break;
            case 3 :
                System.out.println("Good Bye");
                System.exit(0);
                break;
            default:
                System.err.println("Vui lòng nhập 1 số từ 1 đến 3");
        }
    }
    public  static  void login(){
        System.out.println("Nhập username :");
        String username = Config.scanner().nextLine();
        System.out.println("Nhập password :");
        String password = Config.scanner().nextLine();
        User userLogin = userController.login(username,password);
        if(userLogin == null){
            System.err.println(" Sai tài khoản hoặc mật khẩu vui lòng thử lại");

        }else {
            if (userLogin.getRole()==1){
                // admin => menu admin
                System.out.println(" đây là trang admin");
                menuAdmin();
                Config.scanner().nextLine();
            }else {
                // user => menu user
                System.out.println(" đây là trang user");
                Config.scanner().nextLine();
            }
        }
    }
    public  static  void register(){
        User newUser = new User();
        int id = userController.getNewId();
        System.out.println("New ID : "+id);
        newUser.setId(id);
        System.out.println("Nhập username :");
        newUser.setUserName(Config.scanner().nextLine());
        System.out.println("Nhập password :");
        newUser.setPassword(Config.scanner().nextLine());
        System.out.println("Nhập fulllname :");
        newUser.setFullName(Config.scanner().nextLine());
        System.out.println("Nhập phoneNumber :");
        newUser.setPhoneNumber(Config.scanner().nextLine());
        System.out.println("Nhập email :");
        newUser.setEmail(Config.scanner().nextLine());
        userController.save(newUser);
        login();
    }
    public static  void menuAdmin(){
        System.out.println("----------------ADMIN--------------");
        System.out.println("1. Quản lí Danh mục");
        System.out.println("2. Quản lý sách");
        System.out.println("3. Quản lí tài khoản");
        System.out.println("4. Lịch sử mượn trả sách");
        System.out.println("5. Đăng xuất");
        int choice = Config.scanner().nextInt();
        switch (choice){
            case 1:
                // danh mục
                menuCategory();
                break;
            default:
                System.err.println("Nhập số từ 1 đến 5");
        }
    }

    // menu quản trị danh mục
    public static void menuCategory(){
        System.out.println("----------------Category--------------");
        System.out.println("1. Danh sách danh mục");
        System.out.println("2. Thêm mới danh mục");
        System.out.println("3. Chỉnh sửa danh mục");
        System.out.println("4. Xóa danh mục");
        System.out.println("5. Quay lại");
        int choice = Config.scanner().nextInt();
        switch (choice){
            case 1:
                // hiển thị danh sách danh mục

        }
    }
    // Hiển thị danh mục
    public


}
