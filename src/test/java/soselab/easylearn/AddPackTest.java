package soselab.easylearn;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import feign.Feign;
import soselab.easylearn.model.*;

import java.util.Arrays;
import java.util.List;

public class AddPackTest {

    private String userName = "name";
    private String userId = "id";
    private String packId = "pack12479861234";

    @Given("^I am a  logged-in  user$")
    public void i_am_a_logged_in_user() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        CreateDriverAndLogin();
//        throw new PendingException();
    }

    @When("^I add pack with following content$")
    public void i_add_pack_with_following_content(List<AddPack> pack) throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // List<YourType>, List<List<E>>, List<Map<K,V>> or Map<K,V>.
        // E,K,V must be a scalar (String, Integer, Date, enum etc)
        PackClient bank = Feign.builder()
                .encoder(new JacksonEncoder())
                .decoder(new JacksonDecoder())
                .target(PackClient.class, "https://dev.microservices.ntou.edu.tw");

        Pack pack1 = new PackBuilder()
                .setCreatorUserId(userId)
                .setCreatorUserName(userName)
                .setDescription(pack.get(0).getDescription())
                .setId(packId)
                .setVersion(Arrays.asList(new VersionBuilder()
                        .setContent(pack.get(0).getContent())
                        .createVersion()))
                .createPack();
        bank.addPack(pack1, "id");
//        throw new PendingException();
    }

    @Then("^the pack create$")
    public void the_pack_create() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
//        throw new PendingException();
    }
}
