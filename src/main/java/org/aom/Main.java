package org.aom;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import org.aom.entities.Blog;
import org.aom.entities.Comment;
import org.aom.utils.HibernateUtils;

import java.time.LocalDate;

/**
 * @author : ${USER}
 * @since : ${YEAR}-${MONTH}-${DAY}, ${DAY_NAME_FULL}
 **/
public class Main {


    public static void main(String[] args) {
        System.out.println("Hello world!");

        EntityManagerFactory emf = HibernateUtils.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        try{

            em.getTransaction().begin();

            //get the existing blog
            Blog blog = em.find(Blog.class, 3);
            // New comment
            Comment comment = Comment.builder().content("Third comment for Technical Blog - Java Collections").blog(blog).build();

            em.persist(comment); // will properly associate the comment with the existing blog.

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }

/*    public static void main(String[] args) {
        System.out.println("Hello world!");

        Blog blog = Blog.builder().title("Java Collections").blogType("Technical").createdOn(LocalDate.now()).content("Learn Java Collections").build();
        Comment commentOne = Comment.builder().content("First comment for Technical Blog - Java Collections").blog(blog).build();
        Comment commentTwo = Comment.builder().content("Second comment for Technical Blog - Java Collections").blog(blog).build();

        Blog blogTwo = Blog.builder().title("Resilience").blogType("Motivational").createdOn(LocalDate.now()).content("How to be Resilient").build();
        Comment commentOne_motivationalBlog = Comment.builder().content("First comment for Motivational Blog - Resilience").blog(blogTwo).build();

        EntityManagerFactory emf = HibernateUtils.createEntityManagerFactory();
        EntityManager em = emf.createEntityManager();
        try{

            em.getTransaction().begin();

            //em.persist(blog);
            em.persist(commentOne);
            em.persist(commentTwo);

            //em.persist(blogTwo);
            em.persist(commentOne_motivationalBlog);

            em.getTransaction().commit();
        } finally {
            em.close();
        }
    }*/
}