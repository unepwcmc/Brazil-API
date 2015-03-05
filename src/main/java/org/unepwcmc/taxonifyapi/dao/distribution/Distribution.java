package org.unepwcmc.taxonifyapi.dao.distribution;

import javax.annotation.concurrent.Immutable;
import javax.validation.constraints.NotNull;

@Immutable
public class Distribution {
    public int id;
    @NotNull
    public String region;
    @NotNull
    public int speciesId;
    
    public Distribution(int id, String region, int speciesId) {
        this.id = id;
        this.region = region;
        this.speciesId = speciesId;
    }
    
    public Distribution() {
    }
    
    public int getId() {
        return id;
    }
    
    public String getRegion() {
        return region;
    }
    
    public int getSpeciesId() {
        return speciesId;
    }
}
