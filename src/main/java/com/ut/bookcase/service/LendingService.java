package com.ut.bookcase.service;

import com.ut.bookcase.persistence.Book;
import com.ut.bookcase.persistence.Person;
import com.ut.bookcase.web.dto.LendingDTO;
import com.ut.bookcase.web.dto.LendingToNewPersonDTO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class LendingService {

    @PersistenceContext(unitName = "bookcase-unit")
    private EntityManager em;

    public void lendBook(LendingDTO lendingDTO) {
        Person borrower = em.find(Person.class, lendingDTO.getBorrowerId());
        Book book = em.find(Book.class, lendingDTO.getBookId());

        book.setHolder(borrower);
    }

    public void lendBookToNewPerson(LendingToNewPersonDTO lendingDTO) {
        Person person = new Person(lendingDTO.getName());
        em.persist(person);

        Book book = em.find(Book.class, lendingDTO.getBookId());
        book.setHolder(person);
    }

    public void returnBook(LendingDTO lendingDTO) {
        Book book = em.find(Book.class, lendingDTO.getBookId());

        book.setHolder(null);
    }
}
