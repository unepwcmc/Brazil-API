package org.unepwcmc.taxonifyapi.resources;

import io.dropwizard.jersey.params.LongParam;
import org.unepwcmc.taxonifyapi.dao.CommonName;
import org.unepwcmc.taxonifyapi.dao.CommonNamesDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/commonNames/{speciesId}")
@Produces(MediaType.APPLICATION_JSON)
public class CommonNamesResource {

    private final CommonNamesDAO dao;

    public CommonNamesResource(CommonNamesDAO dao) {
        this.dao = dao;
    }

    @GET
    public List<CommonName> getTaxon(@PathParam("speciesId") LongParam speciesId) {
        return dao.commonNamesFor(speciesId.get());
    }
}
