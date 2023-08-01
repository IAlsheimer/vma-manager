package biz.alsheimer.vma;

import biz.alsheimer.vma.VmaApp;
import biz.alsheimer.vma.config.AsyncSyncConfiguration;
import biz.alsheimer.vma.config.EmbeddedElasticsearch;
import biz.alsheimer.vma.config.EmbeddedKafka;
import biz.alsheimer.vma.config.EmbeddedSQL;
import biz.alsheimer.vma.config.TestSecurityConfiguration;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;

/**
 * Base composite annotation for integration tests.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@SpringBootTest(classes = { VmaApp.class, AsyncSyncConfiguration.class, TestSecurityConfiguration.class })
@EmbeddedElasticsearch
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
@EmbeddedKafka
public @interface IntegrationTest {
}
