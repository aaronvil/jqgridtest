package roster

import grails.converters.JSON

class RosterController {

    def scaffold = Roster

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
        def results = roster?.collect{ [cell: ['', it.name, it.position, it.department, it.location], id: it.id]
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
        def response = [state:state,id:id]
        render response as JSON
    }


}
