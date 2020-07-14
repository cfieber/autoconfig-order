package bootapp;

import badlib.badclient.BadClient;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

@SpringBootTest(classes = {Main.class, BreakyTest.BreakyConfiguration.class})
public class BreakyTest {

  @Test
  public void test_referenceToAutoconfiguredBeanBreaksAutoconfigurationOrder() {
    System.out.println("this test fails because BreakyConfiguration references BreakyClient and it doesn't AutoConfigureAfter BreakyConfigAutoConfiguration");
  }

  @TestConfiguration
  public static class BreakyConfiguration {
    @Bean
    Breaky breaky(BadClient badClient) {
      return new Breaky(badClient);
    }
  }

  public static class Breaky {
    private final BadClient badClient;
    public Breaky(BadClient badClient) {
      this.badClient = badClient;
    }
  }
}
