package org.unepwcmc.taxonifyapi.dao;

import javax.annotation.concurrent.Immutable;

@Immutable
public class Distribution {
    public final int id;
    public final String region;
    public final int speciesId;
    
    public Distribution(int id, String region, int speciesId) {
        this.id = id;
        this.region = region;
        this.speciesId = speciesId;
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
