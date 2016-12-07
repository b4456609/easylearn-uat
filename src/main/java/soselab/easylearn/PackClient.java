package soselab.easylearn;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import soselab.easylearn.model.Pack;
import soselab.easylearn.model.Version;

import java.util.List;


@Headers("Content-Type: application/json")
public interface PackClient {
    @RequestLine("POST /api/pack/")
    @Headers("X-Auth-Token: {token}")
    void addPack(Pack pack, @Param("token") String token);

    @RequestLine("GET /api/pack/")
    @Headers("X-Auth-Token: {token}")
    List<Pack> getPack(@Param("token") String token);

    @RequestLine("POST /api/pack/{packId}/version")
    @Headers("X-Auth-Token: {token}")
    public void addVersion(@Param("token") String token,
                           @Param("packId") String packId, Version version);
}
