package fruitNinja.data.services;

import fruitNinja.data.wrappers.Urls;
import fruitNinja.data.wrappers.Players;
import fruitNinja.models.fruits.FruitData;
import fruitNinja.models.users.Player;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.util.ArrayList;

public class FruitService extends BaseService<FruitData>{
    @Override
    public ArrayList<FruitData> readData() {
        JAXBContext jaxbContext= null;
        ArrayList<FruitData> fruitData = null;
        try {
            jaxbContext = JAXBContext.newInstance(Urls.class);
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            Urls urls = (Urls) unmarshaller.unmarshal(getUrlsFile());
            fruitData = urls.getFruitData();
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return fruitData;
    }

    @Override
    public void writeData(FruitData data) {
        Urls urls= new Urls();
        ArrayList<FruitData> fruitData = readData();
        fruitData.add(data);
        urls.setFruitData(fruitData);

        try {
            JAXBContext jaxbContext = JAXBContext.newInstance(Urls.class);
            Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
            jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
            jaxbMarshaller.marshal(urls, getUrlsFile());
            jaxbMarshaller.marshal(urls, System.out);
        } catch (JAXBException e) {
            e.printStackTrace();
        }

    }
}
