package org.unepwcmc.taxonifyapi.dao.common_name;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(CommonNamesMapper.class)
public interface CommonNamesDAO {

    @SqlQuery("SELECT id, value AS name, data->>'language' AS language, data->>'region' AS region," +
            " taxon_id AS speciesId FROM meta_data WHERE type = 'COMMON_NAME'"+
            " AND taxon_id = :speciesId")
    List<CommonName> commonNamesFor(@Bind("speciesId") long speciesId);

    @SqlQuery("UPDATE meta_data" +
            " SET value = :name" +
            " WHERE id = :id" +
            " RETURNING value AS name, taxon_id AS speciesId, id, data->>'language' AS language," +
            " data->>'region' AS region")
    CommonName updateCommonName(@Bind("name") String name,
                                    @Bind("id") long id);

    @SqlQuery("INSERT INTO meta_data(version, taxon_id, value, type)" +
            " VALUES(0, :speciesId, :name, 'COMMON_NAME')" +
            " RETURNING value AS name, taxon_id AS speciesId, id," +
            " data->>'language' AS language, data->>'region' AS region")
    CommonName addCommonName(@Bind("name") String name, @Bind("speciesId") int speciesId);
}
