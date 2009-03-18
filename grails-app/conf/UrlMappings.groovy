class UrlMappings {
    static mappings = {
      "/$controller/$action?/$id?"{
	      constraints {
			 // apply constraints here
		  }
	  }
	  "/"(controller:"entry")
	  "/blog/$id/$title?"(controller:"entry", action="list")
	  "/entry/$action?/$id?/$title?"(controller:"entry")
	  "500"(view:'/error')
	}
}
