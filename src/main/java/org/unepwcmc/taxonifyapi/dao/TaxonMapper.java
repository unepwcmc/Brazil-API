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
        return new Taxon(r.getString("scientific_name"), r.getString("kingdom_name"));
    }
}
