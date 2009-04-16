import grails.util.GrailsUtil

class BootStrap {

  def init = { servletContext ->
    switch(GrailsUtil.environment){
      case "development":
        def admin = new User(login:"admin", password:"password", name:"Administrator", role:"admin")
        admin.save()
      
        def jdoe = new User(login:"jdoe", password:"password", name:"John Doe", role:"author")
        def e1 = new Entry(title:"Grails 1.1 beta is out", summary:"Check out the new features")
        def e2 = new Entry(title:"Just Released - Groovy 1.6 beta 2", summary:"It is looking good.")
        jdoe.addToEntries(e1)
        jdoe.addToEntries(e2)
        jdoe.save()
        
        def jsmith = new User(login:"jsmith", password:"wordpass", name:"Jane Smith", role:"author")
        def e3 = new Entry(title:"Codecs in Grails", summary:"See Mastering Grails")
        def e4 = new Entry(title:"Testing with Groovy", summary:"See Practically Groovy")
        jsmith.addToEntries(e3)
        jsmith.addToEntries(e4)
        jsmith.save()              
      break

      case "production":
      break
    }

  }
  def destroy = {
  }
} 