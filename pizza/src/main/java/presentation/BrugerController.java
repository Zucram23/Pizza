package presentation;

import applicationLayer.BrugerService;
import domain.Bruger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/bruger")
public class BrugerController {

    private final BrugerService brugerService;

    public BrugerController(BrugerService brugerService) {
        this.brugerService = brugerService;
    }

    // Til oprettelse af bruger
    @GetMapping("/opret")
    public String visBrugerForm(Model model) {
        model.addAttribute("bruger", new Bruger());
        return "opret"; // returnerer opret.html under templates
    }

    @PostMapping("/opret")
    public String gemBruger(@ModelAttribute Bruger bruger) {
        brugerService.gemBruger(bruger);
        return "redirect:/bruger/" + bruger.getId(); // redirect til brugerprofil
    }

    // Til visning af brugerprofil
    @GetMapping("/{id}")
    public String visBrugerProfil(@PathVariable int id, Model model) {
        Bruger bruger = brugerService.getBrugerById(id);
        model.addAttribute("bruger", bruger);
        return "profil"; // returnerer profil.html under templates
    }
}