package bootapp;

import badlib.badclient.BadClient;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

@SpringBootTest(classes = Main.class, properties = "breaky.enabled=false")
public class StartupTest {

  @Autowired
  ApplicationContext ctx;

  @Autowired
  BadClient badClient;

  @Test
  public void testStartupWithBadClientDependency() {
    Assertions.assertThat(ctx.getBean("badClient")).isNotNull();
    Assertions.assertThat(badClient).isNotNull();
  }
}
