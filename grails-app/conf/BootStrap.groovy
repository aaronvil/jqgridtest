import roster.Location
import roster.Roster

class BootStrap {
    def LA, NY
    def init = { servletContext ->
        if(Location.count() == 0){
            LA =  new Location(city: "Los Angles", state: "California", country: "USA", zipcode: "90001").save(failOnError: true)
            NY = new Location(city: "New York City", state: "New York", country: "USA", zipcode: "90002").save(failOnError: true)
        }

        if(Roster.count() == 0){
            new Roster(name: 'Henry', position: 'assistant', department: 'sales', location: LA).save(failOnError: true)
            new Roster(name: 'Jake', position: 'Tech', department: 'IT', location: LA).save(failOnError: true)
            new Roster(name: 'Aaron', position: 'Intern', department: 'IT', location: NY).save(failOnError: true)
            new Roster(name: 'Mary', position: 'Supervisor', department: 'HR', location: LA).save(failOnError: true)
            new Roster(name: 'Alice', position: 'CFO', department: 'Marketing', location: NY).save(failOnError: true)
            new Roster(name: 'Mark', position: 'assistant', department: 'sales', location: LA).save(failOnError: true)
            new Roster(name: 'Frank', position: 'Tech', department: 'IT', location: LA).save(failOnError: true)
            new Roster(name: 'Jessica', position: 'Intern', department: 'IT', location: NY).save(failOnError: true)
            new Roster(name: 'Sarah', position: 'Supervisor', department: 'HR', location: LA).save(failOnError: true)
            new Roster(name: 'Erik', position: 'CFO', department: 'Marketing', location: NY).save(failOnError: true)
        }


    }
    def destroy = {
    }
}
