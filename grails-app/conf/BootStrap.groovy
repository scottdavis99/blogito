import grails.util.GrailsUtil

class BootStrap {

  def init = { servletContext ->
    switch(GrailsUtil.environment){
      case "development":
        new Entry(title:"Grails 1.1 beta is out", summary:"Check out the new features").save()
        new Entry(title:"Just Released - Groovy 1.6 beta 2", summary:"It is looking good.").save()
      break

      case "production":
      break
    }

  }
  def destroy = {
  }
} 