

<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>Blogito</title>
  </head>
  <body>
    <g:if test="${session.user}">      
      <div class="nav">
        <span class="menuButton"><a class="home" href="${createLinkTo(dir:'')}">Home</a></span>
        <span class="menuButton"><g:link class="create" action="create">New Entry</g:link></span>
      </div>
    </g:if>
    
    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    
      <div class="body">
        <div class="list">
          <g:each in="${entryInstanceList}" status="i" var="entryInstance">
            <g:render template="entry" bean="${entryInstance}" var="entryInstance" />
          </g:each>
        </div>
      </div>    
      <div class="paginateButtons">
        <g:paginate total="${entryCount}" params="${flash}"/>
      </div>
  </body>
</html>
