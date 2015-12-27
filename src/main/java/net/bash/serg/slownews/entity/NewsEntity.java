package net.bash.serg.slownews.entity;

import javax.persistence.*;

/**
 * Created by Serg Bash on 12/20/2015.
 */
@Entity(name = "News")
public class NewsEntity implements SlowNewsEntity {
    public NewsEntity(){
    }

    public NewsEntity(long userId ,String description, String category, String title, String image, String link) {
        this.setUserid(userId);
        this.setDescription(description);
        this.setCategory(category);
        this.setTitle(title);
        this.setImage(image);
        this.setLink(link);
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(length = 500, unique = false, name = "userid")
    private long userid;

    @Column(length = 500, unique = false)
    private String category;

    @Column(length = 500, unique = false)
    private String title;

    @Column(length = 500, unique = false)
    private String image;

    @Column(length = 500, unique = false)
    private String link;

    @Column(length = 1000, unique = false)
    private String description;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public long getUserid() {
        return userid;
    }

    public void setUserid(long userid) {
        this.userid = userid;
    }
}
