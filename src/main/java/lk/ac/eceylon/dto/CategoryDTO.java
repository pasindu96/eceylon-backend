package lk.ac.eceylon.dto;

public class CategoryDTO {
    private int categoryID;
    private String category;
    private UserDTO user;

    public CategoryDTO(int categoryID, String category, UserDTO user) {
        this.categoryID = categoryID;
        this.category = category;
        this.user = user;
    }

    public CategoryDTO() {
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

    public UserDTO getUser() {
        return user;
    }

    public void setUser(UserDTO user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "CategoryDTO{" +
                "categoryID=" + categoryID +
                ", category='" + category + '\'' +
                ", user=" + user +
                '}';
    }
}
