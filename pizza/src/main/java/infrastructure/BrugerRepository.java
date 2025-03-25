package infrastructure;

import domain.Bruger;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BrugerRepository {

    private final JdbcTemplate jdbcTemplate;

    public BrugerRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Bruger gemBruger(Bruger bruger) {
        String sql = "INSERT INTO bruger (navn, adresse, email, bonuspoint) VALUES (?, ?, ?, ?)";

        jdbcTemplate.update(sql, bruger.getNavn(), bruger.getAdresse(), bruger.getEmail(), bruger.getBonuspoint());
        return bruger;
    }

    public Bruger findBrugerById(int id) {
        String sql = "SELECT * FROM bruger WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Bruger.class), id);
    }

    public List<Bruger> findAllBrugere() {
        String sql = "SELECT * FROM bruger";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Bruger.class));
    }

    public void deleteBruger(int id) {
        String sql = "DELETE FROM bruger WHERE id = ?";
        jdbcTemplate.update(sql, id);
    }
}
