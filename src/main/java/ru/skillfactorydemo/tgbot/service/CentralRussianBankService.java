package ru.skillfactorydemo.tgbot.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.ws.client.core.WebServiceTemplate;
import ru.skillfactorydemo.tgbot.DTO.GetCursOnDateXml;
import ru.skillfactorydemo.tgbot.DTO.GetCursOnDateXmlResponse;
import ru.skillfactorydemo.tgbot.DTO.ValuteCursOnDate;

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

public class CentralRussianBankService extends WebServiceTemplate {

    // Get value from application.properties or application.yml
    @Value("${cbr.api.url}")
    private String cbrApiUrl;

    // Create receiving data method
    public List<ValuteCursOnDate> getCurrenciesFromCbr() throws DatatypeConfigurationException {
        final GetCursOnDateXml getCursOnDateXml = new GetCursOnDateXml();
        GregorianCalendar cal = new GregorianCalendar();
        cal.setTime(new Date());

        XMLGregorianCalendar xmlGregCal = DatatypeFactory.newInstance().newXMLGregorianCalendar(cal);
        getCursOnDateXml.setOnDate(xmlGregCal);

        GetCursOnDateXmlResponse response = (GetCursOnDateXmlResponse) marshalSendAndReceive(cbrApiUrl, getCursOnDateXml);

        if (response == null) {
            throw new IllegalStateException("Could not get response from CBR Service");
        }

        final List<ValuteCursOnDate> courses = response.getGetCurseOnDateXmlResult().getValuteData();
        courses.forEach(course -> course.setName(course.getName().trim()));
        return courses;
    }
}
