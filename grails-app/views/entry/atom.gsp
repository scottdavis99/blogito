<% response.setContentType("application/atom+xml") %><feed xmlns="http://www.w3.org/2005/Atom">
  <title type="text">News from Blogito.org</title>
  <link rel="alternate" type="text/html" href="http://blogito.org/"/>
  <link rel="self" type="application/atom+xml" href="http://blogito.org/entry/atom" />
  <updated><g:atomDate>${lastUpdated}</g:atomDate></updated>
  <author><name>Blogito.org</name></author>
  <id>tag:blogito.org,2009-01-01:entry/atom</id>
  <generator uri="http://blogito.org" version="0.1">Hand-rolled Grails code</generator>

  <g:each in="${entryInstanceList}" status="i" var="entryInstance">
<g:render template="atomEntry" bean="${entryInstance}" var="entryInstance" />
  </g:each>  
  
</feed>