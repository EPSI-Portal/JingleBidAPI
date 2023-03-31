package fr.epsi.JingleBidAPI.repository;

import fr.epsi.JingleBidAPI.model.Auction;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuctionRepository extends CrudRepository<Auction, Long> {
}
