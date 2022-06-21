package com.tsi.omar.butt.program;

import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface FilmRepository extends CrudRepository<Film,Integer> {
    Iterable<Film> findByTitleLike(String title);
}
