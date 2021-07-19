package lk.ac.eceylon.controller;

import lk.ac.eceylon.entity.Product;
import lk.ac.eceylon.entity.Search;
import lk.ac.eceylon.repository.CategoryRepository;
import lk.ac.eceylon.repository.SearchRepository;
import lk.ac.eceylon.service.CategoryService;
import lk.ac.eceylon.service.ProductService;
import lk.ac.eceylon.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="api/eceylon")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ProductService productService;

    @PostMapping(value="/search",consumes = MediaType.APPLICATION_JSON_VALUE,
    produces=MediaType.APPLICATION_JSON_VALUE)
    public int saveSearch(@RequestBody Search search){
        System.out.println(search);
        int catID=0;
        List<Product> products= productService.getCategoryByProductName(search.getSearchItem());
        catID = products.get(0).getCategory().getCategoryID();
        if(catID!=0){
            search.setCategoryID(catID);
            searchService.saveSearchResults(search);
        }
        System.out.println(catID);
        return catID;
    }

    @GetMapping(value="/search/category")
    public String test(){
        return searchService.mostSearchedCategory();
    }
}
