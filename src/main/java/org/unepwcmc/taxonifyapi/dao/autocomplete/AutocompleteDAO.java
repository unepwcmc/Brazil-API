package org.unepwcmc.taxonifyapi.dao.autocomplete;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(ResultMapper.class)
public interface AutocompleteDAO {
    
    @SqlQuery("SELECT id, scientific_name FROM taxon WHERE UPPER(taxon.scientific_name) LIKE UPPER(:query)" +
            " ORDER BY scientific_name ASC LIMIT 9")
    List<Result> findByScientificName(@Bind("query") String query);
}
