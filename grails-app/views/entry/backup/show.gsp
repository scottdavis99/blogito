

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
        <meta name="layout" content="main" />
        <title>Show Entry</title>
    </head>
    <body>
      <g:if test="${session.user}">     
        <div class="nav">
            <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
            <span class="menuButton"><g:link class="list" action="list">Entry List</g:link></span>
            <span class="menuButton"><g:link class="create" action="create">New Entry</g:link></span>
        </div>
      </g:if>  
        <div class="body">
          <g:render template="entry" bean="${entryInstance}" var="entryInstance" />

          <g:if test="${session.user}">      
            <div class="buttons">
                <g:form>
                    <input type="hidden" name="id" value="${entryInstance?.id}" />
                    <span class="button"><g:actionSubmit class="edit" value="Edit" /></span>
                    <span class="button"><g:actionSubmit class="delete" onclick="return confirm('Are you sure?');" value="Delete" /></span>
                </g:form>
            </div>
          </g:if>
        </div>
    </body>
</html>
