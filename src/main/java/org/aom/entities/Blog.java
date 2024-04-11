package org.aom.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDate;
import java.util.Collection;

/**
 * @author  : Abhishek
 * @since   : 2024-04-11, Thursday
 **/
@Entity
@Builder(toBuilder = true)
@AllArgsConstructor(access = AccessLevel.PACKAGE)
@NoArgsConstructor(access = AccessLevel.PACKAGE)
//@Setter(value = AccessLevel.PROTECTED)
@Setter(value = AccessLevel.PUBLIC)
@Getter
@EqualsAndHashCode
//@ToString
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String content;
    private LocalDate createdOn;
    private String blogType;
    //private Collection<Comment> comments;

    @Override
    public String toString() {
        return "Blog{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", createdOn=" + createdOn +
                ", blogType='" + blogType + '\'' +
                '}';
    }
}
