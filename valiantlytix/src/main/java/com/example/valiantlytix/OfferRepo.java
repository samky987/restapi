package com.example.valiantlytix;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;


public interface OfferRepo extends PagingAndSortingRepository<Offer,Long>
{
}
