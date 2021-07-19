package lk.ac.eceylon.service.impl;

import lk.ac.eceylon.entity.Category;
import lk.ac.eceylon.entity.Search;
import lk.ac.eceylon.repository.CategoryRepository;
import lk.ac.eceylon.repository.ProductRepository;
import lk.ac.eceylon.repository.SearchRepository;
import lk.ac.eceylon.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly =  true)

public class SearchServiceImpl implements SearchService {

    @Autowired
    private SearchRepository searchRepository;

    @Override
    public boolean saveSearchResults(Search search) {
        Search result=searchRepository.save(search);
        if(result!=null)
            return true;
        else
            return false;
    }

    @Override
    public int mostSearchedCategory(String email) {
        List<Search> searchResults=searchRepository.findSearchByUserEmail(email);
        List<Integer> catList=new ArrayList<Integer>();
        int searchCount=0;
        int mostSearchedCategoryID=0;
        int tempValue=0;

        for (Search search :searchResults) {
            catList.add(search.getCategoryID());
        }
        for(int i=1;i<16;i++){
            tempValue=Collections.frequency(catList,i);
            if(searchCount < tempValue){
                mostSearchedCategoryID=i;
                searchCount=tempValue;
            }
        }
        if(searchCount==0)
            return 1;
        else
            return mostSearchedCategoryID;
    }

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public String mostSearchedCategory() {
        int category=0;
        int count=0;
        int tempCount=0;
        for (int catID:categoryRepository.getCategoryID()) {
            tempCount=0;
            tempCount=searchRepository.countSearchByCategoryIDEquals(catID);
//            System.out.println(tempCount);
            if(count<tempCount){
                count=tempCount;
                category=catID;
            }
        }
        Category categoryDetails =categoryRepository.findById(category).get();
        return (categoryRepository.findById(category).get()).getCategory();
    }
}
