package soselab.easylearn;

import feign.Headers;
import feign.Param;
import feign.RequestLine;
import soselab.easylearn.model.FolderDTO;

import java.util.List;

@Headers("Content-Type: application/json")
public interface UserClient {

    @RequestLine("POST /api/user/folder")
    @Headers("X-Auth-Token: {token}")
    void addFolder(FolderDTO folderDTO, @Param("token") String token);


    @RequestLine("GET /api/user/folder")
    @Headers("X-Auth-Token: {token}")
    List<FolderDTO> getFolder(@Param("token") String token);

}
