package com.example.pms.repositories;


import com.example.pms.models.Chat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Character interface extends JpaRepository
 * It takes the domain class to manage as well as the type of the ID.
 * This gives standard CRUD operations for character table
 */

@Repository
public interface ChatRepository extends JpaRepository <Chat, Integer> {
}
