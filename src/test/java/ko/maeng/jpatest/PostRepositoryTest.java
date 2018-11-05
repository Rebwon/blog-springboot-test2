package ko.maeng.jpatest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


/**
 * Create By Solomon on 2018-11-03.
 * Blog : https://medium.com/msolo021015
 * Github : https://github.com/Rebwon
 */

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
public class PostRepositoryTest {

    @Autowired
    PostRepository postRepository;

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void createPost(){
        Account account = new Account();
        account.setUsername("msolo021015");
        account.setPassword("1234");

        accountRepository.save(account);

        Post post = new Post();
        post.setTitle("스프링 데이터 JPA 테스트");
        post.setContents("테스트를 시작합니다.");
        post.setAccount(account);

        postRepository.save(post);

        List<Post> getPosts = postRepository.findAll();

        getPosts.forEach(post1 -> {
            assertThat(post1.getTitle().equals("스프링 데이터 JPA 테스트"));
            assertThat(post1.getContents().equals("테스트를 시작합니다."));
            assertThat(post1.getAccount().getUsername().equals("msolo021015"));
            assertThat(post1.getAccount().getPassword().equals("1234"));
        });
    }
}