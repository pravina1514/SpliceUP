package com.example.demo;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * @author HP
 *
 */
@Repository
public interface EventRepository extends JpaRepository<Event, Long> {
	@Modifying
	@Transactional
	@Query(value = "delete from Event e where e.eid = ?1")
	void deleteEventFromDB(Long eventId);

}