# IndeedBot
###### RESTful API
[![BUILD](https://github.com/AdamWandoch/indeed-bot-api/actions/workflows/maven.yml/badge.svg?branch=split)](https://github.com/AdamWandoch/indeed-bot-api/actions/workflows/maven.yml)

VIEW DEPLOYMENT : [HEROKU](https://indeed-bot.herokuapp.com) < | >
[AWS](https://ru4umr3xja.eu-west-1.awsapprunner.com)

This is an experimental project to explore Java ecosystem of technologies for web development.

This application serves data from Postgres Database gathered by [indeed-bot](https://github.com/AdamWandoch/indeed-bot)

This Spring Boot powered RESTful API is running on Heroku and another instance on AWS.

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
[/job/{index}](http://indeed-bot.herokuapp.com/job/0) - retrieves a single job object <br>
[/jobs](http://indeed-bot.herokuapp.com/jobs) - retrieves a list of all job objects <br>
[/jobs/sort/id](http://indeed-bot.herokuapp.com/jobs/sort/id) - retrieves a list of all job objects sorted by ID <br>
[/jobs/sort/title](http://indeed-bot.herokuapp.com/jobs/sort/title) - retrieves a list of all job objects in sorted by title <br>
[/jobs/sort/company](http://indeed-bot.herokuapp.com/jobs/sort/company) - retrieves a list of all job objects in sorted by company <br>
[/jobs/title/{keyword}](http://indeed-bot.herokuapp.com/jobs/title/software) - retrieves a list of jobs containing keyword in title <br>
[/jobs/title/{keyword}/sort/id](http://indeed-bot.herokuapp.com/jobs/title/software/sort/id) - retrieves a list of jobs containing keyword in title sorted by ID <br>
[/jobs/title/{keyword}/sort/title](http://indeed-bot.herokuapp.com/jobs/title/software/sort/title) - retrieves a list of jobs containing keyword in title sorted by title <br>
[/jobs/title/{keyword}/sort/company](http://indeed-bot.herokuapp.com/jobs/title/software/sort/company) - retrieves a list of jobs containing keyword in title sorted by company <br>
[/jobs/company/{keyword}](http://indeed-bot.herokuapp.com/jobs/company/reperio) - retrieves a list of jobs containing keyword in company name <br>
[/jobs/company/{keyword}/sort/id](http://indeed-bot.herokuapp.com/jobs/company/reperio/sort/id) - retrieves a list of jobs containing keyword in company name sorted by ID <br>
[/jobs/company/{keyword}/sort/title](http://indeed-bot.herokuapp.com/jobs/company/reperio/sort/title) - retrieves a list of jobs containing keyword in company name sorted by title <br>
[/jobs/company/{keyword}/sort/company](http://indeed-bot.herokuapp.com/jobs/company/reperio/sort/company) - retrieves a list of jobs containing keyword in company name sorted by company <br>

