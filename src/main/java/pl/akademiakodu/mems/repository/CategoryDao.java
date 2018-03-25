package pl.akademiakodu.mems.repository;

import pl.akademiakodu.mems.model.Category;
import pl.akademiakodu.mems.model.Gif;

import java.util.List;

public interface CategoryDao {
    List<Category> findAll();
    List<Category> findById(Long id);
    Category categoryById(Long id);
    boolean ifIsCategory(String q);
    Category findByCategory(String q);

}
