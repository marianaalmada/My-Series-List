package com.myserieslist.serieslist.Service;

import java.util.List;

import com.myserieslist.serieslist.Entity.Category;
import com.myserieslist.serieslist.Entity.Serie;
import com.myserieslist.serieslist.Exception.SerieExistsInCategory;
import com.myserieslist.serieslist.Repository.CategoryRepository;
import com.myserieslist.serieslist.Repository.SerieRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoryService {

    private final CategoryRepository categoryRepository;
    private final SerieRepository serieRepository;

    @Autowired
    public CategoryService(CategoryRepository categoryRepository, SerieRepository serieRepository) {
        this.categoryRepository = categoryRepository;
        this.serieRepository = serieRepository;
    }

    public Category createCategory(Category category) {
        return categoryRepository.save(category);
    }

    public List<Category> findAllCategories() {
        return categoryRepository.findAll();
    }

    public Category findCategoryById(Long categoryId) {
        return categoryRepository.findById(categoryId).get();
    }

    public void deleteCategory(Long categoryId) {
        categoryRepository.deleteById(categoryId);
    }

    public Category updateCategory(Long categoryId, Category newCategory) {
        Category category = categoryRepository.findById(categoryId).get();
        category.setName(newCategory.getName());
        return categoryRepository.save(category);
    }

    public Category updateCategory(Long categoryId, Long serieId) {
        Category category = categoryRepository.findById(categoryId).get();
        Serie serie = serieRepository.findById(serieId).get();
        if (categoryRepository.findByIdAndSeries(categoryId, serie).isPresent()) {
            throw new SerieExistsInCategory("The serie already exists in Category");
        } else {
            category.addSerie(serie);
            return categoryRepository.save(category);
        }
        
    }

    public void removeSerie(Long categoryId, Long serieId) {
        Category category = categoryRepository.findById(categoryId).get();
        Serie serie = serieRepository.findById(serieId).get();
        category.removeSerie(serie);
        categoryRepository.save(category);
    }
}
