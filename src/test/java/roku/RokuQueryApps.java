package roku;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.io.StringReader;
import java.util.Objects;
import static io.restassured.RestAssured.given;


public class RokuQueryApps {

    private final String rokuIp = "192.168.1.124";

    @BeforeClass
    public void setupURL() {
        RestAssured.useRelaxedHTTPSValidation();
        RestAssured.baseURI = "http://" + this.rokuIp +":8060";
    }

    private String getAppIDs() {
        String queryApps = "apps";
        String queryAppsResponse = given().
                log().everything().
                header("X-App-Version", "123456").
                header("Accept", "application/media.geotest-v1+json").
                when().
                get("/query/{appId}", queryApps).
                then().
                log().everything().
                statusCode(200).
                contentType(ContentType.XML).
                extract().body().asString();
        System.out.print("");
        return queryAppsResponse;
    }

    private String getCPCAppID() throws ParserConfigurationException {
        DocumentBuilderFactory appId = DocumentBuilderFactory.newInstance();
        DocumentBuilder builder = appId.newDocumentBuilder();
        String nodeValue = "";

        try {
            Document doc = builder.parse(new InputSource(new StringReader(getAppIDs())));

            Element element = doc.getDocumentElement();
            NodeList nodes = element.getChildNodes();

            for (int i = 0; i < nodes.getLength(); i++) {
                if (Objects.equals(nodes.item(i).getTextContent(), "CPC Roku App")) {
                    nodeValue = nodes.item(i).getAttributes().getNamedItem("id").getNodeValue();
                }
            }

        } catch (SAXException | IOException e) {
            e.printStackTrace();
        }

        return nodeValue;
    }


    @Test
    public void startRokuApp() throws ParserConfigurationException {
        String appId = getCPCAppID();

        given().
                log().everything().
                header("X-App-Version", "123456").
                header("Accept", "application/media.geotest-v1+json").
                when().
                post("/launch/{appId}", appId).
                then().
                log().everything().
                statusCode(200);
    }

    @Test
    public void gotoRokuHome() throws ParserConfigurationException {
        given().
                log().everything().
                header("X-App-Version", "123456").
                header("Accept", "application/media.geotest-v1+json").
                when().
                post("/keypress/home").
                then().
                log().everything().
                statusCode(200);
    }
}
