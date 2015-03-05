package org.unepwcmc.taxonifyapi.dao.taxon;

import org.unepwcmc.taxonifyapi.dao.common_name.CommonName;
import org.unepwcmc.taxonifyapi.dao.distribution.Distribution;

import javax.annotation.concurrent.Immutable;
import java.util.List;

@Immutable
public class Taxon {

    private final String scientificName;
    private final String kingdomName;
    private final String phylumName;
    private final String className;
    private final String orderName;
    private final String familyName;
    private final int speciesId;
    private final int speciesPlusId;
    private final int gbifId;
    private final String citesListing;
    private final String description;
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
