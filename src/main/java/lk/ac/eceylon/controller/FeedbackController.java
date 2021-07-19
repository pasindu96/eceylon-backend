package lk.ac.eceylon.controller;

import lk.ac.eceylon.entity.Feedback;
import lk.ac.eceylon.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/eceylon")
public class FeedbackController {

    @Autowired
    private FeedbackService feedbackService;

    @PostMapping(value="/feedback" ,consumes= MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveFeedback(@RequestBody Feedback feedback){
        return feedbackService.saveFeedback(feedback);
    }

    @GetMapping(value = "/feedback/{productid}",produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Feedback> viewFeedback(@PathVariable String productid) {
        return feedbackService.viewFeedback(Integer.parseInt(productid));
    }



}
