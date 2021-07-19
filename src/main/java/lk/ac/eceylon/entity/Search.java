package lk.ac.eceylon.entity;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
public class Search {

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int searchID;
    private String searchItem;
    @CreationTimestamp
    private Timestamp dateTime;
    private int categoryID;
    @ManyToOne(optional = false)
    @JoinColumn(name="email")
    private User user;

    public Search() {
    }

    public Search(String searchItem, Timestamp dateTime, int categoryID, User user) {
        this.searchItem = searchItem;
        this.dateTime = dateTime;
        this.categoryID = categoryID;
        this.user = user;
    }

    public int getSearchID() {
        return searchID;
    }

    public void setSearchID(int searchID) {
        this.searchID = searchID;
    }

    public String getSearchItem() {
        return searchItem;
    }

    public void setSearchItem(String searchItem) {
        this.searchItem = searchItem;
    }

    public Timestamp getDateTime() {
        return dateTime;
    }

    public void setDateTime(Timestamp dateTime) {
        this.dateTime = dateTime;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Search{" +
                "searchID=" + searchID +
                ", searchItem='" + searchItem + '\'' +
                ", dateTime='" + dateTime + '\'' +
                ", categoryID=" + categoryID +
                ", user=" + user +
                '}';
    }
}
