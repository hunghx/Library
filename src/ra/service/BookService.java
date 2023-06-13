package ra.service;


import ra.model.Book;

public class BookService {
    private Book[] listBooks = new Book[100];
    private int size;
    public Book[] getAll(){
        return listBooks;
    }

    public BookService() {

    }

    public int getSize(){
        return size;
    }
    public boolean save(Book cat){
        // add
        if (findById(cat.getId())==null){
            if (size==listBooks.length){
                System.err.println("Danh sách danh muc quá số lương, vui lòng them moi sau");
                return false;
            }else {
                for (int i = 0; i < listBooks.length; i++) {
                    if(listBooks[i]==null){
                        listBooks[i] = cat;
                        break;
                    }
                }
                System.out.println("Thêm mới thành công");
                size++;
                return true;
            }
        }else {
            // update
            for (int i = 0; i < listBooks.length; i++) {
                if (listBooks[i]!=null&& listBooks[i].getId()== cat.getId()){
                    listBooks[i] = cat;
                    break;
                }
            }
            System.out.println("Cập nhật thành công");
            return true;
        }
    }
    public Book findById(int id){
        for (Book cat:listBooks) {
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
            for (int i = 0; i < listBooks.length ; i++) {
                if (listBooks[i]!=null&& listBooks[i].getId()== id){
                    listBooks[i] = null;
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
        for (Book cat: listBooks) {
            if(cat!= null ){
                if (cat.getId()>= max){
                    max = cat.getId();
                }
            }
        }
        return max+1;
    }
    public boolean checkExistBookByCategoryId(int idCat){
        for (Book book:listBooks
             ) {
            if(book!=null){
                if (book.getCategory().getId()==idCat){
                    return true;
                }
            }
        }
        return false;
    }
}
