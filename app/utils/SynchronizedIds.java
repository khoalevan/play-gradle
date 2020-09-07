package utils;

import com.google.inject.Singleton;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@Singleton
public class SynchronizedIds {
    public static final String GET_TICKET_SUN = "get_ticket_sun";
    Map<String, Object> locks;

    public SynchronizedIds() {
        locks = new ConcurrentHashMap<>();
    }

    public Object getSyncObject(Integer id, String module) {
        locks.putIfAbsent(module + id, new Object());
        return locks.get(module + id);
    }

    public Object getSyncObject(Long id, String module) {
        locks.putIfAbsent(module + id, new Object());
        return locks.get(module + id);
    }

    public Object getSyncObject(String id, String module) {
        locks.putIfAbsent(module + id, new Object());
        return locks.get(module + id);
    }
}
