package lk.ac.eceylon.repository;

import lk.ac.eceylon.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoryRepository extends JpaRepository<Category,Integer> {
    @Query(value="select categoryID from Category", nativeQuery=true)
    List<Integer>  getCategoryID();
}
