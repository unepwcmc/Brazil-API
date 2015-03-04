package org.unepwcmc.taxonifyapi.resources;

import io.dropwizard.jersey.params.LongParam;
import org.unepwcmc.taxonifyapi.dao.taxon.Taxon;
import org.unepwcmc.taxonifyapi.dao.taxon.TaxonDAO;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

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
