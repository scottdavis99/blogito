class EntryController {

  def beforeInterceptor = [action:this.&auth, except:["index", "list", "show", "atom"]]

  def auth() {
    if(!session.user) {
      redirect(controller:"user", action:"login")
      return false
    }
  }

  def scaffold = Entry

  def atom = {
    if(!params.max) params.max = 10
    def list = Entry.list( params )    
    def lastUpdated = list[0].lastUpdated
    println request.serverName
    
    [ entryInstanceList:list, lastUpdated:lastUpdated ]
  }



  def save = {
      def entryInstance = new Entry(params)
      entryInstance.author = User.get(session.user.id)
      
      //handle uploaded file
      def uploadedFile = request.getFile('payload')
      if(!uploadedFile.empty){
        println "Class: ${uploadedFile.class}"
        println "Name: ${uploadedFile.name}"
        println "OriginalFileName: ${uploadedFile.originalFilename}"
        println "Size: ${uploadedFile.size}"
        println "ContentType: ${uploadedFile.contentType}"
        
        def webRootDir = servletContext.getRealPath("/")
        println webRootDir
        def userDir = new File(webRootDir, "/payload/${session.user.login}")
        userDir.mkdirs()
        uploadedFile.transferTo( new File( userDir, uploadedFile.originalFilename))               
        entryInstance.filename = uploadedFile.originalFilename
      }      
      
      if(!entryInstance.hasErrors() && entryInstance.save()) {
          flash.message = "Entry ${entryInstance.id} created"
          redirect(action:show,id:entryInstance.id)
      }
      else {
          render(view:'create',model:[entryInstance:entryInstance])
      }
  }


  //scaffolded code with authorization checks
  def edit = {
      def entryInstance = Entry.get( params.id )
      
      //limit editing to the original author
      if( !(session.user.login == entryInstance.author.login) ){
        flash.message = "Sorry, you can only edit your own entries."
        redirect(action:list)
      }

      if(!entryInstance) {
          flash.message = "Entry not found with id ${params.id}"
          redirect(action:list)
      }
      else {
          return [ entryInstance : entryInstance ]
      }
  }

  def delete = {
      def entryInstance = Entry.get( params.id )

      //limit deletes to the original author
      if( !(session.user.login == entryInstance.author.login) ){
        flash.message = "Sorry, you can only delete your own entries."
        redirect(action:list)
      }

      if(entryInstance) {
          entryInstance.delete()
          flash.message = "Entry ${params.id} deleted"
          redirect(action:list)
      }
      else {
          flash.message = "Entry not found with id ${params.id}"
          redirect(action:list)
      }
  }



  
  def list = {
      if(!params.max) params.max = 10
      flash.id = params.id
      if(!params.id) params.id = "No User Supplied"
      flash.title = params.title
      if(!params.title) params.title = ""

      def author = User.findByLogin(params.id)
      def entryList
      def entryCount
      if(author){
        def query = { 
          and{
            eq('author', author) 
            like("title", params.title.decodeUnderscore() + '%')
          }
        }  
        entryList = Entry.createCriteria().list(params, query)        
        entryCount = Entry.createCriteria().count(query)
      }else{
        entryList = Entry.list( params )
        entryCount = Entry.count()
      }
      
      [ entryInstanceList:entryList, entryCount:entryCount  ]
  }  
}