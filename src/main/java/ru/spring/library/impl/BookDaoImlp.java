package ru.spring.library.impl;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.*;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import ru.spring.library.dao.BookDao;
import ru.spring.library.entities.Author;
import ru.spring.library.entities.Book;
import ru.spring.library.entities.Genre;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;
import javax.xml.transform.Transformer;
import java.util.List;

@Component
@EnableTransactionManagement
public class BookDaoImlp implements BookDao {
    @Autowired
    private SessionFactory sessionFactory;

    ProjectionList bookProjection;
    private List<Book> books;

    public BookDaoImlp(){
        bookProjection= Projections.projectionList();
        bookProjection.add(Projections.property("bookId"),"bookId");
        bookProjection.add(Projections.property("name"),"name");
        bookProjection.add(Projections.property("image"),"image");
        bookProjection.add(Projections.property("genreId"),"genreId");
        bookProjection.add(Projections.property("pageCount"),"pageCount");
        bookProjection.add(Projections.property("isbn"),"isbn");
        bookProjection.add(Projections.property("pubisherYear"),"pubisherYear");
        bookProjection.add(Projections.property("desor"),"desor");
        bookProjection.add(Projections.property("raiting"),"raiting");
        bookProjection.add(Projections.property("voteCount"),"voteCount");
        bookProjection.add(Projections.property("authorId"),"authorId");
        bookProjection.add(Projections.property("publisherId"),"publisherId");
    }
    @Transactional
    public List<Book> getBooks() {
//        CriteriaBuilder buider=sessionFactory.getCriteriaBuilder();
//        CriteriaQuery<Book> criteria=buider.createQuery(Book.class);
//        criteria.from(Book.class);
//        books=sessionFactory.getCurrentSession().createQuery(criteria).getResultList();


        books=createBookList(createBookCriteria());
        return books;
    }

    @Transactional
    public List<Book> getBooks(Author authorId) {
        books=createBookList(createBookCriteria().add(Restrictions.ilike("authorId.fio",authorId.getFio(),MatchMode.ANYWHERE)));
        return books;
    }

    @Transactional
    public List<Book> getBooks(String bookName) {
        books=createBookList(createBookCriteria().add(Restrictions.ilike("b.name",bookName,MatchMode.ANYWHERE)));
        return books;
    }
    @Transactional
    public List<Book> getBooks(Genre genre) {
        return null;
    }
    @Transactional
    public List<Book> getBooks(Character letter) {

        books=createBookList(createBookCriteria().add(Restrictions.ilike("b.name",letter.toString(),MatchMode.START)));
        return books;
    }

    private DetachedCriteria createBookCriteria(){
        DetachedCriteria bookListCriteria=DetachedCriteria.forClass(Book.class,"b");
        createAliases(bookListCriteria);
        return bookListCriteria;
    }
    private void createAliases(DetachedCriteria criteria){
        criteria.createAlias("b.authorId","authorId");
        criteria.createAlias("b.genreId","genreId");
        criteria.createAlias("b.publisherId","publisherId");
    }

    private List<Book> createBookList(DetachedCriteria bookListCriteria){

        Criteria criteria=bookListCriteria.getExecutableCriteria(sessionFactory.getCurrentSession());
        criteria.addOrder(Order.asc("b.name")).setProjection(bookProjection).setResultTransformer(Transformers.aliasToBean(Book.class));
        return criteria.list();
    }
}
