package org.unepwcmc.taxonifyapi.resources;

import io.dropwizard.jersey.params.LongParam;
import org.unepwcmc.taxonifyapi.dao.common_name.CommonName;
import org.unepwcmc.taxonifyapi.dao.common_name.CommonNamesDAO;

import javax.validation.Valid;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/commonNames")
@Produces(MediaType.APPLICATION_JSON)
public class CommonNamesResource {

    private final CommonNamesDAO dao;

    public CommonNamesResource(CommonNamesDAO dao) {
        this.dao = dao;
    }

    @GET
    @Path("/{speciesId}")
    public List<CommonName> getTaxon(@PathParam("speciesId") LongParam speciesId) {
        return dao.commonNamesFor(speciesId.get());
    }
    
    @POST
    public CommonName updateDistribution(@Valid CommonName commonName) {
        return commonName.getId() != 0 ?
                dao.updateCommonName(commonName.getName(), commonName.getId()) :
                dao.addCommonName(commonName.getName(), commonName.getSpeciesId());
    }
}
