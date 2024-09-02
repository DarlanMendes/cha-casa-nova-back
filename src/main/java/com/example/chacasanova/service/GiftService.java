package com.example.chacasanova.service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.chacasanova.domain.entity.Gift;
import com.example.chacasanova.repository.GiftRepository;

@Service
public class GiftService {
    @Autowired
    private final GiftRepository giftRepository;
    public GiftService(GiftRepository giftRepository){
        this.giftRepository = giftRepository;
    }
    public List<Gift> getAllGifts(){
        return   giftRepository.findAll();
    }
    public Optional<Gift> getById(UUID id){
        return giftRepository.findById(id);
    }
    public Gift addGift(Gift gift){
       return  giftRepository.save(gift);
    }
    public Gift addPresenter(Gift gift){
        return giftRepository.save(gift);
    }
}
