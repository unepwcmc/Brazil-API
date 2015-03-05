package org.unepwcmc.taxonifyapi.dao.taxon;

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


    @SqlQuery("SELECT taxon.* FROM taxon WHERE taxon.id = :taxonId GROUP BY taxon.id")
    Taxon findById(@Bind("taxonId") long taxonId);

    @RegisterMapper(CommonNamesMapper.class)
    @SqlQuery("SELECT value AS name, data->>'language' AS language, data->>'region' AS region," +
            " id AS id, taxon_id AS speciesId" +
            " FROM meta_data" +
            " WHERE taxon_id = :taxonId AND type = 'COMMON_NAME'")
    List<CommonName> getCommonNames(@Bind("taxonId") long taxonId);

    @RegisterMapper(DistributionMapper.class)
    @SqlQuery("SELECT value AS region, id AS id, taxon_id AS speciesId" +
            " FROM meta_data" +
            " WHERE taxon_id = :taxonId AND type = 'DISTRIBUTION'")
    List<Distribution> getDistribution(@Bind("taxonId") long taxonId);
}
