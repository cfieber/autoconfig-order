package autoconfigs.badclient;

import badlib.badclient.BadClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BadClientAutoConfiguration {
  @Bean
  BadClient badClient() {
    return new BadClient();
  }
}
