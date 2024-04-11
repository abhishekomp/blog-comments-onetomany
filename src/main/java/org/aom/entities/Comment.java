package org.aom.entities;

import jakarta.persistence.*;
import lombok.*;

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
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String content;

    @ManyToOne(cascade = { CascadeType.PERSIST })
    @JoinColumn(name = "post")
    private Blog blog;

    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", content='" + content + '\'' +
                '}';
    }
}
