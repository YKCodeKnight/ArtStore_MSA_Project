package com.drawarts.cartservice.Client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import com.drawarts.cartservice.Client.dto.ArtDto;

@FeignClient(name = "artservice")
public interface ArtFeignClient {
    @GetMapping("/arts/{id}")
    ArtDto getArtById(@PathVariable("id") Long id);
}
