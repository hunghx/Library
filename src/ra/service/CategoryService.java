package ra.service;

import ra.model.Category;
import ra.model.User;

public class CategoryService {
    private Category[] listCategories = new Category[100];
    private int size;
    public Category[] getAll(){
        return listCategories;
    }
    public int getSize(){
        return size;
    }
    public boolean save(Category cat){
        // add
        if (findById(cat.getId())==null){
            if (size==listCategories.length){
                System.err.println("Danh sách danh muc quá số lương, vui lòng them moi sau");
                return false;
            }else {
                for (int i = 0; i < listCategories.length; i++) {
                    if(listCategories[i]==null){
                        listCategories[i] = cat;
                        break;
                    }
                }
                System.out.println("Thêm mới thành công");
                size++;
                return true;
            }
        }else {
            // update
            for (int i = 0; i < listCategories.length; i++) {
                if (listCategories[i]!=null&& listCategories[i].getId()== cat.getId()){
                    listCategories[i] = cat;
                    break;
                }
            }
            System.out.println("Cập nhật thành công");
            return true;
        }
    }
    public Category findById(int id){
        for (Category cat:listCategories) {
            if (cat!=null) {
                if (cat.getId() == id) {
                    return cat;
                }
            }
        }
        return null;
    }
    public boolean delete(int id){
        if (findById(id) != null){
            for (int i = 0; i < listCategories.length ; i++) {
                if (listCategories[i]!=null&& listCategories[i].getId()== id){
                    listCategories[i] = null;
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

    public  int getNewId(){
        int max = 0;
        for (Category cat: listCategories) {
            if(cat!= null ){
                if (cat.getId()>= max){
                    max = cat.getId();
                }
            }
        }
        return max+1;
    }
}
