package com.ut.bookcase.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ut.bookcase.persistence.Book;
import com.ut.bookcase.persistence.Person;
import com.ut.bookcase.web.dto.LendingDTO;
import com.ut.bookcase.web.dto.LendingToNewPersonDTO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LendingService {

    Logger logger = LoggerFactory.getLogger(LendingService.class);

    @PersistenceContext(unitName = "bookcase-unit")
    private EntityManager em;

    public void lendBook(LendingDTO lendingDTO) {
        logger.info("lendingDTO - book id: {}, borrower id: {}", lendingDTO.getBookId(), lendingDTO.getBorrowerId());

        Person borrower = em.find(Person.class, lendingDTO.getBorrowerId());
        Book book = em.find(Book.class, lendingDTO.getBookId());

        book.setHolder(borrower);
    }

    public void lendBookToNewPerson(LendingToNewPersonDTO lendingDTO) {
        logger.info("lendingDTO - book id: {}, friend: {}", lendingDTO.getBookId(), lendingDTO.getName());

        Person person = new Person(lendingDTO.getName());
        em.persist(person);

        Book book = em.find(Book.class, lendingDTO.getBookId());
        book.setHolder(person);
    }

    public void returnBook(LendingDTO lendingDTO) {
        logger.info("lendingDTO - book id: {}, borrower id: {}", lendingDTO.getBookId(), lendingDTO.getBorrowerId());

        Book book = em.find(Book.class, lendingDTO.getBookId());

        book.setHolder(null);
    }
}
