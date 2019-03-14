package com.example.demo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantsGroupRepository extends JpaRepository<ParticipantsGroup, Long> {
	List<ParticipantsGroup> findByEvent(Event eventId);

}
