package com.ekart.card.service;

import java.util.List;

import com.ekart.card.dto.CardDTO;

public interface CardService {
	public List<CardDTO> getAllCards(Integer customerId);
	public String addCard(CardDTO cardDTO);
}
