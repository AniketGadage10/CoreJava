package com.app.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.entities.Catagory;
import com.app.entities.series;

@Repository
public interface Seriesrepo extends JpaRepository<series, Long> {

	List<series> findByCname(Catagory c);
}
