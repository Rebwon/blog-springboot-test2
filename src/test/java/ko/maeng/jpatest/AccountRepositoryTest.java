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
public class AccountRepositoryTest {

    @Autowired
    AccountRepository accountRepository;

    @Test
    public void join(){
        Account account = new Account();
        account.setUsername("msolo021015");
        account.setPassword("1234");

        accountRepository.save(account);

        List<Account> getAccounts = accountRepository.findAll();

        getAccounts.forEach(accountInfor -> {
            assertThat(accountInfor.getUsername().equals("msolo021015"));
            assertThat(accountInfor.getPassword().equals("1234"));
        });
    }
}