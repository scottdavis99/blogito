class EntryController {
  def scaffold = Entry
  
  def list = {
      if(!params.max) params.max = 10
      flash.id = params.id
      if(!params.id) params.id = "No User Supplied"

      def author = User.findByLogin(params.id)
      def entryList
      def entryCount
      if(author){
        def query = { eq('author', author) }
        entryList = Entry.createCriteria().list(params, query)        
        entryCount = Entry.createCriteria().count(query)
      }else{
        entryList = Entry.list( params )
        entryCount = Entry.count()
      }
      
      [ entryInstanceList:entryList, entryCount:entryCount  ]
  }  
}