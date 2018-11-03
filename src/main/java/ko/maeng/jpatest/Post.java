package ko.maeng.jpatest;

import javax.persistence.*;
import java.util.Date;

/**
 * Create By Solomon on 2018-11-03.
 * Blog : https://medium.com/msolo021015
 * Github : https://github.com/Rebwon
 */
@Entity
public class Post {

    @Id @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String title;               //글 제목

    private String contents;            //글 내용

    @Temporal(TemporalType.TIMESTAMP)
    private Date date = new Date();     //글 작성일

    @ManyToOne(fetch = FetchType.LAZY)
    private Account accounts;           //작성자

    //Getter, Setter

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContents() {
        return contents;
    }

    public void setContents(String contents) {
        this.contents = contents;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Account getAccount() {
        return accounts;
    }

    public void setAccount(Account account) {
        this.accounts = account;
        account.getPosts().add(this);
    }

}
