package utils;

import static play.mvc.Http.Context.Implicit.request;

public class Utils {
    public static String getLang() {
        String language = request().header("Accept-Language").orElse("vi");
        if (!language.matches("(en|vi)")) language = "vi";
        return language;
    }
}
