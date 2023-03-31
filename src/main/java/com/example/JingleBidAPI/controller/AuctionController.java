package com.example.JingleBidAPI.controller;

import com.example.JingleBidAPI.model.Auction;
import com.example.JingleBidAPI.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

@RestController
public class AuctionController {

    @Autowired
    private AuctionRepository auctionRepository;

    @PostMapping(path = "/auction")
    public void postAuction(@RequestBody Auction auction) throws InterruptedException, ExecutionException {
            Auction auction1 = new Auction();
            auction1.setId(auction.getId());
            auction1.setName(auction1.getName());
            auctionRepository.save(auction);
    }

    @GetMapping(path = "/auction")
    public Iterable<Auction> getAuction() throws InterruptedException, ExecutionException {
        return auctionRepository.findAll();
    }

    @GetMapping(path = "/auction/{id}")
    public Auction getAuctionDetails(@RequestParam String id) throws InterruptedException, ExecutionException {
        return auctionRepository.findById(Integer.valueOf(id)).get();
    }

    @PutMapping(path = "/auction")
    public void updateAuction(@RequestBody Auction auction, String id ) throws InterruptedException, ExecutionException {
        Auction auction1 = auctionRepository.findById(Integer.valueOf(id)).get();
        auction1.setName(auction.getName());
    }

    @DeleteMapping(path = "/auction")
    public void deleteAuction(@RequestParam String id) throws InterruptedException, ExecutionException {
        auctionRepository.deleteById(Integer.valueOf(id));
    }

}
