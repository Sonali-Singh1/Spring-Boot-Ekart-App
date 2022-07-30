package com.ekart.card.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ekart.card.entity.Card;

public interface CardRepository extends JpaRepository<Card, Integer> {
	public List<Card> findByCustomerId(Integer customerId);
}
