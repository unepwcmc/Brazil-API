package org.unepwcmc.taxonifyapi.resources;

import com.google.common.base.Optional;
import org.unepwcmc.taxonifyapi.dao.TaxaSearchResponse;
import org.unepwcmc.taxonifyapi.dao.Taxon;
import org.unepwcmc.taxonifyapi.dao.TaxonDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/taxa")
@Produces(MediaType.APPLICATION_JSON)
public class TaxaResource {
    private final TaxonDAO dao;

    public TaxaResource(TaxonDAO dao) {
        this.dao = dao;
    }


    @GET
    public TaxaSearchResponse searchTaxa(@QueryParam("scientificName") Optional<String> scientificName,
                              @QueryParam("rank") Optional<String> rank,
                              @QueryParam("page") Optional<Integer> page,
                              @QueryParam("perPage") Optional<Integer> perPage) {
        int myPage;
        int myPerPage;
        if(!perPage.isPresent() || perPage.get() < 0 || perPage.get() > 400) {
            myPerPage = 50;
        } else {
            myPerPage = perPage.get();
        }
        if(!page.isPresent()){
            myPage = 1;
        } else {
            myPage = (page.get() - 1) * myPerPage;
        }
        
        int total;
        List<Taxon> species;
       if(scientificName.isPresent()) {
           switch(rank.get().toLowerCase()) {
               case "kingdom":
                   species = dao.findByKingdomName(scientificName.get() + "%", myPage, myPerPage);
                   total = dao.countForKingdomName(scientificName.get()+"%");
                   break;
               case "phylum":
                   species = dao.findByPhylumName(scientificName.get() + "%", myPage, myPerPage);
                   total = dao.countForPhylumName(scientificName.get()+"%");
                   break;
               case "class":
                   species = dao.findByClassName(scientificName.get() + "%", myPage, myPerPage);
                   total = dao.countForClassName(scientificName.get()+"%");
                   break;
               case "order":
                   species=  dao.findByOrderName(scientificName.get() + "%", myPage, myPerPage);
                   total = dao.countForOrderName(scientificName.get()+"%");
                   break;
               case "family":
                   species = dao.findByFamilyName(scientificName.get() + "%", myPage, myPerPage);
                   total = dao.countForFamilyName(scientificName.get()+"%");
                   break;
               case "genus":
                   species = dao.findByGenusName(scientificName.get() + "%", myPage, myPerPage);
                   total = dao.countForGenusName(scientificName.get()+"%");
                   break;
               default:
                  species = dao.findByScientificName(scientificName.get() + "%", myPage, myPerPage);
                   total = dao.countForScientificName(scientificName.get()+"%");

           }
       } else {
           species = dao.findAll(myPage, myPerPage);
           total = dao.countAll();
       }

        return new TaxaSearchResponse(total, species);
    }
}
