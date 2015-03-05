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

    @SqlQuery("UPDATE meta_data" +
            " SET value = :region" +
            " WHERE id = :id" +
            " RETURNING value AS region, taxon_id AS speciesId, id")
    Distribution updateDistribution(@Bind("region") String region,
                                    @Bind("id") long id);

    @SqlQuery("INSERT INTO meta_data(version, taxon_id, value, type)" +
            " VALUES(0, :speciesId, :region, 'DISTRIBUTION')" +
            " RETURNING value AS region, taxon_id AS speciesId, id")
    Distribution addDistribution(@Bind("region") String region, @Bind("speciesId") int speciesId);
}
