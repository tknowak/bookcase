package com.ut.bookcase.service;

import com.ut.bookcase.persistence.Friend;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.ut.bookcase.persistence.Book;
import com.ut.bookcase.web.dto.LendingDTO;
import com.ut.bookcase.web.dto.LendingToNewFriendDTO;

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

        Friend borrower = em.find(Friend.class, lendingDTO.getBorrowerId());
        Book book = em.find(Book.class, lendingDTO.getBookId());

        book.setHolder(borrower);
    }

    public void lendBookToNewFriend(LendingToNewFriendDTO lendingDTO) {
        logger.info("lendingDTO - book id: {}, friend: {}", lendingDTO.getBookId(), lendingDTO.getName());

        Friend friend = new Friend(lendingDTO.getName());
        em.persist(friend);

        Book book = em.find(Book.class, lendingDTO.getBookId());
        book.setHolder(friend);
    }

    public void returnBook(int bookId) {
        logger.info("Returning book with id: {}", bookId);

        Book book = em.find(Book.class, bookId);
        book.setHolder(null);
    }
}
