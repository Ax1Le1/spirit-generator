package com.spirit.maker.meta;

import cn.hutool.core.io.resource.ResourceUtil;
import cn.hutool.json.JSONUtil;

/**
 * MetaManager
 *
 * @author yaojc
 * @date 2024/3/12
 */
public class MetaManager {

    private static volatile Meta meta;

    private static Meta initMeta() {
//        String metaJson = ResourceUtil.readUtf8Str("meta.json");
        String metaJson = ResourceUtil.readUtf8Str("springboot-init-meta.json");
        Meta newMeta = JSONUtil.toBean(metaJson, Meta.class);
        // 校验配置文件，处理默认值
        MetaValidator.doValidAndFill(newMeta);
        return newMeta;
    }

    public static Meta getMetaObject() {
        if (meta == null) {
            synchronized (MetaManager.class) {
                if (meta == null) {
                    meta = initMeta();
                }
            }
        }
        return meta;
    }


}
