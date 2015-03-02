package org.unepwcmc.taxonifyapi.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by Simao on 02/03/15.
 */

@RegisterMapper(TaxonMapper.class)
public interface TaxonDAO {

    @SqlQuery("SELECT count(*) FROM taxon")
    int countAll();

    @SqlQuery("SELECT * FROM taxon WHERE UPPER(scientific_name) LIKE UPPER(:query) LIMIT 20")
    List<Taxon> findByScientificName(@Bind("query") String query);

    @SqlQuery("SELECT * FROM taxon LIMIT 20")
    List<Taxon> findAll();
}