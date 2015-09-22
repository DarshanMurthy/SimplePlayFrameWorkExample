
// @GENERATOR:play-routes-compiler
// @SOURCE:/Users/tumkur/Downloads/activator-dist-1.3.6/PROJECTNAME/conf/routes
// @DATE:Sun Sep 20 21:46:51 PDT 2015


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
