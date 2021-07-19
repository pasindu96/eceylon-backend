package lk.ac.eceylon.service.impl;

import lk.ac.eceylon.entity.Feedback;
import lk.ac.eceylon.repository.FeedbackRepository;
import lk.ac.eceylon.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly =  true)
public class FeedbackServiceImpl implements FeedbackService {

    @Autowired
    FeedbackRepository feedbackRepository;

    @Override
    public boolean saveFeedback(Feedback feedback) {
        if(feedbackRepository.save(feedback)!=null)
            return true;
        else
            return false;
    }

    @Override
    public List<Feedback> viewFeedback(int productid) {
        return feedbackRepository.findFeedbackByProductProductID(productid);
    }
}
