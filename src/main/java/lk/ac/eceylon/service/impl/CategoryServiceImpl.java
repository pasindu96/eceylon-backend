package lk.ac.eceylon.service.impl;

import lk.ac.eceylon.dto.CategoryDTO;
import lk.ac.eceylon.entity.Category;
import lk.ac.eceylon.entity.User;
import lk.ac.eceylon.repository.CategoryRepository;
import lk.ac.eceylon.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(propagation = Propagation.SUPPORTS, readOnly =  true)
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
    @Transactional(propagation = Propagation.REQUIRED)
    public boolean saveCategory(CategoryDTO categoryDTO) {
        User user=new User();
        user.setEmail(categoryDTO.getUser().getEmail());
        Category category= new Category();
        category.setCategory(categoryDTO.getCategory());
        category.setUser(user);
        if(categoryRepository.save(category)!=null)
            return true;
        else
            return false;
    }
}
