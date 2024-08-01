package org.prasad.web.controller;

import org.prasad.web.model.Form;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * Created by Leeladurga Prasad Gunti on 26-Mar-2015 14:57.
 */

@Controller
@RequestMapping(value = "/form")
public class FormController {

    @RequestMapping(value = {"*","","/show"}, method = RequestMethod.GET)
    public String showUserPage(@ModelAttribute("form") Form form,HttpServletRequest request,BindingResult result, ModelMap modelMap){

        System.out.println("FormController GET called");
        HttpSession session = request.getSession();
        String autoGen = request.getParameter("autoGen");
        String size = request.getParameter("size");
        if(null != autoGen && !autoGen.isEmpty() && autoGen.equalsIgnoreCase("true")) {

            int genSize = 10;
            if(null != size && !size.isEmpty()) {
                try {
                    genSize = Integer.valueOf(size);
                } catch (Exception e) {
                    // unable to process the size
                }
            }
            String data = generateData(genSize * 1024);
            form.setContent(data);
        }
        return "formPage";
    }

    @RequestMapping(value = "/save",method = RequestMethod.POST)
    public String showUser(@ModelAttribute("form") Form form,HttpServletRequest request,ModelMap modelMap){

        HttpSession session = request.getSession(false);
        if(session != null) {
            session.setAttribute("content",form.getContent());
        }
        modelMap.put("content", form.getContent());

        modelMap.put("contentSize",(double)form.getContent().toString().length()/1024);
        return "showFormData";
    }

    /**
     * Method to genarate random data..
     *
     * @param size
     * @return
     */
    private static String generateData(int size){

        StringBuilder sb = new StringBuilder();
        Random random = new Random();

        for(;size >= 0 ; size-- ) {

            int select = random.nextInt(3);

            if(select == 0) {
                sb.append(random.nextInt(9));
            } else if (select == 1) {
                sb.append(Character.valueOf( (char)(random.nextInt(26) + 'a')));
            } else {
                sb.append(Character.valueOf( (char)(random.nextInt(26) + 'A')));
            }
        }

        return sb.toString();
    }



}
