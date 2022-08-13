package ru.skillfactorydemo.tgbot.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import ru.skillfactorydemo.tgbot.repository.IncomeRepository;
import ru.skillfactorydemo.tgbot.repository.SpendRepository;
import ru.skillfactorydemo.tgbot.repository.StatsRepository;

import java.util.List;

@SpringBootTest
public class StatsServiceTest {

    @InjectMocks
    private StatsService statsService;

    @InjectMocks
    private FinanceService financeService;

    @Mock
    private IncomeRepository incomeRepository;

    @Mock
    private SpendRepository spendRepository;

    @Mock
    private StatsRepository statsRepository;

    @DisplayName(value = "GET_SPENDS_LIST_TEST")
    @Test
    public void getSpendsListTest() {
        String price = "1000";
        String message = financeService.addFinanceOperation("/nan", price, 250L);
        Assertions.assertEquals("Расход в размере " + price + " был успешно добавлен", message);
        long amount = 5L;
        List<Integer> spends = statsService.getSpendsListGraterThan(amount);
        Assertions.assertNotNull(spends);
        Assertions.assertEquals(100, spends.get(0));
    }

}
