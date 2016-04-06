<%@ page import="roster.Roster" %>



<div class="fieldcontain ${hasErrors(bean: rosterInstance, field: 'name', 'error')} required">
    <label for="name">
        <g:message code="roster.name.label" default="Name"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="name" required="" value="${rosterInstance?.name}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rosterInstance, field: 'position', 'error')} required">
    <label for="position">
        <g:message code="roster.position.label" default="Position"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="position" required="" value="${rosterInstance?.position}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rosterInstance, field: 'department', 'error')} required">
    <label for="department">
        <g:message code="roster.department.label" default="Department"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="department" required="" value="${rosterInstance?.department}"/>

</div>

<div class="fieldcontain ${hasErrors(bean: rosterInstance, field: 'location', 'error')} required">
    <label for="location">
        <g:message code="roster.location.label" default="Location"/>
        <span class="required-indicator">*</span>
    </label>
    <g:textField name="location" required="" value="${rosterInstance?.location}"/>

</div>

