package ra.run;

import ra.config.Config;
import ra.controller.CategoryController;
import ra.controller.UserController;
import ra.model.Category;
import ra.model.User;

import javax.jws.soap.SOAPBinding;

public class Library {
    private static UserController userController = new UserController();
    private static CategoryController categoryController = new CategoryController();

    public static void main(String[] args) {
        while (true) {
            System.out.println("----------------LIBRARY--------------");
            System.out.println("1. Đăng nhâp");
            System.out.println("2. Đăng kí");
            System.out.println("3. Thoát");
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    // login
                    login();

                    break;
                case 2:
                    // register
                    register();
                    break;
                case 3:
                    System.out.println("Good Bye");
                    System.exit(0);
                    break;
                default:
                    System.err.println("Vui lòng nhập 1 số từ 1 đến 3");
            }
        }
    }

    public static void login() {
        System.out.println("Nhập username :");
        String username = Config.scanner().nextLine();
        System.out.println("Nhập password :");
        String password = Config.scanner().nextLine();
        User userLogin = userController.login(username, password);
        if (userLogin == null) {
            System.err.println(" Sai tài khoản hoặc mật khẩu vui lòng thử lại");

        } else {
            if (userLogin.getRole() == 1) {
                // admin => menu admin
                System.out.println(" đây là trang admin");
                menuAdmin();
                Config.scanner().nextLine();
            } else {
                // user => menu user
                System.out.println(" đây là trang user");
                Config.scanner().nextLine();
            }
        }
    }

    public static void register() {
        User newUser = new User();
        int id = userController.getNewId();
        System.out.println("New ID : " + id);
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

    public static void menuAdmin() {
        while (true) {
            System.out.println("----------------ADMIN--------------");
            System.out.println("1. Quản lí Danh mục");
            System.out.println("2. Quản lý sách");
            System.out.println("3. Quản lí tài khoản");
            System.out.println("4. Lịch sử mượn trả sách");
            System.out.println("5. Đăng xuất");
            int choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    // danh mục
                    menuCategory();
                    break;
                case 5:
                    System.out.println("Đăng xuất");
                    break;
                default:
                    System.err.println("Nhập số từ 1 đến 5");
            }
            if (choice == 5) {
                break;
            }
        }
    }

    // menu quản trị danh mục
    public static void menuCategory() {
        int choice=0;
        while (choice!=5) {

            System.out.println("----------------Category--------------");
            System.out.println("1. Danh sách danh mục");
            System.out.println("2. Thêm mới danh mục");
            System.out.println("3. Chỉnh sửa danh mục");
            System.out.println("4. Xóa danh mục");
            System.out.println("5. Quay lại");
             choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    // hiển thị danh sách danh mục
                    displayAll();

                    break;
                case 2:
                    // thêm mới
                    addNewCategory();
                    break;
                case 3:
                    // update
                    updateCategory();
                    break;

                case 4:
                    // xóa
                    deleteCategory();
                    break;
                case 5:
                    break;
                default:
                    System.err.println("Nhập số từ 1 đến 5");
            }


        }

    }

    // Hiển thị danh mục
    public static void displayAll() {
        Category[] listCategories = categoryController.getAll();
        if (categoryController.getSize() == 0) {
            System.err.println("danh sách trống");
        } else {
            for (Category cat : listCategories) {
                if (cat != null) {
                    System.out.println(cat);
                }
            }
        }
    }
    // thêm mới
    public  static  void addNewCategory(){
        System.out.println("nhập số lượng danh mục cần thêm mới");
        int n = Config.scanner().nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("nhập thông tin danh mục thứ "+ (i+1));
            Category newCategory = new Category();
            int id = categoryController.getNewId();
            System.out.println("Id : " +id);
            newCategory.setId(id);
            System.out.println("nhập tên danh mục");
            newCategory.setName(Config.scanner().nextLine());
            System.out.println("nhập mô tả");
            newCategory.setDescriptions(Config.scanner().nextLine());
            // lưu nó vào listcategory
            categoryController.save(newCategory);
        }
    }
    public static  void  updateCategory(){
        System.out.println(" hãy nhập vào id của danh mục muốnn sửa");
        int idEdit = Config.scanner().nextInt();
        Category categoryEdit = categoryController.findById(idEdit);
        if (categoryEdit!= null){
            // có ton tại , cho phép chỉnh sửa
            System.out.println("nhập tên danh mục mới");
            categoryEdit.setName(Config.scanner().nextLine());
            System.out.println("nhập mô tả mới");
            categoryEdit.setDescriptions(Config.scanner().nextLine());
            categoryController.save(categoryEdit);
        }else {
            System.err.println("Id không tồn tại");
        }
    }
    public static void deleteCategory(){
        System.out.println(" hãy nhập vào id của danh mục muốn xóa");
        int idDel = Config.scanner().nextInt();
        // cho phép xóa
        categoryController.delete(idDel);
    }


}
