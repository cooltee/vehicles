import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractJUnit4SpringContextTests;

/**
 * Base abstract class of text, use to upload spring context;
 * Note: No Transactional Test should extends this.
 * Created by Daniel on 2017/2/14.
 */
@ContextConfiguration(locations = {"classpath:/spring/spring-*.xml"})
public abstract class NoTransSpringTestSupport extends AbstractJUnit4SpringContextTests {
}
