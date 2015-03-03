package org.unepwcmc.taxonifyapi;

import io.dropwizard.Application;
import io.dropwizard.assets.AssetsBundle;
import io.dropwizard.jdbi.DBIFactory;
import io.dropwizard.setup.Bootstrap;
import io.dropwizard.setup.Environment;
import org.skife.jdbi.v2.DBI;
import org.unepwcmc.taxonifyapi.dao.TaxonDAO;
import org.unepwcmc.taxonifyapi.resources.TaxonResource;

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

        final DBIFactory factory = new DBIFactory();
        final DBI jdbi = factory.build(environment, config.getDataSourceFactory(), "postgresql");
        final TaxonDAO dao = jdbi.onDemand(TaxonDAO.class);

        environment.jersey().register(new TaxonResource(dao));
    }
}
