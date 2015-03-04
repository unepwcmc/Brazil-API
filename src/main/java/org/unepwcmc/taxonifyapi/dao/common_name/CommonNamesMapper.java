package org.unepwcmc.taxonifyapi.dao.common_name;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class CommonNamesMapper implements ResultSetMapper<CommonName> {
    
    public CommonName map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new CommonName(r.getInt("id"), r.getString("name"), r.getString("language"),
                r.getString("region"), r.getInt("speciesId"));
    }

}
