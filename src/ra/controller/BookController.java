package ra.controller;

import ra.model.Book;
import ra.service.BookService;

public class BookController {
    private BookService bookService = new BookService();
    public Book[] getAll(){
        return bookService.getAll();
    }
    public void save(Book cat){
        bookService.save(cat);
    }
    public Book findById(int id){
        return bookService.findById(id);
    }
    public void delete(int id){
        bookService.delete(id);
    }
    public  int getSize(){
        return bookService.getSize();
    }

    public int getNewId(){
        return bookService.getNewId();
    }
    public  boolean checkExistBookByCategoryId(int idCat){
        return bookService.checkExistBookByCategoryId(idCat);
    }
}
