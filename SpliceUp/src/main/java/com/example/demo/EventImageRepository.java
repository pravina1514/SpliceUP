package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author HP
 *
 */
@Repository
public interface EventImageRepository extends JpaRepository<EventImage, Long> {
	List<EventImage> findByEvent(Event event);

}