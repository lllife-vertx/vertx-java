import HelloVertx.model.HelloInfo

vertx.eventBus.registerHandler("ping-address") { message ->
  message.reply("pong!")
  container.logger.info("Sent back pong groovy!")
}


var x = new HelloInfo();
x.name = "xx";
x.password = "yyy";

