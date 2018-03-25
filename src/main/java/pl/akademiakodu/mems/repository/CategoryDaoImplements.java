package pl.akademiakodu.mems.repository;

import org.springframework.stereotype.Component;
import pl.akademiakodu.mems.model.Category;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryDaoImplements implements CategoryDao{


    static List<Category> categoryById = new ArrayList<>();
    static List<Category> categories = new ArrayList<>();

    @Override
    public List<Category> findAll() {
        return categories;
    }

    static {
        categories.add(new Category(1L, "Android"));
        categories.add(new Category(2L, "Funny"));
        categories.add(new Category(3L, "Programming"));

    }


    public CategoryDaoImplements(){
    }

    @Override
    public List<Category> findById(Long id) {
        for ( Category category: categories){
            if( category.getId() == id ){
                categoryById.add(category);
                return categoryById;
            }
        }
        return null;
    }

    @Override
    public Category categoryById(Long id) {
        for ( Category category: categories){
            if( category.getId() == id ){
                return category;
            }
        }
        return null;
    }

    @Override
    public boolean ifIsCategory(String q){
        for(Category category : findAll()) {
            if (q.toLowerCase().equals(category.getName().toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Category findByCategory(String q) {
        return categories.stream().filter(c->c.getName().equals(q)).collect(Collectors.toList()).get(0);
    }

}
