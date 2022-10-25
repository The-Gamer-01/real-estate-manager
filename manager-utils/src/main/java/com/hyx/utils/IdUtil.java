package com.hyx.utils;

import java.util.Random;

/**
 * ID工具类,先用随机正整数生成,不保证去重,
 * 未来再更新雪花算法.
 *
 * @author com.hyx
 **/

public class IdUtil {
    
    /**
     * 生成id.
     * @return 生成后的id.
     */
    public static synchronized Long generateId() {
        Random random = new Random();
        long id = -1L;
        while (id <= 0) {
            id = random.nextLong();
        }
        return id;
    }
}
