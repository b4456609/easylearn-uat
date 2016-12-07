package soselab.easylearn;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import soselab.easylearn.client.ClientFactory;
import soselab.easylearn.model.Pack;
import soselab.easylearn.model.Version;
import soselab.easylearn.model.VersionBuilder;

import java.util.Date;
import java.util.List;

public class AddVersionTest {

    private final String packId = "pack1479221373194";
    private String versionId;

    @Given("^I am viewing a pack$")
    public void i_am_viewing_a_pack() throws Throwable {
        // Write code here that turns the phrase above into concrete actions

    }

    @When("^I edit a version with following content$")
    public void i_edit_a_version_with_following_content(String arg1) throws Throwable {
        PackClient packClient = ClientFactory.getClient(PackClient.class);
        versionId = String.format("version%d", new Date().getTime());
        Version version = new VersionBuilder()
                .setContent(arg1)
                .setId(versionId)
                .setCreatorUserId(User.userId)
                .setCreatorUserName(User.userName)
                .createVersion();

        packClient.addVersion(User.userId, packId, version);
    }

    @Then("^The version is created$")
    public void the_version_is_created() throws Throwable {
        PackClient client = ClientFactory.getClient(PackClient.class);

        Thread.sleep(2000);
        List<Pack> pack = client.getPack(User.userId);
        boolean contains = pack.toString().contains(versionId);
        System.out.println(pack);
        System.out.println(versionId);
        Assert.assertTrue(contains);
    }
}
