class UserController {
  
  def beforeInterceptor = [action:this.&auth, except:["login", "authenticate", "logout"]]

  def auth() {
    if( !(session?.user?.role == "admin") ){
      flash.message = "You must be an administrator to perform that task."
      redirect(controller:"user", action:"login")
      return false
    }
  }  
  
  def scaffold = User
  
  def login = {}
  
  def authenticate = {
    def user = User.findByLoginAndPassword(params.login, params.password)
    if(user){
      session.user = user
      flash.message = "Hello ${user.name}!"
      redirect(controller:"entry", action:"list")      
    }else{
      flash.message = "Sorry, ${params.login}. Please try again."
      redirect(action:"login")
    }
  }
  
  def logout = {
    flash.message = "Goodbye ${session.user.name}"
    session.user = null
    redirect(controller:"entry", action:"list")      
  }  
}