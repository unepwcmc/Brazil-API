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

    @SqlQuery("SELECT * FROM taxon WHERE UPPER(scientific_name) LIKE UPPER(:query) LIMIT :perPage OFFSET :page")
    List<Taxon> findByScientificName(@Bind("query") String query,
                                     @Bind("page") int page, @Bind("perPage") int perPage);

    @SqlQuery("SELECT taxon.*, string_agg(geo_entity.name, ', ') as distribution" +
            " FROM taxon INNER JOIN distribution ON taxon.id = distribution.taxon_id" +
            " INNER JOIN geo_entity ON geo_entity.id = distribution.geo_entity_id" +
            " GROUP BY taxon.id LIMIT 20")
    List<Taxon> findAll(@Bind("page") int page, @Bind("perPage") int perPage);

    @SqlQuery("SELECT taxon.*, string_agg(geo_entity.name, ', ') as distribution" +
            " FROM taxon INNER JOIN distribution ON taxon.id = distribution.taxon_id" +
            " INNER JOIN geo_entity ON geo_entity.id = distribution.geo_entity_id" +
            " WHERE taxon.id = :taxonId GROUP BY taxon.id")
    Taxon findById(@Bind("taxonId") long taxonId);

    @SqlQuery("SELECT taxon.* FROM taxon WHERE UPPER(kingdom_name) LIKE UPPER(:query) LIMIT :perPage OFFSET :page + 1")
    List<Taxon> findByKingdomName(@Bind("query") String query,
                                            @Bind("page") int page, @Bind("perPage") int perPage);
    
    @SqlQuery("SELECT taxon.* FROM taxon WHERE UPPER(phylum_name) LIKE UPPER(:query) LIMIT :perPage OFFSET :page + 1")
    List<Taxon> findByPhylumName(@Bind("query") String query,
                                            @Bind("page") int page, @Bind("perPage") int perPage);
    
    @SqlQuery("SELECT taxon.* FROM taxon WHERE UPPER(class_name) LIKE UPPER(:query) LIMIT :perPage OFFSET :page + 1")
    List<Taxon> findByClassName(@Bind("query") String query,
                                            @Bind("page") int page, @Bind("perPage") int perPage);
    
    @SqlQuery("SELECT taxon.* FROM taxon WHERE UPPER(order_name) LIKE UPPER(:query) LIMIT :perPage OFFSET :page + 1")
    List<Taxon> findByOrderName(@Bind("query") String query,
                                            @Bind("page") int page, @Bind("perPage") int perPage);
    
    @SqlQuery("SELECT taxon.* FROM taxon WHERE UPPER(family_name) LIKE UPPER(:query) LIMIT :perPage OFFSET :page + 1")
    List<Taxon> findByFamilyName(@Bind("query") String query,
                                @Bind("page") int page, @Bind("perPage") int perPage);
    
    @SqlQuery("SELECT taxon.* FROM taxon WHERE UPPER(genus_name) LIKE UPPER(:query) LIMIT :perPage OFFSET :page + 1")
    List<Taxon> findByGenusName(@Bind("query") String query,
                                 @Bind("page") int page, @Bind("perPage") int perPage);
}
