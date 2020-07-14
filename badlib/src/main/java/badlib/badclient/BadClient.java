package badlib.badclient;

import badlib.badconfig.BadConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class BadClient {
  private static final Logger log = LoggerFactory.getLogger(BadClient.class);

  public BadClient() {
    if (BadConfig.theDefaultValue) {
      throw new IllegalStateException("I don't work with the default value...");
    }

    log.info("You made the bad client!");
  }
}
