package org.unepwcmc.taxonifyapi.dao.distribution;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(DistributionMapper.class)
public interface DistributionDAO {

    @SqlQuery("SELECT meta_data.id AS id, meta_data.value AS region, taxon_id AS speciesId" +
            " FROM meta_data" +
            " WHERE taxon_id = :speciesId AND type = 'DISTRIBUTION'")
    List<Distribution> distributionFor(@Bind("speciesId") long speciesId);
}
