/*
 * Copyright (C) 2015-2019 Lightbend Inc. <https://www.lightbend.com>
 */
package play.soap.sbtplugin.tester

import java.net.ServerSocket
import java.util.Arrays
import java.util.concurrent.atomic.AtomicBoolean
import javax.xml.ws.Endpoint
import javax.xml.ws.handler.soap._
import javax.xml.ws.handler.MessageContext

import org.apache.cxf.jaxws.EndpointImpl
import play.soap.testservice.client._
import scala.collection.JavaConverters._
import scala.concurrent.{Await, Future}
import scala.concurrent.duration._
import scala.reflect.ClassTag

import play.api.test._
import play.api.Application
import play.api.inject.guice.GuiceApplicationBuilder
import play.soap.testservice.PrimitivesImpl

/*
 * THIS FILE IS AUTO GENERATED. DO NOT EDIT THIS FILE MANUALLY.
 *
 * Run 'generate-primitives.py' to regenerate it.
 */

object PrimitivesSpec extends ServiceSpec {

  sequential
  "Primitives" should {

    "handle boolean ops" in withClient { client =>
      await(client.booleanOp(true)) must_== true
    }

    "handle boolean sequences" in withClient { client =>
      await(client.booleanSequence(Arrays.asList(true, true))).asScala must_== List(true, true, true)
    }
    "handle byte ops" in withClient { client =>
      await(client.byteOp(1.toByte)) must_== 1.toByte
    }

    "handle byte sequences" in withClient { client =>
      await(client.byteSequence(Arrays.asList(1.toByte, 1.toByte))).asScala must_== List(1.toByte, 1.toByte, 1.toByte)
    }
    "handle double ops" in withClient { client =>
      await(client.doubleOp(1.0d)) must_== 1.0d
    }

    "handle double sequences" in withClient { client =>
      await(client.doubleSequence(Arrays.asList(1.0d, 1.0d))).asScala must_== List(1.0d, 1.0d, 1.0d)
    }
    "handle float ops" in withClient { client =>
      await(client.floatOp(1.0f)) must_== 1.0f
    }

    "handle float sequences" in withClient { client =>
      await(client.floatSequence(Arrays.asList(1.0f, 1.0f))).asScala must_== List(1.0f, 1.0f, 1.0f)
    }
    "handle int ops" in withClient { client =>
      await(client.intOp(1)) must_== 1
    }

    "handle int sequences" in withClient { client =>
      await(client.intSequence(Arrays.asList(1, 1))).asScala must_== List(1, 1, 1)
    }
    "handle long ops" in withClient { client =>
      await(client.longOp(1L)) must_== 1L
    }

    "handle long sequences" in withClient { client =>
      await(client.longSequence(Arrays.asList(1L, 1L))).asScala must_== List(1L, 1L, 1L)
    }
    "handle short ops" in withClient { client =>
      await(client.shortOp(1.toShort)) must_== 1.toShort
    }

    "handle short sequences" in withClient { client =>
      await(client.shortSequence(Arrays.asList(1.toShort, 1.toShort))).asScala must_== List(1.toShort, 1.toShort, 1.toShort)
    }
  }

  override type ServiceClient = PrimitivesService

  override type Service = Primitives

  override implicit val serviceClientClass: ClassTag[PrimitivesService] = ClassTag(classOf[PrimitivesService])

  override def getServiceFromClient(c: ServiceClient): Service = c.primitives

  override def createServiceImpl(): Any = new PrimitivesImpl

  val servicePath: String = "primitives"

}