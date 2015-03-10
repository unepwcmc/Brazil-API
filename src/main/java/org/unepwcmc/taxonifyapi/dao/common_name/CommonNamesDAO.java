package org.unepwcmc.taxonifyapi.dao.common_name;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;

import java.util.List;

@RegisterMapper(CommonNamesMapper.class)
public interface CommonNamesDAO {

    @SqlQuery("SELECT id, value AS name, data->>'language' AS language, data->>'region' AS region," +
            " taxon_id AS speciesId FROM meta_data WHERE type = 'COMMON_NAME'"+
            " AND taxon_id = :speciesId")
    List<CommonName> commonNamesFor(@Bind("speciesId") long speciesId);

    @SqlQuery("UPDATE meta_data" +
            " SET value = :name, data = CAST('{\"language\": \"' || :language || '\"," +
            " \"region\": \"' || :region || '\"}' AS JSON)" +
            " WHERE id = :id" +
            " RETURNING value AS name, taxon_id AS speciesId, id, data->>'language' AS language," +
            " data->>'region' AS region")
    CommonName updateCommonName(@Bind("name") String name, @Bind("id") long id,
                                @Bind("language") String language, @Bind("region") String region);

    @SqlQuery("INSERT INTO meta_data(version, taxon_id, value, type, data)" +
            " VALUES(0, :speciesId, :name, 'COMMON_NAME'," +
            " CAST('{\"language\": \"' || :language || '\", \"region\": \"' || :region || '\"}' AS JSON))" +
            " RETURNING value AS name, taxon_id AS speciesId, id," +
            " data->>'language' AS language, data->>'region' AS region")
    CommonName addCommonName(@Bind("name") String name, @Bind("speciesId") int speciesId,
                             @Bind("language") String language, @Bind("region") String region);

    @SqlUpdate("DELETE FROM meta_data WHERE id = :commonNameId AND type = 'COMMON_NAME'")
    void deleteCommonName(@Bind("commonNameId") long commonNameId);
}
