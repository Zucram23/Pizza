package presentation;

import applicationLayer.PizzaService;
import domain.Pizza;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PizzaController {

        private final PizzaService pizzaService;

        public PizzaController(PizzaService pizzaService) {
            this.pizzaService = pizzaService;
        }

        @GetMapping("/pizza")
        public String visPizzaMenu(Model model) {
            model.addAttribute("pizzaer", pizzaService.getAllPizzas());
            return "pizza/pizzamenu"; // matcher /templates/pizza/pizzamenu.html
        }

        @GetMapping("/pizza/opret")
        public String visPizzaForm(Model model) {
            model.addAttribute("pizza", new Pizza());
            return "pizza/opret";
        }

        @PostMapping("/pizza/opret")
        public String gemPizza(@ModelAttribute Pizza pizza) {
            pizzaService.gemPizza(pizza);
            return "redirect:/pizza";
        }
    }

