package org.unepwcmc.taxonifyapi.dao;

import javax.annotation.concurrent.Immutable;

/**
 * Created by Simao on 02/03/15.
 */
@Immutable
public class Taxon {

    private final String scientificName;
    private final String kingdomName;

    public Taxon(String scientificName, String kingdomName) {
        this.scientificName = scientificName;
        this.kingdomName = kingdomName;
    }


    public String getScientificName() {
        return scientificName;
    }

    public String getKingdomName() {
        return kingdomName;
    }
}
