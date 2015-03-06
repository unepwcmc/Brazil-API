package org.unepwcmc.taxonifyapi.dao.taxon;

import org.unepwcmc.taxonifyapi.dao.common_name.CommonName;
import org.unepwcmc.taxonifyapi.dao.distribution.Distribution;

import javax.annotation.concurrent.Immutable;
import javax.validation.constraints.NotNull;
import java.util.List;

@Immutable
public class Taxon {

    private String scientificName;
    private String kingdomName;
    private String phylumName;
    private String className;
    private String orderName;
    private String familyName;
    @NotNull
    private int speciesId;
    private int speciesPlusId;
    private int gbifId;
    private String citesListing;
    private String description;
    private List<CommonName> commonNames;
    private List<Distribution> distribution;

    public Taxon(int speciesId, String kingdomName, String phylumName,
                 String className, String orderName, String familyName, String scientificName, 
                 int speciesPlusId, int gbifId, String citesListing, String description) {
        this.speciesId = speciesId;
        this.speciesPlusId = speciesPlusId;
        this.gbifId = gbifId;
        this.kingdomName = kingdomName;
        this.phylumName = phylumName;
        this.className = className;
        this.orderName = orderName;
        this.familyName = familyName;
        this.scientificName = scientificName;
        this.citesListing = citesListing;
        this.description = description;
    }
    
    public Taxon() {}

    public int getSpeciesId() { return speciesId; }
    public int getSpeciesPlusId() { return speciesPlusId; }
    public int getGbifId() { return gbifId; }
    public String getScientificName() {
        return scientificName;
    }

    public String getKingdomName() {
        return kingdomName;
    }
    public String getPhylumName() {
        return phylumName;
    }
    public String getClassName() {
        return className;
    }
    public String getOrderName() {
        return orderName;
    }
    public String getFamilyName() {
        return familyName;
    }
    public String getCitesListing() { return citesListing; }
    public String getDescription() { return  description; }
    
    public List<CommonName> getCommonNames() {
        return commonNames;
    }
    public List<Distribution> getDistribution() {
        return distribution;
    }
    
    public void setCommonNames(List<CommonName> commonNames) {
        this.commonNames = commonNames;
    }
    
    public void setDistribution(List<Distribution> distribution) {
        this.distribution = distribution;
    }
}
