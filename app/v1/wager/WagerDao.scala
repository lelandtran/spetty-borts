package v1.wager

import javax.inject.Inject
import org.mongodb.scala._

import scala.concurrent.{ExecutionContext, Future}

class WagerDao @Inject()()(implicit ec: ExecutionContext){

  // Use a Connection String
  val mongoClient: MongoClient = MongoClient("mongodb://localhost:27017")

  val database: MongoDatabase = mongoClient.getDatabase("bortsdb")

  def findAll(): Future[Seq[Document]] = {
    database.getCollection("wager").find().toFuture()
  }
}
