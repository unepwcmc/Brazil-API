package org.unepwcmc.taxonifyapi.resources;

import com.google.common.base.Optional;
import org.unepwcmc.taxonifyapi.dao.taxa.Taxa;
import org.unepwcmc.taxonifyapi.dao.taxa.TaxaDAO;
import org.unepwcmc.taxonifyapi.dao.taxa.TaxaSearchResponse;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/taxa")
@Produces(MediaType.APPLICATION_JSON)
public class TaxaResource {
    private final TaxaDAO dao;

    public TaxaResource(TaxaDAO dao) {
        this.dao = dao;
    }


    @GET
    public TaxaSearchResponse searchTaxa(@QueryParam("scientificName") Optional<String> scientificName,
                              @QueryParam("rank") Optional<String> rank,
                              @QueryParam("page") Optional<Integer> page,
                              @QueryParam("perPage") Optional<Integer> perPage) {
        int myPage;
        int myPerPage;
        if(!perPage.isPresent() || perPage.get() < 0) {
            myPerPage = 50;
        } else if(perPage.get() > 400) {
            myPerPage = 400;
        } else {
            myPerPage = perPage.get();
        }
        if(!page.isPresent()){
            myPage = 0;
        } else {
            myPage = (page.get() - 1) * myPerPage;
        }
        
        int total;
        List<Taxa> species;
       if(scientificName.isPresent()) {
           String myRank = rank.isPresent() ? rank.get().toLowerCase() : "";
           String query = scientificName.get().trim();
           switch(myRank) {
               case "kingdom":
                   species = dao.findByKingdomName(query + "%", myPage, myPerPage);
                   total = dao.countForKingdomName(query+"%");
                   break;
               case "phylum":
                   species = dao.findByPhylumName(query + "%", myPage, myPerPage);
                   total = dao.countForPhylumName(query+"%");
                   break;
               case "class":
                   species = dao.findByClassName(query + "%", myPage, myPerPage);
                   total = dao.countForClassName(query+"%");
                   break;
               case "order":
                   species=  dao.findByOrderName(query + "%", myPage, myPerPage);
                   total = dao.countForOrderName(query+"%");
                   break;
               case "family":
                   species = dao.findByFamilyName(query + "%", myPage, myPerPage);
                   total = dao.countForFamilyName(query+"%");
                   break;
               case "genus":
                   species = dao.findByGenusName(query + "%", myPage, myPerPage);
                   total = dao.countForGenusName(query+"%");
                   break;
               default:
                  species = dao.findByScientificName(query + "%", myPage, myPerPage);
                   total = dao.countForScientificName(query+"%");

           }
       } else {
           species = dao.findAll(myPage, myPerPage);
           total = dao.countAll();
       }

        return new TaxaSearchResponse(total, species);
    }
}
