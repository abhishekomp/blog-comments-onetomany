
# Hibernate One to Many mapping @OneToMany, @ManyToOne

This project demonstrates the usage of @OneToMany, @ManyToOne annotation along with cascade and @JoinColumn. 

- This project shows the implementation of @OneToMany, @ManyToOne mapping.
- UniDirectional mapping from Blog side: The relationship can be from Blog side when Blog knows about the Comments. Then use @OneToMany and mention @JoinColumn in Blog class.
- @JoinColumn is specified on the Owner entity (the entity that has the foreign key). In this case, Comment has the foreign key because there will be multiple comments for a Blog.
- In case of One to Many, the owner is always the "Many" side (Comment Entity).
- @JoinColumn defines the name of the foreign key column in the db table.
- UniDirectional mapping from Comment side: When we specify just the @ManyToOne annotation in the Comment class, then the Blog object doesn't know anything about the comment. However, Comment object knows about the Blog object with this set up.
- @JoinColumn is used on the Owner side of the relationship (Comment) but with one exception when we use @OneToMany in the Blog class.
- mappedBy attribute is used in the opposite side of the relationship (in the Blog class when defining bidirectional mapping)

## Lessons Learned

- Usage of cascade attribute when using @ManyToOne annotation on the Comment Entity to save Blog when saving Comment without writing persist(blog)  
  @ManyToOne(cascade = { CascadeType.PERSIST })  
- For @ManyToOne field the fetch is Eager by default.
- For @OneToMany field the fetch is Lazy by default.

## To run this program, MySQL db was used. Update db related parameters in MyCustomPersistenceUnitInfo.java



