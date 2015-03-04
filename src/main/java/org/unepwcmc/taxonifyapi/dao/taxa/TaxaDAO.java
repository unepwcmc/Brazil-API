package org.unepwcmc.taxonifyapi.dao.taxa;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(TaxaMapper.class)
public interface TaxaDAO {
    
    public final String defaultQuery = "SELECT taxon.*, string_agg(meta_data.value, ', ') AS common_names" +
            " FROM taxon " +
            " LEFT JOIN meta_data ON taxon_id = taxon.id AND type = 'COMMON_NAME'" +
            " WHERE name_status = 'NOME_ACEITO'";

    @SqlQuery(defaultQuery + " GROUP BY taxon.id ORDER by scientific_name ASC LIMIT :perPage OFFSET :page")
    List<Taxa> findAll(@Bind("page") int page, @Bind("perPage") int perPage);
    
    @SqlQuery("SELECT COUNT(*) FROM taxon WHERE name_status = 'NOME_ACEITO'")
    int countAll();

    @SqlQuery(defaultQuery +
            " AND UPPER(scientific_name) LIKE UPPER(:query)" +
            " GROUP BY taxon.id" +
            " ORDER by scientific_name ASC LIMIT :perPage OFFSET :page")
    List<Taxa> findByScientificName(@Bind("query") String query,
                                    @Bind("page") int page, @Bind("perPage") int perPage);

    @SqlQuery("SELECT COUNT(*) FROM taxon WHERE UPPER(scientific_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO'")
    int countForScientificName(@Bind("query") String query);

    @SqlQuery(defaultQuery +
            " AND UPPER(kingdom_name) LIKE UPPER(:query)" +
            " GROUP BY taxon.id" +
            " ORDER by scientific_name ASC LIMIT :perPage OFFSET :page + 1")
    List<Taxa> findByKingdomName(@Bind("query") String query,
                                 @Bind("page") int page, @Bind("perPage") int perPage);

    @SqlQuery("SELECT COUNT(*) FROM taxon WHERE UPPER(kingdom_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO'")
    int countForKingdomName(@Bind("query") String query);

    @SqlQuery(defaultQuery +
            " AND UPPER(phylum_name) LIKE UPPER(:query)" +
            " GROUP BY taxon.id" +
            " ORDER by scientific_name ASC LIMIT :perPage OFFSET :page + 1")
    List<Taxa> findByPhylumName(@Bind("query") String query,
                                @Bind("page") int page, @Bind("perPage") int perPage);
    @SqlQuery("SELECT COUNT(*) FROM taxon WHERE UPPER(phylum_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO'")
    int countForPhylumName(@Bind("query") String query);

    @SqlQuery(defaultQuery +
            " AND UPPER(class_name) LIKE UPPER(:query)" +
            " GROUP BY taxon.id" +
            " ORDER by scientific_name ASC LIMIT :perPage OFFSET :page + 1")
    List<Taxa> findByClassName(@Bind("query") String query,
                               @Bind("page") int page, @Bind("perPage") int perPage);

    @SqlQuery("SELECT COUNT(*) FROM taxon WHERE UPPER(class_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO'")
    int countForClassName(@Bind("query") String query);

    @SqlQuery(defaultQuery +
            " AND UPPER(order_name) LIKE UPPER(:query)" +
            " GROUP BY taxon.id" +
            " ORDER by scientific_name ASC LIMIT :perPage OFFSET :page + 1")
    List<Taxa> findByOrderName(@Bind("query") String query,
                               @Bind("page") int page, @Bind("perPage") int perPage);

    @SqlQuery("SELECT COUNT(*) FROM taxon WHERE UPPER(order_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO'")
    int countForOrderName(@Bind("query") String query);

    @SqlQuery(defaultQuery +
            " AND UPPER(family_name) LIKE UPPER(:query)" +
            " GROUP BY taxon.id" +
            " ORDER by scientific_name ASC LIMIT :perPage OFFSET :page + 1")
    List<Taxa> findByFamilyName(@Bind("query") String query,
                                @Bind("page") int page, @Bind("perPage") int perPage);

    @SqlQuery("SELECT COUNT(*) FROM taxon WHERE UPPER(family_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO'")
    int countForFamilyName(@Bind("query") String query);

    @SqlQuery(defaultQuery +
            " AND UPPER(genus_name) LIKE UPPER(:query)" +
            " GROUP BY taxon.id" +
            " ORDER by scientific_name ASC LIMIT :perPage OFFSET :page + 1")
    List<Taxa> findByGenusName(@Bind("query") String query,
                               @Bind("page") int page, @Bind("perPage") int perPage);

    @SqlQuery("SELECT COUNT(*) FROM taxon WHERE UPPER(genus_name) LIKE UPPER(:query)" +
            " AND name_status = 'NOME_ACEITO'")
    int countForGenusName(@Bind("query") String query);

}
