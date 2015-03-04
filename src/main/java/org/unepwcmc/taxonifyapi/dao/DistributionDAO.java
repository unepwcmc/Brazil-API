package org.unepwcmc.taxonifyapi.dao;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(DistributionMapper.class)
public interface DistributionDAO {

    @SqlQuery("SELECT distribution.id AS id, geo_entity.name AS region, taxon_id AS speciesId" +
            " FROM distribution" +
            " INNER JOIN geo_entity ON geo_entity_id = geo_entity.id" +
            " WHERE taxon_id = :speciesId")
    List<Distribution> distributionFor(@Bind("speciesId") long speciesId);
}
