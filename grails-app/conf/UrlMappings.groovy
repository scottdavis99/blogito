class UrlMappings {
    static mappings = {
      "/$controller/$action?/$id?"{
	      constraints {
			 // apply constraints here
		  }
	  }
	  "/"(controller:"entry")
	  "/blog/$id"(controller:"entry", action="list")
	  "500"(view:'/error')
	}
}
