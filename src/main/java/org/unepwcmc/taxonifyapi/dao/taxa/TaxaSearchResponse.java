package org.unepwcmc.taxonifyapi.dao.taxa;

import java.util.List;

/**
 * Created by Simao on 04/03/15.
 */
public class TaxaSearchResponse {
    
    public final int total;
    public final List<Taxa> species;
    
    public TaxaSearchResponse(int total, List<Taxa> species) {
        this.total = total;
        this.species = species;
    }
    
    public int getTotal() {
        return total;
    }
    
    public List<Taxa> getSpecies() {
        return species;
    }
}
