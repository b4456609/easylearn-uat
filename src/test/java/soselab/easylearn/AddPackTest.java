package soselab.easylearn;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import soselab.easylearn.client.ClientFactory;
import soselab.easylearn.model.AddPack;
import soselab.easylearn.model.Pack;
import soselab.easylearn.model.PackBuilder;
import soselab.easylearn.model.VersionBuilder;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class AddPackTest {

    private String packId;

    @When("^I add pack with following content$")
    public void i_add_pack_with_following_content(List<AddPack> pack) throws Throwable {

        PackClient client = ClientFactory.getClient(PackClient.class);
        packId = String.format("pack%d", new Date().getTime());
        Pack pack1 = new PackBuilder()
                .setCreatorUserId(User.userId)
                .setCreatorUserName(User.userName)
                .setDescription(pack.get(0).getDescription())
                .setId(packId)
                .setVersion(Arrays.asList(new VersionBuilder()
                        .setId(User.userId)
                        .setContent(pack.get(0).getContent())
                        .createVersion()))
                .createPack();
        client.addPack(pack1, User.userId);
    }

    @Then("^the pack create$")
    public void the_pack_create() throws Throwable {
//        PackClient client = ClientFactory.getClient(PackClient.class);
//        List<Pack> pack = client.getPack(User.userId);
//        boolean contains = pack.toString().contains(packId);
//        Assert.assertTrue(contains);
    }
}
