package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

//	@Query("Select e from Participant e where e.eid=:eventId")
//	List<Participant> findByEId(Long eventId);

	List<Participant> findByEvent(Event eventId);

	List<Participant> findByUser(Login user);

}