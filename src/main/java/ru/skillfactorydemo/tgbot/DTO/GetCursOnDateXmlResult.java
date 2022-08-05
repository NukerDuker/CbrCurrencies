package ru.skillfactorydemo.tgbot.DTO;

import lombok.Data;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlAccessorType(XmlAccessType.FIELD) //Specify how to receive/send value of the field
@XmlRootElement(name = "GetCursOnDateXmlResult") //Root element, other elements will be inside this
@Data //Generate getters and setters
public class GetCursOnDateXmlResult {

    @XmlElementWrapper(name = "ValuteData", namespace = "")
    @XmlElement(name = "ValuteCursOnDate", namespace = "")
    private List<ValuteCursOnDate> valuteData = new ArrayList<>();
}
