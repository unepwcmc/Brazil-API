package org.unepwcmc.taxonifyapi.dao;

import com.google.common.base.Optional;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

/**
 * Created by Simao on 02/03/15.
 */

@RegisterMapper(TaxonMapper.class)
public interface TaxonDAO {

    @SqlQuery("SELECT * FROM taxon WHERE UPPER(scientific_name) LIKE UPPER(:query) LIMIT 20")
    List<Taxon> findByScientificName(@Bind("query") String query);

    @SqlQuery("SELECT taxon.*, string_agg(geo_entity.name, ', ') as distribution" +
            " FROM taxon INNER JOIN distribution ON taxon.id = distribution.taxon_id" +
            " INNER JOIN geo_entity ON geo_entity.id = distribution.geo_entity_id" +
            " GROUP BY taxon.id LIMIT 20")
    List<Taxon> findAll();

    @SqlQuery("SELECT taxon.*, string_agg(geo_entity.name, ', ') as distribution" +
            " FROM taxon INNER JOIN distribution ON taxon.id = distribution.taxon_id" +
            " INNER JOIN geo_entity ON geo_entity.id = distribution.geo_entity_id" +
            " WHERE taxon.id = :taxonId GROUP BY taxon.id")
    Taxon findById(@Bind("taxonId") long taxonId);
    
}
