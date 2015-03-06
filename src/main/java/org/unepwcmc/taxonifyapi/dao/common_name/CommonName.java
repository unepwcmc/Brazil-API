package org.unepwcmc.taxonifyapi.dao.common_name;

import javax.annotation.concurrent.Immutable;
import javax.validation.constraints.NotNull;

@Immutable
public class CommonName {
    private int id;
    @NotNull
    private String name;
    private String language;
    private String region;
    @NotNull
    private int speciesId;
    
    public CommonName(int id, String name, String language, String region, int speciesId) {
        this.id = id;
        this.name = name;
        this.language = language;
        this.region = region;
        this.speciesId = speciesId;
    }
    
    public CommonName() {}
    
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
