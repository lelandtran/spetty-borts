package dao

import javax.inject.Inject
import org.mongodb.scala._

import scala.collection.JavaConverters._
import scala.concurrent.{ExecutionContext, Future}

class WagerDao @Inject()()(implicit ec: ExecutionContext){

  // Use a Connection String
  val mongoClient: MongoClient = MongoClient("mongodb://localhost:27017")

  val database: MongoDatabase = mongoClient.getDatabase("bortsdb")

  def first() = {
    database.getCollection("wager").find().first().head()
  }
}
