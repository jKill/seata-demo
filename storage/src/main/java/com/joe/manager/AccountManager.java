package com.joe.manager;

import com.joe.entity.AccountReqDTO;
import com.joe.entity.RpcResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "account")
public interface AccountManager {

    /**
     * 扣款
     * @param dto
     * @return
     */
    @PostMapping("/account/deduct")
    RpcResponse<Object> deductAccount(@RequestBody AccountReqDTO dto);
}
