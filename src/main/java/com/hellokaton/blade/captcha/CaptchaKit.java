package com.hellokaton.blade.captcha;

import com.hellokaton.blade.mvc.WebContext;
import com.hellokaton.blade.mvc.http.ByteBody;
import com.hellokaton.blade.mvc.http.Response;
import com.wf.captcha.SpecCaptcha;
import com.wf.captcha.base.Captcha;
import io.netty.buffer.ByteBufOutputStream;
import io.netty.buffer.Unpooled;

import java.awt.*;
import java.io.IOException;

public class CaptchaKit {

    private static final int DEFAULT_LEN = 4;
    private static final int DEFAULT_WIDTH = 130;
    private static final int DEFAULT_HEIGHT = 48;

    public static void render(Captcha captcha) throws IOException {
        render(captcha, WebContext.response());
    }

    /**
     * draw captcha image
     *
     * @param len      width
     * @param response Response
     * @throws IOException
     */
    public static void render(int len, Response response) throws IOException {
        render(DEFAULT_WIDTH, DEFAULT_HEIGHT, len, response);
    }

    /**
     * draw captcha image
     *
     * @param width    width
     * @param height   height
     * @param len      code length
     * @param response Response
     * @throws IOException
     */
    public static void render(int width, int height, int len, Response response) throws IOException {
        render(width, height, len, null, response);
    }

    /**
     * draw captcha image
     *
     * @param font     font
     * @param response Response
     * @throws IOException
     */
    public static void render(Font font, Response response)
            throws IOException {
        render(DEFAULT_WIDTH, DEFAULT_HEIGHT, DEFAULT_LEN, font, response);
    }

    /**
     * draw captcha image
     *
     * @param len      code length
     * @param font     font
     * @param response Response
     * @throws IOException
     */
    public static void render(int len, Font font, Response response) throws IOException {
        render(DEFAULT_WIDTH, DEFAULT_HEIGHT, len, font, response);
    }

    /**
     * draw captcha image
     *
     * @param width    width
     * @param height   height
     * @param len      code length
     * @param font     font
     * @param response Response
     */
    public static void render(int width, int height, int len, Font font, Response response) {
        SpecCaptcha specCaptcha = new SpecCaptcha(width, height, len);
        if (font != null) {
            specCaptcha.setFont(font);
        }
        render(specCaptcha, response);
    }

    /**
     * draw captcha image
     *
     * @param captcha  Captcha
     * @param response Response
     */
    public static void render(Captcha captcha, Response response) {
        setHeader(response);

        ByteBufOutputStream out = new ByteBufOutputStream(Unpooled.buffer());
        captcha.out(out);
        response.body(new ByteBody(out.buffer()));
    }

    public static void setHeader(Response response) {
        response.contentType("image/gif");
        response.header("Pragma", "No-cache");
        response.header("Cache-Control", "no-cache");
        response.header("Expires", "0");
    }

}
