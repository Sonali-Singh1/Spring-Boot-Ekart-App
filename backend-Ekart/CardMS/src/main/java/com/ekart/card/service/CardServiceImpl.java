package com.ekart.card.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ekart.card.dto.CardDTO;
import com.ekart.card.entity.Card;
import com.ekart.card.repository.CardRepository;

@Service
public class CardServiceImpl implements CardService {
	
	@Autowired
	private CardRepository cardRepository;
	
	public List<CardDTO> getAllCards(Integer customerId){
		List<Card> cards = cardRepository.findByCustomerId(customerId);
		List<CardDTO> cardDTOs = new ArrayList<>();
		cards.forEach(card -> cardDTOs.add(CardDTO.prepareCardDTO(card)));
		return cardDTOs;
	}
	
	public String addCard(CardDTO cardDTO) {
		Card card = CardDTO.prepareCardEntity(cardDTO);
//		List<Card> cards = cardRepository.findByCustomerId(cardDTO.getCustomerId());
//		for(Card temp:cards) {
//			if(temp.getCardNumber() == cardDTO.getCardNumber()) {
//				return "Card already present";
//			}
//		}
		cardRepository.saveAndFlush(card);
		return "Card added";
	}
}
