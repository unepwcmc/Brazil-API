package org.unepwcmc.taxonifyapi;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.eclipse.jetty.servlets.CrossOriginFilter;
import org.skife.jdbi.v2.DBI;
import org.unepwcmc.taxonifyapi.dao.autocomplete.AutocompleteDAO;
import org.unepwcmc.taxonifyapi.dao.common_name.CommonNamesDAO;
import org.unepwcmc.taxonifyapi.dao.distribution.DistributionDAO;
import org.unepwcmc.taxonifyapi.dao.taxa.TaxaDAO;
import org.unepwcmc.taxonifyapi.dao.taxon.TaxonDAO;
import org.unepwcmc.taxonifyapi.resources.*;

import javax.servlet.DispatcherType;
import javax.servlet.FilterRegistration;
import java.util.EnumSet;

/**
 * Created by Simao on 02/03/15.
 */
public class ApiApplication extends Application<ApiConfiguration> {
    @Override
    public String getName() {
        return "taxonify-api";
    }

    @Override
    public void initialize(Bootstrap<ApiConfiguration> bootstrap) {
        bootstrap.addBundle(new AssetsBundle("/app", "/", "index.html"));
    }

    public static void main(String[] args) throws Exception {
        new ApiApplication().run(args);
    }

    @Override
    public void run(ApiConfiguration config, Environment environment) throws Exception {
        environment.jersey().setUrlPattern("/api/*");

        final FilterRegistration.Dynamic cors =
                environment.servlets().addFilter("CORS", CrossOriginFilter.class);
        
        cors.setInitParameter("allowedOrigins", "*");
        cors.setInitParameter("allowedHeaders", "X-Requested-With,Content-Type,Accept,Origin");
        cors.setInitParameter("allowedMethods", "OPTIONS,GET,PUT,POST,DELETE,HEAD");
        
        cors.addMappingForUrlPatterns(EnumSet.allOf(DispatcherType.class), true, "/*");

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, config.getDataSourceFactory(), "postgresql");
        final TaxonDAO dao = jdbi.onDemand(TaxonDAO.class);
        final TaxaDAO taxaDao = jdbi.onDemand(TaxaDAO.class);
        final CommonNamesDAO commonNamesDAO = jdbi.onDemand(CommonNamesDAO.class);
        final DistributionDAO distributionDAO = jdbi.onDemand(DistributionDAO.class);
        final AutocompleteDAO autocompleteDAO = jdbi.onDemand(AutocompleteDAO.class);

        environment.jersey().register(new TaxonResource(dao));
        environment.jersey().register(new TaxaResource(taxaDao));
        environment.jersey().register(new CommonNamesResource(commonNamesDAO));
        environment.jersey().register(new DistributionResource(distributionDAO));
        environment.jersey().register(new AutocompleteResource(autocompleteDAO));
    }
}
