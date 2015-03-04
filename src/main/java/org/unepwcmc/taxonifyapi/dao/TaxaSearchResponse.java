package org.unepwcmc.taxonifyapi.dao;

import java.util.List;

/**
 * Created by Simao on 04/03/15.
 */
public class TaxaSearchResponse {
    
    public final int total;
    public final List<Taxon> species;
    
    public TaxaSearchResponse(int total, List<Taxon> species) {
        this.total = total;
        this.species = species;
    }
    
    public int getTotal() {
        return total;
    }
    
    public List<Taxon> getSpecies() {
        return species;
    }
}
