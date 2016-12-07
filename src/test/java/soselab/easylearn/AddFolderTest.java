package soselab.easylearn;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import soselab.easylearn.client.ClientFactory;
import soselab.easylearn.model.AddFolder;
import soselab.easylearn.model.FolderDTO;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by bernie on 12/7/16.
 */
public class AddFolderTest {

    private List<String> folderIds;

    @When("^I add a folder with following name$")
    public void i_add_a_folder_with_following_name(List<AddFolder> folder) throws Throwable {
        UserClient client = ClientFactory.getClient(UserClient.class);
        folderIds = folder.stream()
                .map(i -> {
                    String folderId = String.format("folder%d", new Date().getTime());
                    FolderDTO folderDTO = new FolderDTO(folderId, i.getName(), Collections.EMPTY_LIST);
                    client.addFolder(folderDTO, User.userId);
                    return folderId;
                })
                .collect(Collectors.toList());
    }

    @Then("^The folder is created$")
    public void the_folder_is_created() throws Throwable {

        UserClient client = ClientFactory.getClient(UserClient.class);
        String result = client.getFolder(User.userId).toString();
        boolean b = folderIds.stream().allMatch(i -> result.contains(i));
        Assert.assertTrue(b);
    }
}
