package com.mscourse.hrpayroll.feingclients;

import com.mscourse.hrpayroll.entities.Worker;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
//Chamando o outro serviço descoberto apenas pelo nome
@FeignClient(name = "hr-worker", path = "/workers")
public interface WorkerFeignClient {
    @GetMapping(value = "/{id}")
    ResponseEntity<Worker> findById(@PathVariable Long id);
}

