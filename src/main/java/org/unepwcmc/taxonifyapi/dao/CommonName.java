package org.unepwcmc.taxonifyapi.dao;

import javax.annotation.concurrent.Immutable;

@Immutable
public class CommonName {
    private final int id;
    private final String name;
    private final String language;
    private final String region;
    private final int speciesId;
    
    public CommonName(int id, String name, String language, String region, int speciesId) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.region = region;
        this.speciesId = speciesId;
    }
    
    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    
    public String getLanguage() {
        return language;
    }
    
    public String getRegion() {
        return region;
    }
    
    public int getSpeciesId() {
        return speciesId;
    }
}
