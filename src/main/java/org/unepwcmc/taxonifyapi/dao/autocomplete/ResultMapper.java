package org.unepwcmc.taxonifyapi.dao.autocomplete;

import org.skife.jdbi.v2.StatementContext;
import org.skife.jdbi.v2.tweak.ResultSetMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class ResultMapper implements ResultSetMapper<Result> {

    public Result map(int index, ResultSet r, StatementContext ctx) throws SQLException {
        return new Result(r.getInt("id"), r.getString("scientific_name"));
    }
}
