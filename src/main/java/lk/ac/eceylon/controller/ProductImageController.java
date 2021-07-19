package lk.ac.eceylon.controller;

import lk.ac.eceylon.dto.ProductDTO;
import lk.ac.eceylon.entity.ProductImage;
import lk.ac.eceylon.service.ProductImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value = "api/eceylon")
public class ProductImageController {

    @Autowired
    private ProductImageService productImageService;

    @PostMapping(value="/image",consumes= MediaType.APPLICATION_JSON_VALUE,
            produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean saveProduct(@RequestBody ProductImage productImage){
        return productImageService.saveImages(productImage);
    }

    @GetMapping(value="/image/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<ProductImage> productDescription(@PathVariable("id") String id){
        return productImageService.getProduct(Integer.parseInt(id.replace("id=", "")));
    }

    @GetMapping(value="/get/image/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> productImages(@PathVariable("id") String id){
        List<String> imageList=new ArrayList<String>();
        for (ProductImage image : productImageService.getProduct(Integer.parseInt(id.replace("id=", "")))) {
            System.out.println("./"+image.getImageurl());
            imageList.add(image.getImageurl().replace("resources/",""));
        }

        return imageList;
    }

    class image{
        private String url;

        public image(String url) {
            this.url = url;
        }

        public image() {
        }

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }
    }

    @GetMapping(value="/get/image/test/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public List<image> productImagesList(@PathVariable("id") String id){
        List<String> imageList=new ArrayList<String>();
        List<image> test=new ArrayList<image>();

        for (ProductImage image : productImageService.getProduct(Integer.parseInt(id.replace("id=", "")))) {
            System.out.println("./"+image.getImageurl());
            imageList.add(image.getImageurl().replace("resources/","./resources/"));
            test.add(new image(image.getImageurl()));
        }

//        return imageList;
        return test;
    }

}
