package org.unepwcmc.taxonifyapi.dao.taxon;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


@RegisterMapper(TaxonMapper.class)
public interface TaxonDAO {


    @SqlQuery("SELECT taxon.* FROM taxon WHERE taxon.id = :taxonId GROUP BY taxon.id")
    Taxon findById(@Bind("taxonId") long taxonId);

}
