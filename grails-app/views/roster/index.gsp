<%@ page import="roster.Roster" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'roster.label', default: 'Roster')}"/>
    <title><g:message code="default.list.label" args="[entityName]"/></title>
</head>
<body>
<a href="#list-roster" class="skip" tabindex="-1"><g:message code="default.link.skip.label" default="Skip to content&hellip;"/></a>
<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label" args="[entityName]" /></g:link></li>
    </ul>
</div>

<div class="pageBody">
    %{--MUST HAVE THE RESOUCE TAGS FOR JQGRID TO WORK
        joqgrid rendered in the listGrid template
    --}%
    <jq:resources />
    <jqui:resources />
    <jqgrid:resources />
    <g:render template="listGrid"/>
</div>
</body>
</html>



%{-- The original code

<a href="#list-roster" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                             default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="list-roster" class="content scaffold-list" role="main">
    <h1><g:message code="default.list.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <table>
        <thead>
        <tr>

            <g:sortableColumn property="name" title="${message(code: 'roster.name.label', default: 'Name')}"/>

            <g:sortableColumn property="position"
                              title="${message(code: 'roster.position.label', default: 'Position')}"/>

            <g:sortableColumn property="department"
                              title="${message(code: 'roster.department.label', default: 'Department')}"/>

            <g:sortableColumn property="location"
                              title="${message(code: 'roster.location.label', default: 'Location')}"/>

        </tr>
        </thead>
        <tbody>
        <g:each in="${rosterInstanceList}" status="i" var="rosterInstance">
            <tr class="${(i % 2) == 0 ? 'even' : 'odd'}">

                <td><g:link action="show"
                            id="${rosterInstance.id}">${fieldValue(bean: rosterInstance, field: "name")}</g:link></td>

                <td>${fieldValue(bean: rosterInstance, field: "position")}</td>

                <td>${fieldValue(bean: rosterInstance, field: "department")}</td>

                <td>${fieldValue(bean: rosterInstance, field: "location")}</td>

            </tr>
        </g:each>
        </tbody>
    </table>

    <div class="pagination">
        <g:paginate total="${rosterInstanceCount ?: 0}"/>
    </div>
</div>
</body>
</html>--}%
