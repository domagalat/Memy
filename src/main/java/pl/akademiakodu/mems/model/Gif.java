package pl.akademiakodu.mems.model;

import pl.akademiakodu.mems.repository.GifDAO;

/**
 * Created by TomDom on 2018-03-19.
 */
public class Gif{

    private Long id;

    private String name;

    private String userName;

    private Long idCategory;

    private boolean isFavorite;

    public boolean isFavorite() {
        return isFavorite;
    }

    public void setFavorite(boolean favorite) {
        isFavorite = favorite;
    }


    public void setName(String name) {
        this.name = name;
    }

    public Long getIdCategory() {
        return idCategory;
    }


    public void setIdCategory(Long idCategory) {
        this.idCategory = idCategory;
    }

    public Gif(){}


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }


    public Gif(Long id, String name, String userName, Long idCategory, boolean isFavorite) {
        this.id = id;
        this.name = name;
        this.userName = userName;
        this.idCategory = idCategory;
        this.isFavorite = isFavorite;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getGifPath() {
        return "/gifs/" + getName() + ".gif";
    }



    @Override
    public String toString() {
        return "Gif{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", userName='" + userName + '\'' +
                ", idCategory=" + idCategory +
                ", isFavorite=" + isFavorite +
                '}';
    }
}
