package com.tsi.omar.butt.program;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface FilmCategoryRepository extends CrudRepository<FilmCategory,Integer> {
    List<FilmCategory> findByCategoryId (int categoryId);
}
