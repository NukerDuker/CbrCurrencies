package ru.skillfactorydemo.tgbot.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;
import ru.skillfactorydemo.tgbot.service.StatsService;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Repository
@RequiredArgsConstructor
public class StatsRepository {

    private final JdbcTemplate jdbcTemplate;


    public int getCountOfIncomesThatGreaterThan(BigDecimal amount) {
        return jdbcTemplate.queryForObject("SELECT count(*) FROM incomes WHERE income > ?", Integer.class, amount);
    }

    public List<Integer> getSpendsGraterThan(Long amount) {
        List<Integer> spends = new ArrayList<>();
        SqlRowSet result = jdbcTemplate.queryForRowSet("SELECT * FROM spend where spend > ?", amount);
        while(result.next()) {
            spends.add(result.getInt("spend"));
        }
        return spends;
    }
}
