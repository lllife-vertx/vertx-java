package HelloVertx;
/*
 * Copyright 2013 Red Hat, Inc.
 *
 * Red Hat licenses this file to you under the Apache License, version 2.0
 * (the "License"); you may not use this file except in compliance with the
 * License.  You may obtain a copy of the License at:
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.  See the
 * License for the specific language governing permissions and limitations
 * under the License.
 *
 * @author <a href="http://tfox.org">Tim Fox</a>
 */

import org.vertx.java.core.Handler;
import org.vertx.java.core.eventbus.Message;
import org.vertx.java.core.http.HttpServer;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.core.http.RouteMatcher;
import org.vertx.java.platform.Verticle;

/*
This is a simple Java verticle which receives `ping` messages on the event bus and sends back `pong` replies
 */
public class PingVerticle extends Verticle {

//    public void start() {
//
//
//        vertx.eventBus().registerHandler("ping-address", new Handler<Message<String>>() {
//            @Override
//            public void handle(Message<String> message) {
//                message.reply("pong!");
//                container.logger().info("Sent back pong");
//            }
//        });
//
//        container.logger().info("PingVerticle started");
//
//
//    }

//    public  void start(){
//        final HttpServer server = vertx.createHttpServer();
//        final int port  = 8877;
//
//        server.requestHandler(new Handler<HttpServerRequest>() {
//            @Override
//            public void handle(HttpServerRequest req) {
//                req.response().putHeader("Content-Type", "text/plain");
//                req.response().end("Hello world");
//            }
//        });
//
//        container.logger().info("Hello world! @0.0.0.0:8877");
//        server.listen(port, "0.0.0.0");
//
//    }

    public void start() {
        HttpServer server = vertx.createHttpServer();
        RouteMatcher hello = new HelloRouter();

        vertx.eventBus().registerHandler("ping-address", new Handler<Message<String>>() {
            @Override
            public void handle(Message<String> message) {
                message.reply("pong!");
                container.logger().info("Sent back pong");
            }
        });

        container.logger().info("PingVerticle started");
        server.requestHandler(hello).listen(8877, "0.0.0.0");
    }
}
