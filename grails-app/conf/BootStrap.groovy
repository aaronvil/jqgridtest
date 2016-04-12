import roster.Roster

class BootStrap {

    def init = { servletContext ->
        if(Roster.count() == 0){
            new Roster(name: 'Henry', position: 'assistant', department: 'sales', location: 'LA branch').save()
            new Roster(name: 'Jake', position: 'Tech', department: 'IT', location: 'NY branch').save()
        }
    }
    def destroy = {
    }
}
