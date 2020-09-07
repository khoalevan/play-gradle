package controllers;

import com.google.inject.Inject;
import com.typesafe.config.Config;
import lombok.extern.slf4j.Slf4j;
import play.mvc.Controller;
import play.mvc.Result;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;

@Slf4j
public class HomeController extends Controller {
    @Inject
    Config config;

    public Result index() {
        return ok("Hello world - now time: " + new Date() + " timezone: " + TimeZone.getDefault().toString() + "/" + TimeZone.getDefault().getRawOffset());
    }

    public Result option(String all) {
        List<String> corsDomains = config.getStringList("cors_domains");
        if (corsDomains == null) {
            corsDomains = new ArrayList<>();
        }
        String requestOrigin = request().getHeader("Origin");

        response().setHeader(Controller.ACCESS_CONTROL_ALLOW_CREDENTIALS, "true");
        response().setHeader(Controller.ACCESS_CONTROL_ALLOW_METHODS, "POST, GET, PUT, DELETE, OPTIONS");
        if (corsDomains.contains(requestOrigin)) {
            response().setHeader(Controller.ACCESS_CONTROL_ALLOW_ORIGIN, requestOrigin);
        }
        response().setHeader(Controller.ACCESS_CONTROL_ALLOW_HEADERS, "Authorization, Content-Type, Accept, Origin," +
                "User-Agent, DNT, Cache-Control, X-Mx-ReqToken, Keep-Alive, X-Requested-With, If-Modified-Since, login_token," +
                "timezone, access_token, expiry, client, token-type");
        response().setHeader(Controller.ACCESS_CONTROL_MAX_AGE, "86400");
        response().setHeader(Controller.CONTENT_LENGTH, "0");
        response().setHeader(Controller.CONTENT_TYPE, "text/plain charset=UTF-8");

        return ok();
    }

    public Result test() {
        return ok("NOT_OK");
    }

    public Result healthCheck() {
        return ok();
    }
}
