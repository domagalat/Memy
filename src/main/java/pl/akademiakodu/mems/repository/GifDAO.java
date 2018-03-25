package pl.akademiakodu.mems.repository;

import org.springframework.stereotype.Component;
import pl.akademiakodu.mems.model.Gif;

import java.util.List;

/**
 * Created by TomDom on 2018-03-19.
 */

public interface GifDAO{
    List<Gif> findAll();
    Gif findByName(String name);
    List<Gif> searchByName(String q);
    List<Gif> findById(Long id);
    String toString();



}
