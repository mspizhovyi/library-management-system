package maxdev;

import maxdev.service.BorrowingServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSingleton {

    @Test
    void testSameInstance() {
        assertSame(BorrowingServiceImpl.getInstance(),
                BorrowingServiceImpl.getInstance());
    }

    @Test
    void testSingletonNotNull() {
        assertNotNull(BorrowingServiceImpl.getInstance());
    }
}
