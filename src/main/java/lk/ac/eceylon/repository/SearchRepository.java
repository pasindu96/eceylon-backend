package lk.ac.eceylon.repository;

import lk.ac.eceylon.entity.Search;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SearchRepository extends JpaRepository<Search,Integer> {
    List<Search> findSearchByUserEmail(@Param("email") String email);
    int countSearchByCategoryIDEquals(int categoryID);
}
