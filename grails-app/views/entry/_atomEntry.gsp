<entry xmlns='http://www.w3.org/2005/Atom'>
  <author>
    <name>${entryInstance.author.name}</name>
  </author>
  <published><g:atomDate>${entryInstance.dateCreated}</g:atomDate></published>
  <updated><g:atomDate>${entryInstance.lastUpdated}</g:atomDate></updated>
  <link href="http://blogito.org/blog/${entryInstance.author.login}/${entryInstance.title.encodeAsUnderscore()}" rel="alternate" title="${entryInstance.title}" type="text/html" />
  <id>tag:thirstyhead.com,2009:/blog/${entryInstance.author.login}/${entryInstance.title.encodeAsUnderscore()}</id>
  <title type="text">${entryInstance.title}</title>
  <content type="xhtml">
    <div xmlns="http://www.w3.org/1999/xhtml">
      ${entryInstance.summary}
    </div>
  </content>
</entry>
