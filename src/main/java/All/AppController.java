package All;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class AppController {

    @Autowired
    private AppService appService;

    public static Long id3;

    @GetMapping("/")
    public String HomePage(Model model) {
        model.addAttribute("us",appService.getAll());
        return "homepage";
    }

    @GetMapping("/add")
    public String add(Model model) {
        Users users1 = new Users();
        model.addAttribute("us",users1);
        return "add";
    }

    @PostMapping("/resultOfAdd")
    public String resultOfAdd(@Valid @ModelAttribute("us") Users users1, BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "errorpage";
        }
        appService.add(users1);
        return "redirect:/";
    }

    @GetMapping("/delete")
    public String delete(Model model) {
        Users users = new Users();
        model.addAttribute("us",users);
        return "delete";
    }

    @PostMapping("/resultOfDelete")
    public String resultOfDelete(@ModelAttribute("us") Users users) {
        appService.delete(users.getId2());
        return "redirect:/";
    }

    @GetMapping("/update")
    public String update(Model model) {
        Users users = new Users();
        model.addAttribute("us",users);
        return "update";
    }

    @PostMapping("/resultOfUpdate")
    public String resultOfUpdate(@ModelAttribute("us") Users users,Model model) {
        id3 = users.getId2();
        model.addAttribute("us",users);
        return "resultOfUpdate";
    }

    @PostMapping("/resultOfUpdate2")
    public String resultOfUpdate2(@Valid @ModelAttribute("us") Users users,BindingResult bindingResult) {
        if(bindingResult.hasErrors()) {
            return "redirect:/";
        }
        appService.update(users,id3);
        return "redirect:/";
    }
}
