package soselab.easylearn;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import soselab.easylearn.model.Pack;

public interface PackClient {
    @RequestLine("POST /api/pack/")
    @Headers("X-Auth-Token: {token}")
    void addPack(Pack pack, @Param("token") String token);
}
