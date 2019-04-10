package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author HP
 *
 */
@Repository
public interface ChatRepository extends JpaRepository<Chat, Long> {

	List<Chat> findByEvent(Event event);
	
}