package lk.ac.eceylon.service;

import lk.ac.eceylon.entity.Search;

public interface SearchService {

    boolean saveSearchResults(Search search);
    int mostSearchedCategory(String email);
    String mostSearchedCategory();

}
