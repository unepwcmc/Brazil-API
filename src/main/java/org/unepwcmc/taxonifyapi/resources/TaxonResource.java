package org.unepwcmc.taxonifyapi.resources;

import io.dropwizard.jersey.params.LongParam;
import org.unepwcmc.taxonifyapi.dao.taxon.Taxon;
import org.unepwcmc.taxonifyapi.dao.taxon.TaxonDAO;

import javax.validation.Valid;
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
        Taxon taxon = dao.findById(speciesId.get());
        taxon.setCommonNames(dao.getCommonNames(speciesId.get()));
        taxon.setDistribution(dao.getDistribution(speciesId.get()));
        return taxon;
    }
    
    @PUT
    @Consumes("application/json")
    public Taxon updateTaxon(@PathParam("speciesId") LongParam speciesId,
                             @Valid Taxon taxon) {
        taxon = dao.updateTaxon(speciesId.get(), taxon.getDescription());
        taxon.setCommonNames(dao.getCommonNames(speciesId.get()));
        taxon.setDistribution(dao.getDistribution(speciesId.get()));
        return taxon;
    }
}
