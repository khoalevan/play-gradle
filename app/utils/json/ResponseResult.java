package utils.json;

import com.fasterxml.jackson.databind.node.ObjectNode;
import play.Play;
import play.i18n.Lang;
import play.i18n.Messages;
import play.i18n.MessagesApi;
import play.libs.Json;
import play.mvc.Result;

import static play.mvc.Results.ok;

public class ResponseResult {
    public static Result error(String message) {
        ObjectNode result = Json.newObject();
        result.put("code", 400);
        result.put("message", message);

        return ok(result);
    }

    public static Result generalError(Lang lang) {
        MessagesApi messagesApi = Play.application().injector().instanceOf(MessagesApi.class);
        return error(messagesApi.get(lang, "general_error"));
    }

    public static Result success(String message) {
        ObjectNode result = Json.newObject();
        result.put("code", 200);
        result.put("message", message);

        return ok(result);
    }

    public static Result success(Object data) {
        ObjectNode result = Json.newObject();
        result.put("code", 200);
        result.put("message", "Thành công");
        result.put("data", Json.toJson(data));

        return ok(result);
    }

    public static Result response(Integer code, String message, Object data) {
        ObjectNode result = Json.newObject();
        result.put("code", code);
        result.put("message", message);
        result.put("data", Json.toJson(data));

        return ok(result);
    }
}
