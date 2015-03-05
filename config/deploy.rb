require 'capistrano/ext/multistage'
set :application, "Taxonify-API-Capistrano"
set :repository, "git@github.com:unepwcmc/Taxonify-API.git"
set :branch, "master"
set :scm, "git"
set :scm_username, 'unepwcmc-read'
set :user, "ubuntu"
set(:deploy_to) { File.join("", "home", user, application) }
ssh_options[:forward_agent] = true
namespace :TaxonifyAPI do
task :deploy do
puts "==================Building with Maven======================"
run "cd #{deploy_to}/current && mvn package"
run "sudo service Taxonify-API restart"
end
end
after "deploy", "TaxonifyAPI:deploy"
