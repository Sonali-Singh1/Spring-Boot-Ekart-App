package com.ekart.card.dto;

import com.ekart.card.entity.Card;

public class CardDTO {
	
	private Integer cardId;
	private Integer customerId;
	private Long cardNumber;
	private String cardHolder;
	private Integer expiryMonth;
	private Integer expiryYear;
	
	public static Card prepareCardEntity(CardDTO cardDTO) {
		Card card = new Card();
		card.setCardId(cardDTO.getCardId());
		card.setCustomerId(cardDTO.getCustomerId());
		card.setCardNumber(cardDTO.getCardNumber());
		card.setCardHolder(cardDTO.getCardHolder());
		card.setExpiryMonth(cardDTO.getExpiryMonth());
		card.setExpiryYear(cardDTO.getExpiryYear());
		return card;
	}
	
	public static CardDTO prepareCardDTO(Card card) {
		CardDTO cardDTO = new CardDTO();
		cardDTO.setCardId(card.getCardId());
		cardDTO.setCustomerId(card.getCustomerId());
		cardDTO.setCardNumber(card.getCardNumber());
		cardDTO.setCardHolder(card.getCardHolder());
		cardDTO.setExpiryMonth(card.getExpiryMonth());
		cardDTO.setExpiryYear(card.getExpiryYear());
		return cardDTO;
	}
	
	public Integer getCardId() {
		return cardId;
	}
	public void setCardId(Integer cardId) {
		this.cardId = cardId;
	}
	public Integer getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Integer customerId) {
		this.customerId = customerId;
	}
	public Long getCardNumber() {
		return cardNumber;
	}
	public void setCardNumber(Long cardNumber) {
		this.cardNumber = cardNumber;
	}
	public String getCardHolder() {
		return cardHolder;
	}
	public void setCardHolder(String cardHolder) {
		this.cardHolder = cardHolder;
	}
	public Integer getExpiryMonth() {
		return expiryMonth;
	}
	public void setExpiryMonth(Integer expiryMonth) {
		this.expiryMonth = expiryMonth;
	}
	public Integer getExpiryYear() {
		return expiryYear;
	}
	public void setExpiryYear(Integer expiryYear) {
		this.expiryYear = expiryYear;
	}
	
}
