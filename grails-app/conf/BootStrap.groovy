import roster.Roster

class BootStrap {

    def init = { servletContext ->
        if(Roster.count() == 0){
            new Roster(name: 'Henry', position: 'assistant', department: 'sales', location: 'LA branch').save()
        }
    }
    def destroy = {
    }
}
