package fr.epsi.JingleBidAPI.controller;

import fr.epsi.JingleBidAPI.model.Auction;
import fr.epsi.JingleBidAPI.repository.AuctionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.concurrent.ExecutionException;

@RestController
public class AuctionController {

    @Autowired
    AuctionRepository auctionRepository;

    @PostMapping(path = "/auction")
    public @ResponseBody Auction postAuction(@RequestBody Auction auction) throws InterruptedException, ExecutionException {
            Auction auction1 = new Auction();
            /*auction1.setProductId(auction.getProductId());
            auction1.setTimeOptions(auction.getTimeOptions());*/
            auction1.setActualPrice(auction.getActualPrice());
            return auctionRepository.save(auction1);
    }

    @GetMapping(path = "/auction")
    public Iterable<Auction> getAuction() throws InterruptedException, ExecutionException {
        return auctionRepository.findAll();
    }

    @GetMapping(path = "/auction/{id}")
    public Auction getAnAuctionDetail(@PathVariable Long id) throws InterruptedException, ExecutionException {
        Optional<Auction> auctionOptional = auctionRepository.findById(id);
        if (auctionOptional.isPresent())
            return auctionOptional.get();
        else
            return null;
    }

    @PutMapping(path = "/auction/{id}")
    public void updateAnAuction(@RequestBody Auction auction, @PathVariable Long id ) throws InterruptedException, ExecutionException {

        Optional<Auction> auctionOptional = auctionRepository.findById(id) ;
        if(auctionOptional.isPresent()) {
            Auction auction1 = auctionOptional.get();
            /*auction1.setProductId(auction.getProductId());
            auction1.setTimeOptions(auction.getTimeOptions());*/
            auction1.setActualPrice(auction.getActualPrice());
            auctionRepository.save(auction1);
        }
    }

    @DeleteMapping(path = "/auction")
    public @ResponseBody String deleteAnAuction(@PathVariable Long id) throws InterruptedException, ExecutionException {
        Optional<Auction> auctionOptional = auctionRepository.findById(id) ;
        if(auctionOptional.isPresent()) {
            auctionRepository.deleteById(id);
            return "L'enchère qui contient l'id " + id + " a été supprimé" ;

        }
        return "L'ID est introuvable";
    }

}
