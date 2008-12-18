class UrlMappings {
    static mappings = {
      "/$controller/$action?/$id?"{
	      constraints {
			 // apply constraints here
		  }
	  }
	  "/"(controller:"entry")
	  "500"(view:'/error')
	}
}
