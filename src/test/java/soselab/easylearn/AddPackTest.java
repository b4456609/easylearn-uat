package soselab.easylearn;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import soselab.easylearn.client.ClientFactory;
import soselab.easylearn.model.AddPack;
import soselab.easylearn.model.Pack;
import soselab.easylearn.model.PackBuilder;
import soselab.easylearn.model.VersionBuilder;

import java.util.Arrays;
import java.util.List;

public class AddPackTest {

    private String userName = "name";
    private String userId = "1009840175700426";
    private String packId = "pack12479861234";
    private PackClient client;


    @Given("^I am a  logged-in  user$")
    public void i_am_a_logged_in_user() throws Throwable {
        client = ClientFactory.getClient(PackClient.class);

    }

    @When("^I add pack with following content$")
    public void i_add_pack_with_following_content(List<AddPack> pack) throws Throwable {

        Pack pack1 = new PackBuilder()
                .setCreatorUserId(userId)
                .setCreatorUserName(userName)
                .setDescription(pack.get(0).getDescription())
                .setId(packId)
                .setVersion(Arrays.asList(new VersionBuilder()
                        .setId(userId)
                        .setContent(pack.get(0).getContent())
                        .createVersion()))
                .createPack();
        client.addPack(pack1, userId);
    }

    @Then("^the pack create$")
    public void the_pack_create() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }
}
