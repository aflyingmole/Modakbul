package com.modakbul.repository.freeboard;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import com.modakbul.entity.freeboard.Freeboard;

public interface FreeboardRepository extends JpaRepository<Freeboard, Long> {
	
	Page<Freeboard> findAll(Pageable pageable);
}
