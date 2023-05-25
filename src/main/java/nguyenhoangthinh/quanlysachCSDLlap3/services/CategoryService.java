package nguyenhoangthinh.quanlysachCSDLlap3.services;

import nguyenhoangthinh.quanlysachCSDLlap3.entity.Category;
import nguyenhoangthinh.quanlysachCSDLlap3.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    public List<Category> getAllCategories() {return categoryRepository.findAll();}
    public Category getCategoryById(long id){return categoryRepository.findById(id).orElse(null);}
    public Category saveCategory (Category category){return categoryRepository.save(category);}

    public void deleteCategory(long id){categoryRepository.deleteById(id);}

}
