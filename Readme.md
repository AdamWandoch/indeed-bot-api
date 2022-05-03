##### :exclamation::exclamation::exclamation: MY AWS ACCOUNT HAS BEEN SUSPENDED :exclamation::exclamation::exclamation:
##### :exclamation::exclamation::exclamation: RUN THE PROJECT LOCALLY, CHECK HEROKU_MASTER BRANCH OR CONTACT ME FOR INFO :exclamation::exclamation::exclamation:

# IndeedBot API
###### RESTful API
[![BUILD](https://github.com/AdamWandoch/indeed-bot-api/actions/workflows/maven.yml/badge.svg?branch=split)](https://github.com/AdamWandoch/indeed-bot-api/actions/workflows/maven.yml)

VIEW DEPLOYMENT : [AWS](http://indeedbotapi-env.eba-6i3bdcsz.eu-west-1.elasticbeanstalk.com/)

This is an experimental project to explore Java ecosystem of technologies for web development.

The application serves data from Postgres Database gathered by instances of [indeed-bot.](https://github.com/AdamWandoch/indeed-bot)

This Spring Boot powered RESTful API is deployed on AWS.

#### To run the project locally:
* install PostgreSQL
* create a local postgres database (I'm using pgAdmin for local postgres administration)
* install Java 11 or higher
* [install](https://github.com/AdamWandoch/indeed-bot#readme) indeed-bot to populate database
* git clone this repository
* add system environment variables:
   * POSTGRES_USERNAME set value to your local postgres username
   * POSTGRES_PASSWORD set value to your local postgres password
   * SPRING_PROFILE set value to dev
* rename application-dev-sample.properties to application-dev.properties
* update application-dev.properties spring.datasource.url property with your database name (I used indeed-db)
* install Maven or use your favourite IDE that has Maven support (I recommend IntelliJ IDEA)
* build, run and let me know what can we improve :)
#### Available endpoints serving JSON:
[/job/{index}](http://indeedbotapi-env.eba-6i3bdcsz.eu-west-1.elasticbeanstalk.com/job/0) - retrieves a single job object <br>
[/jobs](http://indeedbotapi-env.eba-6i3bdcsz.eu-west-1.elasticbeanstalk.com/jobs) - retrieves a list of all job objects <br>
[/jobs/sort/id](http://indeedbotapi-env.eba-6i3bdcsz.eu-west-1.elasticbeanstalk.com/jobs/sort/id) - retrieves a list of all job objects sorted by ID <br>
[/jobs/sort/title](http://indeedbotapi-env.eba-6i3bdcsz.eu-west-1.elasticbeanstalk.com/jobs/sort/title) - retrieves a list of all job objects in sorted by title <br>
[/jobs/sort/company](http://indeedbotapi-env.eba-6i3bdcsz.eu-west-1.elasticbeanstalk.com/jobs/sort/company) - retrieves a list of all job objects in sorted by company <br>
[/jobs/title/{keyword}](http://indeedbotapi-env.eba-6i3bdcsz.eu-west-1.elasticbeanstalk.com/jobs/title/software) - retrieves a list of jobs containing keyword in title <br>
[/jobs/title/{keyword}/sort/id](http://indeedbotapi-env.eba-6i3bdcsz.eu-west-1.elasticbeanstalk.com/jobs/title/software/sort/id) - retrieves a list of jobs containing keyword in title sorted by ID <br>
[/jobs/title/{keyword}/sort/title](http://indeedbotapi-env.eba-6i3bdcsz.eu-west-1.elasticbeanstalk.com/jobs/title/software/sort/title) - retrieves a list of jobs containing keyword in title sorted by title <br>
[/jobs/title/{keyword}/sort/company](http://indeedbotapi-env.eba-6i3bdcsz.eu-west-1.elasticbeanstalk.com/jobs/title/software/sort/company) - retrieves a list of jobs containing keyword in title sorted by company <br>
[/jobs/company/{keyword}](http://indeedbotapi-env.eba-6i3bdcsz.eu-west-1.elasticbeanstalk.com/jobs/company/reperio) - retrieves a list of jobs containing keyword in company name <br>
[/jobs/company/{keyword}/sort/id](http://indeedbotapi-env.eba-6i3bdcsz.eu-west-1.elasticbeanstalk.com/jobs/company/reperio/sort/id) - retrieves a list of jobs containing keyword in company name sorted by ID <br>
[/jobs/company/{keyword}/sort/title](http://indeedbotapi-env.eba-6i3bdcsz.eu-west-1.elasticbeanstalk.com/jobs/company/reperio/sort/title) - retrieves a list of jobs containing keyword in company name sorted by title <br>
[/jobs/company/{keyword}/sort/company](http://indeedbotapi-env.eba-6i3bdcsz.eu-west-1.elasticbeanstalk.com/jobs/company/reperio/sort/company) - retrieves a list of jobs containing keyword in company name sorted by company <br>

