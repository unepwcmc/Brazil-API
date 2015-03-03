package org.unepwcmc.taxonifyapi.dao;

import javax.annotation.concurrent.Immutable;

/**
 * Created by Simao on 02/03/15.
 */
@Immutable
public class Taxon {

    private final String scientificName;
    private final String kingdomName;
    private final String phylumName;
    private final String className;
    private final String orderName;
    private final String familyName;
    private final String distribution;
    private final Integer taxonId;

    public Taxon(Integer taxonId, String kingdomName, String phylumName,
                 String className, String orderName, String familyName, String scientificName,
                 String distribution) {
        this.taxonId = taxonId;
        this.kingdomName = kingdomName;
        this.phylumName = phylumName;
        this.className = className;
        this.orderName = orderName;
        this.familyName = familyName;
        this.scientificName = scientificName;
        this.distribution = distribution;
    }

    public Integer getTaxonId() { return taxonId; }
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
    public String getDistribution() {
        return distribution;
    }
}
