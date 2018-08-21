package ru.spring.library.beans;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.spring.library.entities.Genre;

@Component
public class TestBean {

    @Autowired
    private SessionFactory sessionFactory;
    public void test(){
        Session session=sessionFactory.openSession();
        Genre genre;
        genre=session.get(Genre.class,1);
        genre.setName("myNewName");
        session.close();

    }
}
