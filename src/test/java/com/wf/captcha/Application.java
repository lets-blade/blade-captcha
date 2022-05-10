package com.wf.captcha;

import com.hellokaton.blade.Blade;
import com.hellokaton.blade.annotation.Path;
import com.hellokaton.blade.annotation.route.GET;
import com.hellokaton.blade.captcha.CaptchaKit;

import java.io.IOException;

@Path
public class Application {

    @GET("/captcha")
    public void captcha() throws IOException {
        GifCaptcha captcha = new GifCaptcha(130, 48, 6);
        System.out.println(captcha.text());
        CaptchaKit.render(captcha);
    }

    public static void main(String[] args) {
        Blade.create().start(Application.class, args);
    }

}
