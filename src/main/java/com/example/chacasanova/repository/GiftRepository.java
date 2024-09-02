package com.example.chacasanova.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.chacasanova.domain.entity.Gift;
@Repository
public interface GiftRepository extends JpaRepository<Gift, UUID>{
}
