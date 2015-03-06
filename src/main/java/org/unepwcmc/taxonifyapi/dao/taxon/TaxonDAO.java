package org.unepwcmc.taxonifyapi.dao.taxon;

import io.dropwizard.jersey.params.LongParam;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.unepwcmc.taxonifyapi.dao.common_name.CommonName;
import org.unepwcmc.taxonifyapi.dao.common_name.CommonNamesMapper;
import org.unepwcmc.taxonifyapi.dao.distribution.Distribution;
import org.unepwcmc.taxonifyapi.dao.distribution.DistributionMapper;

import java.util.List;


@RegisterMapper(TaxonMapper.class)
public interface TaxonDAO {


    @SqlQuery("SELECT taxon.* FROM taxon WHERE taxon.id = :speciesId GROUP BY taxon.id")
    Taxon findById(@Bind("speciesId") long speciesId);
    
    @SqlQuery("UPDATE taxon" +
            " SET description = :description" +
            " WHERE id = :speciesId" +
            " RETURNING taxon.*")
    Taxon updateTaxon(@Bind("speciesId") long speciesId, @Bind("description") String description);

    @RegisterMapper(CommonNamesMapper.class)
    @SqlQuery("SELECT value AS name, data->>'language' AS language, data->>'region' AS region," +
            " id AS id, taxon_id AS speciesId" +
            " FROM meta_data" +
            " WHERE taxon_id = :speciesId AND type = 'COMMON_NAME'")
    List<CommonName> getCommonNames(@Bind("speciesId") long speciesId);

    @RegisterMapper(DistributionMapper.class)
    @SqlQuery("SELECT value AS region, id AS id, taxon_id AS speciesId" +
            " FROM meta_data" +
            " WHERE taxon_id = :speciesId AND type = 'DISTRIBUTION'")
    List<Distribution> getDistribution(@Bind("speciesId") long speciesId);

}
