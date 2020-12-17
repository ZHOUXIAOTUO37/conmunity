package com.xt37.community.controller;

import com.xt37.community.dto.AccessTokenDto;
import com.xt37.community.dto.GithubUser;
import com.xt37.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/*
 * 获取code
 * 即为跳转之后的值
 * */
@Controller
public class AuthorizeController {

    @Autowired
    private GithubProvider githubProvider;
    @Value("${github.client.id}")
    private String clientid;
    @Value("${github.client.secret}")
    private String clientsecret;
    @Value("${github.redirect.uri}")
    private String redireceuri;

    @GetMapping("/callback")
    public String callback(@RequestParam(name = "code") String code,
                           @RequestParam(name = "state") String state,
                           HttpServletRequest request) {
        {
            AccessTokenDto accessTokenDto = new AccessTokenDto();
            //set user 账户中的信息
            accessTokenDto.setClient_id(clientid);
            accessTokenDto.setClient_secret(clientsecret);
            accessTokenDto.setCode(code);
            accessTokenDto.setRedirect_uri(redireceuri);
            accessTokenDto.setClient_secret(state);

            String accessToken = githubProvider.getAccessToken(accessTokenDto);
            GithubUser user = githubProvider.getUser(accessToken);
            if (user != null) {
                //登陆成功,写cookie和session
                request.getSession().setAttribute("user", user);
                return "redirect:/";
            } else {
                //登录失败,重新登录
                return "redirect:/";
            }
        }

    }
}
