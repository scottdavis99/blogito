<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <meta name="layout" content="main" />
    <title>Blogito</title>
  </head>
  <body>
    <g:if test="${flash.message}">
      <div class="message">${flash.message}</div>
    </g:if>
    
    <div class="body">
      <div class="list">
        <g:each in="${searchResults}" status="i" var="entry">

        <div class="entry">
          <h2>
            <g:link action="show" 
                    id="${entry.id}">${entry.title}</g:link>
          </h2>                  
          <p>${entry.summary}</p>    
        </div>

        </g:each>
      </div>
    </div>    
    <div class="paginateButtons">
      <g:paginate total="${resultCount}" params="${flash}"/>
    </div>
  </body>
</html>
