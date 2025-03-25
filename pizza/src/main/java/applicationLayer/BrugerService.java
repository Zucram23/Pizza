package applicationLayer;

import domain.Bruger;
import infrastructure.BrugerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BrugerService {

    private final BrugerRepository repository;

    public BrugerService(BrugerRepository repository) {
        this.repository = repository;
    }

    public Bruger gemBruger(Bruger bruger) {
        return repository.gemBruger(bruger);
    }

    public Bruger getBrugerById(int id) {
        return repository.findBrugerById(id);
    }

    public List<Bruger> getAllBrugere() {
        return repository.findAllBrugere();
    }

    public void deleteBruger(int id) {
        repository.deleteBruger(id);
    }
}
