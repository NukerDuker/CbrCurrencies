package ru.skillfactorydemo.tgbot.repository;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.skillfactorydemo.tgbot.entity.Income;
import ru.skillfactorydemo.tgbot.repository.IncomeRepository;

import java.math.BigDecimal;
import java.util.Optional;

@DataJpaTest
public class IncomeRepositoryTest {

    @Autowired
    private IncomeRepository incomeRepository;

    @Test
    public void testDataScripts() {
        Optional<Income> income = incomeRepository.findById(12345L);
        assert income.isPresent();
        assert income.get().getIncome().equals(BigDecimal.valueOf(3000L));
    }
}
