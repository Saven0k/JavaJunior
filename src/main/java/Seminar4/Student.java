package Seminar4;

import jakarta.persistence.*;

@Entity()
@Table(name = "students")
public class Student {

  public Student() {
  }

  @Id
  @Column(name = "id")
  private long id;

  @Column(name = "first_name")
  private String first_name;

  @Column(name = "second_name")
  private String second_name;

  @Column(name = "group_name")
  private String group_name;

  @ManyToOne
  @JoinColumn(name = "group_id")
  private Group group_id;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getFirst_name() {
    return first_name;
  }

  public void setFirst_name(String first_name) {
    this.first_name = first_name;
  }

  public String getSecond_name() {
    return second_name;
  }

  public void setSecond_name(String second_name) {
    this.second_name = second_name;
  }

  public String getGroup_name() {
    return group_name;
  }

  public void setGroup_name(String group_name) {
    this.group_name = group_name;
  }

  public Group getGroup() {
    return group_id;
  }

  public void setGroup(Group group) {
    this.group_id = group;
  }

  @Override
  public String toString() {
    return "Student{" +
            "id=" + id +
            ", first_name='" + first_name + '\'' +
            ", second_name='" + second_name + '\'' +
            ", group_name='" + group_name + '\'' +
            ", group_id=" + group_id +
            '}';
  }
}
