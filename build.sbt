lazy val root = (project in file("."))
 .aggregate(client)

lazy val client = project in file("client")

lazy val plugin = (project in file("sbt-plugin"))
  .settings(scriptedSettings: _*)
  .settings(
    (resourceGenerators in Compile) <+= generateVersionFile,
    scriptedDependencies := {
      val () = publishLocal.value
      val () = (publishLocal in client).value
    }
  )

def generateVersionFile = Def.task {
  val clientVersion = (version in client).value
  val pluginVersion = version.value
  val file = (resourceManaged in Compile).value / "play-soap.version.properties"
  val content =
    s"""play-soap-client.version=$clientVersion
       |play-soap-sbt.version=$pluginVersion
     """.stripMargin
  if (!file.exists() || !(IO.read(file) == content)) {
    IO.write(file, content)
  }
  Seq(file)
}