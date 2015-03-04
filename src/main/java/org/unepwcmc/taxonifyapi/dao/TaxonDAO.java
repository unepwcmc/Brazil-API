package org.unepwcmc.taxonifyapi.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;


@RegisterMapper(TaxonMapper.class)
public interface TaxonDAO {

    @SqlQuery("SELECT taxon.* FROM taxon WHERE name_status = 'NOME_ACEITO' ORDER by scientific_name ASC LIMIT :perPage OFFSET :page")
    List<Taxon> findAll(@Bind("page") int page, @Bind("perPage") int perPage);
    
    @SqlQuery("SELECT COUNT(*) FROM taxon WHERE name_status = 'NOME_ACEITO'")
    int countAll();

    @SqlQuery("SELECT taxon.* FROM taxon WHERE taxon.id = :taxonId GROUP BY taxon.id")
    Taxon findById(@Bind("taxonId") long taxonId);

    @SqlQuery("SELECT * FROM taxon WHERE UPPER(scientific_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO' ORDER by scientific_name ASC LIMIT :perPage OFFSET :page")
    List<Taxon> findByScientificName(@Bind("query") String query,
                                     @Bind("page") int page, @Bind("perPage") int perPage);

    @SqlQuery("SELECT COUNT(*) FROM taxon WHERE UPPER(scientific_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO'")
    int countForScientificName(@Bind("query") String query);

    @SqlQuery("SELECT taxon.* FROM taxon WHERE UPPER(kingdom_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO' ORDER by scientific_name ASC LIMIT :perPage OFFSET :page + 1")
    List<Taxon> findByKingdomName(@Bind("query") String query,
                                            @Bind("page") int page, @Bind("perPage") int perPage);
    
    @SqlQuery("SELECT COUNT(*) FROM taxon WHERE UPPER(kingdom_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO'")
    int countForKingdomName(@Bind("query") String query);
    
    @SqlQuery("SELECT taxon.* FROM taxon WHERE UPPER(phylum_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO' ORDER by scientific_name ASC LIMIT :perPage OFFSET :page + 1")
    List<Taxon> findByPhylumName(@Bind("query") String query,
                                            @Bind("page") int page, @Bind("perPage") int perPage);
    @SqlQuery("SELECT COUNT(*) FROM taxon WHERE UPPER(phylum_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO'")
    int countForPhylumName(@Bind("query") String query);

    @SqlQuery("SELECT taxon.* FROM taxon WHERE UPPER(class_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO' ORDER by scientific_name ASC LIMIT :perPage OFFSET :page + 1")
    List<Taxon> findByClassName(@Bind("query") String query,
                                            @Bind("page") int page, @Bind("perPage") int perPage);
    
    @SqlQuery("SELECT COUNT(*) FROM taxon WHERE UPPER(class_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO'")
    int countForClassName(@Bind("query") String query);
    
    @SqlQuery("SELECT taxon.* FROM taxon WHERE UPPER(order_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO' ORDER by scientific_name ASC LIMIT :perPage OFFSET :page + 1")
    List<Taxon> findByOrderName(@Bind("query") String query,
                                            @Bind("page") int page, @Bind("perPage") int perPage);
    
    @SqlQuery("SELECT COUNT(*) FROM taxon WHERE UPPER(order_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO'")
    int countForOrderName(@Bind("query") String query);
    
    @SqlQuery("SELECT taxon.* FROM taxon WHERE UPPER(family_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO' ORDER by scientific_name ASC LIMIT :perPage OFFSET :page + 1")
    List<Taxon> findByFamilyName(@Bind("query") String query,
                                @Bind("page") int page, @Bind("perPage") int perPage);
    
    @SqlQuery("SELECT COUNT(*) FROM taxon WHERE UPPER(family_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO'")
    int countForFamilyName(@Bind("query") String query);
    
    @SqlQuery("SELECT taxon.* FROM taxon WHERE UPPER(genus_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO' ORDER by scientific_name ASC LIMIT :perPage OFFSET :page + 1")
    List<Taxon> findByGenusName(@Bind("query") String query,
                                 @Bind("page") int page, @Bind("perPage") int perPage);
    
    @SqlQuery("SELECT COUNT(*) FROM taxon WHERE UPPER(genus_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO'")
    int countForGenusName(@Bind("query") String query);

}
