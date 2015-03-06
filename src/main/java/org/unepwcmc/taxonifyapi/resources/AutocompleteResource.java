package org.unepwcmc.taxonifyapi.resources;

import com.google.common.base.Optional;
import io.dropwizard.jersey.caching.CacheControl;
import org.unepwcmc.taxonifyapi.dao.autocomplete.AutocompleteDAO;
import org.unepwcmc.taxonifyapi.dao.autocomplete.Result;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Path("/autocomplete")
@Produces(MediaType.APPLICATION_JSON)
public class AutocompleteResource {
    private final AutocompleteDAO dao;

    public AutocompleteResource(AutocompleteDAO dao) {
        this.dao = dao;
    }

    @GET
    @CacheControl(maxAge=5, maxAgeUnit = TimeUnit.DAYS)
    public List<Result> getTaxon(@QueryParam("query") Optional<String> query) {
        return query.isPresent() ? dao.findByScientificName(query.get().trim()+"%") : null;
    }
}
