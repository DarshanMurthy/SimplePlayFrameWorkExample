
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/tumkur/Desktop/Fraud-As-a-Service/conf/routes
// @DATE:Tue Sep 22 15:19:37 PDT 2015


package router {
  object RoutesPrefix {
    private var _prefix: String = "/"
    def setPrefix(p: String): Unit = {
      _prefix = p
    }
    def prefix: String = _prefix
    val byNamePrefix: Function0[String] = { () => prefix }
  }
}
