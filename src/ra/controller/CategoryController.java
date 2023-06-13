package ra.controller;

import ra.model.Category;
import ra.service.CategoryService;

public class CategoryController {
    private CategoryService categoryService = new CategoryService();
    public Category[] getAll(){
        return categoryService.getAll();
    }
    public void save(Category cat){
        categoryService.save(cat);
    }
    public Category findById(int id){
        return categoryService.findById(id);
    }
    public void delete(int id){
        categoryService.delete(id);
    }
    public  int getSize(){
        return categoryService.getSize();
    }

    public int getNewId(){
        return categoryService.getNewId();
    }
}
