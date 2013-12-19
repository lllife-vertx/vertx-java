package HelloVertx.model

/**
 * Created by recovery on 12/19/13.
 */
class HelloInfoTest extends GroovyTestCase {
    void testInsert() {
        HelloInfo info = new HelloInfo();
        info.setEmail("somnuk.wk@gmail.com");
        info.setPassword("1234");
        info.setName("Somnuk Wongkhan");
        boolean result = info.insert();
        assertEquals(true, result);
    }
}
