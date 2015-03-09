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
    
    @PUT
    @Consumes("application/json")
    public CommonName updateCommonName(@Valid CommonName commonName) {
        return commonName.getId() != 0 ?
                dao.updateCommonName(commonName.getName(), commonName.getId(),
                        commonName.getLanguage(), commonName.getRegion()) :
                dao.addCommonName(commonName.getName(), commonName.getSpeciesId(),
                        commonName.getLanguage(), commonName.getRegion());
    }
    
    @DELETE
    @Path("/{commonNameId}")
    @Consumes("application/json")
    public void deleteCommonName(@PathParam("commonNameId") LongParam commonNameId) {
        dao.deleteCommonName(commonNameId.get());
    }
}
