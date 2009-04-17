<div class="entry">
  <span class="entry-date"><g:longDate>${entryInstance.lastUpdated}</g:longDate> : ${entryInstance.author}</span>
  <h2><g:link action="show" id="${entryInstance.id}">${entryInstance.title}</g:link></h2>                  
  <p>${entryInstance.summary}</p>    
  
  <!--
  <g:if test="${entryInstance.filename}">
    <p>
      <img src="${createLinkTo(dir:'payload/'+entryInstance.author.login,
                               file:''+entryInstance.filename)}" 
           alt="${entryInstance.filename}" 
           title="${entryInstance.filename}" />
    </p>    
  </g:if>
  -->
  
  <g:displayFile filename="${entryInstance.filename}" 
                 user="${entryInstance.author.login}" />
              
</div>