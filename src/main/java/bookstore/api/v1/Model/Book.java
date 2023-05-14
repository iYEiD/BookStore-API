package bookstore.api.v1.Model;
import java.util.Date;

public class Book {
private String id;
private String title;
private String author;
private double price;
private Date releaseDate;
private int stock;
private boolean availability;



public String getId() {
    return id;
}

public void setId(String id) {
    this.id = id;
}

public String getTitle() {
    return title;
}

public void setTitle(String title) {
    this.title = title;
}

public String getAuthor() {
    return author;
}

public void setAuthor(String author) {
    this.author = author;
}

public double getPrice() {
    return price;
}

public void setPrice(double price) {
    this.price = price;
}


public Date getReleaseDate(){
    return releaseDate;
}

public void setReleaseDate(int year , int month , int day){
    Date temp= new Date(year,month,day);
    releaseDate=temp;
}

public int getStock(){
    return stock;
}
public void setStock(int stock){
this.stock=stock;
}

public boolean getAvailability(){
    if(this.stock <= 0)return false;
    return availability;
}

public void setAvailability(){
    if(this.stock <= 0) this.availability = false;
    else this.availability = true;
}

public void setAvailability(boolean availability){
    this.availability = availability;
}


}



