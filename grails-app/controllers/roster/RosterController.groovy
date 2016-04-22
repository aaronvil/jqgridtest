package roster

import grails.converters.JSON

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class RosterController {

    static allowedMethods = [save: "POST", update: "PUT", delete: "DELETE"]

    def index(Integer max) {
        params.max = Math.min(max ?: 10, 100)
        respond Roster.list(params), model: [rosterInstanceCount: Roster.count()]
    }

    def listLocation(Integer max){
        params.max = Math.min(max ?: 10,100)
        respond Location.list(params), model: [locationInstanceCount: Location.count()]
    }

    def show(Roster rosterInstance) {
        respond rosterInstance
    }
    def showLocation(Roster locationInstance) {
        respond locationInstance
    }

    def create() {
        respond new Roster(params)
    }


    def listAllRoster = {
        def sortIndex = params.sidx ?: 'name'
        def sortOrder = params.sord ?: 'asc'
        def maxRows = Integer.valueOf(params.rows)
        def currentPage = Integer.valueOf(params.page) ?:1
        def rowOffset = currentPage == 1 ? 0 : (currentPage -1) * maxRows
        def roster = Roster.createCriteria().list(max: maxRows, offset: rowOffset){
            if (params.name) ilike('name', "%${params.name}%")
            if (params.position) ilike('position', "%${params.position}%")
            if (params.department) ilike('department', "%${params.department}%")
            if (params.location) ilike('location', "%${params.location}%")
        }
        def totalRows = roster.totalCount
        def numberOfPages = Math.ceil(totalRows / maxRows)
        //the first attribute in the collection is for the edit feature action thing
        def results = roster?.collect{ [cell: ['', it.name, it.position, it.department, it.location.toString()], id: it.id]
        }
        def jsonData = [rows: results, page: currentPage, records: totalRows, total: numberOfPages]
        render jsonData as JSON
    }

    def editAllRoster = {
        def item = null
        def message = ""
        def state = "FAIL"
        def id

        params.theObject = Roster.get(params.id)

        switch (params.oper){
            case 'edit':
                if(params.name)
                    params.theObject.name = params.name
                if(params.position)
                    params.theObject.position = params.position
                if(params.department)
                    params.theObject.department = params.deparment
                if(params.location)
                    params.theObject.location = params.location

                if (! params.theObject.hasErrors() && params.theObject.save()) {
                    id params.theObject.id
                    state = "OK"
                }
                break;
            case 'del':
                item = Roster.get(params.id)
                if(item) {
                    item.delete()
                    message ="Name'${item.name}' Deleted"
                    state = "OK"
                }
                break;
            case 'add':
                respond new Roster(params)
                break;
        }

        def response = [state:state,id:id]
        render response as JSON
    }

    def listAllLocations = {
        def sortIndex = params.sidx ?: 'city'
        def sortOrder = params.sord ?: 'asc'
        def maxRows = Integer.valueOf(params.rows)
        def currentPage = Integer.valueOf(params.page) ?:1
        def rowOffset = currentPage == 1 ? 0 : (currentPage -1) * maxRows
        def location = Location.createCriteria().list(max: maxRows, offset: rowOffset){
            if (params.city) ilike('city', "%${params.city}%")
            if (params.state) ilike('state', "%${params.state}%")
            if (params.country) ilike('country', "%${params.country}%")
            if (params.zipcode) ilike('zipcode', "%${params.zipcdode}%")
        }

        def totalRows = location.totalCount
        def numberOfPages = Math.ceil(totalRows/maxRows)
        def results = roster?.collect{[cell: ['', it.city, it.state, it.country, it.zipcode], id: it.id]}
        def jsonData = [rows: results, page: currentPage, records: totalRows, total: numberOfPages]
        render jsonData as JSON
    }

    def editAllLocation = {
        def item = null
        def message = ""
        def state = "FAIL"
        def id

        params.theObject = Location.get(params.id)

        if(params.city)
            params.theObject.city = params.city
        if(params.state)
            params.theObject.state = params.state
        if(params.country)
            params.theObject.country = params.country
        if(params.zipcode)
            params.theObject.zipcode = params.zipcode

        if (! params.theObject.hasErrors() && params.theObject.save()) {
            id params.theObject.id
            state = "OK"
        }
        def response = [state:state,id:id]
        render response as JSON

    }

    def listLocation = {
        def lst = roster.Location.list()

        StringBuffer buf = new StringBuffer("<select")

        lst.each{
            buf.append("<option value=\"${it.id}\">")
            buf.append(it.toString())
            buf.append("</option>")
        }
        buf.append("</select>")
        render buf.toString()

    }


    @Transactional
    def save(Roster rosterInstance) {
        if (rosterInstance == null) {
            notFound()
            return
        }

        if (rosterInstance.hasErrors()) {
            respond rosterInstance.errors, view: 'create'
            return
        }

        rosterInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'roster.label', default: 'Roster'), rosterInstance.id])
                redirect rosterInstance
            }
            '*' { respond rosterInstance, [status: CREATED] }
        }
    }

    def edit(Roster rosterInstance) {
        respond rosterInstance
    }

    @Transactional
    def update(Roster rosterInstance) {
        if (rosterInstance == null) {
            notFound()
            return
        }

        if (rosterInstance.hasErrors()) {
            respond rosterInstance.errors, view: 'edit'
            return
        }

        rosterInstance.save flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.updated.message', args: [message(code: 'Roster.label', default: 'Roster'), rosterInstance.id])
                redirect rosterInstance
            }
            '*' { respond rosterInstance, [status: OK] }
        }
    }

    @Transactional
    def delete(Roster rosterInstance) {

        if (rosterInstance == null) {
            notFound()
            return
        }

        rosterInstance.delete flush: true

        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.deleted.message', args: [message(code: 'Roster.label', default: 'Roster'), rosterInstance.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NO_CONTENT }
        }
    }

    protected void notFound() {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.not.found.message', args: [message(code: 'roster.label', default: 'Roster'), params.id])
                redirect action: "index", method: "GET"
            }
            '*' { render status: NOT_FOUND }
        }
    }

}
