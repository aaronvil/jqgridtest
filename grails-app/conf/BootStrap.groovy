import roster.Roster

class BootStrap {

    def init = { servletContext ->
        if(Roster.count() == 0){
            new Roster(name: 'Henry', position: 'assistant', department: 'sales', location: 'LA branch').save()
            new Roster(name: 'Jake', position: 'Tech', department: 'IT', location: 'NY branch').save()
            new Roster(name: 'Aaron', position: 'Intern', department: 'IT', location: 'London Branch').save()
            new Roster(name: 'Mary', position: 'Supervisor', department: 'HR', location: 'Main Branch').save()
            new Roster(name: 'Alice', position: 'CFO', department: 'Marketing', location: 'London Branch').save()
        }
    }
    def destroy = {
    }
}
