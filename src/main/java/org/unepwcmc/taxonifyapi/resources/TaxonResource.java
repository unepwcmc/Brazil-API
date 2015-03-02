package org.unepwcmc.taxonifyapi.resources;

import com.codahale.metrics.annotation.Timed;
import com.google.common.base.Optional;
import org.unepwcmc.taxonifyapi.dao.Taxon;
import org.unepwcmc.taxonifyapi.dao.TaxonDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Simao on 02/03/15.
 */
@Path("/")
@Produces(MediaType.APPLICATION_JSON)
public class TaxonResource {
    private final TaxonDAO dao;

    public TaxonResource(TaxonDAO dao) {
        this.dao = dao;
    }

    @GET
    @Timed
    public List<Taxon> scientificName(@QueryParam("scientificName") Optional<String> scientificName) {
        return scientificName.isPresent() ? dao.findByScientificName(scientificName.get() + "%") : dao.findAll();
    }

}
