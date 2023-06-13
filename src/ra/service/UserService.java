package ra.service;

import ra.model.User;

public class UserService {
   private User[] lisUsers = new User[100];
   private int size = 0;

   public UserService(){
       User user = new User(1,"hunghx","123456",1);
       lisUsers[0] = user;
       size++;
   }
   public User[] getAll(){
       return lisUsers;
   }
   public int getSize(){
       return size;
   }
   public boolean save(User user){
       // add
       if (findById(user.getId())==null){
           if (size==lisUsers.length){
               System.err.println("Danh sách người dùng quá số lương, vui lòng đăng kí sau");
               return false;
           }else {
               for (int i = 0; i < lisUsers.length; i++) {
                   if(lisUsers[i]==null){
                       lisUsers[i] = user;
                       break;
                   }
               }
               System.out.println("Thêm mới thành công");
               size++;
               return true;
           }
       }else {
           // update
           for (int i = 0; i < lisUsers.length; i++) {
               if (lisUsers[i]!=null&& lisUsers[i].getId()== user.getId()){
                   lisUsers[i] = user;
                   break;
               }
           }
           System.out.println("Cập nhật thành công");
           return true;
       }
   }
   public User findById(int id){
       for (User user:lisUsers) {
           if (user!=null) {
               if (user.getId() == id) {
                   return user;
               }
           }
       }
       return null;
   }
   public boolean delete(int id){
       if (findById(id) != null){
           for (int i = 0; i < lisUsers.length ; i++) {
               if (lisUsers[i]!=null&& lisUsers[i].getId()== id){
                   lisUsers[i] = null;
                   break;
               }
           }
           size--;
           System.out.println("Xóa thành công");
           return true;
       }
       System.out.println("không tìm thấy id cần xóa");
       return false;

   }
   public User login(String username, String password){
       for (User user: lisUsers) {
           if (user!=null && user.getUserName().equalsIgnoreCase(username)&& user.getPassword().equalsIgnoreCase(password)){
               return user;
           }
       }
       return null;
   }
   public  int getNewId(){
       int max = 0;
       for (User user: lisUsers) {
           if(user!= null ){
               if (user.getId()>= max){
                   max = user.getId();
               }
           }
       }
       return max+1;
   }
}
