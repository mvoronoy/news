package denis.news.Controller;


import denis.news.model.Article;
import denis.news.services.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class MainController  {

    @Autowired
    private ArticleService service;

    @RequestMapping
    public String mainPage(Model model){
        model.addAttribute("message" , "Добро пожаловать на сайт!");
        return "main";
    }

    @RequestMapping(value = "/editor")
    public String editorPage(Model model){
        model.addAttribute("article", new Article());
        return "editor";
    }
    @RequestMapping(value = "/editor/submit",method = RequestMethod.POST)
    public String submitArticle(@ModelAttribute Article article){
        service.save(article);
        return "redirect:../";
    }
}
