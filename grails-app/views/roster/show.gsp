<%@ page import="roster.Roster" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="layout" content="main">
    <g:set var="entityName" value="${message(code: 'roster.label', default: 'Roster')}"/>
    <title><g:message code="default.show.label" args="[entityName]"/></title>
</head>

<body>
<a href="#show-roster" class="skip" tabindex="-1"><g:message code="default.link.skip.label"
                                                             default="Skip to content&hellip;"/></a>

<div class="nav" role="navigation">
    <ul>
        <li><a class="home" href="${createLink(uri: '/')}"><g:message code="default.home.label"/></a></li>
        <li><g:link class="list" action="index"><g:message code="default.list.label" args="[entityName]"/></g:link></li>
        <li><g:link class="create" action="create"><g:message code="default.new.label"
                                                              args="[entityName]"/></g:link></li>
    </ul>
</div>

<div id="show-roster" class="content scaffold-show" role="main">
    <h1><g:message code="default.show.label" args="[entityName]"/></h1>
    <g:if test="${flash.message}">
        <div class="message" role="status">${flash.message}</div>
    </g:if>
    <ol class="property-list roster">

        <g:if test="${rosterInstance?.name}">
            <li class="fieldcontain">
                <span id="name-label" class="property-label"><g:message code="roster.name.label" default="Name"/></span>

                <span class="property-value" aria-labelledby="name-label"><g:fieldValue bean="${rosterInstance}"
                                                                                        field="name"/></span>

            </li>
        </g:if>

        <g:if test="${rosterInstance?.position}">
            <li class="fieldcontain">
                <span id="position-label" class="property-label"><g:message code="roster.position.label"
                                                                            default="Position"/></span>

                <span class="property-value" aria-labelledby="position-label"><g:fieldValue bean="${rosterInstance}"
                                                                                            field="position"/></span>

            </li>
        </g:if>

        <g:if test="${rosterInstance?.department}">
            <li class="fieldcontain">
                <span id="department-label" class="property-label"><g:message code="roster.department.label"
                                                                              default="Department"/></span>

                <span class="property-value" aria-labelledby="department-label"><g:fieldValue bean="${rosterInstance}"
                                                                                              field="department"/></span>

            </li>
        </g:if>

        <g:if test="${rosterInstance?.location}">
            <li class="fieldcontain">
                <span id="location-label" class="property-label"><g:message code="roster.location.label"
                                                                            default="Location"/></span>

                <span class="property-value" aria-labelledby="location-label"><g:fieldValue bean="${rosterInstance}"
                                                                                            field="location"/></span>

            </li>
        </g:if>

    </ol>
    <g:form url="[resource: rosterInstance, action: 'delete']" method="DELETE">
        <fieldset class="buttons">
            <g:link class="edit" action="edit" resource="${rosterInstance}"><g:message code="default.button.edit.label"
                                                                                       default="Edit"/></g:link>
            <g:actionSubmit class="delete" action="delete"
                            value="${message(code: 'default.button.delete.label', default: 'Delete')}"
                            onclick="return confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}');"/>
        </fieldset>
    </g:form>
</div>
</body>
</html>
