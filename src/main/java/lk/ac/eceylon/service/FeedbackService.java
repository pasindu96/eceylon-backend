package lk.ac.eceylon.service;

import lk.ac.eceylon.entity.Feedback;

import java.util.List;

public interface FeedbackService {
    public boolean saveFeedback(Feedback feedback);
    public List<Feedback> viewFeedback(int productid);
}
