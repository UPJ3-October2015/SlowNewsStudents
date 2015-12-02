package net.bash.serg.slownews.model;

import org.eclipse.persistence.oxm.annotations.XmlPath;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;

@XmlRootElement(name="rss")
@XmlType(propOrder={"category", "title", "image", "link", "description"})
@XmlAccessorType(XmlAccessType.FIELD)
public class News {

     @XmlPath("channel/item/category/text()")
     private ArrayList <String> category;

     @XmlPath("channel/item/title/text()")
     private  ArrayList <String> title;

     @XmlPath("channel/item/enclosure/@url")
     private ArrayList <String> image;

     @XmlPath("channel/item/link/text()")
     private ArrayList <String> link;

    @XmlPath("channel/item/description/text()")
    private ArrayList <String> description;

     public ArrayList <String> getCategory() {
          return category;
     }

     public void setCategory(ArrayList <String> category) {
          this.category = category;
     }

     public ArrayList <String> getImage() {
          return image;
     }

     public void setImage(ArrayList <String> image) {
          this.image = image;
     }

     public ArrayList <String> getTitle() {
        return title;
    }

     public void setTitle(ArrayList <String> title) {
        this.title = title;
    }

    public ArrayList<String> getLink() {
        return link;
    }

    public void setLink(ArrayList<String> link) {
        this.link = link;
    }

    public ArrayList<String> getDescription() {
        return description;
    }

    public void setDescription(ArrayList<String> description) {
        this.description = description;
    }
}