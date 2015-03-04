package org.unepwcmc.taxonifyapi.dao.taxa;

import javax.annotation.concurrent.Immutable;

@Immutable
public class Taxa {
    private final String scientificName;
    private final String kingdomName;
    private final String phylumName;
    private final String className;
    private final String orderName;
    private final String familyName;
    private final int speciesId;
    private final int speciesPlusId;
    private final int gbifId;
    private final String commonNames;

    public Taxa(int speciesId, String kingdomName, String phylumName,
                 String className, String orderName, String familyName, String scientificName,
                 int speciesPlusId, int gbifId, String commonNames) {
        this.speciesId = speciesId;
        this.speciesPlusId = speciesPlusId;
        this.gbifId = gbifId;
        this.kingdomName = kingdomName;
        this.phylumName = phylumName;
        this.className = className;
        this.orderName = orderName;
        this.familyName = familyName;
        this.scientificName = scientificName;
        this.commonNames = commonNames;
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
    public String getCommonNames() { return commonNames; }
}
