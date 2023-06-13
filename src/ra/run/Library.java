package ra.run;

import ra.config.Config;
import ra.controller.BookController;
import ra.controller.CategoryController;
import ra.controller.UserController;
import ra.model.Book;
import ra.model.Category;
import ra.model.User;

import javax.jws.soap.SOAPBinding;

public class Library {
    private static UserController userController = new UserController();
    private   static BookController bookController= new BookController();
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
                case 2:
                    //  sách
                    menuBook();
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
//        Category[] listCategories = categoryController.getAll();
        if (categoryController.getSize() == 0) {
            System.err.println("danh sách trống");
        } else {
            for (Category cat : categoryController.getAll()) {
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
        if(bookController.checkExistBookByCategoryId(idDel)){
            System.err.println("danh mục có sách, không thể xóa");
            return;
        }
        categoryController.delete(idDel);

    }

        // menuBook
    public  static  void menuBook(){
        int choice=0;
        while (choice!=5) {

            System.out.println("----------------Book--------------");
            System.out.println("1. Danh sách tất cả cuốn sách");
            System.out.println("2. Thêm mới sách");
            System.out.println("3. Chỉnh sửa sách");
            System.out.println("4. Xóa sách");
            System.out.println("5. Quay lại");
            choice = Config.scanner().nextInt();
            switch (choice) {
                case 1:
                    // hiển thị danh sách sách
                    displayBook();
                    break;
                case 2:
                    // thêm mới
                    addNewBook();
                    break;
                case 3:
                    // update
                    updateBook();
                    break;

                case 4:
                    // xóa
                    deleteBook();
                    break;
                case 5:
                    break;
                default:
                    System.err.println("Nhập số từ 1 đến 5");
            }
        }
    }
    public  static void displayBook(){
        if(bookController.getSize()==0){
            System.err.println("khong co sach trong thu vien");
            return;
        }
        for (Book book: bookController.getAll()) {
            if(book!=null){
                System.out.println(book);
            }
        }
    }
    // them moi sach
    public  static  void addNewBook(){
        if (categoryController.getSize() == 0) {
            System.err.println("Bạn phải thêm danh mục trước");
            return;
        }
        System.out.println("nhập số lượng sach cần thêm mới");
        int n = Config.scanner().nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("nhập thông tin sach thứ "+ (i+1));
            Book newBook = new Book();
            int id = bookController.getNewId();
            System.out.println("Id : " +id);
            newBook.setId(id);
            System.out.println("nhập tên sach");
            newBook.setName(Config.scanner().nextLine());
            // cho phép chọn danh mục cho sách
            displayAll();
            // chọn theo id của danh mục
            while(true) {
                System.out.println("Nhập id cua danh mục");
                int categoryId = Config.scanner().nextInt();
                Category cat = categoryController.findById(categoryId);
                if(cat ==null){
                    System.err.println("Id không tôn tại, vui lòng nhập lại");
                }else {
                    newBook.setCategory(cat);
                    break;
                }
            }
            System.out.println("nhập giá");
            newBook.setPrice(Config.scanner().nextDouble());
            System.out.println("nhập tên tác giả");
            newBook.setAuthorName(Config.scanner().nextLine());
            System.out.println("nhập số lương");
            newBook.setQuantity(Config.scanner().nextInt());
            System.out.println("nhập tổng số trang");
            newBook.setTotalPage(Config.scanner().nextInt());
            // lưu nó vào listBook
            bookController.save(newBook);

        }
    }
    public static  void  updateBook(){
        System.out.println("Nhập vào id cần sửa");
        int id = Config.scanner().nextInt();
        Book bookEdit = bookController.findById(id);
        if(bookEdit==null){
            System.err.println("id không tồn tại ");
            return;
        }
        // cho phép người dùng sửa
        System.out.println("nhập tên sach moi");
        bookEdit.setName(Config.scanner().nextLine());
        // cho phép chọn danh mục cho sách
        displayAll();
        // chọn theo id của danh mục
        while(true) {
            System.out.println("Nhập id cua danh mục moi");
            int categoryId = Config.scanner().nextInt();
            Category cat = categoryController.findById(categoryId);
            if(cat ==null){
                System.err.println("Id không tôn tại, vui lòng nhập lại");
            }else {
                bookEdit.setCategory(cat);
                break;
            }
        }
        System.out.println("nhập giá moi");
        bookEdit.setPrice(Config.scanner().nextDouble());
        System.out.println("nhập tên tác giả moi");
        bookEdit.setAuthorName(Config.scanner().nextLine());
        System.out.println("nhập số lương moi");
        bookEdit.setQuantity(Config.scanner().nextInt());
        System.out.println("nhập tổng số trang moi");
        bookEdit.setTotalPage(Config.scanner().nextInt());
        // lưu thay đổi
        bookController.save(bookEdit);
    }
    /// xóa
    public static void deleteBook(){
        System.out.println(" hãy nhập vào id của sach muốn xóa");
        int idDel = Config.scanner().nextInt();
        // cho phép xóa
        bookController.delete(idDel);
    }
}
