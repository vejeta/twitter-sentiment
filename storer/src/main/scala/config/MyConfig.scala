package config

import classy.generic._
import classy.config._
import com.typesafe.config.Config

case class MyConfig(
  google: Google
)

case class Google(
  project: String,
  pubsub: PubSub
)

case class PubSub(
  subscriptionname: String
)

object storerconfig {

  val decoder = deriveDecoder[Config, MyConfig]
  def getConfig(): Either[_, MyConfig] = decoder.load()

}
