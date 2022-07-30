package com.ekart.card.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ekart.card.dto.CardDTO;
import com.ekart.card.service.CardService;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("/card")
public class CardController {
	
	@Autowired
	private CardService cardService;
	
	@GetMapping("/all")
	public ResponseEntity<List<CardDTO>> getAllCards(@RequestParam Integer customerId){
		List<CardDTO> cardDTOs = cardService.getAllCards(customerId);
		return ResponseEntity.ok(cardDTOs);
	}
	
	@PostMapping("/add")
	public ResponseEntity<String> addCard(@RequestBody CardDTO cardDTO){
		String response = cardService.addCard(cardDTO);
		return ResponseEntity.ok(response);
	}
}
