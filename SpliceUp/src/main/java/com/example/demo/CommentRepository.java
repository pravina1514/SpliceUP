package com.example.demo;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface CommentRepository extends JpaRepository<Comment, Long> {

	List<Comment> findByEvent(Event eventId);

	@Modifying
	@Transactional
	@Query(value = "delete from Comment e where e.cid = ?1")
	void deleteCommentFromDB(Long commentId);

}
