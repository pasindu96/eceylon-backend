package lk.ac.eceylon.entity;

import javax.persistence.*;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int categoryID;
    private String category;

    @ManyToOne(optional = false)
    @JoinColumn(name="email")
    private User user;

    public Category() {
    }

    public Category(String category, User user) {
        this.category = category;
        this.user = user;
    }

    public int getCategoryID() {
        return categoryID;
    }

    public void setCategoryID(int categoryID) {
        this.categoryID = categoryID;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Category{" +
                "categoryID=" + categoryID +
                ", category='" + category + '\'' +
                ", user=" + user +
                '}';
    }

}
