package roster

class Roster {

    String name
    String position
    String department
    String location

    static constraints = {
        name(blank: false)
        position(blank: false)
        department(blank: false)
        location(blank: false)
    }
}
