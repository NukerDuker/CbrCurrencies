package ru.skillfactorydemo.tgbot.repository;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import ru.skillfactorydemo.tgbot.entity.Spend;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class SpendRepositoryTest {

    @Autowired
    private SpendRepository spendRepository;

    @Test
    public void testRepo() {
    for (int i = 0; i < 10; i++, spendRepository.save(new Spend()));
    final List<Spend> spends = spendRepository.findAll();
    assertEquals(10, spends.size());
    }

    @Test
    public void  spendsTest() {
        Optional<Spend> spend = spendRepository.findById(12L);
        assertTrue(spend.isPresent());
        assertEquals(new BigDecimal("48093745.00"), spend.get().getSpend());
    }

}