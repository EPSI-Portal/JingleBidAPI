package com.example.JingleBidAPI.repository;

import com.example.JingleBidAPI.model.Auction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends CrudRepository<Auction, Integer> {
}
