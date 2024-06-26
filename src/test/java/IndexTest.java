import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.List;

public class IndexTest {
    record IndexResponse(String programmer, List<String> progLangs);

    @Test
    public void testIndex() {
        String url = "http://localhost:8000/index";

    }
}
