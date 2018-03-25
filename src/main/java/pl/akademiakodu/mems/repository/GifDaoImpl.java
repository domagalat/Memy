package pl.akademiakodu.mems.repository;

import com.sun.javafx.scene.control.skin.VirtualFlow;
import org.apache.catalina.LifecycleState;
import org.springframework.stereotype.Component;
import pl.akademiakodu.mems.model.Gif;
import pl.akademiakodu.mems.repository.GifDAO;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by TomDom on 2018-03-19.
 */
@Component
public class GifDaoImpl implements GifDAO{

    static List<Gif> gifs = new ArrayList<>();
    static List<Gif> gifsByID = new ArrayList<>();
    static List<Gif> gifsByCategory = new ArrayList<>();

    static {


        gifs.add(new Gif(1L, "android-explosion","Heniek",1L, true ));
        gifs.add(new Gif(2L, "ben-and-mike","Zenek",2L, false));
        gifs.add(new Gif(3L, "book-dominos", "Tadek",3L, false));
        gifs.add(new Gif(4L, "compiler-bot", "Władek",1L, true));
        gifs.add(new Gif(5L, "cowboy-coder","Ziuta",2L, true));
        gifs.add(new Gif(6L, "infinite-andrew","Krycha",3L, false));

    }


    public GifDaoImpl() {}

    @Override
    public List<Gif> findAll(){
        return gifs;
    }

    public Gif findByName(String name) {
        for ( Gif gif: gifs){
            if( gif.getName().equals(name)){
                return gif;
            }
        }
        return null;
    }

    public List<Gif> searchByName(String q) {
        List<Gif> returnedGifs =new ArrayList<>();
        for ( Gif gif: gifs){
            if( gif.getName().contains(q)){
                returnedGifs.add(gif);
            }
        }
        return returnedGifs;
    }


    public List<Gif> findById(Long id) {
        for ( Gif gif: gifs){
            if( gif.getId() == id){
                gifsByID.add(gif);
                return gifsByID;
            }
        }
        return null;
    }



}
