package com.example.chacasanova.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.chacasanova.domain.entity.Gift;
import com.example.chacasanova.dto.GiftDTO;
import com.example.chacasanova.dto.PresenterDTO;
import com.example.chacasanova.service.GiftService;

import jakarta.validation.Valid;
import jakarta.websocket.server.PathParam;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;




@RestController
@RequestMapping("/gift")
public class GiftController {
    @Autowired
    private final GiftService giftService;
    
    public GiftController(GiftService giftService){
        this.giftService = giftService;
    }
    @GetMapping("")
    public ResponseEntity<?>getAllGifts() {
        List<Gift>  gifts = giftService.getAllGifts();   
        return new ResponseEntity<>(gifts, HttpStatus.OK);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getMethodName(@RequestParam UUID id) { 
        Optional<Gift> foundGift = giftService.getById(id);
        if(foundGift.isPresent()){
            return new ResponseEntity<>(foundGift, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    

    @PostMapping("")
    public ResponseEntity<Gift> addGift(@Valid @RequestBody GiftDTO giftDTO) {
        Gift gift = new Gift();
        gift.setImgLink(giftDTO.imgLink());
        gift.setDescription(giftDTO.description());
        gift.setExampleLink(giftDTO.exampleLink());
        gift.setTitle(giftDTO.title());
        Gift newGift = giftService.addGift(gift);
        return new ResponseEntity<>(newGift, HttpStatus.OK);
    }
    @PatchMapping("/{id}")
    public ResponseEntity<Gift> addPresenter(@Valid @RequestBody PresenterDTO presenterDTO, @PathVariable UUID id){
       Optional<Gift> gift =  giftService.getById(id);
        if(gift.isPresent()){
            Gift giftWithPresenter = new Gift();
            giftWithPresenter.setId(id);
            giftWithPresenter.setDescription(gift.get().getDescription());
            giftWithPresenter.setTitle(gift.get().getTitle());
            giftWithPresenter.setExampleLink(gift.get().getExampleLink());
            giftWithPresenter.setImgLink(gift.get().getImgLink());
            giftWithPresenter.setPhone(presenterDTO.phone());
            giftWithPresenter.setPresenter(presenterDTO.presenter());
            Gift giftPresented =  giftService.addPresenter(giftWithPresenter);
            return new ResponseEntity<>(giftPresented, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }   
}
