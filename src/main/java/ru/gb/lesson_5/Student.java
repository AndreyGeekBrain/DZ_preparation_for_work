package ru.gb.lesson_5;

import javax.persistence.*;

@Entity
@Table(name = "student")
public class Student {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   @Column(name = "id")
   private Long id;
   @Column(name = "name")
   private String name;
   @Column(name = "mark")
   private int mark;

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public int getMark() {
      return mark;
   }

   public void setMark(int mark) {
      this.mark = mark;
   }

   public Student(String name, int mark) {
      this.name = name;
      this.mark = mark;
   }

   public Student() {

   }

   @Override
   public String toString() {
      return "Student{" +
              "id=" + id +
              ", name='" + name + '\'' +
              ", mark=" + mark +
              '}';
   }
}
