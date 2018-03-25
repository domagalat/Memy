package pl.akademiakodu.mems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import pl.akademiakodu.mems.model.Category;
import pl.akademiakodu.mems.model.Gif;
import pl.akademiakodu.mems.repository.CategoryDao;
import pl.akademiakodu.mems.model.Gif;
import pl.akademiakodu.mems.repository.GifDAO;

import java.util.ArrayList;
import java.util.List;


@Controller
public class CategoryController {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private GifDAO gifDAO;

    @GetMapping("/categories")
    public String findAll(ModelMap modelMap){
        modelMap.put("categories", categoryDao.findAll());
                return "categories";
    }

    @GetMapping("/category/{id}")
    public String getCategory(@PathVariable Long id, ModelMap modelMap) {
        modelMap.put("category", categoryDao.categoryById(id));
        List<Gif> gifsByCategory = new ArrayList<>();
        for (Gif gifs : gifDAO.findAll()) {
            if (gifs.getIdCategory()==id) {
                gifsByCategory.add(gifs);
            }
        }
        modelMap.put("gifs", gifsByCategory);
        System.out.println(categoryDao.categoryById(id));

        return "category";
    }

    @GetMapping("/find")
    public String main(ModelMap modelMap) {
        modelMap.put("gifs", gifDAO.findAll());
        return "category";
    }
}
