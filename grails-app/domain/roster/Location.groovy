package roster

class Location {

    String city
    String state
    String country
    String zipcode

    static constraints = {
        city(blank: false, maxSize: 100)
        state(nullable: true)
        country(blank: false, maxSize: 100)
        zipcode(blank: false, maxSize: 10)

    }
}
