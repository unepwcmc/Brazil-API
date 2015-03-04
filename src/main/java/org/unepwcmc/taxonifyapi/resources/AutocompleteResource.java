package org.unepwcmc.taxonifyapi.resources;

import com.google.common.base.Optional;
import org.unepwcmc.taxonifyapi.dao.autocomplete.AutocompleteDAO;
import org.unepwcmc.taxonifyapi.dao.autocomplete.Result;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/autocomplete")
@Produces(MediaType.APPLICATION_JSON)
public class AutocompleteResource {
    private final AutocompleteDAO dao;

    public AutocompleteResource(AutocompleteDAO dao) {
        this.dao = dao;
    }

    @GET
    public List<Result> getTaxon(@QueryParam("query") Optional<String> query) {
        return query.isPresent() ? dao.findByScientificName(query.get()+"%") : null;
    }
}
