import roster.Location
import roster.Roster

class BootStrap {
    def LA
    def init = { servletContext ->
        if(Roster.count() == 0){
            new Roster(name: 'Henry', position: 'assistant', department: 'sales', location: LA).save()
            new Roster(name: 'Jake', position: 'Tech', department: 'IT', location: LA).save()
            new Roster(name: 'Aaron', position: 'Intern', department: 'IT', location: LA).save()
            new Roster(name: 'Mary', position: 'Supervisor', department: 'HR', location: LA).save()
            new Roster(name: 'Alice', position: 'CFO', department: 'Marketing', location: LA).save()
        }

        if(Location.count() == 0){
             LA =  new Location(city: "Los Angles", state: "California", country: "USA", zipcode: "90001").save()
        }
    }
    def destroy = {
    }
}
