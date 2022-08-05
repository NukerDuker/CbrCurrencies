package ru.skillfactorydemo.tgbot.DTO;

import lombok.Data;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlAccessorType(XmlAccessType.FIELD) //Specify, how to get/set field value
@XmlRootElement(name = "ValuteCursOnDate") //Root element
@Data //Getters and Setters
public class ValuteCursOnDate {

    @XmlElement(name = "Vname") //XML tags name
    private String name;

    @XmlElement(name = "Vnom")
    private int nominal;

    @XmlElement(name = "Vcurs")
    private double course;

    @XmlElement(name = "Vcode")
    private String code;

    @XmlElement(name = "VchCode")
    private String chCode;
}
