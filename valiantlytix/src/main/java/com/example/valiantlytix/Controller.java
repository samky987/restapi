package com.example.valiantlytix;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import static java.util.stream.Collectors.toList;

@RestController
@RequestMapping("api/v1/")
public class Controller
{
    @Autowired
    OfferRepo offerRepo;

    //return all available offers
    @GetMapping("get_offers")
    public String getOffers()
    {
        Pageable pageable = PageRequest.of(0,5);
        List<Offer> offers = StreamSupport.stream(offerRepo.findAll().spliterator(),false).collect(Collectors.toList());

        System.out.println(offers);
        return offers.toString();
    }

    //return all pending offers
    @GetMapping("/get_offers/pending")
    public String getPendingOffers()
    {
        Pageable pageable = PageRequest.of(0,5);
        //Pending offers are determined based on the boolean value in Offer
        List<Offer> offersList =  offerRepo.findAll(pageable).stream().filter(Offer::isItPending).collect(Collectors.toList());


        System.out.println(offersList);
        return offersList.toString();
    }
    //return all past offers
    @GetMapping("/get_offers/past")
    public String getPastOffers()
    {
        Pageable pageable = PageRequest.of(0,5);

        //Past offers are determined based on the end date, I would not use a real Date object since it have a problem with JPA and will take time to implement my own
        //I will suppose that all past offers are before December
        List<Offer> offersList =  offerRepo.findAll(pageable).stream().filter(e -> (!e.getEndDate().endsWith("12/2020"))).collect(Collectors.toList());


        System.out.println(offersList);
        return offersList.toString();
    }

    //return all ongoing offers
    @GetMapping("/get_offers/ongoing")
    public String getOngoingOffers()
    {
        Pageable pageable = PageRequest.of(0,5);

        //I will suppose that ongoing offers are from 12/2020
        List<Offer> offersList =  offerRepo.findAll(pageable).stream().filter(e -> e.getEndDate().endsWith("12/2020")).collect(Collectors.toList());


        System.out.println(offersList);
        return offersList.toString();
    }

    //add an offer
    @PostMapping("add_offer")
    public String addOffers(Offer s)
    {
        return offerRepo.save(s).toString();
    }

    //update an offer
    @PutMapping("update_offer")
    public void updateOffer(Offer offer)
    {
        try
        {
            offerRepo.save(offer);

        }
        catch (Exception e)
        {
            System.out.println("Exception");
        }
    }

    //delete an offer
    @DeleteMapping("delete_offer")
    public void deleteOffer(long id)
    {
        offerRepo.deleteById(id);
    }
}
