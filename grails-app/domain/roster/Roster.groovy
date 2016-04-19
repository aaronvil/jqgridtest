package roster

class Roster {

    String name
    String position
    String department
    Location location

    static hasMany = [location: Location]
    static belongsTo = [location:Location]

    static constraints = {
        name(blank: false, maxSize: 100)
        position(blank: false)
        department(blank: false)
        location(nullable: true)
    }
}
