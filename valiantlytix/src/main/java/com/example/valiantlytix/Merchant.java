package com.example.valiantlytix;

import javax.persistence.CascadeType;
import javax.persistence.OneToMany;
import java.util.List;

public class Merchant
{
    @OneToMany(cascade = CascadeType.ALL)
    private List<Offer> offerList;

}
