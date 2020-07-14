package autoconfigs.badconfig;

import autoconfigs.badclient.BadClientAutoConfiguration;
import badlib.badconfig.BadConfig;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@AutoConfigureBefore(BadClientAutoConfiguration.class)
public class BadConfigAutoConfiguration {
  private static class BadConfigInitializer {
    public BadConfigInitializer() {
      BadConfig.theDefaultValue = false;
    }
  }

  @Bean
  BadConfigInitializer badConfigInitializer() {
    return new BadConfigInitializer();
  }
}
