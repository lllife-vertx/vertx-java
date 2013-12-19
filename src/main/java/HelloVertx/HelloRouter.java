package HelloVertx;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.vertx.java.core.Handler;
import org.vertx.java.core.buffer.Buffer;
import org.vertx.java.core.http.HttpServerRequest;
import org.vertx.java.core.http.RouteMatcher;

/**
 * Created by recovery on 12/19/13.
 */

public class HelloRouter extends RouteMatcher{

    private Logger _logger = LogManager.getLogger(this.getClass());

   public HelloRouter(){
       super();
       init();
   }

    private void init() {

        this.get("/hello", new Handler<HttpServerRequest>() {
            @Override
            public void handle(HttpServerRequest req) {
                req.response().end("Hi");
            }
        });

        this.post("/hello", new Handler<HttpServerRequest>() {
            @Override
            public void handle(HttpServerRequest httpServerRequest) {
                httpServerRequest.response().end("Hi");
            }

        });

        this.put("/hello", new Handler<HttpServerRequest>() {
            @Override
            public void handle(HttpServerRequest httpServerRequest) {

            }
        });

        this.post("/insert", new Handler<HttpServerRequest>() {
            @Override
            public void handle(final HttpServerRequest req) {
                req.bodyHandler(new Handler<Buffer>() {
                    @Override
                    public void handle(Buffer buffer) {
                        String message = buffer.getString(0, buffer.length());

                        _logger.info("[insert]");
                        _logger.info(message);

                        req.response().write(message);
                    }
                });

                req.response().write("OK..");
            }
        });
    }
}
