package Seminar4;

import jakarta.persistence.*;

import java.util.List;

@Entity()
@Table(name = "groups")
public class Group {
  public Group() {
  }

  @Id
  @Column(name = "id")
  private long id;

  @Column(name = "group_name")
  private String groupName;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getGroupName() {
    return groupName;
  }

  public void setGroupName(String groupName) {
    this.groupName = groupName;
  }

  @Override
  public String toString() {
    return "Group{" +
            "id=" + id +
            ", groupName='" + groupName + '\'' +
            '}';
  }
}
