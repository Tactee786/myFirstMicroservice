package com.tsi.omar.butt.program;

import org.springframework.data.repository.CrudRepository;

public interface FilmRepository extends CrudRepository<Film,Integer> {
    Iterable<Film> findByTitleLike(String title);
}
