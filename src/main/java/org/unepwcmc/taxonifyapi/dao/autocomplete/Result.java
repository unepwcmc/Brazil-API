package org.unepwcmc.taxonifyapi.dao.autocomplete;

import javax.annotation.concurrent.Immutable;

@Immutable
public class Result {
    public final int speciesId;
    public final String scientificName;
    
    public Result(int speciesId, String scientificName) {
        this.speciesId = speciesId;
        this.scientificName = scientificName;
    }
    
    public int getSpeciesId() {
        return speciesId;
    }
    
    public String getScientificName() {
        return scientificName;
    }
}
