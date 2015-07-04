package com.ut.bookcase.service;

import com.ut.bookcase.persistence.Book;
import com.ut.bookcase.persistence.Person;
import com.ut.bookcase.web.dto.BookDTO;
import com.ut.bookcase.web.dto.PersonDTO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class AdministrationService {

    @PersistenceContext(unitName = "bookcase-unit")
    private EntityManager em;

    public List<BookDTO> listAllBooks() {
        TypedQuery<Book> allBooksQuery = em.createNamedQuery(Book.ALL_BOOKS, Book.class);
        List<Book> allBooks = allBooksQuery.getResultList();
        return allBooks.stream()
                .map(book -> {
                    Person holder = book.getHolder();
                    PersonDTO personDTO = holder != null ? new PersonDTO(holder.getId(), holder.getName()) : null;
                    return new BookDTO(book.getBookId(), book.getTitle(), book.getAuthor(), personDTO);
                })
                .collect(Collectors.toList());
    }

    public void addBookToBookcase(BookDTO bookDTO) {
        Book book = new Book(bookDTO.getTitle(), bookDTO.getAuthor());
        em.persist(book);
    }
}
