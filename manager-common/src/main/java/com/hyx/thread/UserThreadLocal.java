package com.hyx.thread;

/**
 * 携带UserId的ThreadLocal.
 *
 * @author hyx
 **/

public class UserThreadLocal {
    
    private UserThreadLocal() {}
    
    private static final ThreadLocal<Long> USER_THREAD_LOCAL = new ThreadLocal<>();

    public static void put(Long id) {
        USER_THREAD_LOCAL.set(id);
    }
    
    /**
     * 获取UserId.
     * @return userId
     */
    public static Long get() {
        Long userId = USER_THREAD_LOCAL.get();
        USER_THREAD_LOCAL.remove();
        return userId;
    }
    
    public static void remove() {
        USER_THREAD_LOCAL.remove();
    }
}
