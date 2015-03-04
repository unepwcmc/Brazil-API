package org.unepwcmc.taxonifyapi.resources;

import com.google.common.base.Optional;
import com.sun.jersey.api.NotFoundException;
import io.dropwizard.jersey.params.LongParam;
import org.unepwcmc.taxonifyapi.dao.Taxon;
import org.unepwcmc.taxonifyapi.dao.TaxonDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

/**
 * Created by Simao on 02/03/15.
 */
@Path("/taxa/{speciesId}")
@Produces(MediaType.APPLICATION_JSON)
public class TaxonResource {
    private final TaxonDAO dao;

    public TaxonResource(TaxonDAO dao) {
        this.dao = dao;
    }

    @GET
    public Taxon getTaxon(@PathParam("speciesId") LongParam speciesId) {
        return findSafely(speciesId.get());
    }
    
    private Taxon findSafely(long speciesId) {
        Taxon taxon = dao.findById(speciesId);
        return taxon;
    }
}
