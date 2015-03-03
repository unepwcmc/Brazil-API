package org.unepwcmc.taxonifyapi.resources;

import com.google.common.base.Optional;
import org.unepwcmc.taxonifyapi.dao.Taxon;
import org.unepwcmc.taxonifyapi.dao.TaxonDAO;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by Simao on 03/03/15.
 */
@Path("/taxa")
@Produces(MediaType.APPLICATION_JSON)
public class TaxaResource {
    private final TaxonDAO dao;

    public TaxaResource(TaxonDAO dao) {
        this.dao = dao;
    }


    @GET
    public List<Taxon> searchTaxa(@QueryParam("scientificName") Optional<String> scientificName,
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
       if(scientificName.isPresent()) {
           switch(rank.get().toLowerCase()) {
               case "kingdom":
                   return dao.findByKingdomName(scientificName.get() + "%", myPage, myPerPage);
               case "phylum":
                   return dao.findByPhylumName(scientificName.get() + "%", myPage, myPerPage);
               case "class":
                   return dao.findByClassName(scientificName.get() + "%", myPage, myPerPage);
               case "order":
                   return dao.findByOrderName(scientificName.get() + "%", myPage, myPerPage);
               case "family":
                   return dao.findByFamilyName(scientificName.get() + "%", myPage, myPerPage);
               case "genus":
                   return dao.findByGenusName(scientificName.get() + "%", myPage, myPerPage);
               default:
                  return dao.findByScientificName(scientificName.get() + "%", myPage, myPerPage);
                   
           }
       } else {
           return dao.findAll(myPage, myPerPage);
       }
    }
}
