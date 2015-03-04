package org.unepwcmc.taxonifyapi.dao.distribution;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class DistributionMapper implements ResultSetMapper<Distribution> {
    
    public Distribution map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Distribution(r.getInt("id"), r.getString("region"), r.getInt("speciesId"));
    }
}
