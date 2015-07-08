package com.ut.bookcase.service;

import com.ut.bookcase.persistence.Friend;
import com.ut.bookcase.web.dto.FriendDTO;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.stream.Collectors;

@Stateless
public class FriendsService {

    @PersistenceContext(unitName = "bookcase-unit")
    private EntityManager em;

    public List<FriendDTO> listAllFriends() {
        TypedQuery<Friend> allBooksQuery = em.createNamedQuery(Friend.ALL_FRIENDS, Friend.class);
        List<Friend> allBooks = allBooksQuery.getResultList();

        return allBooks.stream()
                .map(friend -> new FriendDTO(friend.getId(), friend.getName()))
                .collect(Collectors.toList());
    }
}
