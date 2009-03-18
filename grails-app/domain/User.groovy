class User {
  static constraints = {
    login(unique:true, blank:false, nullable:false)
    password(password:true, blank:false, nullable:false)
    name(blank:false, nullable:false)
    role(inList:["author", "admin"])
  }
  
  static hasMany = [entries:Entry]
  
  String login
  String password
  String name
  String role
  
  String toString(){
    name
  }
}
