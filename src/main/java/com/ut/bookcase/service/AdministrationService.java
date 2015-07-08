package com.ut.bookcase.service;

import com.ut.bookcase.persistence.Book;
import com.ut.bookcase.persistence.Friend;
import com.ut.bookcase.web.dto.BookDTO;
import com.ut.bookcase.web.dto.FriendDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class AdministrationService {

    Logger logger = LoggerFactory.getLogger(AdministrationService.class);

    @PersistenceContext(unitName = "bookcase-unit")
    private EntityManager em;

    public List<BookDTO> listAllBooks() {
        TypedQuery<Book> allBooksQuery = em.createNamedQuery(Book.ALL_BOOKS, Book.class);
        List<Book> allBooks = allBooksQuery.getResultList();
        return allBooks.stream()
                .map(book -> {
                    Friend holder = book.getHolder();
                    FriendDTO friendDTO = holder != null ? new FriendDTO(holder.getId(), holder.getName()) : null;
                    return new BookDTO(book.getBookId(), book.getTitle(), book.getAuthor(), friendDTO);
                })
                .collect(Collectors.toList());
    }

    public void addBookToBookcase(BookDTO bookDTO) {
        logger.info("bookDTO - title: {}, author: {}", bookDTO.getTitle(), bookDTO.getAuthor());

        Book book = new Book(bookDTO.getTitle(), bookDTO.getAuthor());
        em.persist(book);
    }
}
