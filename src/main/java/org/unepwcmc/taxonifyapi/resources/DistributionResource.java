package org.unepwcmc.taxonifyapi.resources;

import io.dropwizard.jersey.params.LongParam;
import org.unepwcmc.taxonifyapi.dao.distribution.Distribution;
import org.unepwcmc.taxonifyapi.dao.distribution.DistributionDAO;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/distribution")
@Produces(MediaType.APPLICATION_JSON)
public class DistributionResource {
    private final DistributionDAO dao;

    public DistributionResource(DistributionDAO dao) {
        this.dao = dao;
    }

    @GET
    @Path("/{speciesId}")
    public List<Distribution> getDistributionFor(@PathParam("speciesId") LongParam speciesId) {
        return dao.distributionFor(speciesId.get());
    }
    
    @PUT
    @Consumes("application/json")
    public Distribution updateDistribution(@Valid Distribution distribution) {
       return distribution.getId() != 0 ?
               dao.updateDistribution(distribution.getRegion(), distribution.getId()) :
               dao.addDistribution(distribution.getRegion(), distribution.getSpeciesId());
    }
}
