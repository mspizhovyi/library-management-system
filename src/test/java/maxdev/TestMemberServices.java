package maxdev;

import maxdev.factory.AudioBookFactory;
import maxdev.factory.EBookFactory;
import maxdev.factory.PaperBookFactory;
import maxdev.model.Book;
import maxdev.model.Member;
import maxdev.service.BorrowingBookResult;
import maxdev.service.BorrowingServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestMemberServices {

    @Test
    void testSameServiceInjected() {
        var service = BorrowingServiceImpl.getInstance();
        Member m1 = new Member("A", service);
        Member m2 = new Member("B", service);
        assertSame(m1.getBorrowingService(), m2.getBorrowingService());
    }

    @Test
    void testInjectedServiceNotNull() {
        Member m1 = new Member("A", BorrowingServiceImpl.getInstance());
        assertNotNull(m1.getBorrowingService());
    }

    @Test
    void testMemberUsesServiceWithPaperBook() {
        Member m = new Member("A", BorrowingServiceImpl.getInstance());
        Book b = new PaperBookFactory().createBook("Clean Code");
        BorrowingBookResult r = m.borrowBook(b);
        assertTrue(r.isSuccess());
    }

    @Test
    void testMemberUsesServiceWithEBook() {
        Member m = new Member("A", BorrowingServiceImpl.getInstance());
        Book b = new EBookFactory().createBook("Clean Architecture");
        BorrowingBookResult r = m.borrowBook(b);
        assertTrue(r.isSuccess());
    }

    @Test
    void testMemberUsesServiceWithAudioBook() {
        Member m = new Member("A", BorrowingServiceImpl.getInstance());
        Book b = new AudioBookFactory().createBook("Design Patterns");
        BorrowingBookResult r = m.borrowBook(b);
        assertTrue(r.isSuccess());
    }

    @Test
    void testBorrowLimitRespectedThroughInjectedService() {
        Member m = new Member("A", BorrowingServiceImpl.getInstance());
        m.borrowBook(new PaperBookFactory().createBook("Clean Code"));
        m.borrowBook(new PaperBookFactory().createBook("Clean Architecture"));
        m.borrowBook(new PaperBookFactory().createBook("Design Patterns"));
        BorrowingBookResult r =
                m.borrowBook(new PaperBookFactory().createBook("Agile Development"));
        assertFalse(r.isSuccess());
    }
}
