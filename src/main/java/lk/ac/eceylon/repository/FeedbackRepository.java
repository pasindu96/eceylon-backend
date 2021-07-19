package lk.ac.eceylon.repository;

import lk.ac.eceylon.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FeedbackRepository extends JpaRepository<Feedback,Integer> {
     List<Feedback> findFeedbackByProductProductID(@Param("productid") Integer productid);
}
