package ru.skillfactorydemo.tgbot.DTO;

import lombok.Data;

import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlRootElement(name = "GetCursOnDateXmlResponse", namespace = "http://web.cbr.ru") //Specify XML tag and namespace
@Data
public class GetCursOnDateXmlResponse {

    @XmlElement(name = "GetCurseOnDateXMLResult", namespace = "http://web.cbr.ru")
    private GetCursOnDateXmlResult getCurseOnDateXmlResult;
}
