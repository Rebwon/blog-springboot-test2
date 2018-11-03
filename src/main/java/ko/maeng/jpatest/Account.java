package ko.maeng.jpatest;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Create By Solomon on 2018-11-03.
 * Blog : https://medium.com/msolo021015
 * Github : https://github.com/Rebwon
 */
@Entity
public class Account {

    @Id @GeneratedValue
    private Long id;                    //식별자 값

    @Column(nullable = false)
    private String username;            //이름

    @Column(nullable = false)
    private String password;            //비밀번호

    @Temporal(TemporalType.TIMESTAMP)
    private Date date =  new Date();    //가입일

    @OneToMany(mappedBy = "accounts")
    private List<Post> posts = new ArrayList<>();   //게시글

    //Getter, Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Post> getPosts() {
        return posts;
    }

    public void setPosts(List<Post> posts) {
        this.posts = posts;
    }
}
