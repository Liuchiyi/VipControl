package com.chiyi.vip.function;

import com.chiyi.vip.entity.VIPEntity;
import com.chiyi.vip.web.handler.ao.VIPAo;
import org.springframework.transaction.annotation.Transactional;

public interface VipFunction {

    /**
     * VIP 查询
     * @param code
     * @return
     * @throws Exception
     */
    VIPEntity queryVip(String code)throws Exception;

    /**
     * 录入VIP
     * @param ao
     * @return
     * @throws Exception
     */
    @Transactional
    VIPEntity  addVip(VIPAo ao)throws Exception;
}
