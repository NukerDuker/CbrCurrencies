package ru.skillfactorydemo.tgbot.DTO;

import lombok.AccessLevel;
import lombok.Data;
import lombok.Getter;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlRootElement(name = "GetCursOnDateXML", namespace = "http://web.cbr.ru/")
@XmlAccessorType(XmlAccessType.FIELD)
@Data //Getters and Setters
public class GetCursOnDateXml {

    @XmlElement(name = "On_date", required = true, namespace = "http://web.cbr.ru/") //Specify XML field for the Class field
    protected XMLGregorianCalendar onDate;
}
