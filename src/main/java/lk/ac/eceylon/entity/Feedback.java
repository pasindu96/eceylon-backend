package lk.ac.eceylon.entity;

import javax.persistence.*;

@Entity
public class Feedback {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int feedbackID;

    @ManyToOne(optional = false)
    @JoinColumn(name="productid")
    private Product product;

    @ManyToOne(optional = false)
    @JoinColumn(name="email")
    private User user;

    private String feedback;

    public Feedback() {
    }

    public Feedback(Product product, User user, String feedback) {
        this.product = product;
        this.user = user;
        this.feedback = feedback;
    }

    public int getFeedbackID() {
        return feedbackID;
    }

    public void setFeedbackID(int feedbackID) {
        this.feedbackID = feedbackID;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "feedbackID=" + feedbackID +
                ", product=" + product +
                ", user=" + user +
                ", feedback='" + feedback + '\'' +
                '}';
    }
}
