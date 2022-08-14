package ru.skillfactorydemo.tgbot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Answers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.SqlRowSetResultSetExtractor;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.test.util.ReflectionTestUtils;
import ru.skillfactorydemo.tgbot.repository.IncomeRepository;
import ru.skillfactorydemo.tgbot.repository.SpendRepository;
import ru.skillfactorydemo.tgbot.repository.StatsRepository;

import javax.sql.RowSetWriter;
import java.util.Arrays;
import java.util.List;

import static org.mockito.ArgumentMatchers.*;

@SpringBootTest
public class StatsServiceTest {

    @InjectMocks
    private StatsService statsService;

    @Mock
    private SpendRepository spendRepository;

    @Mock
    private StatsRepository statsRepository;

    @Mock
    private JdbcTemplate jdbcTemplate;

    @DisplayName(value = "GET_SPENDS_LIST_TEST")
    @Test
    public void getSpendsListTest() {
        statsService = new StatsService(statsRepository);
        ReflectionTestUtils.setField(statsService, "statsRepository", statsRepository);
        Mockito.when(statsRepository.getSpendsGraterThan(anyLong()))
                .thenReturn(Arrays.asList(550, 1000));

        Assertions.assertEquals(550, statsService.getSpendsListGraterThan(500L).get(0));
    }

}
