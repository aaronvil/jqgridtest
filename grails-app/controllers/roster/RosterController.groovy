package roster

import grails.converters.JSON

class RosterController {

    def scaffold = Roster

    def listRoster = {
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
        // def results = mobilesuits?.collect{[cell: ['', it.name, it.model, it.affiliation, it.pilot], id: it.id]}
        def jsonData = [rows: results, page: currentPage, records: totalRows, total: numberOfPages]
        render jsonData as JSON
    }
}
