/**
 * 
 */
package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author HP
 *
 */
@Repository
public interface UserMasterRepository extends JpaRepository<Login, Long> {

	Login findByEmail(String username);

}
