class Entry {
  static constraints = {
    title()
    summary(maxSize:1000)
    filename(blank:true, nullable:true)
    dateCreated()
    lastUpdated()
  }
  
  static mapping = {
    sort "lastUpdated":"desc"
  }  
  
  static belongsTo = [author:User]
  
  String title
  String summary
  String filename
  Date dateCreated
  Date lastUpdated
}
