package pl.akademiakodu.mems.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import pl.akademiakodu.mems.model.Gif;
import pl.akademiakodu.mems.repository.CategoryDao;
import pl.akademiakodu.mems.repository.GifDAO;

import org.springframework.web.bind.annotation.RequestParam;


import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {


    @Autowired
    private GifDAO gifDAO;

    @Autowired
    private CategoryDao categoryDao;

    @GetMapping("/")
    public String main(ModelMap modelMap) {
        modelMap.put("gifs", gifDAO.findAll());
        return "home";
    }

    @GetMapping("gif/{name}")
    public String edit(@PathVariable String name, ModelMap modelMap) {
        modelMap.put("gif", gifDAO.findByName(name));
        return "gif-details";
    }

    @GetMapping("/favorites")
    public String favorites(ModelMap modelMap) {
        List<Gif> favorites = new ArrayList<>();
        for (Gif gifs : gifDAO.findAll()) {
            if (gifs.isFavorite()) {
                favorites.add(gifs);
            }
        }
        modelMap.put("gifs", favorites);
        return "favorites";
    }


    @GetMapping("/search")
    public String search(@RequestParam String q, ModelMap modelMap) {
        if (categoryDao.ifIsCategory(q)) {
            return "redirect:/category/" + categoryDao.findByCategory(q).getId();
        }
        List<Gif> gifList = gifDAO.searchByName(q);
        if (gifList.isEmpty()) {
            modelMap.put("message", "Nie znaleziono memu");
        } else {
            modelMap.put("gifs", gifList);
            System.out.println(gifDAO.toString());
            System.out.println(gifList);
        }
        return "home";
    }

    private String toString(GifDAO gifDAO) {
        return "HomeController{" +
                "gifDAO=" + gifDAO +
                '}';
    }


}
