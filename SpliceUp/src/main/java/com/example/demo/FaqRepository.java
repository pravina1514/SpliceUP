package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author HP
 *
 */
@Repository
public interface FaqRepository extends JpaRepository<Faq, Long> {

}