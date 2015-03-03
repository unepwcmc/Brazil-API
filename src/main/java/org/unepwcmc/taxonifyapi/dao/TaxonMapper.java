package org.unepwcmc.taxonifyapi.dao;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by Simao on 02/03/15.
 */
public class TaxonMapper implements ResultSetMapper<Taxon> {

    public Taxon map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Taxon(r.getInt("id"), r.getString("kingdom_name"),
                r.getString("phylum_name"), r.getString("class_name"), r.getString("order_name"),
                r.getString("family_name"), r.getString("scientific_name"));
    }
}
